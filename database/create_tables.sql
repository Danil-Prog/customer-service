-- Creation of customer table
CREATE TABLE IF NOT EXISTS customer (
    id serial PRIMARY KEY,
    lastname VARCHAR ( 100 ) NOT NULL,
    firstname VARCHAR ( 100 ) NOT NULL
);

-- Creation of product table
CREATE TABLE IF NOT EXISTS product (
    id serial PRIMARY KEY,
    name VARCHAR ( 100 ) NOT NULL,
    price NUMERIC NOT NULL
);

-- Creation of purchases table
CREATE TABLE IF NOT EXISTS purchases (
    customer_id int REFERENCES customer (id) ON UPDATE CASCADE ON DELETE CASCADE,
    product_id int REFERENCES product (id) ON UPDATE CASCADE,
    date_of_purchase DATE NOT NULL
);
