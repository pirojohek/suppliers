CREATE SCHEMA storage;

CREATE TABLE storage.t_supplier
(
    c_id   SERIAL PRIMARY KEY,
    c_name VARCHAR(2048) NOT NULL
);

CREATE TABLE storage.t_product
(
    c_id   SERIAL PRIMARY KEY,
    c_name VARCHAR(2048) NOT NULL,
    c_type VARCHAR(128)  NOT NULL -- не добавляю constraint под тип продукта, так как возможно расширение
);

CREATE TABLE storage.t_supplier_product_price
(
    c_id        SERIAL PRIMARY KEY,
    c_supplier  INTEGER REFERENCES storage.t_supplier (c_id) NOT NULL,
    c_product   INTEGER REFERENCES storage.t_product (c_id)  NOT NULL,
    c_price     DECIMAL(15, 2)                               NOT NULL,
    c_date_from DATE                                         NOT NULL,
    c_date_to   DATE                                         NOT NULL
);

CREATE TABLE storage.t_supply
(
    c_id          SERIAL PRIMARY KEY,
    c_supplier    INTEGER REFERENCES storage.t_supplier (c_id) NOT NULL,
    c_supply_date DATE                                         NOT NULL
);

CREATE TABLE storage.t_supply_item
(
    c_id             SERIAL PRIMARY KEY,
    c_supply         INTEGER REFERENCES storage.t_supply (c_id)         NOT NULL,
    c_supplier_price INTEGER REFERENCES storage.t_supplier_product_price (c_id) NOT NULL,
    c_weight_per_kg  INTEGER                                            NOT NULL
);