package com.helisa.deliveryservice.service.Impl;

import com.helisa.deliveryservice.enums.OrderStatus;
import com.helisa.deliveryservice.messaging.DeliveryProducer;
import com.helisa.deliveryservice.model.Orders;
import com.helisa.deliveryservice.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryProducer deliveryProducer;

    @Override
    public void createDelivery(Orders orders) {
        log.info("Generando despacho y guardando");
        orders.setStatus(OrderStatus.DELIVERED);
        deliveryProducer.sendResult(orders);
    }
}
