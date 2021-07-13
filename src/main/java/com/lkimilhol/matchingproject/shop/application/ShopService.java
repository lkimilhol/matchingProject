package com.lkimilhol.matchingproject.shop.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingproject.exception.CustomException;
import com.lkimilhol.matchingproject.exception.NotFoundShopException;
import com.lkimilhol.matchingproject.request.CreateShop;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.shop.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopService {
    private final ShopRepository shopRepository;

    @Transactional
    public Shop addShop(CreateShop createShop) throws CustomException {
        return shopRepository.save(Shop.of(createShop));
    }

    public Shop getShop(String shopName) {
        return shopRepository.findByName(shopName).orElseThrow(NotFoundShopException::new);
    }
}
