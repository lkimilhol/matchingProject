package com.lkimilhol.matchingproject.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lkimilhol.matchingproject.order.domain.OrderCurrent;

public interface OrderMongoRepository extends MongoRepository<OrderCurrent, String> {
}
