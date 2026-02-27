package fi.metropolia.aurila.demo.controllers;

import fi.metropolia.aurila.demo.entity.Order;
import fi.metropolia.aurila.demo.entity.OrderItem;
import fi.metropolia.aurila.demo.entity.Product;
import fi.metropolia.aurila.demo.repositories.OrderRepository;
import fi.metropolia.aurila.demo.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderController(final OrderRepository orderRepository,
                           final ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    // get order by id
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable final Integer id) {
        return orderRepository.findById(id).map(order -> ResponseEntity.ok(order)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Order> createOrder(@RequestBody final Order order) {
        // Set the order reference on each order item and attach managed products
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                item.setOrder(order);

                // Fetch and attach the managed product from database
                if (item.getProduct() != null) {
                    Product managedProduct = productRepository.findById(item.getProduct().getId())
                            .orElseThrow(() -> new RuntimeException("Product not found with id: " + item.getProduct().getId()));
                    item.setProduct(managedProduct);
                }
            }
        }

        return ResponseEntity.ok(orderRepository.save(order));
    }
}
