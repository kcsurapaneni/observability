
-- Table `user`
CREATE TABLE `user` (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE
);

-- `user` Table data

INSERT INTO `user` (id, name) VALUES (1, 'KC');
INSERT INTO `user` (id, name) VALUES (2, 'VK');
INSERT INTO `user` (id, name) VALUES (3, 'RJ');


-- Table `user_comment`

CREATE TABLE `user_comment` (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    comment TEXT NOT NULL,
    user_id INT UNSIGNED NOT NULL,
    CONSTRAINT fk_uc_user_id FOREIGN KEY (user_id) REFERENCES `user` (`id`)
);

-- `user_comment` Table data

INSERT INTO `user_comment`(comment, user_id) VALUES ('Hello World!', 1);
INSERT INTO `user_comment`(comment, user_id) VALUES ('Welcome to Observability', 1);
INSERT INTO `user_comment`(comment, user_id) VALUES ('Distributed Systems', 1);
INSERT INTO `user_comment`(comment, user_id) VALUES ('Microservices', 2);
INSERT INTO `user_comment`(comment, user_id) VALUES ('OpenTelemetry', 2);
INSERT INTO `user_comment`(comment, user_id) VALUES ('Prometheus', 3);
