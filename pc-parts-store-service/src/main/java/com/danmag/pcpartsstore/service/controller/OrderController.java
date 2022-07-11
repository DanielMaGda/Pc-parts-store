package com.danmag.pcpartsstore.service.controller;

import com.danmag.pcpartsstore.service.api.ApiResponse;
import com.danmag.pcpartsstore.service.dto.OrderItemsDto;
import com.danmag.pcpartsstore.service.model.Order;
import com.danmag.pcpartsstore.service.repository.CustomerRepository;
import com.danmag.pcpartsstore.service.repository.OrderItemRepository;
import com.danmag.pcpartsstore.service.service.CustomerService;
import com.danmag.pcpartsstore.service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/order")
@RestController
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderController(OrderService orderService, CustomerService customerService, CustomerRepository customerRepository, OrderItemRepository orderItemRepository) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addOrder(
            @RequestBody OrderItemsDto orderItemsList, Authentication authentication
    ) {
        try {
            orderService.addOrder(orderItemsList, authentication);
            return new ResponseEntity<>(new ApiResponse(true, "Order has been added"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, "Something went wrong"), HttpStatus.BAD_REQUEST);

        }


    }

    @GetMapping()
    public List<Order> getAllOrders() {

        return orderService.orderList();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getOrderByUserId(@PathVariable("id") long id) {
        try {
            var order = orderService.getOrdersByUserId(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, "User with id " + id + " dont have any orders"), HttpStatus.NOT_FOUND);

        }

    }

}


