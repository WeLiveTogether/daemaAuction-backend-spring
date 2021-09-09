package mungsanbackend.daemaAuction.domain.category.subCateogory;

import mungsanbackend.daemaAuction.domain.category.Category;

import javax.persistence.*;

@Entity
public class SubCateogory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
