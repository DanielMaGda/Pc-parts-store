package com.danmag.pcpartsstore.service.service;


import com.danmag.pcpartsstore.service.model.Customers;
import com.danmag.pcpartsstore.service.model.UserRole;
import com.danmag.pcpartsstore.service.repository.CustomerRepository;
import com.danmag.pcpartsstore.service.repository.UserRoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomerService {
    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;
    private final UserRoleRepository userRoleRepository;

    public CustomerService(PasswordEncoder passwordEncoder, CustomerRepository customerRepository, UserRoleRepository userRoleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
        this.userRoleRepository = userRoleRepository;
    }


    public void addUser(Customers user) throws Exception {
        if (customerRepository.existsByUserName(user.getUserName())) {
            throw new Exception("User with this " + user.getUserName() + " exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserRole roles = userRoleRepository.findByName("USER").orElse(null);
        if (roles != null) {
            user.setRoles(Collections.singleton(roles));
            customerRepository.save(user);
            return;
        }
        throw new NoSuchElementException("Role not present");


    }

    public Customers getByUserName(String userName) {
        Optional<Customers> customers = customerRepository.findByUserName(userName);
        if (customers.isPresent()) {
            return customers.get();
        }
        throw new NoSuchElementException("User with " + userName + " not present");

    }

    public List<Customers> getAll() {
        return (List<Customers>) customerRepository.findAll();
    }

    public void deleteUser(long id) {
        Customers customers = customerRepository.findById(id).orElse(null);
        if (customers != null) {
            customerRepository.delete(customers);
        } else {
            throw new NoSuchElementException("User with " + id + " not present");

        }

    }

}

