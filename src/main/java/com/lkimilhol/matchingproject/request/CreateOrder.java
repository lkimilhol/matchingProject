package com.lkimilhol.matchingproject.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrder {
    Long memberId;
    Long shopId;
    Long menuId;
    int amount;

    public CreateOrder(Long memberId, Long shopId, Long menuId, int amount) {
        this.memberId = memberId;
        this.shopId = shopId;
        this.menuId = menuId;
        this.amount = amount;
    }
}
