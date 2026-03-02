package fi.metropolia.aurila.demo.controllers;

import fi.metropolia.aurila.demo.entity.ProductCategory;
import fi.metropolia.aurila.demo.repositories.ProductCategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {

    private final ProductCategoryRepository repository;

    public ProductCategoryController(final ProductCategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<ResponseEntity<ProductCategory>> getAllProductCategories() {
        return repository.findAll().stream().map(productCategory -> ResponseEntity.ok(productCategory)).toList();
    }

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable final Integer id) {
        return repository.findById(id).map(category -> ResponseEntity.ok(category).toString()).orElse(ResponseEntity.notFound().toString());
    }
}
