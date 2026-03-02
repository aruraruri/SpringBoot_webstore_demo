package fi.metropolia.aurila.demo.repositories;

import fi.metropolia.aurila.demo.entity.Order;
import fi.metropolia.aurila.demo.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
}
