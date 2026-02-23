package fi.metropolia.aurila.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="first_name")
    private String firstName;

    // getters setters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
}
