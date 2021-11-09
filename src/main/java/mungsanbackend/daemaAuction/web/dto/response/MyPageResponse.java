package mungsanbackend.daemaAuction.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.domain.Category;
import mungsanbackend.daemaAuction.domain.ProductSaleStatus;
import mungsanbackend.daemaAuction.domain.SubCategory;
import mungsanbackend.daemaAuction.oauth.entity.ProviderType;

@Getter
@Builder
@AllArgsConstructor
public class MyPageResponse {

    // user
    private String userName;
    private String email;
    private String profileImageUrl;
    private ProviderType providerType;

    // product 자신이 등록한 상품, 거래완료된 상품
    private String title;
    private int auctionPrice;
    private Long views;
    private ProductSaleStatus SaleStatus;
    private Category category;
    private SubCategory subCategory;
}