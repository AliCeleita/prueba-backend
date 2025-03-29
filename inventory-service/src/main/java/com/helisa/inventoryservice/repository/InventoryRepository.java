package com.helisa.inventoryservice.repository;

import com.helisa.inventoryservice.model.Inventory;
import com.helisa.inventoryservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findByProduct(Product product);
}
