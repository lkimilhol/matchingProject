package com.lkimilhol.matchingproject.menu.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lkimilhol.matchingproject.exception.NegativeValueException;
import com.lkimilhol.matchingproject.shop.domain.Shop;
import com.lkimilhol.matchingproject.exception.CustomException;
import com.lkimilhol.matchingproject.exception.ErrorInfo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	private String name;

	private int amount;

	@Column(name = "update_time", columnDefinition = "DATETIME")
	private LocalDateTime updateTime;

	@Column(name = "insert_time", columnDefinition = "DATETIME")
	private LocalDateTime insertTime;

	public void removeAmount(int amount) {
		checkNegative(amount);
		this.amount -= amount;
	}

	private void checkNegative(int amount) {
		if (this.amount - amount < 0) {
			throw new NegativeValueException();
		}
	}
}