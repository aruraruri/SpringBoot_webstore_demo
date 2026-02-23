package fi.metropolia.aurila.demo;

import fi.metropolia.aurila.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
