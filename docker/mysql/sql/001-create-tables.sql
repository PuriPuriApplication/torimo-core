---- drop -----

DROP TABLE IF EXISTS `article_categories`;
DROP TABLE IF EXISTS `article_likes`;
DROP TABLE IF EXISTS `articles`;
DROP TABLE IF EXISTS `categories`;
DROP TABLE IF EXISTS `follow_users`;
DROP TABLE IF EXISTS `shops`;
DROP TABLE IF EXISTS `users`;


---- create ---
CREATE TABLE `article_categories` (
  `article_id` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`article_id`, `category_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO article_categories VALUES ('1', '1');


CREATE TABLE `article_likes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `article_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO article_likes VALUES ('1', '1', '1');


CREATE TABLE `articles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `user_id` int NOT NULL,
  `shop_id` int,
  `body` text,
  `status` varchar(16) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
articles
(`title`,
 `user_id`,
 `shop_id`,
 `body`,
 `status`,
 `create_at`)
VALUES
('test_title', '1', '1', 'このお店おいしい！！', 'publish', now());


CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `create_user` int NOT NULL DEFAULT 1,
  `is_deleted` boolean DEFAULT 0,
  `create_at` datetime NOT NULL,
  `delete_at` datetime,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
categories
(`name`,
 `create_user`,
 `create_at`)
VALUES
('test_tag', '1', now());


CREATE TABLE `follow_users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `from` int NOT NULL,
  `to` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO follow_users VALUES ('1', '1', '2');


CREATE TABLE `shops` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `station_id` int DEFAULT 0,
  `create_user` int NOT NULL DEFAULT 1,
  `is_deleted` boolean DEFAULT 0,
  `create_at` datetime NOT NULL,
  `delete_at` datetime,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
shops
(`name`,
 `create_user`,
 `create_at`)
VALUES
('test_shop', '1', now());


CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `external_service_id` varchar(50) NOT NULL,
  `external_service_type` varchar(16) NOT NULL,
  `is_deleted` boolean DEFAULT 0,
  `create_at` datetime NOT NULL,
  `update_at` datetime,
  `delete_at` datetime,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO
users
(`name`,
 `external_service_id`,
 `external_service_type`,
 `create_at`)
VALUES
('test_user1', '@test_user1', 'twitter', now()),
('test_user2', '@test_user2', 'twitter', now());
