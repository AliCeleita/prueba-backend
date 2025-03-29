package com.helisa.orderservice.service;

import com.helisa.orderservice.dto.OrderDTO;
import com.helisa.orderservice.enums.OrderStatus;
import com.helisa.orderservice.model.Orders;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {

    Orders sendOrder(OrderDTO order);

    void updateOrder(Long orderId, OrderStatus status);

    Orders getOrderById(Long orderId);
}
