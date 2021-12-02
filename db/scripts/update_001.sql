CREATE TABLE post (
    id   SERIAL PRIMARY KEY,
    name TEXT,
    description TEXT,
    created TIMESTAMP DEFAULT now(),
    modified TIMESTAMP DEFAULT now()
);