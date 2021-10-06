package mungsanbackend.daemaAuction.repository;

import mungsanbackend.daemaAuction.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Modifying
//    @Query("UPDATE Product A SET A.view = A.view + 1 WHERE A.id = :id")
//    Integer updateView(Long id);
}
