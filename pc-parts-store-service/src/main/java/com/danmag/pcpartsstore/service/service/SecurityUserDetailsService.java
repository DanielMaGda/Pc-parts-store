package com.danmag.pcpartsstore.service.service;

import com.danmag.pcpartsstore.service.security.CustomerDetails;
import com.danmag.pcpartsstore.service.repository.CustomerRepository;
import com.danmag.pcpartsstore.service.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customers customers = customerRepository.findByUserName(username).
                orElseThrow(() -> new UsernameNotFoundException("User not present"));

        return new CustomerDetails(customers);
    }

    public void createUser(UserDetails user) {
        customerRepository.save((Customers) user);
    }
}
