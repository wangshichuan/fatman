/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50533
Source Host           : localhost:3306
Source Database       : food

Target Server Type    : MYSQL
Target Server Version : 50533
File Encoding         : 65001

Date: 2016-05-03 15:32:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('5', '李灿', '123', '超级管理员');
INSERT INTO `admin` VALUES ('6', '易瑾', '123', '普通管理员');
INSERT INTO `admin` VALUES ('7', '代玉梅', '123', '普通管理员');
INSERT INTO `admin` VALUES ('8', '徐兰香', '123', '普通管理员');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `describes` varchar(50) DEFAULT NULL,
  `picUrl` varchar(200) DEFAULT NULL,
  `menuname` varchar(50) DEFAULT NULL,
  `typename` varchar(20) DEFAULT NULL,
  `chengben` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '13', '宅男套餐', 'upload/7.jpg', '飘儿白肉片盖饭', '盖饭', null);
INSERT INTO `menu` VALUES ('2', '12', '特色菜', 'images/红烧肉盖饭.jpg', '红烧肉盖饭', '盖饭', null);
INSERT INTO `menu` VALUES ('3', '12', '家常菜', 'images/回锅肉盖饭.jpg', '回锅肉盖饭', '盖饭', null);
INSERT INTO `menu` VALUES ('4', '12', '拿手菜', 'images/鸡杂盖饭.jpg', '鸡杂盖饭', '盖饭', null);
INSERT INTO `menu` VALUES ('5', '12', '特色菜', 'images/尖椒肉盖饭.jpg', '尖椒肉盖饭', '盖饭', null);
INSERT INTO `menu` VALUES ('6', '12', '特色菜', 'images/辣子鸡盖饭.jpg', '辣子鸡盖饭', '盖饭', null);
INSERT INTO `menu` VALUES ('7', '9', '拿手菜', 'images/腊肉炒饭.jpg', '腊肉炒饭', '炒饭', null);
INSERT INTO `menu` VALUES ('8', '8', '特色菜', 'images/蛋炒饭.jpg', '蛋炒饭', '炒饭', null);
INSERT INTO `menu` VALUES ('9', '9', '招牌菜', 'images/牛肉炒饭.jpg', '牛肉炒饭', '炒饭', null);
INSERT INTO `menu` VALUES ('10', '9', '家常菜', 'images/泡椒肉丝炒饭.jpg', '泡椒肉丝炒饭', '炒饭', null);
INSERT INTO `menu` VALUES ('11', '9', '家常菜', 'images/鱼香肉丝炒饭.jpg', '鱼香肉丝炒饭', '炒饭', null);
INSERT INTO `menu` VALUES ('12', '10', '家常菜', 'images/泡椒猪肝炒饭.jpg', '泡椒猪肝炒饭', '炒饭', null);
INSERT INTO `menu` VALUES ('13', '15', '甜味点心', 'images/甜品1.jpg', '甜品1', '甜品', null);
INSERT INTO `menu` VALUES ('14', '10', '甜味点心', 'images/甜品2.jpg', '甜品2', '甜品', null);
INSERT INTO `menu` VALUES ('15', '10', '甜味点心', 'images/甜品3.jpg', '甜品3', '甜品', null);
INSERT INTO `menu` VALUES ('17', '12', '甜味点心', 'images/甜品5.jpg', '甜品5', '甜品', null);
INSERT INTO `menu` VALUES ('18', '8', '甜味点心', 'images/甜品6.jpg', '甜品6', '甜品', null);
INSERT INTO `menu` VALUES ('19', '5', '素食', 'images/面食1.jpg', '面食1', '面食', null);
INSERT INTO `menu` VALUES ('20', '6', '素食', 'images/面食2.jpg', '面食2', '面食', null);
INSERT INTO `menu` VALUES ('21', '8', '素食', 'images/面食3.jpg', '面食3', '面食', null);
INSERT INTO `menu` VALUES ('22', '8', '素食', 'images/面食4.jpg', '面食4', '面食', null);
INSERT INTO `menu` VALUES ('23', '5', '素食', 'images/面食5.jpg', '面食5', '面食', null);
INSERT INTO `menu` VALUES ('24', '5', '素食', 'images/面食6.jpg', '面食6', '面食', null);
INSERT INTO `menu` VALUES ('25', '3', '清凉一下', 'images/饮料6.jpg', '饮料6', '饮料', null);
INSERT INTO `menu` VALUES ('26', '4', '清凉一下', 'images/饮料5.jpg', '饮料5', '饮料', null);
INSERT INTO `menu` VALUES ('27', '6', '清凉一下', 'images/饮料4.jpg', '饮料4', '饮料', null);
INSERT INTO `menu` VALUES ('28', '4', '清凉一下', 'images/饮料3.jpg', '饮料3', '饮料', null);
INSERT INTO `menu` VALUES ('29', '5', '清凉一下', 'images/饮料2.jpg', '饮料2', '饮料', null);
INSERT INTO `menu` VALUES ('30', '4', '清凉一下', 'images/饮料1.jpg', '饮料1', '饮料', null);
INSERT INTO `menu` VALUES ('31', '8', '炖汤', 'images/汤2.jpg', '汤2', '汤', null);
INSERT INTO `menu` VALUES ('32', '5', '炖汤', 'images/汤1.jpg', '汤1', '汤', null);
INSERT INTO `menu` VALUES ('33', '8', '炖汤', 'images/汤3.jpg', '汤3', '汤', null);
INSERT INTO `menu` VALUES ('34', '10', '炖汤', 'images/汤4.jpg', '汤4', '汤', null);
INSERT INTO `menu` VALUES ('35', '10', '炖汤', 'images/汤5.jpg', '汤5', '汤', null);
INSERT INTO `menu` VALUES ('36', '5', '炖汤', 'images/汤6.jpg', '汤6', '汤', null);

-- ----------------------------
-- Table structure for `ordertable`
-- ----------------------------
DROP TABLE IF EXISTS `ordertable`;
CREATE TABLE `ordertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `menuid` int(11) DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `times` varchar(50) DEFAULT NULL,
  `orderaddress` varchar(200) DEFAULT NULL,
  `orderusername` varchar(20) DEFAULT NULL,
  `orderphone` varchar(20) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `ordernumber` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user` (`userid`),
  KEY `menu2` (`menuid`),
  CONSTRAINT `ordertable_ibfk_1` FOREIGN KEY (`menuid`) REFERENCES `menu` (`id`),
  CONSTRAINT `ordertable_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=960533 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 3072 kB; (`menuid`) REFER `food/menu`(`id`); (`';

-- ----------------------------
-- Records of ordertable
-- ----------------------------
INSERT INTO `ordertable` VALUES ('30390', '17', null, '5', '2015/05/03 00:27:41', '1-210', '李灿', '18523321615', '已完成', null);
INSERT INTO `ordertable` VALUES ('58158', '3', null, '3', '2015/05/01 22:08:55', '6舍', '用户3', '9090900', '已下单', null);
INSERT INTO `ordertable` VALUES ('217596', '3', null, '16', '2015/05/01 21:32:46', '6舍', '222', '9090900', '已完成', null);
INSERT INTO `ordertable` VALUES ('236143', '3', null, '51', '2015/04/22 09:44:21', '210寝室', '用户3', '18523321615', '已完成', null);
INSERT INTO `ordertable` VALUES ('265114', '3', null, '6', '2015/04/22 10:17:13', '6舍', '用户3', '9090900', '问题订单', null);
INSERT INTO `ordertable` VALUES ('269407', '3', null, '5', '2015/05/01 21:44:46', '6舍', '444', '9090900', '已下单', null);
INSERT INTO `ordertable` VALUES ('313342', '3', null, '10', '2015/05/01 23:52:49', '6舍', '用户3', '9090900', '已下单', null);
INSERT INTO `ordertable` VALUES ('398501', '3', null, '6', '2015/05/01 22:05:04', '6舍', '用户3', '9090900', '已下单', null);
INSERT INTO `ordertable` VALUES ('648449', '15', null, '5', '2015/04/22 10:22:37', '大坪', 'daidai', '15923348386', '已完成', null);
INSERT INTO `ordertable` VALUES ('729621', '3', null, '9', '2015/05/08 01:32:28', '6舍', '用户3', '9090900', '已下单', null);
INSERT INTO `ordertable` VALUES ('861007', '3', null, '19', '2015/05/01 21:38:19', '6舍', '333', '9090900', '已下单', null);
INSERT INTO `ordertable` VALUES ('947617', '3', null, '6', '2015/05/01 22:06:12', '6舍', '用户3', '9090900', '已下单', null);
INSERT INTO `ordertable` VALUES ('955705', '3', null, '4', '2015/05/01 22:06:55', '6舍', '用户3', '9090900', '已下单', null);
INSERT INTO `ordertable` VALUES ('960532', '3', null, '8', '2015/05/01 21:47:16', '6舍', '555', '9090900', '已完成', null);

-- ----------------------------
-- Table structure for `order_menu`
-- ----------------------------
DROP TABLE IF EXISTS `order_menu`;
CREATE TABLE `order_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `orderid` int(10) DEFAULT NULL,
  `menuid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderid` (`orderid`),
  KEY `menu_id` (`menuid`),
  CONSTRAINT `menu_id` FOREIGN KEY (`menuid`) REFERENCES `menu` (`id`),
  CONSTRAINT `orderid` FOREIGN KEY (`orderid`) REFERENCES `ordertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_menu
-- ----------------------------
INSERT INTO `order_menu` VALUES ('4', '236143', '19');
INSERT INTO `order_menu` VALUES ('5', '236143', '2');
INSERT INTO `order_menu` VALUES ('6', '265114', '20');
INSERT INTO `order_menu` VALUES ('7', '648449', '19');
INSERT INTO `order_menu` VALUES ('8', '217596', '20');
INSERT INTO `order_menu` VALUES ('9', '217596', '15');
INSERT INTO `order_menu` VALUES ('10', '861007', '20');
INSERT INTO `order_menu` VALUES ('11', '861007', '1');
INSERT INTO `order_menu` VALUES ('12', '269407', '32');
INSERT INTO `order_menu` VALUES ('13', '960532', '33');
INSERT INTO `order_menu` VALUES ('14', '398501', '20');
INSERT INTO `order_menu` VALUES ('15', '947617', '27');
INSERT INTO `order_menu` VALUES ('16', '955705', '28');
INSERT INTO `order_menu` VALUES ('17', '58158', '25');
INSERT INTO `order_menu` VALUES ('18', '313342', '12');
INSERT INTO `order_menu` VALUES ('19', '30390', '24');
INSERT INTO `order_menu` VALUES ('20', '729621', '7');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '用户1', '1', '1', '1', '1', '1');
INSERT INTO `user` VALUES ('3', '用户3', '9090900', '123456789', '123@qq.com', '000', '6舍');
INSERT INTO `user` VALUES ('4', '用户4', '911', '911000', '911@qq.com', '000', '南桐镇南门村');
INSERT INTO `user` VALUES ('5', '用户5', '666', '666666', '666@qq.com', '000', '支路动力村');
INSERT INTO `user` VALUES ('6', '用户6', '888', '888888', '888@qq.com', '000', '万盛田家炳中学');
INSERT INTO `user` VALUES ('14', 'a2011214110', '13800000000', '594746169', 'lican@zhubajie.com', '123456', '208寝室');
INSERT INTO `user` VALUES ('15', 'daidai', '15923348386', '582280299', '582280299@qq.com', '123', '大坪');
INSERT INTO `user` VALUES ('16', 'dai123', '15922590239', '582280288', '582280288@qq.com', '000000', '江北');
INSERT INTO `user` VALUES ('17', 'lican123', '18523321615', '594746169', '594746169@qq.com', '123456', '1-210');
