package mungsanbackend.daemaAuction.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date startAt; // 생성 시간

    private Long views = 0L; // 조회수

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

    public Product(@NotNull String title, @NotNull String content, @NotNull int immePrice, @NotNull int auctionPrice, User user, Category category, SubCategory subCategory) {
        this.title = title;
        this.content = content;
        this.immePrice = immePrice;
        this.auctionPrice = auctionPrice;
        this.user = user;
        this.category = category;
        this.subCategory = subCategory;
    }
}
