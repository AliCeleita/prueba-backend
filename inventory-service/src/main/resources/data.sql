-- Insertar productos
INSERT INTO product (id, product_code, price) VALUES
    (1, 'LAPTOP-123', 1200.00),
    (2, 'PHONE-456', 800.00),
    (3, 'MOUSE-789', 50.00);

-- Insertar inventario relacionado con los productos
INSERT INTO inventory (id, product_id, quantity) VALUES
    (1, 1, 15),  -- 15 Laptops en stock
    (2, 2, 30),  -- 30 Smartphones en stock
    (3, 3, 50);  -- 50 Mouses en stock
