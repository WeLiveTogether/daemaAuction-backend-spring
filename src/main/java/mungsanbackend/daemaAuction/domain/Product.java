package mungsanbackend.daemaAuction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private int immePrice; // 즉시 구매가

    @NotNull
    private int auctionPrice; //현재가 & 시작가

    private Long views = 0L; // 조회수

    @Column(name = "SALE_STATUS", length = 20)
    @Enumerated(EnumType.STRING)
    private ProductSaleStatus saleStatus;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory;

    // 구매자 id
    private Long customerId;

    public Product(@NotNull String title,
                   @NotNull String content,
                   @NotNull int immePrice,
                   @NotNull int auctionPrice,
                   ProductSaleStatus saleStatus,
                   User user,
                   Category category,
                   SubCategory subCategory) {
        this.title = title;
        this.content = content;
        this.immePrice = immePrice;
        this.auctionPrice = auctionPrice;
        this.saleStatus = saleStatus;
        this.user = user;
        this.category = category;
        this.subCategory = subCategory;
    }
}
