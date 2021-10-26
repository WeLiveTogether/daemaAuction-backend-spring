package mungsanbackend.daemaAuction.service;

import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.domain.User;
import mungsanbackend.daemaAuction.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(String userId) {
        return userRepository.findByUserId(userId);
    }

    public User findUserBySeq(Long seq) {
        return userRepository.findUserByUserSeq(seq).orElseThrow(() -> new RuntimeException("User를 찾을 수 없습니다."));
    }
}
