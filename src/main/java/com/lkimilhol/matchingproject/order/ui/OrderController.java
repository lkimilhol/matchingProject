package com.lkimilhol.matchingproject.order.ui;

import java.net.URI;

import com.lkimilhol.matchingproject.order.domain.Order;
import com.lkimilhol.matchingproject.order.dto.OrderDto;
import com.lkimilhol.matchingproject.request.CreateOrder;
import com.lkimilhol.matchingproject.response.ResultBody;
import com.lkimilhol.matchingproject.order.application.OrderService;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/orders/")
    @ResponseBody
    public ResponseEntity<ResultBody> addShop(
            @Valid CreateOrder createOrder
            ) {
        Order order = orderService.addOrder(createOrder);
        return ResponseEntity.created(URI.create("/orders/" + order.getId())).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/orders/{orderId}")
    @ResponseBody
    public ResponseEntity<ResultBody> getOrder(@PathVariable Long orderId) {
        Order order = orderService.getOrder(orderId);
        return ResponseEntity.ok(new ResultBody(getOrderDto(order)));
    }

    @DeleteMapping(value = "/orders/{orderId}")
    @ResponseBody
    public ResponseEntity<ResultBody> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/orders/history/shop/{shopId}")
    @ResponseBody
    public ResponseEntity<ResultBody> getOrderHistory(@PathVariable Long shopId) {
        return ResponseEntity.ok(new ResultBody(orderService.getOrderHistory(shopId)));
    }

    private OrderDto getOrderDto(Order order) {
        return OrderDto.builder().order(order).build();
    }
}
