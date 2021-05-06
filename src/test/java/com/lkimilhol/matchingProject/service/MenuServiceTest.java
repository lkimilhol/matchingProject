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

import com.lkimilhol.matchingProject.domain.Menu;
import com.lkimilhol.matchingProject.domain.Shop;
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
}