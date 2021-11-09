package mungsanbackend.daemaAuction.web.dto.request;

import lombok.Getter;
import mungsanbackend.daemaAuction.domain.ProductSaleStatus;

@Getter
public class ProductRequest {
    private Long userSeq;
    private String title;
    private String content;
    private int immePrice;
    private int auctionPrice;
    private ProductSaleStatus productSaleStatus;
    private String category;
    private String subCategory;
}
