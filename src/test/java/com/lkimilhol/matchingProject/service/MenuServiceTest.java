package com.lkimilhol.matchingProject.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lkimilhol.matchingProject.menu.domain.Menu;
import com.lkimilhol.matchingProject.shop.domain.Shop;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.menu.application.MenuService;
import com.lkimilhol.matchingProject.request.CreateMenu;

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
		CustomException customException = assertThrows(CustomException.class, () -> menu.removeAmount(2));
		//then
		assertEquals(ErrorInfo.INVALID_AMOUNT.getErrorCode(), customException.getErrorInfo().getErrorCode());
	}
}