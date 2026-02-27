package fi.metropolia.aurila.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="orderitems")
@IdClass(OrderItemId.class)
public class OrderItem {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="unit_price")
    private BigDecimal price;

    // Important: Add this method to help with JSON serialization/deserialization
    public Integer getOrderId() {
        return order != null ? order.getId() : null;
    }

    // getters and setters
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}