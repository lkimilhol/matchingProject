package com.lkimilhol.matchingproject.order.integration;

import com.lkimilhol.matchingproject.address.domain.City;
import com.lkimilhol.matchingproject.address.domain.District;
import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.common.Quantity;
import com.lkimilhol.matchingproject.member.domain.Age;
import com.lkimilhol.matchingproject.member.domain.Country;
import com.lkimilhol.matchingproject.member.domain.Gender;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.domain.Nickname;
import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.menu.domain.MenuName;
import com.lkimilhol.matchingproject.order.domain.Order;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.order.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class OrderServiceIntegrationTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("주문 생성 테스트")
    public void createOrder() {
        //given
        Member member = new Member(new Nickname("test"), Gender.M, new Age(18), Country.KR);
        Shop shop = Shop.of("성경", CategoryEnum.CHINA, City.SEOUL, new District("송파구"));
        Menu menu = Menu.of(shop, new MenuName("짜장면"), new Quantity(10));

        Order order = Order.of(member, shop, menu, new Quantity(100));

        //when
        orderRepository.save(order);

        //then
        assertThat(order).isNotNull();
    }
}