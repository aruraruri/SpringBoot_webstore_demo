package fi.metropolia.aurila.demo.entity;

import fi.metropolia.aurila.demo.converter.ProductPriceConverter;
import fi.metropolia.aurila.demo.entity_listener.CustomerListener;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Version
    @Column(name="version")
    private Integer version;

    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    @Convert(converter = ProductPriceConverter.class)
    private Double price;
    @Column(name="stock_quantity")
    private Integer stockQuantity;
    @Column(name="category_id")
    private Integer categoryId;
    @Column(name="supplier_id")
    private Integer supplierId;

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

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public List<ProductCategory> getCategories() {
        return categories;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }
}
