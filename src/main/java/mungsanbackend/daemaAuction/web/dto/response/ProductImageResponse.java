package mungsanbackend.daemaAuction.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.ProductImage;

@Getter
@Builder
@AllArgsConstructor
public class ProductImageResponse {
    private Long id;
    private String url;
    private Product product;

    public static ProductImageResponse of(ProductImage productImage) {
        return ProductImageResponse.builder()
                .id(productImage.getId())
                .url(productImage.getUrl())
                .product(productImage.getProduct())
                .build();
    }
}
