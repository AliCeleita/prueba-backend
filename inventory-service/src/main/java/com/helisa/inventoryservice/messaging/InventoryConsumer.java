package com.helisa.inventoryservice.messaging;

import com.helisa.inventoryservice.service.InventoryService;
import com.helisa.inventoryservice.model.Orders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class InventoryConsumer {
    private final InventoryService inventoryService;

    @RabbitListener(queues = "${queue.orders}")
    public void validationInventory(Orders orders) {
        inventoryService.validationInventory(orders);
    }
}
