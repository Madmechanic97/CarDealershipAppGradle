DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS car;

CREATE TABLE user (
  user_Id INT AUTO_INCREMENT  PRIMARY KEY,
  first_Name VARCHAR(250) NOT NULL,
  last_Name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

CREATE TABLE car (
    car_Id INT AUTO_INCREMENT PRIMARY KEY,
    year INT NOT NULL,
    price DOUBLE NOT NULL,
    name VARCHAR(250) NOT NULL,
    mileage INT NOT NULL,
    brand VARCHAR(250) NOT NULL,
    availability BOOLEAN NOT NULL
);

INSERT INTO User (first_Name, last_Name, email) VALUES ('abdullah', 'tariq', 'atariq@hotmail.com'),
 ('dom', 'pau', 'dpau@hotmail.com'),
 ('seth', 'bragg', 'sbragg@hotmail.com');

INSERT INTO Car (year, price, name, mileage, brand, availability) VALUES (2020, 5000, 'Volvo Series X', 1000, 'Volvo', true),
(2009, 3000, 'Ford Fiesta', 2000, 'Ford', true),
(2012, 4500, 'Nissan Qashqai', 5600, 'Nissan', true),
(2003, 1000, 'Kia Sport', 10000, 'Kia', true),
(2007, 2000, 'BMW 3 Series', 3400, 'BMW', true),
(2018, 5000, 'Series X Mercedes', 1000, 'Mercedes', true),
(2003, 4500, 'Lamborgini Galardo', 5000, 'Lamborgini', true),
(2017, 8000, 'Luxury Mercedes', 4000, 'Mercedes', true);

