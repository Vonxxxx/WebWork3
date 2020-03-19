/*
Navicat MySQL Data Transfer

Source Server         : Fxx
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-03-19 22:13:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(50) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('1', 'Restful API homework', '2020-03-19 17:01:14');
INSERT INTO `task` VALUES ('2', 'Restful API homework', '2020-03-19 17:01:24');
INSERT INTO `task` VALUES ('3', 'Restful API homework', '2020-03-19 18:46:41');
SET FOREIGN_KEY_CHECKS=1;
