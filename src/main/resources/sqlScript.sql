----- Create database from the application. -----
CREATE DATABASE IF NOT EXISTS jpasecuritydb;
 
USE jpasecuritydb;
 
----- User credentials table. -----
CREATE TABLE USERS (
    user_id INT(50) NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    password VARCHAR(200) NOT NULL,
    enabled boolean,
    PRIMARY KEY(user_id)
);
 
----- User roles/authorities table. -----
CREATE TABLE USERS_ROLES (
  user_role_id INT(50) NOT NULL,
  user_id INT(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  PRIMARY KEY (user_role_id),
  FOREIGN KEY (user_id) REFERENCES users (user_id)
)
 
----- Sample users and their respective roles. -----
INSERT INTO users (user_id, user_name, password, enabled) VALUES (1, 'user', '$2y$12$uiojtyao/btaYSQEyfwYAOZ2LUyFegRD12Pd5jZgTufzmW.biuAUO', true); //password: user
INSERT INTO users (user_id, user_name, password, enabled) VALUES (2, 'admin', '$2y$12$X7sb3o338Kcalj0mnIJQxeLx6jWuVWuD.TJqSx17phfZQIHMq8FEe', true);// password:admin
INSERT INTO users (user_id, user_name, password, enabled) VALUES (3, 'test', '$2y$12$DbmGHBEhEQaUZ5O5l/TghuaY/IqTDekMqsxCnVgJCa8B7ry.atUAO', false);// password:test
  
INSERT INTO users_roles (user_role_id, user_id, authority) VALUES (1, 1, 'ROLE_USER');
INSERT INTO users_roles (user_role_id, user_id, authority) VALUES (2, 2, 'ROLE_ADMIN');
INSERT INTO users_roles (user_role_id, user_id, authority) VALUES (3, 2, 'ROLE_USER');
 
