package com.lkimilhol.matchingProject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingProject.domain.Shop;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.repository.ShopRepository;
import com.lkimilhol.matchingProject.request.CreateShop;
import com.lkimilhol.matchingProject.service.ShopService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopService {
    private final ShopRepository shopRepository;

    @Transactional
    public Shop addShop(CreateShop createShop) throws CustomException {
        Shop shop = Shop.builder()
                .name(createShop.getName())
                .category(createShop.getCategory())
                .city(createShop.getCity())
                .district(createShop.getDistrict())
                .build();

        shopRepository.save(shop);

        return shop;
    }

    public Shop getShop(String shopName) {
        Optional<Shop> shop = shopRepository.findByName(shopName);

        if (shop.isEmpty()) {
            throw new CustomException(ErrorInfo.NOT_EXISTS_SHOP);
        }

        return shop.get();
    }
}
