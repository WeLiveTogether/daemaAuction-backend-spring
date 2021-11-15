package mungsanbackend.daemaAuction.service;

import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.User;
import mungsanbackend.daemaAuction.repository.ProductRepository;
import mungsanbackend.daemaAuction.repository.UserRepository;
import mungsanbackend.daemaAuction.web.dto.response.UserResponse;
import mungsanbackend.daemaAuction.web.dto.response.mypage.MyPageResponse;
import mungsanbackend.daemaAuction.web.dto.response.mypage.MyProductResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        User user = getUser(principal.getUsername());
        return new User(user.getUserId(), user.getUsername(), user.getEmail(), user.getProfileImageUrl(), user.getProviderType(), user.getRoleType());
    }

    public List<MyPageResponse> myPage() {
        User user = getUserInfo();
        Optional<Product> product = productRepository.findProductByUser(user);
        return product.stream().map(MyPageResponse::of).collect(Collectors.toList());
    }
}
