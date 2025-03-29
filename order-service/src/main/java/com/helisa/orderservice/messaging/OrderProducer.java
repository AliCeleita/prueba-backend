package com.helisa.orderservice.messaging;

import com.helisa.orderservice.enums.ConstantsOrd;
import com.helisa.orderservice.model.Orders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendOrder(Orders orders) {
        rabbitTemplate.convertAndSend(
                ConstantsOrd.ORDER_EXCHANGE.getValue(),
                ConstantsOrd.NEW_ORDER_KEY.getValue(),
                orders
        );
        log.info("Orden enviada: {}", orders);
    }
}
