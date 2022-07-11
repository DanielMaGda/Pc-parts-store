package com.danmag.pcpartsstore.service.repository;

import com.danmag.pcpartsstore.service.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
