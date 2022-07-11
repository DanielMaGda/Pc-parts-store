package com.danmag.pcpartsstore.service.model;


import com.danmag.pcpartsstore.service.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@CrossOrigin
@Entity
@Table(name = "Product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "Manufacturer")
    private String manufacturer;

    @Column(name = "Price")
    private long price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    @OneToOne(mappedBy = "product",orphanRemoval = true)
    @JsonIgnore
    private OrderItem orderItem;

    public Product() {
    }

    public Product(ProductDto productDto) {
        this.id = productDto.getId();
        this.name = productDto.getName();
        this.category = productDto.getCategory();
        this.manufacturer = productDto.getManufacturer();
        this.price = productDto.getPrice();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Product setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public Product setPrice(long price) {
        this.price = price;
        return this;
    }

    public long getId() {
        return id;
    }

    public Product setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

}