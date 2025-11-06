CREATE SCHEMA IF NOT EXISTS public;


CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


CREATE FUNCTION update_updated_at_column()
returns TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
