package mungsanbackend.daemaAuction.web.dto.request;

import lombok.Getter;

@Getter
public class ProductRequest {
    private String title;
    private String content;
    private int immePrice;
    private int auctionPrice;
    private String category;
    private String subCategory;
}
