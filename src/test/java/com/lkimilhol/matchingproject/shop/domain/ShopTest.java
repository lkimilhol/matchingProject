package com.lkimilhol.matchingproject.shop.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.request.CreateShop;

@DisplayName("가게 테스트")
class ShopTest {

    @DisplayName("생성")
    @Test
    void create() {
        // given
        CreateShop createShop = new CreateShop();
        createShop.setName("성경");
        createShop.setCategory(CategoryEnum.CHINA);
        createShop.setCity("서울");
        createShop.setDistrict("송파구");

        // when
        Shop shop = Shop.of(createShop);

        // then
        assertThat(shop).isNotNull();
        assertThat(shop.getName()).isEqualTo("성경");
    }
}