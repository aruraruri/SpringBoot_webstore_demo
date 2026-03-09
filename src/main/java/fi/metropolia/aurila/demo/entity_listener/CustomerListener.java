package fi.metropolia.aurila.demo.entity_listener;

import fi.metropolia.aurila.demo.entity.Customer;
import jakarta.persistence.PostPersist;

public class CustomerListener {
    @PostPersist
    public void postPersist(Customer c) {
        System.out.println("Customer created: " + c);
    }
}
