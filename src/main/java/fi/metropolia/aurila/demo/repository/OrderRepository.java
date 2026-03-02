package fi.metropolia.aurila.demo.repository;

import fi.metropolia.aurila.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer>{
}
