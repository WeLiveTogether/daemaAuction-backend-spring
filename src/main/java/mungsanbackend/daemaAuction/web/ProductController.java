package mungsanbackend.daemaAuction.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.service.ProductService;
import mungsanbackend.daemaAuction.service.S3UploaderService;
import mungsanbackend.daemaAuction.web.dto.request.ProductRequest;
import mungsanbackend.daemaAuction.web.dto.response.ProductDetailsResponse;
import mungsanbackend.daemaAuction.web.dto.response.ProductImageResponse;
import mungsanbackend.daemaAuction.web.dto.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<ProductResponse> responses = productService.getProductList();
        for (int i = 0; i < responses.size(); i++) {
            Optional<Product> product = productService.getProductById(responses.get(i).getProductId());
            String url = product.get().getProductImages().get(0).getUrl();
            responses.get(i).setImageUrl(url);
        }
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "Product 인기순으로 정렬")
    @GetMapping("/products-popularity")
    public ResponseEntity<List<ProductResponse>> productListByPopularity() {
        List<ProductResponse> responses = productService.getProductListByViews();
        for (int i = 0; i < responses.size(); i++) {
            Optional<Product> product = productService.getProductById(responses.get(i).getProductId());
            String url = product.get().getProductImages().get(0).getUrl();
            responses.get(i).setImageUrl(url);
        }
        return ResponseEntity.ok(responses);
    }

    @Operation(summary = "경매 글 작성", description = "성공 시 경매물품 Response 반환")
    @PostMapping(value = "/product")
    public ResponseEntity<ProductResponse> addProduct(@Parameter @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest.getUserSeq(), productRequest));
    }

    @Operation(summary = "사진 업로드", description = "성공 시 업로드 된 사진들 List로 반환")
    @PostMapping(value = "/product/image/upload")
    public ResponseEntity<List<ProductImageResponse>> upload(@Parameter @RequestParam(value = "file") List<MultipartFile> multipartFile, @Parameter @RequestParam(value = "productId") String productId) throws IOException {
        Long id = Long.parseLong(productId);
        List<ProductImageResponse> list = new ArrayList<>();
        for (int i = 0; i < multipartFile.size(); i++) {
            MultipartFile file = multipartFile.get(i);
            if (!file.isEmpty()) {
                System.out.println(file.getName());
                String url = s3UploaderService.upload(file, "static");
                list.add(productService.createImage(id, url));
                log.info(url);
            }
        }
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "경매 물품 상세보기")
    @GetMapping(value = "/product-details/{productId}")
    public ResponseEntity<List<ProductDetailsResponse>> productDetails(@Parameter @PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productService.findProductById(productId));
    }

/*    @Operation(summary = "경매 물품 상세보기")
    @GetMapping(value = "/product-details/{productId}")
    public ApiResponse productDetails(@PathVariable("productId") Long productId) {
        List<ProductResponse> product = productService.findProductById(productId);
        return ApiResponse.success("product", product);
    }*/
}
