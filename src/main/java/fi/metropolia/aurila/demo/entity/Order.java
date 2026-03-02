package fi.metropolia.aurila.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private BasicCustomer basicCustomer;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    // getters setters

    public int getId() {
        return id;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        if (orderItems != null) {
            for (OrderItem item : orderItems) {
                item.setOrder(this);
            }
        }
    }

    public BasicCustomer getCustomer() {
        return basicCustomer;
    }

    public void setCustomer(BasicCustomer basicCustomer) {
        this.basicCustomer = basicCustomer;
    }

    public java.util.Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(java.util.Date orderDate) {
        this.orderDate = orderDate;
    }


}
