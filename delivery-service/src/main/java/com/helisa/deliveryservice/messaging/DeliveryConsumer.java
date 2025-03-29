package com.helisa.deliveryservice.messaging;

import com.helisa.deliveryservice.model.Orders;
import com.helisa.deliveryservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DeliveryConsumer {

    private final DeliveryService deliveryService;

    @RabbitListener(queues = "${queue.delivery}")
    public void createDelivery(Orders orders) {
        deliveryService.createDelivery(orders);
        log.info("Cambio de estado");
    }
}
