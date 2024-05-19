CREATE TABLE IF NOT EXISTS plant
(
    id
    SERIAL
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) UNIQUE NOT NULL,
    latin_name VARCHAR
(
    255
),
    description TEXT,
    profile_picture VARCHAR
(
    255
),
    watering_schedule VARCHAR
(
    255
),
    last_watered DATE
    );

CREATE TABLE IF NOT EXISTS medicine
(
    id
    SERIAL
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) UNIQUE NOT NULL,
    quantity Integer,
    expiry_date DATE
    );


INSERT INTO plant (name, latin_name, description, watering_schedule)
VALUES ('Dragon spider', 'Dracaena marginata','Arrived in August 2023. Important to note that its roots are sensitive, watering once a week', 'WEEKLY'),
       ('Sabri', 'Haworthia attenuata', 'a cool chill dude, minimal watering and all is good !', 'AS_NEEDED'),
       ('Golden Pothos', 'Eppipremnum aureum', 'An absolute delight! Grows fast, very low maintenance, can be moduled.','WEEKLY'),
       ('Butch', 'Smallus GreenusTree', 'very low maintenance!', 'WEEKLY'),
       ('Monstera', 'Monstera Delicosa', 'beautiful plant with air roots. Must be watered regularly!', 'WEEKLY'),
       ('Bamboomium', 'Spider Plant', 'Gift from Elise, been around since 2021. buds can be replanted.', 'WEEKLY'),
       ('Terrarium', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', 'WEEKLY'),
       ('Seconqua', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', 'AS_NEEDED'),
       ('Masha', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', 'BI_WEEKLY'),
       ('Leeo', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', 'WEEKLY');

INSERT INTO medicine (name, quantity, expiry_date)
VALUES ('Paracetamol', '4', '2025-10-10'),
       ('Neurofen', '10', '2025-12-09'),
       ('Dafalgan Forte', '2', '2026-11-08'),
       ('Bactorban', '4', '2026-12-10'),
       ('Daktozan', '4', '2027-6-10'),
       ('Tramadol', '14', '2027-1-10');
