package mungsanbackend.daemaAuction.repository;

import mungsanbackend.daemaAuction.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(String userId);
}
