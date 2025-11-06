CREATE TABLE products (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    name varchar(200) NOT NULL,
    description text,
    sku varchar(50) UNIQUE,
    barcode varchar(50),

    current_stock DECIMAL(10, 2) DEFAULT 0,
    min_stock DECIMAL(10, 2) DEFAULT 0,
    unit varchar(20) DEFAULT 'UN',

    cost_price DECIMAL(10, 2) DEFAULT 0,
    sale_price DECIMAL(10, 2) DEFAULT 0,
    
    active boolean DEFAULT TRUE,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp
);


CREATE TRIGGER update_products_updated_at 
    BEFORE UPDATE ON products
    FOR EACH ROW 
    EXECUTE FUNCTION update_updated_at_column();


CREATE INDEX idx_products_sku ON products(sku);
CREATE INDEX idx_products_barcode ON products(barcode);
CREATE INDEX idx_products_active ON products(active);
CREATE INDEX idx_products_name ON products(name);
