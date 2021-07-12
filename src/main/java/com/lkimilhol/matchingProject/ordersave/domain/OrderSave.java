package com.lkimilhol.matchingProject.ordersave.domain;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import com.lkimilhol.matchingProject.common.CategoryEnum;

import lombok.Builder;
import lombok.Getter;

@RedisHash
@Getter
@Builder
public class OrderSave {
	@Id
	private final Long id;

	@Indexed
	private final Long memberId;

	@Indexed
	private final Long shopId;

	@Indexed
	private final Long menuId;

	private final CategoryEnum categoryEnum;
	private int orderCount;

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public void increaseOrderCount() {
		orderCount++;
	}
}
