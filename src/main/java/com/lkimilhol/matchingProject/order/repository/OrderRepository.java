package com.lkimilhol.matchingProject.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkimilhol.matchingProject.order.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
