package fi.metropolia.aurila.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.util.Date;
import java.util.UUID;

@Entity
@Immutable
@Table(name="view_orders")
public class OrderView {

    @Id
    private Integer id;

    private String first_name;
    private String last_name;
    private String email;
    private String street_address;
    private String status;
    private Date order_date;
    private Date delivery_date;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet_address() {
        return street_address;
    }

    public String getStatus() {
        return status;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public String getName() {
        return name;
    }
}
