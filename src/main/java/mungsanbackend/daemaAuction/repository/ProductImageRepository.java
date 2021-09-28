package mungsanbackend.daemaAuction.repository;

import mungsanbackend.daemaAuction.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
