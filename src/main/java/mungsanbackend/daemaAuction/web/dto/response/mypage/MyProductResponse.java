package mungsanbackend.daemaAuction.web.dto.response.mypage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.ProductSaleStatus;

@Getter
@Builder
@AllArgsConstructor
public class MyProductResponse {

    // product 자신이 등록한 상품, 거래완료된 상품
    private Long productId;
    private String title;
    private String content;
    private int immePrice;
    private int auctionPrice;
    private String imageUrl;
    private Long views;
    private ProductSaleStatus saleStatus;
    private String userName;
    private String category;
    private String subCategory;

    public static MyProductResponse of(Product product) {
        return MyProductResponse.builder()
                .productId(product.getId())
                .title(product.getTitle())
                .content(product.getContent())
                .immePrice(product.getImmePrice())
                .auctionPrice(product.getAuctionPrice())
                .imageUrl(product.getImageUrl())
                .views(product.getViews())
                .saleStatus(product.getSaleStatus())
                .userName(product.getUser().getUsername())
                .category(product.getCategory().getName())
                .subCategory(product.getSubCategory().getName())
                .build();
    }
}
