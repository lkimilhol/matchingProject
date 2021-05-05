package com.lkimilhol.matchingProject.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lkimilhol.matchingProject.common.OrderStatusEnum;
import com.lkimilhol.matchingProject.domain.Order;

@NoArgsConstructor
@Getter
public class OrderDto {
	private Long id;
	private MemberDto member;
	private ShopDto shop;
	private OrderStatusEnum orderStatus;
	private LocalDateTime updateTime;
	private LocalDateTime insertTime;

	public OrderDto(Order order) {
		this.id = order.getId();
		this.member = new MemberDto(order.getMember());
		this.shop = new ShopDto(order.getShop());
		this.orderStatus = order.getOrderStatus();
		this.updateTime = order.getUpdateTime();
		this.insertTime = order.getInsertTime();
	}
}
