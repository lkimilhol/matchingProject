package com.lkimilhol.matchingProject.order.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lkimilhol.matchingProject.common.OrderStatusEnum;
import com.lkimilhol.matchingProject.shop.dto.ShopDto;
import com.lkimilhol.matchingProject.member.dto.MemberRequest;
import com.lkimilhol.matchingProject.order.domain.Order;

@NoArgsConstructor
@Getter
public class OrderDto {
	private Long id;
	private MemberRequest member;
	private ShopDto shop;
	private OrderStatusEnum orderStatus;
	private LocalDateTime updateTime;
	private LocalDateTime insertTime;

	@Builder
	public OrderDto(Order order) {
		this.id = order.getId();
		this.member = new MemberRequest(order.getMember());
		this.shop = new ShopDto(order.getShop());
		this.orderStatus = order.getOrderStatus();
		this.updateTime = order.getUpdateTime();
		this.insertTime = order.getInsertTime();
	}
}
