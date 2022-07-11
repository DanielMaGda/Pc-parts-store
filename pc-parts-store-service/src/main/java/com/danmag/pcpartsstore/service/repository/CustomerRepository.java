package com.danmag.pcpartsstore.service.repository;

import com.danmag.pcpartsstore.service.model.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Long> {

    Optional<Customers> findByUserName(String userName);

    Boolean existsByUserName(String username);

}
