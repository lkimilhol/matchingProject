package com.lkimilhol.matchingproject.order.application;

import java.util.List;

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
import com.lkimilhol.matchingproject.order.domain.OrderHistory;
import com.lkimilhol.matchingproject.order.repository.OrderHistoryRepository;
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

		OrderHistory orderHistory = OrderHistory.of(
				member.getId(),
				shop.getId(),
				order.getId(),
				menu.getId(),
				new Quantity(createOrder.getAmount()),
				OrderStatus.PROGRESS
		);

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

		OrderHistory orderHistory = OrderHistory.of(
				order.getMember().getId(),
				order.getShop().getId(),
				orderId,
				order.getMenu().getId(),
				order.getQuantity(),
				OrderStatus.CANCEL
		);

		order.updateStatus(OrderStatus.CANCEL);
		orderHistoryRepository.save(orderHistory);
	}

	//트랜잭셔날 애노테이션을 붙여야 할까?
	public List<OrderHistory> getOrderHistory(Long shopId) {
		return orderHistoryRepository.findAllByShopId(shopId);
	}
}
