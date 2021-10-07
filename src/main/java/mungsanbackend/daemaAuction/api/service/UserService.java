package mungsanbackend.daemaAuction.api.service;

import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.api.entity.user.User;
import mungsanbackend.daemaAuction.api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(String userId) {
        return userRepository.findByUserId(userId);
    }
}
