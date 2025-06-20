CREATE DATABASE carrental;

use carrental;

CREATE TABLE vehicles (
    vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_type VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    location VARCHAR(100) NOT NULL,
    price_per_day DECIMAL(10,2) NOT NULL,
    availability VARCHAR(20) DEFAULT 'AVAILABLE'
);

CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(15) NOT NULL
);

INSERT INTO vehicles (vehicle_type, model, location, price_per_day, availability) 
VALUES 
('SUV', 'Hyundai Creta', 'Chennai', 2500.00, 'AVAILABLE'),
('SEDAN', 'Honda City', 'Bengaluru', 2200.00, 'AVAILABLE'),
('HATCHBACK', 'Maruti Swift', 'Hyderabad', 1800.00, 'UNAVAILABLE');


INSERT INTO customers (first_name, last_name, email, username, password, phone_number) 
VALUES 
('Ravi', 'Kumar', 'ravi.kumar@example.com', 'ravi123', 'ravi@123', '9876543210'),
('Sneha', 'Reddy', 'sneha.reddy@example.com', 'sneha99', 'sneha@99', '9123456789'),
('Arjun', 'Mehta', 'arjun.mehta@example.com', 'arjunm', 'arjun@pass', '9988776655');


commit;
select * from customers;

