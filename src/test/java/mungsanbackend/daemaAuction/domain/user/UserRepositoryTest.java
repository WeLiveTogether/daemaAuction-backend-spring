package mungsanbackend.daemaAuction.domain.user;

import mungsanbackend.daemaAuction.domain.product.Product;
import mungsanbackend.daemaAuction.domain.product.ProductRepository;
import mungsanbackend.daemaAuction.domain.room.joinRoom.JoinRoom;
import mungsanbackend.daemaAuction.domain.room.joinRoom.JoinRoomRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private JoinRoomRepository joinRoomRepository;

    @DisplayName("유저 등록 테스트")
    @Test
    void save() {

        // given
        String name = "손윤석";
        int gcn = 2409;
        String email = "dbstjr5517@naver.com";
        List<Product> products = productRepository.findAll();
        List<JoinRoom> joinRooms = joinRoomRepository.findAll();
        final User user = User.builder().name(name).gcn(gcn).email(email).products(products).joinRooms(joinRooms).build();

        // when
        final User savedUser = userRepository.save(user);

        // then
        assertEquals(name, savedUser.getName());
        assertEquals(gcn, savedUser.getGcn());
        assertEquals(email, savedUser.getEmail());
    }
}