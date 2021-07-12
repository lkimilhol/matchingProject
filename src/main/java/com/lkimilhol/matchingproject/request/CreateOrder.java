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
}
