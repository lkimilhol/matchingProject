package com.lkimilhol.matchingproject.order.domain;

import com.lkimilhol.matchingproject.common.OrderStatus;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.member.domain.Member;
import com.lkimilhol.matchingproject.menu.domain.Menu;

import lombok.*;

import static javax.persistence.EnumType.*;
import static javax.persistence.FetchType.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    private int amount;

    @Enumerated(STRING)
    @NotNull
    private OrderStatus orderStatus;

    @Column(name = "update_time", columnDefinition = "DATETIME")
    private LocalDateTime updateTime;

    @Column(name = "insert_time", columnDefinition = "DATETIME")
    private LocalDateTime insertTime;

    private Order(Member member, Shop shop, Menu menu, int amount) {
        this.member = member;
        this.shop = shop;
        this.menu = menu;
        this.amount = amount;
    }

    public static Order of(Member member, Shop shop, Menu menu, int amount) {
        return new Order(member, shop, menu, amount);
    }
}
