package mungsanbackend.daemaAuction.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.oauth.annotation.UserId;
import mungsanbackend.daemaAuction.service.ProductService;
import mungsanbackend.daemaAuction.service.S3UploaderService;
import mungsanbackend.daemaAuction.web.dto.request.ProductRequest;
import mungsanbackend.daemaAuction.web.dto.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;
    private final S3UploaderService s3UploaderService;

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

    @Operation(summary = "경매 글 작성")
    @PostMapping("/product")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest, @RequestParam("images")MultipartFile multipartFile, @UserId Long userId) throws IOException {
        s3UploaderService.upload(multipartFile, "static");
        return ResponseEntity.ok(productService.createProduct(userId, productRequest));
    }

}
