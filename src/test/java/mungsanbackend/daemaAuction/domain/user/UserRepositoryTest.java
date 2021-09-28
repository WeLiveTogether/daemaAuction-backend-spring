package mungsanbackend.daemaAuction.domain.user;

import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.User;
import mungsanbackend.daemaAuction.repository.ProductRepository;
import mungsanbackend.daemaAuction.domain.JoinRoom;
import mungsanbackend.daemaAuction.repository.JoinRoomRepository;
import mungsanbackend.daemaAuction.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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