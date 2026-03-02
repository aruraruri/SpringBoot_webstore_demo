package fi.metropolia.aurila.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="customeraddresses")
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="customer_id")
    private Integer customerId;
    @Column(name="street_address")
    private String streetAddress;

    @OneToOne(optional=false)
    @JoinColumn(name="customer_id", referencedColumnName="id", insertable=false, updatable=false)
    private Customer customer;
}
