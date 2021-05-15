package com.lkimilhol.matchingProject.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lkimilhol.matchingProject.common.OrderStatusEnum;
import com.lkimilhol.matchingProject.domain.Order;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class RedisRepositoryTest {
	@Autowired
	RedisRepository redisRepository;

	@Test
	@DisplayName("redis set test")
	void method() {
	    //given
		Order order = Order.builder()
			.id(1L)
			.orderStatus(OrderStatusEnum.CANCEL)
			.build();
	    //when
		redisRepository.save(order);
		Optional<Order> byId = redisRepository.findById(order.getId());
	    //then
		assertTrue(byId.isPresent());
	}
}