# Spring-boot-Batch-Task-MYSQL<br/>

Using Spring Boot, Spring Batch, Task, MySql<br/>
JAVA 8<br/>

#### Pre require
Java 8<br/>
Maven<br/>

#### 
1)create database 
SpringBatchTask sy_noti sampletables

2) in sampletables database
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) DEFAULT NULL,
  `firstInputDt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '那么', 'test');
INSERT INTO `user` VALUES ('2', '2', '2ss');
INSERT INTO `user` VALUES ('3', 'ba', '3raggv');
INSERT INTO `user` VALUES ('4', 'd', 'd');
INSERT INTO `user` VALUES ('5', 'f', 'f');
INSERT INTO `user` VALUES ('6', 'b', 'b');
INSERT INTO `user` VALUES ('7', 'c', 'c');
INSERT INTO `user` VALUES ('8', 'h', 'h');
INSERT INTO `user` VALUES ('9', 'j', 'j');
INSERT INTO `user` VALUES ('10', 'k', 'k');
INSERT INTO `user` VALUES ('11', 'l', 'l');


3)in sy_noti database

-- ----------------------------
-- Table structure for noti
-- ----------------------------
DROP TABLE IF EXISTS `noti`;
CREATE TABLE `noti` (
  `id` int(11) NOT NULL,
  `firstInputDt` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


