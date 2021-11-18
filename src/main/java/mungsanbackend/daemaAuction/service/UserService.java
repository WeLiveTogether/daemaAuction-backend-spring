package mungsanbackend.daemaAuction.service;

import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.User;
import mungsanbackend.daemaAuction.repository.ProductRepository;
import mungsanbackend.daemaAuction.exception.UserNotFoundException;
import mungsanbackend.daemaAuction.repository.UserRepository;
import mungsanbackend.daemaAuction.web.dto.response.mypage.MyProductResponse;
import mungsanbackend.daemaAuction.web.dto.response.mypage.MyPageResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return userRepository.findUserByUserSeq(seq).orElseThrow(() -> new UserNotFoundException());
    }

    public User getUserInfo() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = getUser(principal.getUsername());
        return new User(user.getUserId(), user.getUsername(), user.getEmail(), user.getProfileImageUrl(), user.getProviderType(), user.getRoleType());
    }

    public MyPageResponse myPage() {
        User userInfo = getUserInfo();

        User user = userRepository.findByUserId(userInfo.getUserId());

        List<Product> product = productRepository.findProductByUser(user);
        List<MyProductResponse> productResponse = product.stream().map(MyProductResponse::of).collect(Collectors.toList());

        return MyPageResponse.builder()
                .userName(user.getUsername())
                .email(user.getEmail())
                .profileImageUrl(user.getProfileImageUrl())
                .productResponseList(productResponse)
                .build();
    }
}
