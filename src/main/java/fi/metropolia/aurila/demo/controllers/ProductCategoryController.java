package fi.metropolia.aurila.demo.controllers;

import fi.metropolia.aurila.demo.entity.Product;
import fi.metropolia.aurila.demo.entity.ProductCategory;
import fi.metropolia.aurila.demo.repositories.ProductCategoryRepository;
import fi.metropolia.aurila.demo.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/productcategory")
public class ProductCategoryController {

    private final ProductCategoryRepository productCategoryRepositoryRepositoryREPOSITORY;
    private final ProductRepository productRepository;

    public ProductCategoryController(final ProductCategoryRepository repository, final ProductRepository productRepository) {
         this.productRepository = productRepository;
        this.productCategoryRepositoryRepositoryREPOSITORY = repository;
    }

    @GetMapping("/all")
    public List<ResponseEntity<ProductCategory>> getAllProductCategories() {
        return productCategoryRepositoryRepositoryREPOSITORY.findAll().stream().map(productCategory -> ResponseEntity.ok(productCategory)).toList();
    }

    @GetMapping("/{id}")
    public List<ResponseEntity<ProductCategory>> getCategoryById(@PathVariable final Integer id) {
        return productCategoryRepositoryRepositoryREPOSITORY.findById(id).map(category -> ResponseEntity.ok(category)).stream().toList();
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductsByCategoryId(@PathVariable final Integer id) {
        return productRepository.findAll().stream().filter(product -> product.getCategoryId().equals(id)).toList();
    }
}
