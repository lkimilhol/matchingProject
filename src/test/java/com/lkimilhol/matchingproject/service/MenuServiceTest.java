package com.lkimilhol.matchingproject.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lkimilhol.matchingproject.exception.NegativeValueException;
import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.exception.CustomException;
import com.lkimilhol.matchingproject.exception.ErrorInfo;
import com.lkimilhol.matchingproject.menu.application.MenuService;
import com.lkimilhol.matchingproject.request.CreateMenu;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MenuServiceTest {
	@Mock
	MenuService menuService;

	@Test
	@DisplayName("메뉴 추가")
	void createMenu() {
	    //given
		Shop shop = Shop.builder()
			.id(1L)
			.name("test")
			.build();

		CreateMenu createMenu = new CreateMenu();
		createMenu.setShopId(1L);
		createMenu.setName("짜장면");
		createMenu.setAmount(100);

	    //when
		when(menuService.createMenu(createMenu)).thenReturn(new Menu());

	    //then
		assertTrue(true);
	}

	@Test
	@DisplayName("메뉴의 수량이 음수가 되는 경우")
	void method() {
	    //given
		Menu menu = Menu.builder()
			.amount(1)
			.build();

	    //when
		//then
		assertThatThrownBy(() -> menu.removeAmount(2))
				.isInstanceOf(NegativeValueException.class);
	}
}