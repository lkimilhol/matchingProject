package com.lkimilhol.matchingProject.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingProject.common.Constant;
import com.lkimilhol.matchingProject.common.OrderStatusEnum;
import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.domain.Menu;
import com.lkimilhol.matchingProject.domain.Order;
import com.lkimilhol.matchingProject.domain.OrderSave;
import com.lkimilhol.matchingProject.domain.Shop;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.repository.MemberRepository;
import com.lkimilhol.matchingProject.repository.MenuRepository;
import com.lkimilhol.matchingProject.repository.OrderRepository;
import com.lkimilhol.matchingProject.repository.OrderSaveRepository;
import com.lkimilhol.matchingProject.repository.ShopRepository;
import com.lkimilhol.matchingProject.request.CreateOrder;

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
		Member member = memberRepository.findById(createOrder.getMemberId());
		Shop shop = shopRepository.findById(createOrder.getShopId());
		Menu menu = menuRepository.findById(createOrder.getMenuId());

		if (!shop.getId().equals(menu.getShop().getId())) {
			throw new CustomException(ErrorInfo.INVALID_SHOP_MENU);
		}

		if (member == null) {
			throw new CustomException(ErrorInfo.NOT_EXISTS_MEMBER);
		}
		if (shop == null) {
			throw new CustomException(ErrorInfo.NOT_EXISTS_SHOP);
		}

		Order order = Order.builder()
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
		return orderRepository.findById(orderId);
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
