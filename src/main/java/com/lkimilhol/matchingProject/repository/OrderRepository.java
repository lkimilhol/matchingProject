package com.lkimilhol.matchingProject.repository;

import com.lkimilhol.matchingProject.domain.Order;

import java.util.List;

public interface OrderRepository {
    Long save(Order order);
    Order findById(Long id);
    List<Order> findAll();
}
