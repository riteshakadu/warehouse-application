CREATE SCHEMA warehouse;
USE warehouse;

CREATE TABLE product(
	id BIGINT PRIMARY KEY AUTO_INCREMENT UNIQUE NOT NULL,
    name VARCHAR(30) NOT NULL,
    phone VARCHAR(30),
    photo VARCHAR(100),
    price REAL NOT NULL,
    unit VARCHAR(30) NOT NULL,
    description TEXT,
    company_id BIGINT,
    warehouse_id BIGINT
);

CREATE TABLE warehouse(
	id BIGINT PRIMARY KEY AUTO_INCREMENT UNIQUE NOT NULL,
    name VARCHAR(30) NOT NULL,
    company_id BIGINT,
    /*address start*/
    country VARCHAR(30),
    city VARCHAR(30),
    street VARCHAR(30),
    house VARCHAR(30)
    /*address end*/
);

CREATE TABLE company(
	id BIGINT PRIMARY KEY AUTO_INCREMENT UNIQUE NOT NULL,
    name VARCHAR(30) NOT NULL,
    registration_date DATETIME,
    photo VARCHAR(100),
    /*address start*/
    country VARCHAR(30),
    city VARCHAR(30),
    street VARCHAR(30),
    house VARCHAR(30)
    /*address end*/
);

CREATE TABLE employee (
	id BIGINT PRIMARY KEY AUTO_INCREMENT UNIQUE NOT NULL,
    name VARCHAR(30) NOT NULL,
    phone VARCHAR(30),
    company_id BIGINT
);

ALTER TABLE product ADD FOREIGN KEY (company_id) REFERENCES company(id);
ALTER TABLE product ADD FOREIGN KEY (warehouse_id) REFERENCES warehouse(id);
ALTER TABLE employee ADD FOREIGN KEY (company_id) REFERENCES company(id);
ALTER TABLE warehouse ADD FOREIGN KEY (company_id) REFERENCES company(id);
