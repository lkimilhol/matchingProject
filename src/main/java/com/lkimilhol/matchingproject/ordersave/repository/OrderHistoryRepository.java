package com.lkimilhol.matchingproject.ordersave.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lkimilhol.matchingproject.ordersave.domain.OrderHistory;

@Repository
public interface OrderHistoryRepository extends CrudRepository<OrderHistory, Long> {
	Optional<OrderHistory> findByMemberIdAndMenuIdAndShopId(Long memberId, Long menuId, Long shopId);
}
