package com.helisa.inventoryservice.model;

import com.helisa.inventoryservice.enums.OrderStatus;
import jakarta.persistence.*;
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
