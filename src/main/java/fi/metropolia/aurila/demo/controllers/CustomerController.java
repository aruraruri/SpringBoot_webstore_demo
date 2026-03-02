package fi.metropolia.aurila.demo.controllers;

import fi.metropolia.aurila.demo.entity.BasicCustomer;
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
    public ResponseEntity<BasicCustomer> getCustomerById(@PathVariable final Integer id) {
        return repository.findById(id).map(basicCustomer -> ResponseEntity.ok(basicCustomer)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<?> getCustomerOrders(@PathVariable final Integer id) {
        return repository.findById(id).map(basicCustomer -> ResponseEntity.ok(basicCustomer.getOrders())).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<BasicCustomer> createCustomer(@RequestBody final BasicCustomer basicCustomer) {
        return ResponseEntity.ok(repository.save(basicCustomer));
    }
}
