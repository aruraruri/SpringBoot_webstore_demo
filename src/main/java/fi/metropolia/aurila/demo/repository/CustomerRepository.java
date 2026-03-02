package fi.metropolia.aurila.demo.repository;

import fi.metropolia.aurila.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
