package mungsanbackend.daemaAuction.domain.category.subCategory;

import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.domain.category.Category;

import javax.persistence.*;

@Entity
@Getter
@Builder
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
