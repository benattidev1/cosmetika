CREATE TABLE people (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    legal_name varchar(200) NOT NULL,
    trade_name varchar(200),
    email varchar(255),
    phone varchar(20),
    document varchar(20),

    is_customer boolean DEFAULT FALSE,
    is_supplier boolean DEFAULT FALSE,

    address varchar(200),
    city varchar(100),
    state varchar(50),
    zip_code varchar(20),
    
    notes text,
    active boolean DEFAULT TRUE,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp
);


CREATE TRIGGER update_people_updated_at 
    BEFORE UPDATE ON people
    FOR EACH ROW 
    EXECUTE FUNCTION update_updated_at_column();


CREATE INDEX idx_people_email ON people(email);
CREATE INDEX idx_people_document ON people(document);
CREATE INDEX idx_people_classification ON people(is_customer, is_supplier);
CREATE INDEX idx_people_active ON people(active);
