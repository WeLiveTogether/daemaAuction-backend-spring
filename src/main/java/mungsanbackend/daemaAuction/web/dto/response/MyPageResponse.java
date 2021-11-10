package mungsanbackend.daemaAuction.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.domain.*;

@Getter
@Builder
@AllArgsConstructor
public class MyPageResponse {

    // user
    private String userName;
    private String email;
    private String profileImageUrl;

    // product 자신이 등록한 상품, 거래완료된 상품
    private String title;
    private int auctionPrice;
    private Long views;
    private ProductSaleStatus saleStatus;
    private Category category;
    private SubCategory subCategory;

    public static MyPageResponse of(Product product) {
        return MyPageResponse.builder()
                .userName(product.getUser().getUsername())
                .email(product.getUser().getEmail())
                .profileImageUrl(product.getUser().getProfileImageUrl())
                .title(product.getTitle())
                .auctionPrice(product.getAuctionPrice())
                .views(product.getViews())
                .saleStatus(product.getSaleStatus())
                .category(product.getCategory())
                .subCategory(product.getSubCategory())
                .build();
    }
}