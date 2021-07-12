package com.lkimilhol.matchingproject.service;

import com.lkimilhol.matchingproject.common.OrderStatusEnum;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.order.domain.Order;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.address.repository.AddressRepository;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;
import com.lkimilhol.matchingproject.order.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class OrderServiceTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("주문 생성 테스트")
    public void createOrder() {
        //given
        Member member = Member.builder()
                .nickname("test")
                .age(18)
                .country("kr")
                .sex("m")
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build()
                ;

        Shop shop = Shop.builder()
                .name("성경")
                .city("서울")
                .district("송파")
                .insertTime(LocalDateTime.now())
                .build();

        Order order = Order.builder()
                .member(member)
                .shop(shop)
                .orderStatus(OrderStatusEnum.PROGRESS)
                .insertTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        //when
        orderRepository.save(order);

        //then
        assertThat(order).isNotNull();
    }
}