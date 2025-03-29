package com.helisa.inventoryservice.messaging;

import com.helisa.inventoryservice.enums.ConstantsInv;
import com.helisa.inventoryservice.model.Orders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class InventoryProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendDelivery(Orders orders) {
        rabbitTemplate.convertAndSend(
                ConstantsInv.ORDER_EXCHANGE.getValue(),
                ConstantsInv.DELIVERY_KEY.getValue(),
                orders
        );
        log.info("Orden enviada a delivery: {}", orders);
    }

    public void sendToOrder(Orders orders) {
        rabbitTemplate.convertAndSend(
                ConstantsInv.ORDER_EXCHANGE.getValue(),
                ConstantsInv.RESPONSE_KEY.getValue(),
                orders
        );
        log.info("Envio de estado a order {}", orders);
    }
}
