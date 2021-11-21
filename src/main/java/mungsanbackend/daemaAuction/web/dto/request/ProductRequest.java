package mungsanbackend.daemaAuction.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class ProductRequest {
    @Schema(description = "물품명", example = "TV")
    private String title;

    @Schema(description = "물품설명", example = "지리는 TV입니다.")
    private String content;

    @Schema(description = "즉시구매가", example = "15000")
    private int immePrice;

    @Schema(description = "경매시작가", example = "1000")
    private int auctionPrice;

    @Schema(description = "메인카테고리 이름", example = "도서")
    private String category;

    @Schema(description = "서브카테고리 이름", example = "전공도서")
    private String subCategory;
}
