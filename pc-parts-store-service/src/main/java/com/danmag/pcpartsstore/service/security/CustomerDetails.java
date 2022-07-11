package com.danmag.pcpartsstore.service.security;

import com.danmag.pcpartsstore.service.model.Customers;
import com.danmag.pcpartsstore.service.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CustomerDetails implements UserDetails {

    private final Customers customers;

    public CustomerDetails(Customers customers) {
        this.customers = customers;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<UserRole> roles = customers.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (UserRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return customers.getPassword();
    }

    @Override
    public String getUsername() {
        return customers.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return customers.isEnabled();
    }
}
