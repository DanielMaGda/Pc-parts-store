package com.danmag.pcpartsstore.service.controller;

import com.danmag.pcpartsstore.service.api.ApiResponse;
import com.danmag.pcpartsstore.service.model.Customers;
import com.danmag.pcpartsstore.service.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("")
public class HomeController {

    private final CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/admin/login")
    public void adminLogin() {
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> addUser(@RequestBody Customers user) {

        try {
            customerService.addUser(user);
            return new ResponseEntity<>(new ApiResponse(true, "User registered successfully"), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, "User with username " + user.getUserName() + " already exist"), HttpStatus.CONFLICT);
        }

    }


}
