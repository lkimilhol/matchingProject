package com.lkimilhol.matchingproject.menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.common.Quantity;
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

        Shop shop = Shop.of("성경", CategoryEnum.CHINA, "서울", "송파구");

        CreateMenu createMenu = new CreateMenu();
        createMenu.setShopId(1L);
        createMenu.setName("짜장면");
        createMenu.setAmount(100);

        //when
        Menu menu = Menu.of(shop, new Name(createMenu.getName()), new Quantity(createMenu.getAmount()));

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

        Shop shop = Shop.of("성경", CategoryEnum.CHINA, "서울", "송파구");
        Menu menu = Menu.of(shop, new Name(createMenu.getName()), new Quantity(createMenu.getAmount()));

        //when
        //then
        assertThatThrownBy(() -> menu.removeAmount(new Quantity(2)))
                .isInstanceOf(NegativeValueException.class);
    }
}