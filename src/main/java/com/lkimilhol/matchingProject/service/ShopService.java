package com.lkimilhol.matchingProject.service;

import com.lkimilhol.matchingProject.domain.Shop;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.request.CreateShop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
    Shop addShop(CreateShop createShop) throws CustomException;

    List<Shop> findShops();
}
