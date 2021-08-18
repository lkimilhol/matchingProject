package com.lkimilhol.matchingproject.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lkimilhol.matchingproject.order.domain.OrderHistory;

@Repository
public interface OrderHistoryRepository extends MongoRepository<OrderHistory, String> {
	List<OrderHistory> findAllByShopId(Long shopId);
}
