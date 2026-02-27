package fi.metropolia.aurila.demo.controllers;

import fi.metropolia.aurila.demo.entity.Order;
import fi.metropolia.aurila.demo.entity.Product;
import fi.metropolia.aurila.demo.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(final ProductRepository repository) {
        this.repository = repository;
     }

     @GetMapping("/{id}")
     public ResponseEntity<Product> getProductById(@PathVariable final Integer id) {
         return repository.findById(id).map(product -> ResponseEntity.ok(product)).orElse(ResponseEntity.notFound().build());
     }
}
