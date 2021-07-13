package com.lkimilhol.matchingproject.menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.exception.NegativeValueException;
import com.lkimilhol.matchingproject.request.CreateMenu;
import com.lkimilhol.matchingproject.request.CreateShop;
import com.lkimilhol.matchingproject.shop.domain.Shop;

class MenuTest {
    @Test
    @DisplayName("메뉴 추가")
    void createMenu() {
        //given
        CreateShop createShop = new CreateShop();
        createShop.setName("성경");
        createShop.setCategory(CategoryEnum.CHINA);
        createShop.setCity("서울");
        createShop.setDistrict("송파구");

        Shop shop = Shop.of(createShop);

        CreateMenu createMenu = new CreateMenu();
        createMenu.setShopId(1L);
        createMenu.setName("짜장면");
        createMenu.setAmount(100);

        //when
        Menu menu = Menu.of(shop, createMenu);

        //then
        assertThat(menu).isNotNull();
        assertThat(menu.getShop().getName()).isEqualTo("성경");
    }

    @Test
    @DisplayName("메뉴의 수량이 음수가 되는 경우")
    void method() {
        //given
        CreateMenu createMenu = new CreateMenu();
        createMenu.setName("짜짱면");
        createMenu.setAmount(1);

        Menu menu = Menu.of(new Shop(), createMenu);

        //when
        //then
        assertThatThrownBy(() -> menu.removeAmount(2))
                .isInstanceOf(NegativeValueException.class);
    }
}