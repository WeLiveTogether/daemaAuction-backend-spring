package mungsanbackend.daemaAuction.domain.product.productImage;

import lombok.Getter;
import mungsanbackend.daemaAuction.domain.product.Product;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String path;

    private Long size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
