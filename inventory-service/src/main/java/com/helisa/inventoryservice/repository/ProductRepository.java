package com.helisa.inventoryservice.repository;

import com.helisa.inventoryservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductCode(String productCode);
}
