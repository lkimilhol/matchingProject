package com.lkimilhol.matchingProject.order.ui;

import com.lkimilhol.matchingProject.order.domain.Order;
import com.lkimilhol.matchingProject.order.dto.OrderDto;
import com.lkimilhol.matchingProject.request.CreateOrder;
import com.lkimilhol.matchingProject.response.ResultBody;
import com.lkimilhol.matchingProject.order.application.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/order/new", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResultBody> addShop(
            @Valid CreateOrder createOrder
            ) {
        Order order = orderService.addOrder(createOrder);
        return ResponseEntity.ok(new ResultBody(getOrderDto(order)));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ResultBody> getOrder(
            @PathVariable Long orderId
    ) {
        Order order = orderService.getOrder(orderId);
        return ResponseEntity.ok(new ResultBody(getOrderDto(order)));
    }

    private OrderDto getOrderDto(Order order) {
        return OrderDto.builder().order(order).build();
    }
}
