package mungsanbackend.daemaAuction.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.ProductSaleStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductResponse {

    private Long productId;
    private String title;
    private String content;
    private int immePrice;
    private int auctionPrice;
    private String imageUrl;
    private ProductSaleStatus saleStatus;
    private Long views;
    private String userName;
    private String category;
    private String subCategory;

    private LocalDateTime createDate;
    private LocalDateTime endDate;

    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
                .productId(product.getId())
                .title(product.getTitle())
                .content(product.getContent())
                .immePrice(product.getImmePrice())
                .auctionPrice(product.getAuctionPrice())
                .saleStatus(product.getSaleStatus())
                .views(product.getViews())
                .createDate(product.getCreateDate())
                .endDate(product.getCreateDate().plusHours(24))
                .userName(product.getUser().getUsername())
                .category(product.getCategory().getName())
                .subCategory(product.getSubCategory().getName())
                .build();
    }
}
