package com.helisa.inventoryservice.service.impl;

import com.helisa.inventoryservice.messaging.InventoryProducer;
import com.helisa.inventoryservice.model.Inventory;
import com.helisa.inventoryservice.model.Product;
import com.helisa.inventoryservice.repository.InventoryRepository;
import com.helisa.inventoryservice.repository.ProductRepository;
import com.helisa.inventoryservice.service.InventoryService;
import com.helisa.inventoryservice.enums.OrderStatus;
import com.helisa.inventoryservice.model.Orders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryProducer inventoryProducer;
    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;

    @Override
    public void validationInventory(Orders orders) {

        if (orders.getStatus() == OrderStatus.ERROR || orders.getStatus() == OrderStatus.VALIDATED) {
            return;
        }

        Product product = productRepository.findByProductCode(orders.getCodeProduct());

        Inventory inventory = inventoryRepository.findByProduct(product);

        if (inventory == null || inventory.getQuantity() <= 0 || inventory.getQuantity() < orders.getQuantity()) {
            orders.setStatus(OrderStatus.ERROR);
            log.info("Error enviado, inventario insuficiente");
        }else{
            orders.setStatus(OrderStatus.VALIDATED);
            log.info("Envio a delivery");
            inventoryProducer.sendDelivery(orders);
        }
        inventoryProducer.sendToOrder(orders);
    }
}
