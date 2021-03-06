package mungsanbackend.daemaAuction.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.ProductImage;
import mungsanbackend.daemaAuction.domain.ProductSaleStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ProductDetailsResponse {

    // product
    private String title;
    private String content;
    private int immePrice; // 즉시 구매가
    private int auctionPrice; //현재가 & 시작가
    private Long views; // 조회수
    private List<ProductImage> productImages;

    // product - User
    private String userId;
    private String username;
    private String email;
    private String profileImageUrl;

    // product - Category
    private String categoryName;

    //product - SubCategory
    private String subCategoryName;

    private ProductSaleStatus saleStatus;

    private LocalDateTime endDate;

    private String imageUrl;

    public static ProductDetailsResponse of(Product product) {
        return ProductDetailsResponse.builder()
                .title(product.getTitle())
                .content(product.getContent())
                .immePrice(product.getImmePrice())
                .auctionPrice(product.getAuctionPrice())
                .views(product.getViews())
                .productImages(product.getProductImages())
                .userId(product.getUser().getUserId())
                .username(product.getUser().getUsername())
                .email(product.getUser().getEmail())
                .profileImageUrl(product.getUser().getProfileImageUrl())
                .categoryName(product.getCategory().getName())
                .subCategoryName(product.getSubCategory().getName())
                .saleStatus(product.getSaleStatus())
                .endDate(product.getCreateDate().plusHours(24))
                .build();
    }
}
