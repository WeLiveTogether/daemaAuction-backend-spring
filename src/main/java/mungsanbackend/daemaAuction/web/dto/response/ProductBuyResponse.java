package mungsanbackend.daemaAuction.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.domain.ProductSaleStatus;

@Getter
@Builder
@AllArgsConstructor
public class ProductBuyResponse {

    private Long productId;
    private String title;
    private int immePrice;
    private int auctionPrice;
    private ProductSaleStatus saleStatus;
    private String category;
    private String subCategory;

    private String consumerId;

}
