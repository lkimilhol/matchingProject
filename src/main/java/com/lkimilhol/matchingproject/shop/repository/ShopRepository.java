package com.lkimilhol.matchingproject.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lkimilhol.matchingproject.shop.domain.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findByName(String shopName);
}
