package com.lkimilhol.matchingProject.service.impl;

import com.lkimilhol.matchingProject.domain.Shop;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.repository.ShopRepository;
import com.lkimilhol.matchingProject.request.CreateShop;
import com.lkimilhol.matchingProject.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;


    @Override
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

    @Override
    public Shop getShop(String shopName) {
        Optional<Shop> shop = shopRepository.findByName(shopName);

        if (shop.isEmpty()) {
            throw new CustomException(ErrorInfo.NOT_EXISTS_SHOP);
        }

        return shop.get();
    }
}
