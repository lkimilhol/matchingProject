package com.lkimilhol.matchingproject.order.integration;

import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.common.OrderStatus;
import com.lkimilhol.matchingproject.common.Quantity;
import com.lkimilhol.matchingproject.config.MongoDBConfig;
import com.lkimilhol.matchingproject.member.domain.Age;
import com.lkimilhol.matchingproject.member.domain.Country;
import com.lkimilhol.matchingproject.member.domain.Gender;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.domain.Nickname;
import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.menu.domain.Name;
import com.lkimilhol.matchingproject.order.domain.Order;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.address.repository.AddressRepository;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;
import com.lkimilhol.matchingproject.order.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

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
        Member member = Member.of(new Nickname("test"), Gender.M, new Age(18), Country.KR);
        Shop shop = Shop.of("성경", CategoryEnum.CHINA, "서울", "송파구");
        Menu menu = Menu.of(shop, new Name("짜장면"), new Quantity(10));

        Order order = Order.of(member, shop, menu, new Quantity(100));

        //when
        orderRepository.save(order);

        //then
        assertThat(order).isNotNull();
    }
}