package com.lkimilhol.matchingProject.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingProject.domain.Menu;
import com.lkimilhol.matchingProject.domain.Shop;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.repository.MenuRepository;
import com.lkimilhol.matchingProject.repository.ShopRepository;
import com.lkimilhol.matchingProject.request.CreateMenu;

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
		Shop shop = shopRepository.findById(createMenu.getShopId());

		if (shop == null) {
			throw new CustomException(ErrorInfo.NOT_EXISTS_SHOP);
		}

		Menu menu = Menu.builder()
			.name(createMenu.getName())
			.shop(shop)
			.amount(createMenu.getAmount())
			.insertTime(LocalDateTime.now())
			.updateTime(LocalDateTime.now())
			.build();

		menuRepository.save(menu);

		return menu;
	}

}
