/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : dbservant

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-10-12 17:51:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `log_user_login`
-- ----------------------------
DROP TABLE IF EXISTS `log_user_login`;
CREATE TABLE `log_user_login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `valid` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_date` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `user_uid` varchar(255) DEFAULT NULL,
  `login_time` varchar(255) DEFAULT NULL,
  `login_ip` varchar(255) DEFAULT NULL,
  `login_env` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_user_login
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `valid` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_date` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `valid` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_date` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `valid` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_date` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `permission_uid` varchar(255) DEFAULT NULL,
  `role_uid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `valid` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_date` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, 'xiangyu', '1e4888fa42f4cc8d51f94a6ac01b0ef90d2a3999', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `valid` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_date` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `user_uid` varchar(255) DEFAULT NULL,
  `role_uid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_status`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_status`;
CREATE TABLE `sys_user_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `valid` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated_date` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `user_uid` varchar(255) DEFAULT NULL,
  `last_login_time` varchar(255) DEFAULT NULL,
  `last_login_ip` varchar(255) DEFAULT NULL,
  `last_login_type` varchar(255) DEFAULT NULL,
  `msg_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_status
-- ----------------------------
