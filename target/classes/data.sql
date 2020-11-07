# TRUNCATE TABLE user;
# INSERT INTO user (id, user_name, last_name, password, email, mobile, active, roles) VALUES (1, 'ilias', 'elgris', 'admin', '@gmail.com', '0679893298', 1, 'ADMIN');
# INSERT INTO user (id, user_name, last_name, password, email, mobile, active, roles) VALUES (2, 'bart', 'elgris', 'user', '@gmail.com', '0679893298', 1, 'MONTEUR');
# INSERT INTO user (id, user_name, last_name, password, email, mobile, active, roles) VALUES (3, 'tom', 'elgris', 'user', '@gmail.com', '0679893298', 1, 'FRONTDESK');
# INSERT INTO user (id, user_name, last_name, password, email, mobile, active, roles) VALUES (4, 'Asare', 'elgris', 'user', '@gmail.com', '0679893298', 1, 'KASSIERE');
# create table if not exists persistent_logins (
#                                                  username varchar(100) not null,
#                                                  series varchar(64) primary key,
#                                                  token varchar(64) not null,
#                                                  last_used timestamp not null
# );

# delete from  users_roles;
# delete from  roles;
# delete from  users;
#
# TRUNCATE TABLE roles;
INSERT INTO roles (id, name) VALUES
(1, 'ADMIN'),
(2, 'MONTEUR'),
(3, 'FRONTDESK'),
(4, 'KASSIERE')
;
# TRUNCATE TABLE users;
INSERT INTO users (id, user_name, last_name, password, email, mobile, active) VALUES (1, 'ilias', 'elgris', 'admin', '@gmail.com', '0679893298', 1);
INSERT INTO users (id, user_name, last_name, password, email, mobile, active) VALUES (2, 'bart', 'elgris', 'user', '@gmail.com', '0679893298', 1);
INSERT INTO users (id, user_name, last_name, password, email, mobile, active) VALUES (3, 'tom', 'elgris', 'user', '@gmail.com', '0679893298', 1);
INSERT INTO users (id, user_name, last_name, password, email, mobile, active) VALUES (4, 'Asare', 'elgris', 'user', '@gmail.com', '0679893298', 1);

# TRUNCATE TABLE users_roles;
insert into users_roles(users_id, roles_id) values
(1,1),
(1,2),
(1,3),
(1,4)
;