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
        // when
        Shop shop = Shop.of("성경", CategoryEnum.CHINA, "서울", "송파구");

        // then
        assertThat(shop).isNotNull();
        assertThat(shop.getName()).isEqualTo("성경");
    }
}