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
    @Query(value = "UPDATE Product p SET p.sale_status= 'SOLD_OUT', p.consumer_id= :consumerId WHERE p.id = :id", nativeQuery = true)
    void updateStatus(@Param("id") Long productId, @Param("consumerId") String consumerId) throws Exception;

    @Modifying
    @Query(value = "UPDATE Product p SET p.auction_price= :price WHERE p.id = :id", nativeQuery = true)
    void updatePrice(@Param("id") Long id, @Param("price") int price) throws Exception;

    @Modifying
    @Query(value = "UPDATE Product p SET p.image_url= :url WHERE p.id = :id", nativeQuery = true)
    void updateImageUrl(@Param("id") Long id, @Param("url") String url) throws Exception;
}
