package fi.metropolia.aurila.demo.controllers;

import fi.metropolia.aurila.demo.entity.Order;
import fi.metropolia.aurila.demo.repositories.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(final OrderRepository repository) {
        this.repository = repository;
    }

    // get order by id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable final Integer id) {
        return repository.findById(id).map(order -> ResponseEntity.ok(order)).orElse(ResponseEntity.notFound().build());
    }
}
