package com.lkimilhol.matchingproject.order.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.common.Quantity;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;
import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.menu.repository.MenuRepository;
import com.lkimilhol.matchingproject.order.domain.Order;
import com.lkimilhol.matchingproject.order.repository.OrderRepository;
import com.lkimilhol.matchingproject.ordersave.repository.OrderHistoryRepository;
import com.lkimilhol.matchingproject.request.CreateOrder;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.shop.repository.ShopRepository;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private ShopRepository shopRepository;

    @Mock
    private MenuRepository menuRepository;

    @Mock
    OrderHistoryRepository orderHistoryRepository;

    @InjectMocks
    OrderService orderService;

    @DisplayName("생성")
    @Test
    void create() {
        // given
        CreateOrder createOrder = new CreateOrder(1L, 1L, 1L, 1);

        Member member = new Member(1L);

        Shop shop = Shop.of("성경", CategoryEnum.CHINA, "서울", "송파구");
        Menu menu = Menu.of(shop, "짜장면", new Quantity(200));

        // when
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(shopRepository.findById(1L)).thenReturn(Optional.of(shop));
        when(menuRepository.findById(1L)).thenReturn(Optional.of(menu));
        Order order = orderService.addOrder(createOrder);

        // then
        assertThat(order).isNotNull();
    }

}