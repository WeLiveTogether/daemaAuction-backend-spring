package mungsanbackend.daemaAuction.service;

import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.User;
import mungsanbackend.daemaAuction.repository.ProductRepository;
import mungsanbackend.daemaAuction.repository.UserRepository;
import mungsanbackend.daemaAuction.web.dto.response.MyPageResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public User getUser(String userId) {
        return userRepository.findByUserId(userId);
    }

    public User findUserBySeq(Long seq) {
        return userRepository.findUserByUserSeq(seq).orElseThrow(() -> new RuntimeException("User를 찾을 수 없습니다."));
    }

    public User getUserInfo() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return getUser(principal.getUsername());
    }

    public List<MyPageResponse> myPage() {
        User user = getUserInfo();
        Optional<Product> product = productRepository.findProductByUser(user);
        return product.stream().map(MyPageResponse::of).collect(Collectors.toList());
    }
}
