package com.lkimilhol.matchingProject.order.domain;

import com.lkimilhol.matchingProject.common.OrderStatusEnum;
import com.lkimilhol.matchingProject.shop.domain.Shop;
import com.lkimilhol.matchingProject.member.domain.Member;
import com.lkimilhol.matchingProject.menu.domain.Menu;

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
    private OrderStatusEnum orderStatus;

    @Column(name = "update_time", columnDefinition = "DATETIME")
    private LocalDateTime updateTime;

    @Column(name = "insert_time", columnDefinition = "DATETIME")
    private LocalDateTime insertTime;
}
