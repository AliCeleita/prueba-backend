package com.helisa.deliveryservice.service;

import com.helisa.deliveryservice.model.Orders;
import org.springframework.stereotype.Component;

@Component
public interface DeliveryService {

    void createDelivery(Orders orders);
}
