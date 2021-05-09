package com.lkimilhol.matchingProject.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lkimilhol.matchingProject.common.OrderStatusEnum;
import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.domain.Menu;
import com.lkimilhol.matchingProject.domain.Order;
import com.lkimilhol.matchingProject.domain.Shop;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.repository.MemberRepository;
import com.lkimilhol.matchingProject.repository.MenuRepository;
import com.lkimilhol.matchingProject.repository.OrderRepository;
import com.lkimilhol.matchingProject.repository.ShopRepository;
import com.lkimilhol.matchingProject.request.CreateOrder;
import com.lkimilhol.matchingProject.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ShopRepository shopRepository;
    private final MenuRepository menuRepository;

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

        orderRepository.save(order);
        return order;
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
