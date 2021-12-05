CREATE TABLE city (
    id SERIAL PRIMARY KEY,
    name TEXT
);

INSERT INTO city (name) VALUES ('Москва');
INSERT INTO city (name) VALUES ('Санкт-Петербург');
INSERT INTO city (name) VALUES ('Калининград');

ALTER TABLE candidate ADD COLUMN city_id INT REFERENCES city (id);