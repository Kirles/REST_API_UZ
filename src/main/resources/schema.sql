CREATE TABLE IF NOT EXISTS station (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(7) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS train (
    id SERIAL PRIMARY KEY,
    number VARCHAR(4) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS wagon (
    id SERIAL PRIMARY KEY,
    train_id INT NOT NULL REFERENCES train(id) ON DELETE CASCADE,
    wagon_number VARCHAR(3) NOT NULL,
    wagon_class CHAR(1) NOT NULL,
    UNIQUE (train_id, wagon_number)
);

CREATE TABLE IF NOT EXISTS trip (
    id SERIAL PRIMARY KEY,
    train_id INT NOT NULL REFERENCES train(id) ON DELETE CASCADE,
    from_station_id INT NOT NULL REFERENCES station(id),
    to_station_id INT NOT NULL REFERENCES station(id),
    departure_time TIMESTAMP NOT NULL,
    arrival_time TIMESTAMP NOT NULL
);