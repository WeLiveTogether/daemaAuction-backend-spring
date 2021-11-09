package mungsanbackend.daemaAuction.web.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import mungsanbackend.daemaAuction.domain.Product;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductResponse {

    private Long productId;
    private String title;
    private String content;
    private int immePrice;
    private int auctionPrice;
    private String imageUrl;
    private Long views;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;

    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
                .productId(product.getId())
                .title(product.getTitle())
                .content(product.getContent())
                .immePrice(product.getImmePrice())
                .auctionPrice(product.getAuctionPrice())
                .views(product.getViews())
                .createDate(product.getCreatedDate())
                .build();
    }
}
