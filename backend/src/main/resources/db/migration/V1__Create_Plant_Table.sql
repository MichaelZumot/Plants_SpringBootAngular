CREATE TABLE IF NOT EXISTS plant (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    latin_name VARCHAR(255),
    description TEXT,
    profile_picture VARCHAR(255),
    watering_schedule VARCHAR(255),
    last_watered TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS medicine (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    expiry_date DATE
    );
