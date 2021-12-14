package com.lkimilhol.matchingproject.order.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lkimilhol.matchingproject.address.domain.City;
import com.lkimilhol.matchingproject.address.domain.District;
import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.common.OrderStatus;
import com.lkimilhol.matchingproject.common.Quantity;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.member.repository.MemberRepository;
import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.menu.domain.MenuName;
import com.lkimilhol.matchingproject.menu.repository.MenuRepository;
import com.lkimilhol.matchingproject.order.domain.Order;
import com.lkimilhol.matchingproject.order.domain.OrderHistory;
import com.lkimilhol.matchingproject.order.dto.OrderRequest;
import com.lkimilhol.matchingproject.order.repository.OrderRepository;
import com.lkimilhol.matchingproject.order.repository.OrderHistoryRepository;
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

        Member member = new Member();

        Shop shop = Shop.of("성경", CategoryEnum.CHINA, City.SEOUL, new District("송파구"));
        Menu menu = Menu.of(shop, new MenuName("짜장면"), new Quantity(200));

        // when
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(shopRepository.findById(1L)).thenReturn(Optional.of(shop));
        when(menuRepository.findById(1L)).thenReturn(Optional.of(menu));
        Order order = orderService.addOrder(createOrder);

        // then
        assertThat(order).isNotNull();
    }

    @DisplayName("취소")
    @Test
    void cancel() {
        // given
        Member member = new Member();

        Shop shop = Shop.of("성경", CategoryEnum.CHINA, City.SEOUL, new District("송파구"));
        Menu menu = Menu.of(shop, new MenuName("짜장면"), new Quantity(200));
        Order order = Order.of(member, shop, menu, new Quantity(100));

        OrderRequest orderRequest = new OrderRequest(1L, 1L, 1L, OrderStatus.CANCEL);

        // when
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(menuRepository.findById(any())).thenReturn(Optional.of(menu));
        when(memberRepository.findById(any())).thenReturn(Optional.of(member));
        when(shopRepository.findById(any())).thenReturn(Optional.of(shop));

        orderService.updateOrderStatus(1L, orderRequest);

        // then
        assertThat(menu.getQuantity()).isEqualTo(new Quantity(300));
    }

    @DisplayName("주문 기록 불러오기")
    @Test
    void getOrderHistory() {
        // given
        Long shopId = 1L;
        List<OrderHistory> orderHistories = new ArrayList<>();
        orderHistories.add(OrderHistory.of(1L, shopId, 1L, 1L, new Quantity(1), OrderStatus.COMPLETE));
        // when
        when(orderHistoryRepository.findAllByShopId(1L)).thenReturn(orderHistories);
        List<OrderHistory> orderHistory = orderService.getOrderHistory(shopId);
        // then
        assertThat(orderHistory.size()).isEqualTo(1);
    }
}