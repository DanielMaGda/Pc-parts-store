package com.danmag.pcpartsstore.service.dto;

import com.danmag.pcpartsstore.service.model.Product;
import com.danmag.pcpartsstore.service.model.Category;

public class ProductDto {
    private long id;
    private String name;
    private Category category;
    private String manufacturer;
    private long price;

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setCategory(product.getCategory());
        this.setManufacturer(product.getManufacturer());
        this.setPrice(product.getPrice());
    }

    public ProductDto(long id, String name, Category category, String manufacturer, long price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public ProductDto setId(long id) {

        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {

        this.name = name;
        return this;
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

    public ProductDto setManufacturer(String manufacturer) {

        this.manufacturer = manufacturer;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public ProductDto setPrice(long price) {

        this.price = price;
        return this;
    }


}
