package com.lkimilhol.matchingproject.order.dto;

import com.lkimilhol.matchingproject.common.OrderStatus;

public class OrderRequest {
    private Long memberId;
    private Long shopId;
    private Long menuId;
    private OrderStatus orderStatus;

    public OrderRequest(Long memberId, Long shopId, Long menuId, OrderStatus orderStatus) {
        this.memberId = memberId;
        this.shopId = shopId;
        this.menuId = menuId;
        this.orderStatus = orderStatus;
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
