package com.shoppingcart.bus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.bus.entity.Order;

@Repository
public interface OrderRP extends CrudRepository<Order, Long> {

}