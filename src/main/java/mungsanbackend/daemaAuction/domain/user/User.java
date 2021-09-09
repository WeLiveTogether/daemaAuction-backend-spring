package mungsanbackend.daemaAuction.domain.user;

import lombok.Getter;
import mungsanbackend.daemaAuction.domain.BaseTimeEntity;
import mungsanbackend.daemaAuction.domain.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 4)
    private int gcn;

    private String email;

    @OneToMany(mappedBy = "user")
    private List<Product> products = new ArrayList<>();
}
