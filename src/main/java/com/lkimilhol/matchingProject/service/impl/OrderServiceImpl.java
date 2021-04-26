package com.lkimilhol.matchingProject.service.impl;

import com.lkimilhol.matchingProject.common.OrderStatusEnum;
import com.lkimilhol.matchingProject.domain.Member;
import com.lkimilhol.matchingProject.domain.Order;
import com.lkimilhol.matchingProject.domain.Shop;
import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.repository.MemberRepository;
import com.lkimilhol.matchingProject.repository.OrderRepository;
import com.lkimilhol.matchingProject.repository.ShopRepository;
import com.lkimilhol.matchingProject.request.CreateOrder;
import com.lkimilhol.matchingProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ShopRepository shopRepository;

    @Override
    public Order addOrder(CreateOrder createOrder) {
        Member member = memberRepository.findById(createOrder.getMemberId());
        Shop shop = shopRepository.findById(createOrder.getShopId());

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

        orderRepository.save(order);
        return order;
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
