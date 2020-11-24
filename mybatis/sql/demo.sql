/*
SQLyog Ultimate v8.32 
MySQL - 5.5.28 : Database - demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `demo`;

/*Table structure for table `t_commodity_info` */

DROP TABLE IF EXISTS `t_commodity_info`;

CREATE TABLE `t_commodity_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `good_name` varchar(100) NOT NULL,
  `create_time` date NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `amount` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_commodity_info` */

/*Table structure for table `t_order_info` */

DROP TABLE IF EXISTS `t_order_info`;

CREATE TABLE `t_order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` date NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `good_id` bigint(20) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `update_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_order_info` */

/*Table structure for table `t_user_info` */

DROP TABLE IF EXISTS `t_user_info`;

CREATE TABLE `t_user_info` (
  `acct_id` varchar(20) NOT NULL,
  `acct_name` varchar(100) NOT NULL,
  `nick_name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `create_time` date NOT NULL,
  `last_update_time` date DEFAULT NULL,
  `vip` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`acct_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user_info` */

insert  into `t_user_info`(`acct_id`,`acct_name`,`nick_name`,`password`,`create_time`,`last_update_time`,`vip`) values ('897238156','Yang','咩咩','123','0000-00-00',NULL,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
