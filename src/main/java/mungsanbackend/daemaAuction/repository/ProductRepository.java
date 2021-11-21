package mungsanbackend.daemaAuction.repository;

import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByUser(User user);
    Product findProductById(Long productId);


    @Modifying
    @Query(value = "UPDATE Product p SET p.sale_status= 'SOLD_OUT' WHERE p.id = :id", nativeQuery = true)
    void updateStatus(@Param("id") Long id) throws Exception;

}
