package com.lkimilhol.matchingProject.ordersave.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lkimilhol.matchingProject.ordersave.domain.OrderSave;

@Repository
public interface OrderSaveRepository extends CrudRepository<OrderSave, Long> {
	Optional<OrderSave> findByMemberIdAndMenuIdAndShopId(Long memberId, Long menuId, Long shopId);
}
