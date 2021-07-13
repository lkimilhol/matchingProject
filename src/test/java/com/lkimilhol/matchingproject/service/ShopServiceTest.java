package com.lkimilhol.matchingproject.service;

import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.request.CreateShop;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.shop.repository.ShopRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ShopServiceTest {

    @Autowired
    private ShopRepository shopRepository;

    @Test
    @DisplayName("가게 생성")
    void createShop() {
        //given
        String name = "성경";

        CreateShop createShop = new CreateShop();
        createShop.setName(name);
        createShop.setCategory(CategoryEnum.CHINA);
        createShop.setCity("서울");
        createShop.setDistrict("송파구");

        Shop shop = Shop.of(createShop);

        //when
        shopRepository.save(shop);

        //then
        assertThat(shop.getId()).isNotZero();
    }

    @Test
    @DisplayName("가게 불러오기")
    void getShop() {
        //given
        String name = "성경";

        CreateShop createShop = new CreateShop();
        createShop.setName(name);
        createShop.setCategory(CategoryEnum.CHINA);
        createShop.setCity("서울");
        createShop.setDistrict("송파구");

        Shop shop = Shop.of(createShop);

        //when
        shopRepository.save(shop);
        Optional<Shop> getShop = shopRepository.findByName(name);
        if (getShop.isEmpty()) {
            fail();
        }

        //then
        assertEquals(shop, getShop.get());
    }
}