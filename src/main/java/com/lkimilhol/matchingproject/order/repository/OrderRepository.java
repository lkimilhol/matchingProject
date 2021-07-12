package com.lkimilhol.matchingproject.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkimilhol.matchingproject.order.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
