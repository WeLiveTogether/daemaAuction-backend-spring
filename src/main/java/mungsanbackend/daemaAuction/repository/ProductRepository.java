package mungsanbackend.daemaAuction.repository;

import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByUser(User user);
}
