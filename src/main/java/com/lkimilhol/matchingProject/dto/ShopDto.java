package com.lkimilhol.matchingProject.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lkimilhol.matchingProject.common.CategoryEnum;
import com.lkimilhol.matchingProject.domain.Shop;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ShopDto {
	private String name;
	private CategoryEnum category;
	private String city;
	private String district;

	public ShopDto(Shop shop) {
		this.name = shop.getName();
		this.category = shop.getCategory();
		this.city = shop.getCity();
		this.district = shop.getDistrict();
	}
}
