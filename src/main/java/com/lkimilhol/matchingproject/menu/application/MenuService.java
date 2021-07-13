package com.lkimilhol.matchingproject.menu.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingproject.exception.NotFoundMenuException;
import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.menu.repository.MenuRepository;
import com.lkimilhol.matchingproject.request.CreateMenu;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.shop.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {
	private final MenuRepository menuRepository;
	private final ShopRepository shopRepository;

	@Transactional
	public Menu createMenu(CreateMenu createMenu) {
		//TODO 옵셔널 수정 예정
		Shop shop = shopRepository.findById(createMenu.getShopId()).orElseThrow(NotFoundMenuException::new);

		Menu menu = Menu.of(shop, createMenu);
		menuRepository.save(menu);

		return menu;
	}
}
