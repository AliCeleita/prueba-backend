package com.helisa.orderservice.service.Impl;

import com.helisa.orderservice.dto.OrderDTO;
import com.helisa.orderservice.enums.OrderStatus;
import com.helisa.orderservice.messaging.OrderProducer;
import com.helisa.orderservice.model.Orders;
import com.helisa.orderservice.repository.OrderRepository;
import com.helisa.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderProducer orderProducer;
    private final OrderRepository orderRepository;

    @Override
    public Orders sendOrder(OrderDTO orderDTO) {
        Orders orders = new Orders(orderDTO);
        orders.setStatus(OrderStatus.PENDING);
        orderRepository.save(orders);
        orderProducer.sendOrder(orders);
        return orders;
    }

    @Override
    public void updateOrder(Long orderId, OrderStatus status) {
        orderRepository.findById(orderId).ifPresent(order -> {
            order.setStatus(status);
            orderRepository.save(order);
        });
    }

    @Override
    public Orders getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
}
