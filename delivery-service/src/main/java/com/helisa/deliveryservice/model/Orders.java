package com.helisa.deliveryservice.model;

import com.helisa.deliveryservice.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class Orders implements Serializable {

    private Long id;

    private String codeProduct;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
