package com.helisa.orderservice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConstantsOrd {
    NEW_ORDER_KEY("order.new"),
    RESPONSE_KEY("response.update"),
    ORDER_EXCHANGE("order.exchange");

    private final String value;

}
