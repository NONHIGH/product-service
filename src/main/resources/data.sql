CREATE TABLE IF NOT EXISTS tbl_categories (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tbl_products (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    stock INT,
    price DECIMAL(10, 2),
    status VARCHAR(50),
    create_at DATE,
    category_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES tbl_categories(id)
);

CREATE TABLE IF NOT EXISTS product_category (
    product_id BIGINT,
    category_id BIGINT,
    FOREIGN KEY (product_id) REFERENCES tbl_products(id),
    FOREIGN KEY (category_id) REFERENCES tbl_categories(id),
    PRIMARY KEY (product_id, category_id)
);

INSERT INTO tbl_categories (id, name) VALUES (1, 'shoes');
INSERT INTO tbl_categories (id, name) VALUES (2, 'books');
INSERT INTO tbl_categories (id, name) VALUES (3, 'electronics');

INSERT INTO tbl_products (id, name, description, stock, price, status, create_at, category_id)
VALUES (1, 'adidas Cloudfoam Ultimate', 'Walk in the air in the black / black CLOUDFOAM ULTIMATE running shoe from ADIDAS', 5, 178.89, 'CREATED', '2018-09-05', 1);

INSERT INTO tbl_products (id, name, description, stock, price, status, create_at, category_id)
VALUES (2, 'under armour Men ''s Micro G Assert – 7', 'under armour Men ''Lightweight mesh upper delivers complete breathability . Durable leather overlays for stability', 4, 12.5, 'CREATED', '2018-09-05', 1);

INSERT INTO tbl_products (id, name, description, stock, price, status, create_at, category_id)
VALUES (3, 'Spring Boot in Action', 'under armour Men '' Craig Walls is a software developer at Pivotal and is the author of Spring in Action', 12, 40.06, 'CREATED', '2018-09-05', 2);
