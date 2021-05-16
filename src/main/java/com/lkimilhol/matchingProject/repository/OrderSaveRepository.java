package com.lkimilhol.matchingProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lkimilhol.matchingProject.domain.OrderSave;

@Repository
public interface OrderSaveRepository extends CrudRepository<OrderSave, Long> {
}
