package fi.metropolia.aurila.demo.controllers;

import fi.metropolia.aurila.demo.entity.Product;
import fi.metropolia.aurila.demo.repositories.ProductCategoryRepository;
import fi.metropolia.aurila.demo.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository categoryRepository;

    public ProductController(final ProductRepository productRepository, final ProductCategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
     }

     @GetMapping("/{id}")
     public ResponseEntity<Product> getProductById(@PathVariable final Integer id) {
         return productRepository.findById(id).map(product -> ResponseEntity.ok(product)).orElse(ResponseEntity.notFound().build());
     }
     
     @GetMapping("/all")
     public ResponseEntity<?> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }


}
