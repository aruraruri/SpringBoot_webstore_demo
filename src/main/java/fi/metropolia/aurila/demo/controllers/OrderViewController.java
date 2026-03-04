package fi.metropolia.aurila.demo.controllers;

import fi.metropolia.aurila.demo.entity.OrderView;
import fi.metropolia.aurila.demo.repositories.OrderViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/vieworders")
public class OrderViewController {

    @Autowired
    private OrderViewRepository orderViewRepository;

    @GetMapping
    public List<OrderView> getAllOrders() {
        return orderViewRepository.findAll();
    }

    @GetMapping("/status/{status}")
    public List<OrderView> getOrdersByStatus(@PathVariable String status) {
        return orderViewRepository.findByStatus(status);
    }

    @GetMapping("/customer/{last_name}")
    public List<OrderView> getOrdersByCustomerLastName(@PathVariable String last_name) {
        return orderViewRepository.findByCustomerLastName(last_name);
    }

    @GetMapping("/date-range")
    public List<OrderView> getOrdersBetweenDates(
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        return orderViewRepository.findOrdersBetweenDates(startDate, endDate);
    }
}