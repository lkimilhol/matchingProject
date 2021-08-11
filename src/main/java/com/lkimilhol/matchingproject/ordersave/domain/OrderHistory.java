package com.lkimilhol.matchingproject.ordersave.domain;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lkimilhol.matchingproject.common.OrderStatus;
import com.lkimilhol.matchingproject.common.Quantity;

@NoArgsConstructor
@Getter
@Document(collection = "current")
@CompoundIndexes({
        @CompoundIndex(name = "member_shop_menu", def = "{'memberId' : 1, 'shopId': 1, 'menuId': 1}")
})
public class OrderHistory {
    @Id
    private Long id;

    private Long memberId;

    private Long shopId;

    private Long menuId;

    private Quantity quantity;

    private OrderStatus orderStatus;

    private LocalDateTime insertTime;

    public OrderHistory(Long memberId, Long shopId, Long menuId, Quantity quantity, OrderStatus orderStatus) {
        this.memberId = memberId;
        this.shopId = shopId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.insertTime = LocalDateTime.now();
    }

    public static OrderHistory of(Long memberId, Long shopId, Long menuId, Quantity quantity, OrderStatus orderStatus) {
        return new OrderHistory(memberId, shopId, menuId, quantity, orderStatus);
    }
}
