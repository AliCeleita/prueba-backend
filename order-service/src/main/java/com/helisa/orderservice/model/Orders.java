package com.helisa.orderservice.model;

import com.helisa.orderservice.dto.OrderDTO;
import com.helisa.orderservice.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeProduct;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Date dateOrdered = new Date();

    public Orders(OrderDTO orderDTO) {
        this.codeProduct = orderDTO.getProductCode();
        this.quantity = orderDTO.getQuantity();
        this.dateOrdered = new Date();
    }

}
