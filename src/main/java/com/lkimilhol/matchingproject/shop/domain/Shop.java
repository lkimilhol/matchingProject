package com.lkimilhol.matchingproject.shop.domain;

import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.order.domain.Order;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Shop {
    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    private String city;

    private String district;

    @OneToMany(mappedBy = "shop")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "shop")
    private List<Menu> menus = new ArrayList<>();

    @Column(name = "update_time", columnDefinition = "DATETIME")
    private LocalDateTime updateTime;

    @Column(name = "insert_time", columnDefinition = "DATETIME")
    private LocalDateTime insertTime;
}
