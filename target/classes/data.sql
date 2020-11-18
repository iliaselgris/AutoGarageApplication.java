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



INSERT INTO appointment(examination, appointment2, price) VALUES ('ja','ja',45);
INSERT INTO appointment(examination, appointment2, price) VALUES ('ja','nee',45);
INSERT INTO appointment(examination, appointment2, price) VALUES ('ja','ja',45);
INSERT INTO appointment(examination, appointment2, price) VALUES ('ja','nee',45);

INSERT INTO customer(email, last_name, mobile, name,appointment_id)
VALUES ('Mark@gmail.com', 'de man', '0612343455', 'Mark',1);
INSERT INTO customer(email, last_name, mobile, name,appointment_id)
VALUES ('blabla@gmail.com', 'de kerel', '0612343455', 'blabla',2);
INSERT INTO customer(email, last_name, mobile, name,appointment_id)
VALUES ('blue@gmail.com', 'de vrouw', '0612343455', 'Blue',3);
INSERT INTO customer(email, last_name, mobile, name,appointment_id)
VALUES ('Sander@gmail.com', 'de sander', '0612343455', 'Sander',4);

INSERT INTO auto (brand, build_year, kilo_stand, model, plate, customer_id)
VALUES ('Audi', '2015', '90000', 'A8', '34-JKL-8', 1);
INSERT INTO auto (brand, build_year, kilo_stand, model, plate, customer_id)
VALUES ('VW', '2011', '115000', 'polo', '80-KZ-67', 1);
INSERT INTO auto (brand, build_year, kilo_stand, model, plate, customer_id)
VALUES ('Cherry', '2003', '253000', 'QQ', '23-dd-21', 2);
INSERT INTO auto (brand, build_year, kilo_stand, model, plate, customer_id)
VALUES ('VW', '2006', '283000', 'polo', '22-st-dd', 3);

INSERT INTO reparings(name, reparing_Price) VALUES ('band vervangen',15);
INSERT INTO reparings(name, reparing_Price) VALUES ('voorruit vervangen',25);
INSERT INTO reparings(name, reparing_Price) VALUES ('linkerspiegel vervangen',5);
INSERT INTO reparings(name, reparing_Price)VALUES ('rechterspiegel vervangen',5);
INSERT INTO reparings(name, reparing_Price)VALUES ('remschijf vervangen',18);
INSERT INTO reparings(name, reparing_Price)VALUES ('remblok vervangen',5);
INSERT INTO reparings(name, reparing_Price)VALUES ('accu vervangen',8);
INSERT INTO reparings(name, reparing_Price)VALUES ('ventilator vervangen',45);
INSERT INTO reparings(name, reparing_Price)VALUES ('schokdemper vervangen',38);
INSERT INTO reparings(name, reparing_Price)VALUES ('bougie vervangen',5);


INSERT INTO parts(name, price,reparings_id) VALUES ('band',55,1);
INSERT INTO parts(name, price,reparings_id) VALUES ('voorruit',100,2);
INSERT INTO parts(name, price,reparings_id) VALUES ('linkerspiegel',12,3);
INSERT INTO parts(name, price,reparings_id) VALUES ('rechterspiegel',12,4);
INSERT INTO parts(name, price,reparings_id) VALUES ('remschijf',40,5);
INSERT INTO parts(name, price,reparings_id) VALUES ('remblok',8.50,6);
INSERT INTO parts(name, price,reparings_id) VALUES ('accu',95,7);
INSERT INTO parts(name, price,reparings_id) VALUES ('ventilator',115,8);
INSERT INTO parts(name, price,reparings_id) VALUES ('schokdemper',52,9);
INSERT INTO parts(name, price,reparings_id) VALUES ('bougie',10,10);