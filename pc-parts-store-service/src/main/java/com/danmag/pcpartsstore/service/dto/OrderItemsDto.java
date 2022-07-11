package com.danmag.pcpartsstore.service.dto;

import com.danmag.pcpartsstore.service.model.OrderItem;

import java.util.List;

public class OrderItemsDto {

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    private List<OrderItem> orderItems;

}
