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
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ä¸»é”®',
  `bookName` varchar(128) DEFAULT NULL COMMENT 'ä¹¦å',
  `author` varchar(128) DEFAULT NULL COMMENT 'ä½œè€…',
  `categoryId` int(11) DEFAULT NULL COMMENT 'åˆ†ç±»id',
  `publisher` varchar(128) DEFAULT NULL COMMENT 'å‡ºç‰ˆç¤¾',
  `price` double DEFAULT NULL COMMENT 'å”®ä»·',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_orders
-- ----------------------------
CREATE TABLE `system_book_orders` (
  `oid` varchar(32) NOT NULL COMMENT 'è®¢å•å·',
  `bid` int(11) DEFAULT NULL COMMENT 'å…³è”SYTEM_BOOK_INFOçš„ä¸»é”®',
  `count` double DEFAULT NULL COMMENT 'è®¢å•æ•°é‡',
  `curPrice` double DEFAULT NULL COMMENT 'å•ä»·',
  `date` datetime DEFAULT NULL COMMENT 'è®¢å•æ—¥æœŸæ—¶é—´',
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_user
-- ----------------------------
CREATE TABLE `system_book_user` (
  `userId` varchar(64) NOT NULL COMMENT '账户',
  `userPsw` varchar(64) NOT NULL COMMENT '密码',
  `userName` varchar(128) DEFAULT NULL COMMENT '姓名',
  `role` int(11) DEFAULT '1' COMMENT '角色',
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `system_book_category` VALUES ('5', '历史');
INSERT INTO `system_book_category` VALUES ('7', '小说');
INSERT INTO `system_book_category` VALUES ('6', '世界历史');
INSERT INTO `system_book_info` VALUES ('1', '聊斋', '蒲松龄', '7', '中国人民邮政', '4.36');
INSERT INTO `system_book_info` VALUES ('4', '欧洲古代史', '欧洲人', '6', '亚马逊', '55');
INSERT INTO `system_book_info` VALUES ('2', '三国演义', '罗贯中', '7', '清华大学出版社', '78.9');
INSERT INTO `system_book_info` VALUES ('3', '资治通鉴', '古人', '5', '华东师范出版社', '35');
INSERT INTO `system_book_info` VALUES ('5', '我的奋斗', '许洪', '7', '四川商务学院', '100');
INSERT INTO `system_book_user` VALUES ('admin', '123456', '系统管理员', '2');
INSERT INTO `system_book_user` VALUES ('zhangsan', '123', '张三', '1');
INSERT INTO `system_book_user` VALUES ('daishiqi', '123', 'd', '1');
INSERT INTO `system_book_user` VALUES ('aaa', 'asd', 'asd', '1');
INSERT INTO `system_book_user` VALUES ('xuhong', '123', '张三丰', '1');
INSERT INTO `system_book_user` VALUES ('make', '123', '马克', '1');
