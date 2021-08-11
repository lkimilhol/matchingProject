package com.lkimilhol.matchingproject.order.domain;

import java.time.LocalDateTime;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

import com.lkimilhol.matchingproject.common.OrderStatus;
import com.lkimilhol.matchingproject.common.Quantity;

@NoArgsConstructor
@Document(collection = "current")
@CompoundIndexes({
        @CompoundIndex(name = "member_shop_menu", def = "{'memberId' : 1, 'shopId': 1, 'menuId': 1}")
})
public class OrderHistory {
    @Id
    private ObjectId id;

    private Long memberId;

    private Long shopId;

    private Long orderId;

    private Long menuId;

    private int quantity;

    private OrderStatus orderStatus;

    private LocalDateTime insertTime;

    public OrderHistory(Long memberId, Long shopId, Long orderId, Long menuId, Quantity quantity, OrderStatus orderStatus) {
        this.memberId = memberId;
        this.shopId = shopId;
        this.menuId = menuId;
        this.orderId = orderId;
        this.quantity = quantity.getAmount();
        this.orderStatus = orderStatus;
        this.insertTime = LocalDateTime.now();
    }

    public static OrderHistory of(Long memberId, Long shopId, Long orderId, Long menuId, Quantity quantity, OrderStatus orderStatus) {
        return new OrderHistory(memberId, shopId, menuId, orderId, quantity, orderStatus);
    }
}
