package com.lkimilhol.matchingproject.shop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lkimilhol.matchingproject.common.CategoryEnum;
import com.lkimilhol.matchingproject.menu.domain.Menu;
import com.lkimilhol.matchingproject.order.domain.Order;

@Entity
@Getter
@NoArgsConstructor
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


    private Shop(String name, CategoryEnum category, String city, String district) {
        this.name = name;
        this.category = category;
        this.city = city;
        this.district = district;
    }

    public static Shop of(String name, CategoryEnum category, String city, String district) {
        return new Shop(name, category, city, district);
    }
}
