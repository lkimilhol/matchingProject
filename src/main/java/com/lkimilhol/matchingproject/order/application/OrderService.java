package com.lkimilhol.matchingproject.order.application;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingproject.common.OrderStatus;
import com.lkimilhol.matchingproject.common.Quantity;
import com.lkimilhol.matchingproject.exception.NotFoundMemberException;
import com.lkimilhol.matchingproject.exception.NotFoundMenuException;
import com.lkimilhol.matchingproject.exception.NotFoundOrderException;
import com.lkimilhol.matchingproject.exception.NotFoundShopException;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;
import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.menu.repository.MenuRepository;
import com.lkimilhol.matchingproject.order.domain.Order;
import com.lkimilhol.matchingproject.order.repository.OrderRepository;
import com.lkimilhol.matchingproject.ordersave.domain.OrderHistory;
import com.lkimilhol.matchingproject.ordersave.repository.OrderHistoryRepository;
import com.lkimilhol.matchingproject.request.CreateOrder;
import com.lkimilhol.matchingproject.shop.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
	private final OrderRepository orderRepository;
	private final MemberRepository memberRepository;
	private final ShopRepository shopRepository;
	private final MenuRepository menuRepository;
	private final OrderHistoryRepository orderHistoryRepository;

	public Order addOrder(CreateOrder createOrder) {
		var member = memberRepository.findById(createOrder.getMemberId()).orElseThrow(NotFoundMemberException::new);
		var shop = shopRepository.findById(createOrder.getShopId()).orElseThrow(NotFoundShopException::new);
		var menu = menuRepository.findById(createOrder.getMenuId()).orElseThrow(NotFoundMenuException::new);

		var order = Order.of(member, shop, menu, new Quantity(createOrder.getAmount()));
		menu.removeAmount(new Quantity(createOrder.getAmount()));

		OrderHistory orderHistory = OrderHistory.builder()
				.memberId(member.getId())
				.shopId(shop.getId())
				.menuId(menu.getId())
				.quantity(new Quantity(createOrder.getAmount()))
				.insertTime(LocalDateTime.now())
				.build();

		orderRepository.save(order);
		orderHistoryRepository.save(orderHistory);

		return order;
	}

	@Transactional(readOnly = true)
	public Order getOrder(Long orderId) {
		return orderRepository.findById(orderId).orElseThrow(NotFoundOrderException::new);
	}

	public void deleteOrder(Long orderId) {
		var order = orderRepository.findById(orderId).orElseThrow(NotFoundOrderException::new);
		Menu menu = menuRepository.findById(order.getMenu().getId()).orElseThrow(NotFoundMenuException::new);
		menu.increaseAmount(order.getQuantity());

		OrderHistory orderHistory = OrderHistory.builder()
				.memberId(order.getMember().getId())
				.shopId(order.getShop().getId())
				.menuId(menu.getId())
				.quantity(order.getQuantity())
				.insertTime(LocalDateTime.now())
				.build();

		order.updateStatus(OrderStatus.CANCEL);
		orderHistoryRepository.save(orderHistory);
	}
}
