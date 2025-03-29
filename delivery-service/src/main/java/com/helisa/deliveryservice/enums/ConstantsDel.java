package com.helisa.deliveryservice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConstantsDel {
    RESPONSE_KEY("response.update"),
    DELIVERY_KEY("delivery.new"),
    ORDER_EXCHANGE("order.exchange");

    private final String value;

}
