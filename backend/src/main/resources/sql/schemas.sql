CREATE TABLE IF NOT EXISTS plants (
    id SERIAL PRIMARY KEY, name VARCHAR(255) UNIQUE NOT NULL,
    latin_name VARCHAR(255),
    description TEXT,
    profile_picture VARCHAR(255),
    watering_schedule VARCHAR(255), -- Assuming this field stores some schedule information
    last_watered TIMESTAMP
    );
INSERT INTO plants (id, name, latin_name, description, profile_picture, watering_schedule, last_watered)
VALUES
    (1, 'Dragon spider', 'Dracaena marginata', 'Arrived in August 2023. Important to note that its roots are sensitive, watering once a week', '1', 'ASNEEDED', TIMESTAMP '2022-01-01' + INTERVAL '1' DAY * (FLOOR(RANDOM() * (365 * 2)))),
    (2, 'Sabri', 'Haworthia attenuata', 'a cool chill dude, minimal watering and all is good !', '2', 'ASNEEDED', TIMESTAMP '2022-01-01' + INTERVAL '1' DAY * (FLOOR(RANDOM() * (365 * 2)))),
    (3, 'Golden Pothos', 'Eppipremnum aureum', 'An absolute delight! Grows fast, very low maintenance, can be moduled.', '3', 'WEEKLY', TIMESTAMP '2022-01-01' + INTERVAL '1' DAY * (FLOOR(RANDOM() * (365 * 2)))),
    (4, 'Butch', 'Smallus GreenusTree', 'very low maintenance!', '4', 'WEEKLY', TIMESTAMP '2022-01-01' + INTERVAL '1' DAY * (FLOOR(RANDOM() * (365 * 2)))),
    (5, 'Monstera', 'Monstera Delicosa', 'beautiful plant with air roots. Must be watered regularly!', '5', 'WEEKLY', TIMESTAMP '2022-01-01' + INTERVAL '1' DAY * (FLOOR(RANDOM() * (365 * 2)))),
    (6, 'Bamboomium', 'Spider Plant', 'Gift from Elise, been around since 2021. buds can be replanted.', '6', 'WEEKLY', TIMESTAMP '2022-01-01' + INTERVAL '1' DAY * (FLOOR(RANDOM() * (365 * 2)))),
    (7, 'Terrarium', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', '7', 'WEEKLY', TIMESTAMP '2022-01-01' + INTERVAL '1' DAY * (FLOOR(RANDOM() * (365 * 2)))),
    (8, 'Seconqua', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', '8', 'ASNEEDED', TIMESTAMP '2022-01-01' + INTERVAL '1' DAY * (FLOOR(RANDOM() * (365 * 2)))),
    (9, 'Masha', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', '9', 'BIWEEKLY', TIMESTAMP '2022-01-01' + INTERVAL '1' DAY * (FLOOR(RANDOM() * (365 * 2)))),
    (10, 'Leeo', 'Bamboo terrarium', 'Bought from a woman who made it. low maintenance be replanted.', '10', 'WEEKLY', TIMESTAMP '2022-01-01' + INTERVAL '1' DAY * (FLOOR(RANDOM() * (365 * 2))));
