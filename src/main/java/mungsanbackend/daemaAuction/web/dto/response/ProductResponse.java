package mungsanbackend.daemaAuction.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.domain.Product;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class ProductResponse {

    private Long productId;
    private String name;
    private int immePrice;
    private int auctionPrice;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startAt;

    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
                .productId(product.getId())
                .name(product.getName())
                .immePrice(product.getImmePrice())
                .auctionPrice(product.getAuctionPrice())
                .startAt(product.getStartAt())
                .build();
    }
}
