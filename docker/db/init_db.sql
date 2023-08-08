CREATE TABLE `user` (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE
);

INSERT INTO `user` (id, name) VALUES (1, 'KC');
INSERT INTO `user` (id, name) VALUES (2, 'VK');
INSERT INTO `user` (id, name) VALUES (3, 'RJ');