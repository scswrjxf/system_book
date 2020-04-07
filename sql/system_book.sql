/*
MySQL Data Transfer
Source Host: localhost
Source Database: system_book
Target Host: localhost
Target Database: system_book
Date: 2019/11/11 14:52:18
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for system_book_category
-- ----------------------------
CREATE TABLE `system_book_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category` varchar(32) NOT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_info
-- ----------------------------
CREATE TABLE `system_book_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bookName` varchar(128) DEFAULT NULL COMMENT '书名',
  `author` varchar(128) DEFAULT NULL COMMENT '作者',
  `categoryId` int(11) DEFAULT NULL COMMENT '分类id',
  `publisher` varchar(128) DEFAULT NULL COMMENT '发行商',
  `price` double DEFAULT NULL COMMENT '售价',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_orders
-- ----------------------------
CREATE TABLE `system_book_orders` (
  `oid` varchar(32) NOT NULL COMMENT '订单编号',
  `bid` int(11) DEFAULT NULL COMMENT '书本编号',
  `count` double DEFAULT NULL COMMENT '购买数量',
  `curPrice` double DEFAULT NULL COMMENT '售价',
  `date` datetime DEFAULT NULL COMMENT '出售日期时间',
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_user
-- ----------------------------
CREATE TABLE `system_book_user` (
  `userId` varchar(64) NOT NULL COMMENT '账户',
  `userPsw` varchar(64) NOT NULL COMMENT '密码',
  `userName` varchar(128) DEFAULT NULL COMMENT '姓名',
  `role` int(11) DEFAULT '1' COMMENT '角色(1-普通用户 2-管理员)',
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------

