CREATE TABLE sales (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    customer_id uuid REFERENCES people(id),

    sale_date timestamp DEFAULT CURRENT_TIMESTAMP,
    subtotal DECIMAL(10, 2) NOT NULL DEFAULT 0,
    discount DECIMAL(10, 2) DEFAULT 0,
    total DECIMAL(10, 2) NOT NULL DEFAULT 0,

    status varchar(20) DEFAULT 'PENDING',
    payment_method varchar(50),

    notes text,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp
);


CREATE TABLE sale_items (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    sale_id uuid NOT NULL REFERENCES sales (id) ON DELETE CASCADE,
    item_number integer NOT NULL,
    product_id uuid NOT NULL REFERENCES products (id),

    quantity DECIMAL(10, 2) NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    discount DECIMAL(10, 2) DEFAULT 0,
    total DECIMAL(10, 2) NOT NULL,
    
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp,
    CONSTRAINT uq_sale_item_number UNIQUE (sale_id, item_number)
);


CREATE TRIGGER update_sales_updated_at 
    BEFORE UPDATE ON sales
    FOR EACH ROW 
    EXECUTE FUNCTION update_updated_at_column();
    

CREATE TRIGGER update_sale_items_updated_at 
    BEFORE UPDATE ON sale_items
    FOR EACH ROW 
    EXECUTE FUNCTION update_updated_at_column();


CREATE INDEX idx_sales_customer_id ON sales(customer_id);
CREATE INDEX idx_sales_date ON sales(sale_date);
CREATE INDEX idx_sales_status ON sales(status);
    

CREATE INDEX idx_sale_items_sale_id ON sale_items(sale_id);
CREATE INDEX idx_sale_items_product_id ON sale_items(product_id);
