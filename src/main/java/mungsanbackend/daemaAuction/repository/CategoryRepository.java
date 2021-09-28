package mungsanbackend.daemaAuction.repository;

import mungsanbackend.daemaAuction.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
