package com.lkimilhol.matchingproject.menu.application;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.menu.repository.MenuRepository;
import com.lkimilhol.matchingproject.request.CreateMenu;
import com.lkimilhol.matchingproject.request.CreateShop;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.shop.repository.ShopRepository;

@ExtendWith(MockitoExtension.class)
class MenuServiceTest {

	@Mock
	private ShopRepository shopRepository;

	@Mock
	private MenuRepository menuRepository;

	@InjectMocks
	private MenuService menuService;

	@Test
	@DisplayName("메뉴 추가")
	void create() {
		// given
		CreateMenu createMenu = new CreateMenu();
		createMenu.setName("짜짱면");
		createMenu.setAmount(1);

		CreateShop createShop = new CreateShop();
		createShop.setName("성경");
		createShop.setCategory(CategoryEnum.CHINA);
		createShop.setCity("서울");
		createShop.setDistrict("송파구");

		Shop shop = Shop.of("성경", CategoryEnum.CHINA, "서울", "송파구");

		// when
		when(shopRepository.findById(any())).thenReturn(Optional.of(shop));

		// then
		menuService.createMenu(createMenu);
	}
}