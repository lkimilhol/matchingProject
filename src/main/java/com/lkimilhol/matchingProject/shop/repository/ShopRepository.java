package com.lkimilhol.matchingProject.shop.repository;

import com.lkimilhol.matchingProject.shop.domain.Shop;
import java.util.List;
import java.util.Optional;

public interface ShopRepository {
    Long save(Shop shop);
    Shop findById(Long id);
    Optional<Shop> findByName(String name);
    List<Shop> findAll();
}
