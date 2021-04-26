package com.lkimilhol.matchingProject.service;

import com.lkimilhol.matchingProject.domain.Order;
import com.lkimilhol.matchingProject.request.CreateOrder;

public interface OrderService {
    Order addOrder(CreateOrder createOrder);
    Order getOrder(Long orderId);
}