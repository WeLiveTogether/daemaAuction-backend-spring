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
    private String title;
    private int auctionPrice;
    private Long views;
    private ProductSaleStatus saleStatus;
    private String category;
    private String subCategory;

    public static MyProductResponse of(Product product) {
        return MyProductResponse.builder()
                .title(product.getTitle())
                .auctionPrice(product.getAuctionPrice())
                .views(product.getViews())
                .saleStatus(product.getSaleStatus())
                .category(product.getCategory().getName())
                .subCategory(product.getSubCategory().getName())
                .build();
    }
}
