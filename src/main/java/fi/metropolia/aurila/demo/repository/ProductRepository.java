package fi.metropolia.aurila.demo.repository;

import fi.metropolia.aurila.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
