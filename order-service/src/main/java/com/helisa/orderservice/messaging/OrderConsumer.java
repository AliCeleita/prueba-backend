package com.helisa.orderservice.messaging;

import com.helisa.orderservice.model.Orders;
import com.helisa.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderConsumer {

    private final OrderService orderService;

    @RabbitListener(queues = "${queue.response}")
    public void receiveInventoryStatus(Orders message) {
        orderService.updateOrder(
                message.getId(),
                message.getStatus()
        );
        log.info("Cambio de estado");
    }
}
