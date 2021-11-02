package mungsanbackend.daemaAuction.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mungsanbackend.daemaAuction.oauth.annotation.UserSeq;
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
@Slf4j
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
    @PostMapping(value = "/product")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest.getUserSeq(), productRequest));
    }

    @Operation(summary = "사진 업로드")
    @PostMapping(value = "/product/image/upload")
    public void upload(@RequestParam(value = "file") List<MultipartFile> multipartFile) throws IOException {

        for (int i = 0; i < multipartFile.size(); i++) {
            MultipartFile file = multipartFile.get(i);
            if (!file.isEmpty()) {
                System.out.println(file.getName());
                String url = s3UploaderService.upload(file, "static");
                log.info(url);
            }
        }

    }
}
