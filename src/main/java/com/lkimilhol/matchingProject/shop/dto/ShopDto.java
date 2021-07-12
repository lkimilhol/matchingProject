package com.lkimilhol.matchingProject.shop.dto;

import java.time.LocalDateTime;

import com.lkimilhol.matchingProject.common.CategoryEnum;
import com.lkimilhol.matchingProject.shop.domain.Shop;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ShopDto {
	private String name;
	private CategoryEnum category;
	private String city;
	private String district;
	private LocalDateTime insertTime;

	@Builder
	public ShopDto(Shop shop) {
		this.name = shop.getName();
		this.category = shop.getCategory();
		this.city = shop.getCity();
		this.district = shop.getDistrict();
		this.insertTime = shop.getInsertTime();
	}
}
