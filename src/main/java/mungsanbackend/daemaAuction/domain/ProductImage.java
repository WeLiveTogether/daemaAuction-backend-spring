package mungsanbackend.daemaAuction.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mungsanbackend.daemaAuction.domain.Product;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
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
