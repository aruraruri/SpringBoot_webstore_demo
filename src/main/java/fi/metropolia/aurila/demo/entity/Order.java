package fi.metropolia.aurila.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date orderDate;
}
