CREATE TABLE IF NOT EXISTS plant (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    latin_name VARCHAR(255),
    description TEXT,
    profile_picture VARCHAR(255),
    watering_schedule VARCHAR(255),
    last_watered DATE
    );

CREATE TABLE IF NOT EXISTS medicine (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    expiry_date DATE
    );
INSERT INTO plant (name, latin_name, description, watering_schedule)
VALUES
    ('Dragon spider', 'Dracaena marginata', 'Arrived in August 2023. Important to note that its roots are sensitive, watering once a week', 'WEEKLY', '2024-03-23'),
    ('Sabri', 'Haworthia attenuata', 'a cool chill dude, minimal watering and all is good !', 'ASNEEDED', '2024-03-23 12:00:00'),
    ('Golden Pothos', 'Eppipremnum aureum', 'An absolute delight! Grows fast, very low maintenance, can be moduled.', 'WEEKLY', '2024-03-23'),
    ('Butch', 'Smallus GreenusTree', 'very low maintenance!', 'WEEKLY', '2024-03-23'),
    ('Monstera', 'Monstera Delicosa', 'beautiful plant with air roots. Must be watered regularly!', 'WEEKLY', '2024-03-23'),
    ('Bamboomium', 'Spider Plant', 'Gift from Elise, been around since 2021. buds can be replanted.', 'WEEKLY', '2024-03-23'),
    ('Terrarium', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', 'WEEKLY', '2024-03-23'),
    ('Seconqua', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', 'ASNEEDED', '2024-03-23'),
    ('Masha', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', 'BIWEEKLY', '2024-03-23'),
    ('Leeo', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', 'WEEKLY', '2024-03-23');

INSERT INTO medicine (name, expiry_date, quantity)
VALUES('Paracetamol', '2025-03-03', '4' );