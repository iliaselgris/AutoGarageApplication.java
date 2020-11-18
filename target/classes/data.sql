INSERT INTO users (username, last_name, password, email, mobile)
VALUES ('ilias', 'elgris', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', '@gmail.com', '0679893298'),
       ('bart', 'elgris', '$2a$10$I2j2fA2pYVT5dv4ZnLbm6uDjyCfLgn1jPpNy0spFPbQWE5PuUQsEW', '@gmail.com', '0679893298'),
       ('tom', 'elgris', '$2a$10$I2j2fA2pYVT5dv4ZnLbm6uDjyCfLgn1jPpNy0spFPbQWE5PuUQsEW', '@gmail.com', '0679893298'),
       ('Asare', 'elgris', '$2a$10$I2j2fA2pYVT5dv4ZnLbm6uDjyCfLgn1jPpNy0spFPbQWE5PuUQsEW', '@gmail.com', '0679893298');


INSERT INTO authorities (username, authority)
VALUES ('bart', 'ROLE_MONTEUR'),
       ('bart', 'ROLE_FRONTDESK'),
       ('tom', 'ROLE_KASSIERE'),
       ('asare', 'ROLE_STOCK_MW'),
       ('ilias', 'ROLE_ADMIN');



INSERT INTO customer(email, last_name, mobile, name)
VALUES ('Mark@gmail.com', 'de man', '0612343455', 'Mark');
INSERT INTO customer(email, last_name, mobile, name)
VALUES ('blabla@gmail.com', 'de kerel', '0612343455', 'blabla');
INSERT INTO customer(email, last_name, mobile, name)
VALUES ('blue@gmail.com', 'de vrouw', '0612343455', 'Blue');
INSERT INTO customer(email, last_name, mobile, name)
VALUES ('Sander@gmail.com', 'de sander', '0612343455', 'Sander');

INSERT INTO auto (brand, build_year, kilo_stand, model, plate, customer_id)
VALUES ('Audi', '2015', '90000', 'A8', '34-JKL-8', 1);
INSERT INTO auto (brand, build_year, kilo_stand, model, plate, customer_id)
VALUES ('VW', '2011', '115000', 'polo', '80-KZ-67', 1);
INSERT INTO auto (brand, build_year, kilo_stand, model, plate, customer_id)
VALUES ('Cherry', '2003', '253000', 'QQ', '23-dd-21', 2);
INSERT INTO auto (brand, build_year, kilo_stand, model, plate, customer_id)
VALUES ('VW', '2006', '283000', 'polo', '22-st-dd', 3);

