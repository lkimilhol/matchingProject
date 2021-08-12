package com.lkimilhol.matchingproject.order.dto;

import com.lkimilhol.matchingproject.common.OrderStatus;

public class UpdateOrderStatusRequest {
    private Long orderId;
    private Long memberId;
    private Long shopId;
    private Long menuId;
    private OrderStatus orderStatus;

    public Long getOrderId() {
        return orderId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getShopId() {
        return shopId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
