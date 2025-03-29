package com.helisa.deliveryservice.enums;

public enum OrderStatus {
    PENDING,       // Estado inicial
    VALIDATED,     // Validado por inventory-service
    ERROR,         // Error en inventory
    DELIVERED      // Entregado
}
