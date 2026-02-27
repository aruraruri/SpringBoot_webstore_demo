package fi.metropolia.aurila.demo.controllers;

import fi.metropolia.aurila.demo.entity.Customer;
import fi.metropolia.aurila.demo.repositories.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(final CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable final Integer id) {
        return repository.findById(id).map(customer -> ResponseEntity.ok(customer)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<?> getCustomerOrders(@PathVariable final Integer id) {
        return repository.findById(id).map(customer -> ResponseEntity.ok(customer.getOrders())).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody final Customer customer) {
        return ResponseEntity.ok(repository.save(customer));
    }
}
