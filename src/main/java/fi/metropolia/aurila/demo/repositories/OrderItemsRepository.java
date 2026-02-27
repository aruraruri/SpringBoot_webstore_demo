package fi.metropolia.aurila.demo.repositories;

import fi.metropolia.aurila.demo.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer> {

}
