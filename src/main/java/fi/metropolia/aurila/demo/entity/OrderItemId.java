package fi.metropolia.aurila.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemId implements Serializable {

    private Integer order;  // This should match the name of the @Id field in OrderItem
    private Integer product; // This should match the name of the @Id field in OrderItem

    public OrderItemId() {}

    public OrderItemId(Integer order, Integer product) {
        this.order = order;
        this.product = product;
    }

    // Getters and setters
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    // equals() and hashCode() are REQUIRED for composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemId that = (OrderItemId) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}