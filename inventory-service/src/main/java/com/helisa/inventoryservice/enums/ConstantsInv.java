package com.helisa.inventoryservice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConstantsInv {
    NEW_ORDER_KEY("order.new"),
    RESPONSE_KEY("response.update"),
    DELIVERY_KEY("delivery.new"),
    ORDER_EXCHANGE("order.exchange");

    private final String value;

}
