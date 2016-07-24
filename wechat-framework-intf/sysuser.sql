/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.42-log : Database - itfvck_weixin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`itfvck_weixin` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `itfvck_weixin`;

/*Table structure for table `sys_r_role_button` */

DROP TABLE IF EXISTS `sys_r_role_button`;

CREATE TABLE `sys_r_role_button` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  `buttonid` int(11) DEFAULT NULL COMMENT '按钮id',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色按钮关联表';

/*Data for the table `sys_r_role_button` */

/*Table structure for table `sys_r_role_menu` */

DROP TABLE IF EXISTS `sys_r_role_menu`;

CREATE TABLE `sys_r_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单id',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

/*Data for the table `sys_r_role_menu` */

/*Table structure for table `sys_r_user_role` */

DROP TABLE IF EXISTS `sys_r_user_role`;

CREATE TABLE `sys_r_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

/*Data for the table `sys_r_user_role` */

/*Table structure for table `sysbutton` */

DROP TABLE IF EXISTS `sysbutton`;

CREATE TABLE `sysbutton` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuid` int(11) DEFAULT NULL COMMENT '所属菜单id',
  `name` varchar(16) DEFAULT NULL COMMENT '按钮名称',
  `url` varchar(64) DEFAULT NULL COMMENT '按钮url',
  `params` varchar(64) DEFAULT NULL COMMENT '按钮url所带参数，填写形式：name=123&password=asdas&a=sdf',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `note` varchar(128) DEFAULT NULL COMMENT '注释、描述',
  `orderno` int(11) DEFAULT '0' COMMENT '排序',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='菜单下的按钮';

/*Data for the table `sysbutton` */

/*Table structure for table `sysdepartment` */

DROP TABLE IF EXISTS `sysdepartment`;

CREATE TABLE `sysdepartment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `pid` int(11) DEFAULT NULL COMMENT '上级部门id',
  `organid` int(11) DEFAULT NULL COMMENT '所属机构id',
  `depname` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `depcode` varchar(32) DEFAULT NULL COMMENT '部门代码',
  `principal` int(11) DEFAULT NULL COMMENT '负责人id',
  `telephone` varchar(16) DEFAULT NULL COMMENT '机构电话',
  `fox` varchar(16) DEFAULT NULL COMMENT '传真',
  `address` varchar(64) DEFAULT NULL COMMENT '地址',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `note` varchar(128) DEFAULT NULL COMMENT '注释、描述',
  `orderno` int(11) DEFAULT '0' COMMENT '排序',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='机构部门';

/*Data for the table `sysdepartment` */

/*Table structure for table `sysdictree` */

DROP TABLE IF EXISTS `sysdictree`;

CREATE TABLE `sysdictree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL COMMENT '数据类型名称',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `note` varchar(128) DEFAULT NULL COMMENT '注释、描述',
  `orderno` int(11) DEFAULT '0' COMMENT '排序',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='数据字典项';

/*Data for the table `sysdictree` */

/*Table structure for table `sysdictreedata` */

DROP TABLE IF EXISTS `sysdictreedata`;

CREATE TABLE `sysdictreedata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '父级节点',
  `treeid` int(11) DEFAULT NULL COMMENT '数据分类id',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `note` varchar(128) DEFAULT NULL COMMENT '注释、描述',
  `orderno` int(11) DEFAULT '0' COMMENT '排序',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='数据字典';

/*Data for the table `sysdictreedata` */

/*Table structure for table `sysmenu` */

DROP TABLE IF EXISTS `sysmenu`;

CREATE TABLE `sysmenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '上级菜单id',
  `name` varchar(16) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(64) DEFAULT NULL COMMENT '菜单url',
  `params` varchar(64) DEFAULT NULL COMMENT '菜单url所带参数，填写形式：name=123&password=asdas&a=sdf',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `note` varchar(128) DEFAULT NULL COMMENT '注释、描述',
  `orderno` int(11) DEFAULT '0' COMMENT '排序',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统菜单';

/*Data for the table `sysmenu` */

/*Table structure for table `sysorgan` */

DROP TABLE IF EXISTS `sysorgan`;

CREATE TABLE `sysorgan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组织机构id',
  `orgname` varchar(32) DEFAULT NULL COMMENT '组织机构名称',
  `orgcode` varchar(16) DEFAULT NULL COMMENT '组织机构代码',
  `principal` int(11) DEFAULT NULL COMMENT '负责人id',
  `telephone` varchar(16) DEFAULT NULL COMMENT '机构电话',
  `fox` varchar(16) DEFAULT NULL COMMENT '传真',
  `address` varchar(64) DEFAULT NULL COMMENT '地址',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `note` varchar(128) DEFAULT NULL COMMENT '注释、描述',
  `orderno` int(11) DEFAULT '0' COMMENT '排序',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='组织机构';

/*Data for the table `sysorgan` */

/*Table structure for table `sysrole` */

DROP TABLE IF EXISTS `sysrole`;

CREATE TABLE `sysrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(16) DEFAULT NULL COMMENT '角色名称',
  `roletype` int(11) DEFAULT NULL COMMENT '角色类型',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `note` varchar(128) DEFAULT NULL COMMENT '注释、描述',
  `orderno` int(11) DEFAULT '0' COMMENT '排序',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统角色';

/*Data for the table `sysrole` */

/*Table structure for table `sysuser` */

DROP TABLE IF EXISTS `sysuser`;

CREATE TABLE `sysuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) DEFAULT NULL COMMENT '用户名',
  `loginid` varchar(16) DEFAULT NULL COMMENT '登录id',
  `password` varbinary(16) DEFAULT NULL COMMENT '登录密码',
  `mobilephone` varchar(16) DEFAULT NULL COMMENT '手机',
  `email` varchar(16) DEFAULT NULL COMMENT '邮箱',
  `usertype` int(11) DEFAULT NULL COMMENT '用户类型',
  `orgid` int(11) DEFAULT NULL COMMENT '所属机构id',
  `orgname` varchar(32) DEFAULT NULL COMMENT '所属机构名称',
  `deptid` int(11) DEFAULT NULL COMMENT '所属部门id',
  `depname` varchar(32) DEFAULT NULL COMMENT '所属部门名称',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `note` varchar(128) DEFAULT NULL COMMENT '注释、描述',
  `orderno` int(11) DEFAULT '0' COMMENT '排序',
  `createUserId` int(11) DEFAULT NULL COMMENT '记录创建人',
  `createTime` datetime DEFAULT NULL COMMENT '记录创建时间',
  `updateUserId` int(11) DEFAULT NULL COMMENT '记录修改人',
  `updateTime` datetime DEFAULT NULL COMMENT '记录修改时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统用户';

/*Data for the table `sysuser` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
