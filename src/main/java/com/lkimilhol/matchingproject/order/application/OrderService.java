package com.lkimilhol.matchingproject.order.application;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingproject.common.Constant;
import com.lkimilhol.matchingproject.common.OrderStatusEnum;
import com.lkimilhol.matchingproject.exception.NotFoundMemberException;
import com.lkimilhol.matchingproject.exception.NotFoundMenuException;
import com.lkimilhol.matchingproject.exception.NotFoundOrderException;
import com.lkimilhol.matchingproject.exception.NotFoundShopException;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.order.domain.Order;
import com.lkimilhol.matchingproject.ordersave.domain.OrderSave;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;
import com.lkimilhol.matchingproject.menu.repository.MenuRepository;
import com.lkimilhol.matchingproject.order.repository.OrderRepository;
import com.lkimilhol.matchingproject.ordersave.repository.OrderSaveRepository;
import com.lkimilhol.matchingproject.shop.repository.ShopRepository;
import com.lkimilhol.matchingproject.request.CreateOrder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
	private final OrderRepository orderRepository;
	private final MemberRepository memberRepository;
	private final ShopRepository shopRepository;
	private final MenuRepository menuRepository;
	private final OrderSaveRepository orderSaveRepository;

	public Order addOrder(CreateOrder createOrder) {
		Member member = memberRepository.findById(createOrder.getMemberId()).orElseThrow(NotFoundMemberException::new);
		Shop shop = shopRepository.findById(createOrder.getShopId()).orElseThrow(NotFoundShopException::new);
		Menu menu = menuRepository.findById(createOrder.getMenuId()).orElseThrow(NotFoundMenuException::new);

		var order = Order.builder()
			.member(member)
			.shop(shop)
			.orderStatus(OrderStatusEnum.PROGRESS)
			.insertTime(LocalDateTime.now())
			.updateTime(LocalDateTime.now())
			.build();

		menu.removeAmount(createOrder.getAmount());

		setOrderSave(member, shop, menu);
		orderRepository.save(order);

		return order;
	}

	@Transactional(readOnly = true)
	public Order getOrder(Long orderId) {
		return orderRepository.findById(orderId).orElseThrow(NotFoundOrderException::new);
	}

	private void setOrderSave(Member member, Shop shop, Menu menu) {
		Optional<OrderSave> orderSave = orderSaveRepository.findByMemberIdAndMenuIdAndShopId(
			member.getId(), menu.getId(), shop.getId());

		if (orderSave.isPresent()) {
			OrderSave data = orderSave.get();
			data.increaseOrderCount();
			orderSaveRepository.save(data); //TODO 영속성 컨텍스트에서 자동으로 set을 해주지 않는지 알아봐야 함
			return;
		}

		OrderSave newOrderSave = OrderSave.builder()
			.memberId(member.getId())
			.shopId(shop.getId())
			.menuId(menu.getId())
			.orderCount(Constant.DEFAULT_ORDER_COUNT)
			.categoryEnum(shop.getCategory())
			.build();
		orderSaveRepository.save(newOrderSave);
	}
}
