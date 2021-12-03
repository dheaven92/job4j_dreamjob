CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    name TEXT,
    email VARCHAR(128) UNIQUE,
    password TEXT,
    created TIMESTAMP DEFAULT now(),
    modified TIMESTAMP DEFAULT now()
);