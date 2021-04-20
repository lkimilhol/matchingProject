package com.lkimilhol.matchingProject.service;

import com.lkimilhol.matchingProject.common.CategoryEnum;
import com.lkimilhol.matchingProject.domain.Shop;
import com.lkimilhol.matchingProject.repository.ShopRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

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
        Shop shop = Shop.builder()
                .name(name)
                .category(CategoryEnum.CHINA)
                .city("서울")
                .district("송파")
                .build();

        //when
        Long shopId = shopRepository.save(shop);

        //then
        assertEquals(shop, shopRepository.findById(shopId));
    }
}