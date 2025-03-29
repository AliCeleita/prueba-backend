package com.helisa.deliveryservice.messaging;

import com.helisa.deliveryservice.enums.ConstantsDel;
import com.helisa.deliveryservice.model.Orders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DeliveryProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendResult(Orders orders) {
        rabbitTemplate.convertAndSend(
                ConstantsDel.ORDER_EXCHANGE.getValue(),
                ConstantsDel.RESPONSE_KEY.getValue(),
                orders
        );
    }
}
