/*
Navicat MySQL Data Transfer

Source Server         : BzmMysql本地
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-04-30 20:56:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `prams` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'qwq', 'qwq', 'qwq');
INSERT INTO `user` VALUES ('11', 'root', '123456', 'user:update');
INSERT INTO `user` VALUES ('12', 'bzm', 'bzm', 'user:add');
