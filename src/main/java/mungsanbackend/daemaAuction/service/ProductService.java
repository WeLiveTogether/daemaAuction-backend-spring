package mungsanbackend.daemaAuction.service;

import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.repository.CategoryRepository;
import mungsanbackend.daemaAuction.repository.ProductRepository;
import mungsanbackend.daemaAuction.repository.SubCategoryRepository;
import mungsanbackend.daemaAuction.web.dto.response.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ProductRepository productRepository;

    public List<ProductResponse> getProductList() {
        return productRepository.findAll().stream().map(ProductResponse::of).collect(Collectors.toList());
    }

//    @Transactional
//    public ProductResponse createProduct(Long userId) {
//
//    }
}
