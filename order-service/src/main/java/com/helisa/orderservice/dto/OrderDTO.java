package com.helisa.orderservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderDTO {

    @NotNull(message = "El codigo del producto es obligatorio")
    private String productCode;

    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int quantity;

}
