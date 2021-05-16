package com.lkimilhol.matchingProject.domain;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

import com.lkimilhol.matchingProject.common.CategoryEnum;

import lombok.Builder;
import lombok.Getter;

@RedisHash
@Getter
@Builder
public class OrderSave {
	@Id
	private final Long id;
	private final Long memberId;
	private final Long shopId;
	private final Long menuId;
	private final CategoryEnum categoryEnum;
}
