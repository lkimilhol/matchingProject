package com.lkimilhol.matchingProject.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lkimilhol.matchingProject.shop.domain.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
