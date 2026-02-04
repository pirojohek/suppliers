INSERT INTO storage.t_supplier (c_name) VALUES
    ('ООО Сад-1'),
    ('ООО Сад-2'),
    ('ООО Сад-3');

INSERT INTO storage.t_product (c_name, c_type) VALUES
    ('Яблоко Гала', 'APPLE'),
    ('Яблоко Фуджи', 'APPLE'),
    ('Груша Конференция', 'PEAR'),
    ('Груша Уильямс', 'PEAR');

INSERT INTO storage.t_supplier_product_price (c_supplier, c_product, c_price, c_date_from, c_date_to) VALUES
    -- Поставщик 1
    (1, 1, 3.10, '2026-02-01', '2026-02-28'),
    (1, 2, 3.50, '2026-02-01', '2026-02-28'),
    (1, 3, 4.00, '2026-02-01', '2026-02-28'),
    (1, 4, 4.40, '2026-02-01', '2026-02-28'),
    -- Поставщик 2
    (2, 1, 3.00, '2026-02-01', '2026-02-28'),
    (2, 2, 3.60, '2026-02-01', '2026-02-28'),
    (2, 3, 4.10, '2026-02-01', '2026-02-28'),
    (2, 4, 4.55, '2026-02-01', '2026-02-28'),
    -- Поставщик 3
    (3, 1, 3.20, '2026-02-01', '2026-02-28'),
    (3, 2, 3.40, '2026-02-01', '2026-02-28'),
    (3, 3, 4.05, '2026-02-01', '2026-02-28'),
    (3, 4, 4.50, '2026-02-01', '2026-02-28');


INSERT INTO storage.t_supply (c_supplier, c_supply_date) VALUES (1, '2026-02-10');

INSERT INTO storage.t_supply_item (c_supply, c_supplier_price, c_weight_per_kg) VALUES
    (1, (SELECT c_id FROM storage.t_supplier_product_price WHERE c_supplier=1 AND c_product=1 AND c_date_from='2026-02-01'), 120.000),
    (1, (SELECT c_id FROM storage.t_supplier_product_price WHERE c_supplier=1 AND c_product=3 AND c_date_from='2026-02-01'), 80.000);


INSERT INTO storage.t_supply (c_supplier, c_supply_date) VALUES (2, '2026-02-15');
INSERT INTO storage.t_supply_item (c_supply, c_supplier_price, c_weight_per_kg) VALUES
    (2, (SELECT c_id FROM storage.t_supplier_product_price WHERE c_supplier=2 AND c_product=2 AND c_date_from='2026-02-01'), 150.000),
    (2, (SELECT c_id FROM storage.t_supplier_product_price WHERE c_supplier=2 AND c_product=4 AND c_date_from='2026-02-01'), 90.000);



INSERT INTO storage.t_supply (c_supplier, c_supply_date) VALUES (1, '2026-02-20');
INSERT INTO storage.t_supply_item (c_supply, c_supplier_price, c_weight_per_kg) VALUES
    (3, (SELECT c_id FROM storage.t_supplier_product_price WHERE c_supplier=1 AND c_product=2 AND c_date_from='2026-02-01'), 60.000),
    (3, (SELECT c_id FROM storage.t_supplier_product_price WHERE c_supplier=1 AND c_product=4 AND c_date_from='2026-02-01'), 55.000);

INSERT INTO storage.t_supply (c_supplier, c_supply_date) VALUES (3, '2026-02-22');
INSERT INTO storage.t_supply_item (c_supply, c_supplier_price, c_weight_per_kg) VALUES
    (4, (SELECT c_id FROM storage.t_supplier_product_price WHERE c_supplier=3 AND c_product=1 AND c_date_from='2026-02-01'), 110.000),
    (4, (SELECT c_id FROM storage.t_supplier_product_price WHERE c_supplier=3 AND c_product=3 AND c_date_from='2026-02-01'), 70.000);
