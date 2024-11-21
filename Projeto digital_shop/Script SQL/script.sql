DROP DATABASE digital_shop;
CREATE DATABASE digital_shop;
USE digital_shop;

CREATE TABLE users (
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    user_surname VARCHAR(50) NOT NULL,
    user_email VARCHAR(100) NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    user_address VARCHAR(255) NOT NULL,
    user_type TINYINT(1) NOT NULL
);

CREATE TABLE products(
	product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(50) DEFAULT NULL,
    product_brand_name VARCHAR(50) DEFAULT NULL,
    product_value DECIMAL(10,2) NOT NULL CHECK (product_value >= 0),
    product_discount INT DEFAULT 0 CHECK (product_discount >= 0 && product_discount <= 100),
    product_type TINYINT(1) NOT NULL
);

CREATE TABLE carts(
    cart_id INT NOT NULL
	user_id INT NOT NULL,
    product_id INT NOT NULL,
    product_quantity INT NOT NULL CHECK (product_quantity > 0),
    cart_state CHAR(1) NOT NULL,
    PRIMARY KEY (cart_id,user_id,product_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products (product_id) ON DELETE CASCADE
);

CREATE TABLE orders(
	order_id INT NOT NULL,
    cart_id INT NOT NULL,
    total DECIMAL(10,2) NOT NULL CHECK (total >= 0),
    dispatch_address VARCHAR(250) DEFAULT NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (cart_id) REFERENCES carts (cart_id) ON DELETE CASCADE
);
