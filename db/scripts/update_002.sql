CREATE TABLE candidate (
    id   SERIAL PRIMARY KEY,
    name TEXT,
    created TIMESTAMP DEFAULT now(),
    modified TIMESTAMP DEFAULT now()
);