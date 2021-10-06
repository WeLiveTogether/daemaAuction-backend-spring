package mungsanbackend.daemaAuction.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.api.entity.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Entity
@Getter
@Builder
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private int immePrice; // 즉시 구매가

    @NotNull
    private int auctionPrice; //현재가 & 시작가

    @Temporal(TemporalType.TIMESTAMP)
    private Date startAt; // 생성 시간

    @Builder.Default
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory;
}
