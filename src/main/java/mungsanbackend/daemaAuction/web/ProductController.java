package mungsanbackend.daemaAuction.web;

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

    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> productList() {
        return ResponseEntity.ok(productService.getProductList());
    }
}
