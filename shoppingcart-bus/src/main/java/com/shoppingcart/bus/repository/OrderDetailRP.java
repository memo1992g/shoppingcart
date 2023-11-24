package com.shoppingcart.bus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppingcart.bus.entity.OrderDetail;

@Repository
public interface OrderDetailRP extends CrudRepository<OrderDetail, Long> {

}