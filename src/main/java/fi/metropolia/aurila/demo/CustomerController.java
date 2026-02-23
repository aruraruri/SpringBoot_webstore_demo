package fi.metropolia.aurila.demo;

import fi.metropolia.aurila.demo.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(final CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable final Integer id) {
        return repository.findById(String.valueOf(id)).map(customer -> ResponseEntity.ok(customer)).orElse(ResponseEntity.notFound().build());
    }
}
