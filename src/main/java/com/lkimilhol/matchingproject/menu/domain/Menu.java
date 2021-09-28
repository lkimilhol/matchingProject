package com.lkimilhol.matchingproject.menu.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lkimilhol.matchingproject.common.Quantity;
import com.lkimilhol.matchingproject.shop.domain.Shop;

@Entity
@Getter
@NoArgsConstructor
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	@Embedded
	private MenuName name;

	@Embedded
	private Quantity quantity;

	@Column(name = "update_time", columnDefinition = "DATETIME")
	private LocalDateTime updateTime;

	@Column(name = "insert_time", columnDefinition = "DATETIME")
	private LocalDateTime insertTime;

	private Menu(Shop shop, MenuName name, Quantity quantity) {
		this.shop = shop;
		this.name = name;
		this.quantity = quantity;
	}

	public static Menu of(Shop shop, MenuName menuName, Quantity quantity) {
		return new Menu(shop, menuName, quantity);
	}

	public void removeAmount(Quantity quantity) {
		this.quantity = this.quantity.sub(quantity);
	}

	public void increaseAmount(Quantity quantity) {
		this.quantity = this.quantity.add(quantity);
	}
}
