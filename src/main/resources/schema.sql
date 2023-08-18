CREATE TABLE IF NOT EXISTS person (
    id INTEGER NOT NULL PRIMARY KEY,
    first_name TEXT,
    last_name TEXT,
    house_id INTEGER
);

CREATE TABLE IF NOT EXISTS house (
    id INTEGER NOT NULL PRIMARY KEY,
    address TEXT
)
