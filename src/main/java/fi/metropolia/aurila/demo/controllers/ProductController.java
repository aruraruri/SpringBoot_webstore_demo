package fi.metropolia.aurila.demo.controllers;

import fi.metropolia.aurila.demo.entity.Product;
import fi.metropolia.aurila.demo.repositories.ProductCategoryRepository;
import fi.metropolia.aurila.demo.repositories.ProductRepository;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
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

    @PostMapping("/newproduct")
    public ResponseEntity<Product> createProduct(@RequestBody final Product product) {
        // Check if the category exists before creating the product
        if (product.getCategoryId() != null && !categoryRepository.existsById(product.getCategoryId())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productRepository.save(product));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable final Integer id,
                                                 @RequestBody final Product updatedProduct) {
        java.util.Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            // Update only non-null fields from the request
            if (updatedProduct.getName() != null) {
                existingProduct.setName(updatedProduct.getName());
            }
            if (updatedProduct.getDescription() != null) {
                existingProduct.setDescription(updatedProduct.getDescription());
            }
            if (updatedProduct.getPrice() != null) {
                existingProduct.setPrice(updatedProduct.getPrice());
            }
            if (updatedProduct.getCategoryId() != null) {
                // Validate that the category exists
                if (!categoryRepository.existsById(updatedProduct.getCategoryId())) {
                    return ResponseEntity.badRequest().build();
                }
                existingProduct.setCategoryId(updatedProduct.getCategoryId());
            }

            // Save the updated existing product
            return ResponseEntity.ok(productRepository.save(existingProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/order")
    public ResponseEntity<?> placeOrder(@PathVariable Integer id, @RequestParam Integer quantity) {
        try {
            Product product = productRepository.findById(id).orElseThrow();
            if (product.getStockQuantity() < quantity) {
                return ResponseEntity.badRequest().body("Insufficient stock");
            }

            product.setStockQuantity(product.getStockQuantity() - quantity);
            productRepository.save(product);

            return ResponseEntity.ok().build();
        } catch (OptimisticLockException e) {
            return ResponseEntity.status(409).body("Stock changed, please try again");
        }
    }


}
