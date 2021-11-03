package mungsanbackend.daemaAuction.service;

import lombok.RequiredArgsConstructor;
import mungsanbackend.daemaAuction.domain.Category;
import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.SubCategory;
import mungsanbackend.daemaAuction.domain.User;
import mungsanbackend.daemaAuction.repository.CategoryRepository;
import mungsanbackend.daemaAuction.repository.ProductRepository;
import mungsanbackend.daemaAuction.repository.SubCategoryRepository;
import mungsanbackend.daemaAuction.web.dto.request.ProductRequest;
import mungsanbackend.daemaAuction.web.dto.response.ProductDetailsResponse;
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
    private final UserService userService;

    public List<ProductResponse> getProductList() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream().map(ProductResponse::of).collect(Collectors.toList());
    }

    public List<ProductResponse> getProductListByViews() {
        return productRepository.findAll(Sort.by(Sort.Direction.DESC, "views")).stream().map(ProductResponse::of).collect(Collectors.toList());
    }

    @Transactional
    public ProductResponse createProduct(Long userSeq, ProductRequest productRequest) {
        User user = userService.findUserBySeq(userSeq);
        Category category = findCategoryByName(productRequest.getCategory());
        SubCategory subCategory = findSubCategoryByName(productRequest.getSubCategory());
        Product product = new Product(productRequest.getTitle(), productRequest.getContent(), productRequest.getImmePrice(), productRequest.getAuctionPrice(), user, category, subCategory);
        Product savedProduct = productRepository.save(product);
        return ProductResponse.of(savedProduct);
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
        return categoryRepository.findByName(name).orElseThrow(() -> new RuntimeException("Category를 찾을 수 없습니다."));
    }

    private SubCategory findSubCategoryByName(String name) {
        Optional<SubCategory> subCategory = subCategoryRepository.findByName(name);
        subCategory.ifPresent(selectSubCategory -> {
            System.out.println(selectSubCategory.getName());
        });
        return subCategoryRepository.findByName(name).orElseThrow(() -> new RuntimeException("SubCategory를 찾을 수 없습니다."));
    }
}
