package mungsanbackend.daemaAuction.api.repository;

import mungsanbackend.daemaAuction.api.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String userId);
}
