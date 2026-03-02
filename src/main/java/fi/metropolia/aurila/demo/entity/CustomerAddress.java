package fi.metropolia.aurila.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customeraddresses")
public class CustomerAddress {
    @Id
    private Integer id;
}
