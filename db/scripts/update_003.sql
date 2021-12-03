CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    name TEXT,
    email TEXT UNIQUE,
    password TEXT,
    created TIMESTAMP DEFAULT now(),
    modified TIMESTAMP DEFAULT now()
);