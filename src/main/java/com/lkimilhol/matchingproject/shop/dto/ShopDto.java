package com.lkimilhol.matchingproject.shop.dto;

import java.time.LocalDateTime;

import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.shop.domain.Shop;

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
		this.city = shop.getCity().toName();
		this.district = shop.getDistrict().getName();
		this.insertTime = shop.getInsertTime();
	}
}
