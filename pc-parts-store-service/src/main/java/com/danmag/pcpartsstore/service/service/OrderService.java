package com.danmag.pcpartsstore.service.service;


import com.danmag.pcpartsstore.service.dto.OrderItemsDto;
import com.danmag.pcpartsstore.service.model.Customers;
import com.danmag.pcpartsstore.service.model.Order;
import com.danmag.pcpartsstore.service.repository.CustomerRepository;
import com.danmag.pcpartsstore.service.repository.OrderItemRepository;
import com.danmag.pcpartsstore.service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.customerRepository = customerRepository;
    }

    public Order addOrder(OrderItemsDto orderItemsDto, Authentication authentication) throws Exception {
        if (authentication == null) {
            throw new Exception("User is not logged in");

        } else {
            Order order = new Order();
            order.setStatus("pending");
            orderItemsDto.getOrderItems().forEach(OrderItem -> OrderItem.setOrder(order));
            order.setOrderItems(orderItemsDto.getOrderItems());
            String username = authentication.getName();
            Optional<Customers> customers = customerRepository.findByUserName(username);
            customers.ifPresent(order::setCustomers);
            return orderRepository.saveAndFlush(order);
        }


    }

    public List<Order> orderList() {
        return (List<Order>) orderRepository.findAll();
    }


    public Order getOrdersByUserId(long id) {
        Optional<Order> order = orderRepository.findByCustomersId(id);
        if (order.isPresent()) {
            return order.get();
        }
        throw new NoSuchElementException("User with id" + id + " dont have any orders");

    }
}
