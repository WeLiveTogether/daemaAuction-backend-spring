package mungsanbackend.daemaAuction.service;

import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.domain.*;
import mungsanbackend.daemaAuction.exception.CategoryNotFoundException;
import mungsanbackend.daemaAuction.exception.SubCategoryNotFoundException;
import mungsanbackend.daemaAuction.repository.CategoryRepository;
import mungsanbackend.daemaAuction.repository.ProductImageRepository;
import mungsanbackend.daemaAuction.repository.ProductRepository;
import mungsanbackend.daemaAuction.repository.SubCategoryRepository;
import mungsanbackend.daemaAuction.web.dto.request.ProductRequest;
import mungsanbackend.daemaAuction.web.dto.response.ProductDetailsResponse;
import mungsanbackend.daemaAuction.web.dto.response.ProductImageResponse;
import mungsanbackend.daemaAuction.web.dto.response.ProductResponse;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final UserService userService;

    public List<ProductResponse> getProductList() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream().map(ProductResponse::of).collect(Collectors.toList());
    }

    public List<ProductResponse> getProductListByViews() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "views")).stream().map(ProductResponse::of).collect(Collectors.toList());
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public ProductResponse createProduct(Long userSeq, ProductRequest productRequest) {
        User user = userService.findUserBySeq(userSeq);
        Category category = findCategoryByName(productRequest.getCategory());
        SubCategory subCategory = findSubCategoryByName(productRequest.getSubCategory());
        Product product = new Product(productRequest.getTitle(), productRequest.getContent(), productRequest.getImmePrice(), productRequest.getAuctionPrice(), productRequest.getSaleStatus(), user, category, subCategory);
        Product savedProduct = productRepository.save(product);
        return ProductResponse.of(savedProduct);
    }

    @Transactional
    public ProductImageResponse createImage(Long productId, String url) {
        Optional<Product> product = getProductById(productId);
        ProductImage productImage = new ProductImage(url, product);
        ProductImage savedProductImage = productImageRepository.save(productImage);
        return ProductImageResponse.of(savedProductImage);
    }

    public List<ProductDetailsResponse> findProductById(Long productId) {
        Optional<Product> productList = productRepository.findById(productId);
        return productList.stream().map(ProductDetailsResponse::of).collect(Collectors.toList());
    }

    private Category findCategoryByName(String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        category.ifPresent(selectCategory -> {
            System.out.println(selectCategory.getName());
        });
        return categoryRepository.findByName(name).orElseThrow(CategoryNotFoundException::new);
    }

    private SubCategory findSubCategoryByName(String name) {
        Optional<SubCategory> subCategory = subCategoryRepository.findByName(name);
        subCategory.ifPresent(selectSubCategory -> {
            System.out.println(selectSubCategory.getName());
        });
        return subCategoryRepository.findByName(name).orElseThrow(SubCategoryNotFoundException::new);
    }
}
