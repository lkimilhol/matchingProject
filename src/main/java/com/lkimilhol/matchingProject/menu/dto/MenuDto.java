package com.lkimilhol.matchingProject.menu.dto;

import java.time.LocalDateTime;

import com.lkimilhol.matchingProject.shop.dto.ShopDto;
import com.lkimilhol.matchingProject.menu.domain.Menu;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MenuDto {
	private Long id;
	private String name;
	private ShopDto shop;
	private LocalDateTime insertTime;
	private LocalDateTime updateTime;

	@Builder
	public MenuDto(Menu menu) {
		this.id = menu.getId();
		this.name = menu.getName();
		this.shop = new ShopDto(menu.getShop());
		this.insertTime = menu.getInsertTime();
		this.updateTime = menu.getUpdateTime();
	}
}
