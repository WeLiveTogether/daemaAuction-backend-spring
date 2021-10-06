package mungsanbackend.daemaAuction.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.service.ProductService;
import mungsanbackend.daemaAuction.web.dto.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Product 최신순으로 정렬")
    @GetMapping("/products-latest")
    public ResponseEntity<List<ProductResponse>> productListByLatest() {
        return ResponseEntity.ok(productService.getProductList());
    }

    @Operation(summary = "Product 인기순으로 정렬")
    @GetMapping("/products-popularity")
    public ResponseEntity<List<ProductResponse>> productListByPopularity() {
        return ResponseEntity.ok(productService.getProductListByViews());
    }
}
