package fi.metropolia.aurila.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="productcategories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "product_category_mapping",  // Name of the join table
            joinColumns = @JoinColumn(name = "category_id"),  // Foreign key to ProductCategory
            inverseJoinColumns = @JoinColumn(name = "product_id")  // Foreign key to Product
    )
    private List<Product> products;

    private String name;

    private String description;

    // getters setters

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
