---- drop ----
DROP TABLE IF EXISTS `test_table`;
DROP TABLE IF EXISTS `articles`;
DROP TABLE IF EXISTS `shops`;
DROP TABLE IF EXISTS `users`;

---- create ----
CREATE TABLE `articles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `user_id` int NOT NULL,
  `shop_id` int,
  `body` varchar(500),
  `header_image` varchar(500),
  `is_deleted` boolean DEFAULT 0,
  `create_at` datetime,
  `update_at` datetime,
  `delete_at` datetime,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE `shops` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `station_id` int DEFAULT 0,
  `create_user` int NOT NULL DEFAULT 0,
  `is_deleted` boolean DEFAULT 0,
  `create_at` datetime,
  `delete_at` datetime,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `external_service_id` varchar(50) NOT NULL,
  `external_service_type` varchar(15) NOT NULL,
  `is_deleted` boolean DEFAULT 0,
  `create_at` datetime,
  `update_at` datetime,
  `delete_at` datetime,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

-- insert --
INSERT INTO `articles` VALUES
(1, 'test title 1', 1, 1, 'body', 'image', 0, null, null, null),
(2, 'test title 2', 2, 2, 'body', 'image', 0, null, null, null);

INSERT INTO `shops` VALUES
(1, 'ガスト', 0, 0, 0, null, null),
(2, 'バーミヤン', 0, 0, 0, null, null);

INSERT INTO `users` VALUES
(1, 'つじたてすと1', '', '', 0, null, null, null ),
(2, 'つじたてすと2', '', '', 0, null, null, null );
