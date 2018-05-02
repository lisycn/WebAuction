DROP DATABASE IF EXISTS `auction`;
CREATE DATABASE `auction` DEFAULT CHARSET=utf8 COLLATE utf8_general_ci;

USE `auction`;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bid
-- ----------------------------
DROP TABLE IF EXISTS `bid`;
CREATE TABLE `bid` (
  `id` INT(4) NOT NULL AUTO_INCREMENT,
  `goods_id` INT(4) NOT NULL,
  `buyer_id` INT(4) NOT NULL,
  `bid_time` DATETIME NOT NULL,
  `bid_price` FLOAT NOT NULL,
  `bid_status` INT(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `buyer_id` (`buyer_id`),
  KEY `goods_id` (`goods_id`,`bid_status`)
) ENGINE=INNODB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` INT(4) NOT NULL AUTO_INCREMENT,
  `goods_name` VARCHAR(50) NOT NULL,
  `goods_price` FLOAT NOT NULL,
  `goods_pic` VARCHAR(200) DEFAULT NULL,
  `goods_desc` MEDIUMTEXT,
  `seller_id` INT(4) NOT NULL,
  `buyer_id` INT(4) NOT NULL,
  `goods_status` INT(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `buyer_id` (`buyer_id`, `goods_status`),
  KEY `seller_id` (`seller_id`)
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` INT(4) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(36) NOT NULL,
  `password` VARCHAR(36) NOT NULL,
  `telephone` VARCHAR(16) NOT NULL,
  `address` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE,
  UNIQUE KEY `telephone` (`telephone`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

