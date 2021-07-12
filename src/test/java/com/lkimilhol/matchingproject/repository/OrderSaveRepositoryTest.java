//package com.lkimilhol.matchingproject.repository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Optional;
//
//import javax.transaction.Transactional;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.lkimilhol.matchingproject.ordersave.domain.OrderSave;
//import com.lkimilhol.matchingproject.ordersave.repository.OrderSaveRepository;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@Transactional
//class OrderSaveRepositoryTest {
//	@Autowired
//    OrderSaveRepository orderSaveRepository;
//
//	@Test
//	@DisplayName("redis set test")
//	void save() {
//	    //given
//		OrderSave order = OrderSave.builder()
//			.memberId(1L)
//			.menuId(1L)
//			.shopId(1L)
//			.build();
//	    //when
//		orderSaveRepository.save(order);
//		Optional<OrderSave> byId = orderSaveRepository.findById(order.getMemberId());
//		//then
//		assertTrue(byId.isPresent());
//	}
//}