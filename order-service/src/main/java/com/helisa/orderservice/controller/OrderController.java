package com.helisa.orderservice.controller;

import com.helisa.orderservice.dto.OrderDTO;
import com.helisa.orderservice.model.Orders;
import com.helisa.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody OrderDTO orderDTO) {
        Orders orders = orderService.sendOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(orders);
    }

    @GetMapping("{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long orderId) {
        Orders orders = orderService.getOrderById(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }
}
