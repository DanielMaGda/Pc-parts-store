package com.danmag.pcpartsstore.service.repository;

import com.danmag.pcpartsstore.service.model.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {


}
