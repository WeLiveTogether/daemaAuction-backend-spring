package mungsanbackend.daemaAuction.domain.product;

import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.domain.BaseTimeEntity;
import mungsanbackend.daemaAuction.domain.category.Category;
import mungsanbackend.daemaAuction.domain.category.subCategory.SubCategory;
import mungsanbackend.daemaAuction.domain.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
