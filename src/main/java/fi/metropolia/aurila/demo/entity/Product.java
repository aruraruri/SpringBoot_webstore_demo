package fi.metropolia.aurila.demo.entity;

import fi.metropolia.aurila.demo.converter.ProductPriceConverter;
import fi.metropolia.aurila.demo.entity_listener.CustomerListener;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="products")
@EntityListeners(CustomerListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    @Convert(converter = ProductPriceConverter.class)
    private BigDecimal price;
    @Column(name="category_id")
    private Integer categoryId;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private List<ProductCategory> categories;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    // getters setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
