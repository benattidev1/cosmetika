CREATE TABLE stock_movements (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    product_id uuid NOT NULL REFERENCES PRODUCTS (id),

    movement_type varchar(20),
    quantity DECIMAL(10, 2) NOT NULL,
    unit_price DECIMAL(10, 2),

    person_id uuid REFERENCES PEOPLE (id),
    sale_id uuid REFERENCES SALES (id),

    movement_date timestamp DEFAULT CURRENT_TIMESTAMP,
    notes text,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP
);
