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
    user_type TINYINT(1) NOT NULL CHECK (user_type >= 1 && user_type <= 2)
);

CREATE TABLE products(
	product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(50) DEFAULT NULL,
    product_brand_name VARCHAR(50) DEFAULT NULL,
    product_quantity INT DEFAULT 0 CHECK (product_quantity >= 0),
    product_value DECIMAL(10,2) NOT NULL CHECK (product_value >= 0),
    product_discount INT DEFAULT 0 CHECK (product_discount >= 0 && product_discount <= 100),
    product_type TINYINT(1) NOT NULL
);

CREATE TABLE carts(
    cart_id INT NOT NULL,
	user_id INT NOT NULL,
    product_id INT NOT NULL,
    product_quantity INT NOT NULL CHECK (product_quantity > 0),
    cart_state CHAR(1) NOT NULL,
    PRIMARY KEY (cart_id,user_id,product_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products (product_id) ON DELETE CASCADE
);

CREATE TABLE orders(
	order_id INT PRIMARY KEY AUTO_INCREMENT,
    cart_id INT NOT NULL,
    total DECIMAL(10,2) NOT NULL CHECK (total >= 0),
    dispatch_address VARCHAR(250) DEFAULT NULL,
    FOREIGN KEY (cart_id) REFERENCES carts (cart_id) ON DELETE CASCADE
);

INSERT INTO products (product_id,product_name,product_brand_name,product_value,product_discount,product_type) VALUES 
    (1,"GTA San Andreas", "Rockstar Games", 99.99, 0, 1),
    (2,"The Witcher 3 Wild Hunt", "Projeckt Red", 199.99, 0, 1),
    (3,"Playstation 5", "Sony", 5599.99, 0, 2),
    (4,"Swicth 2", "Nintendo", 10099.99, 90, 2),
    (5,"Red Dead Redemption 2", "Rockstar Games", 199.99, 0, 1),
    (6,"Controller Dualsense", "Sony", 399.99, 0, 2),
    (7,"Mario Wonder 3", "Nintendo", 299.99, 0, 1),
    (8,"Assassin's Creed 2", "Ubisoft", 99.99, 0, 1),
    (9,"Fifa 25", "EA Games", 299.99, 0, 1),
    (10,"Forza Horizon 5", "Microsoft", 230.99, 0, 1);
