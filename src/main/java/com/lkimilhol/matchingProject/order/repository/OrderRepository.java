package com.lkimilhol.matchingProject.order.repository;

import com.lkimilhol.matchingProject.order.domain.Order;

import java.util.List;

public interface OrderRepository {
    Long save(Order order);
    Order findById(Long id);
    List<Order> findAll();
}
