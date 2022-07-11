package com.danmag.pcpartsstore.service.controller;

import com.danmag.pcpartsstore.service.api.ApiResponse;
import com.danmag.pcpartsstore.service.model.Customers;
import com.danmag.pcpartsstore.service.repository.CustomerRepository;
import com.danmag.pcpartsstore.service.repository.UserRoleRepository;
import com.danmag.pcpartsstore.service.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/user")
@RestController
public class CustomerController {
    private final CustomerService customerService;
    CustomerRepository customerRepository;
    UserRoleRepository userRoleRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository, UserRoleRepository userRoleRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping("/")
    public List<Customers> getUsers() {
        return customerService.getAll();
    }


    @GetMapping(value = "/{userName}")
    public ResponseEntity<Object> getById(@PathVariable String userName) {
        try {
            var Customer = customerService.getByUserName(userName);
            return new ResponseEntity<>(Customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, "User with name" + userName + " not found"), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") long id) {
        try {
            customerService.deleteUser(id);
            return new ResponseEntity<>(new ApiResponse(true, "User has been deleted"), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, "User with id" + id + " not found"), HttpStatus.NOT_FOUND);
        }


    }
}


