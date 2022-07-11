package com.danmag.pcpartsstore.service.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "OrderItem")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long quantity;



    @ManyToOne(cascade=CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private Order order;
    @OneToOne(cascade = { CascadeType.REMOVE })
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public OrderItem(List<OrderItem> orderItems) {
    }

    public OrderItem() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;

    }

    public long getQuantity() {
        return quantity;
    }

    public OrderItem setQuantity(long quantity) {
        this.quantity = quantity;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}



