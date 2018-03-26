/*
SQLyog Community v12.5.1 (64 bit)
MySQL - 5.7.21-log : Database - final_year_project
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`final_year_project` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `final_year_project`;

/*Table structure for table `cron` */

DROP TABLE IF EXISTS `cron`;

CREATE TABLE `cron` (
  `cron_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cron` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`cron_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `cron` */

insert  into `cron`(`cron_id`,`cron`) values 
(1,'0/5 * * * * ?');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=FIXED;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(11);

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `module` */

insert  into `module`(`mid`,`mname`) values 
(1,'add'),
(2,'delete'),
(3,'query'),
(4,'update');

/*Table structure for table `module_role` */

DROP TABLE IF EXISTS `module_role`;

CREATE TABLE `module_role` (
  `rid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  KEY `rid` (`rid`),
  KEY `mid` (`mid`),
  CONSTRAINT `mid` FOREIGN KEY (`mid`) REFERENCES `module` (`mid`),
  CONSTRAINT `rid` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `module_role` */

insert  into `module_role`(`rid`,`mid`) values 
(1,1),
(1,2),
(1,3),
(1,4),
(2,1),
(2,3);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`rid`,`rname`) values 
(1,'admin'),
(2,'customer');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `program` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `year_of_program` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=190 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `student` */

insert  into `student`(`id`,`email`,`name`,`program`,`status`,`year_of_program`) values 
(2,'b@b.com','b','computing','ACTIVE',2),
(3,'c@c.com','c','computing','ACTIVE',3),
(4,'d@d.com','d','computing','ACTIVE',1),
(5,'e@e.com','e','computing','ACTIVE',2),
(6,'f@f.com','f','computing','ACTIVE',3),
(7,'g@g.com','g','computing','ACTIVE',1),
(8,'h@h.com','h','computing','ACTIVE',2),
(9,'i@i.com','i','computing','ACTIVE',3),
(10,'j@j.com','j','computing','ACTIVE',1),
(12,'1.0','1.0',NULL,'ACTIVE',NULL),
(13,'2.0','2.0',NULL,'ACTIVE',NULL),
(14,'3.0','3.0',NULL,'ACTIVE',NULL),
(15,'4.0','4.0',NULL,'ACTIVE',NULL),
(16,'5.0','5.0',NULL,'ACTIVE',NULL),
(17,'6.0','6.0',NULL,'ACTIVE',NULL),
(18,'7.0','7.0',NULL,'ACTIVE',NULL),
(19,'8.0','8.0',NULL,'ACTIVE',NULL),
(20,'9.0','9.0',NULL,'ACTIVE',NULL),
(21,'10.0','10.0',NULL,'ACTIVE',NULL),
(22,'11.0','11.0',NULL,'ACTIVE',NULL),
(23,'12.0','12.0',NULL,'ACTIVE',NULL),
(24,'13.0','13.0',NULL,'ACTIVE',NULL),
(25,'14.0','14.0',NULL,'ACTIVE',NULL),
(26,'15.0','15.0',NULL,'ACTIVE',NULL),
(27,'16.0','16.0',NULL,'ACTIVE',NULL),
(28,'17.0','17.0',NULL,'ACTIVE',NULL),
(29,'18.0','18.0',NULL,'ACTIVE',NULL),
(30,'19.0','19.0',NULL,'ACTIVE',NULL),
(31,'20.0','20.0',NULL,'ACTIVE',NULL),
(32,'21.0','21.0',NULL,'ACTIVE',NULL),
(33,'22.0','22.0',NULL,'ACTIVE',NULL),
(34,'23.0','23.0',NULL,'ACTIVE',NULL),
(35,'24.0','24.0',NULL,'ACTIVE',NULL),
(36,'25.0','25.0',NULL,'ACTIVE',NULL),
(37,'26.0','26.0',NULL,'ACTIVE',NULL),
(38,'27.0','27.0',NULL,'ACTIVE',NULL),
(39,'28.0','28.0',NULL,'ACTIVE',NULL),
(40,'29.0','29.0',NULL,'ACTIVE',NULL),
(41,'30.0','30.0',NULL,'ACTIVE',NULL),
(42,'31.0','31.0',NULL,'ACTIVE',NULL),
(43,'32.0','32.0',NULL,'ACTIVE',NULL),
(44,'33.0','33.0',NULL,'ACTIVE',NULL),
(45,'34.0','34.0',NULL,'ACTIVE',NULL),
(46,'35.0','35.0',NULL,'ACTIVE',NULL),
(47,'36.0','36.0',NULL,'ACTIVE',NULL),
(48,'37.0','37.0',NULL,'ACTIVE',NULL),
(49,'38.0','38.0',NULL,'ACTIVE',NULL),
(50,'39.0','39.0',NULL,'ACTIVE',NULL),
(51,'40.0','40.0',NULL,'ACTIVE',NULL),
(52,'41.0','41.0',NULL,'ACTIVE',NULL),
(53,'42.0','42.0',NULL,'ACTIVE',NULL),
(54,'43.0','43.0',NULL,'ACTIVE',NULL),
(55,'44.0','44.0',NULL,'ACTIVE',NULL),
(56,'45.0','45.0',NULL,'ACTIVE',NULL),
(57,'46.0','46.0',NULL,'ACTIVE',NULL),
(58,'47.0','47.0',NULL,'ACTIVE',NULL),
(59,'48.0','48.0',NULL,'ACTIVE',NULL),
(60,'49.0','49.0',NULL,'ACTIVE',NULL),
(61,'50.0','50.0',NULL,'ACTIVE',NULL),
(62,'51.0','51.0',NULL,'ACTIVE',NULL),
(63,'52.0','52.0',NULL,'ACTIVE',NULL),
(64,'53.0','53.0',NULL,'ACTIVE',NULL),
(65,'54.0','54.0',NULL,'ACTIVE',NULL),
(66,'55.0','55.0',NULL,'ACTIVE',NULL),
(67,'56.0','56.0',NULL,'ACTIVE',NULL),
(68,'57.0','57.0',NULL,'ACTIVE',NULL),
(69,'58.0','58.0',NULL,'ACTIVE',NULL),
(70,'59.0','59.0',NULL,'ACTIVE',NULL),
(71,'60.0','60.0',NULL,'ACTIVE',NULL),
(72,'61.0','61.0',NULL,'ACTIVE',NULL),
(73,'62.0','62.0',NULL,'ACTIVE',NULL),
(74,'63.0','63.0',NULL,'ACTIVE',NULL),
(75,'64.0','64.0',NULL,'ACTIVE',NULL),
(76,'65.0','65.0',NULL,'ACTIVE',NULL),
(77,'66.0','66.0',NULL,'ACTIVE',NULL),
(78,'67.0','67.0',NULL,'ACTIVE',NULL),
(79,'68.0','68.0',NULL,'ACTIVE',NULL),
(80,'69.0','69.0',NULL,'ACTIVE',NULL),
(81,'70.0','70.0',NULL,'ACTIVE',NULL),
(82,'71.0','71.0',NULL,'ACTIVE',NULL),
(83,'72.0','72.0',NULL,'ACTIVE',NULL),
(84,'73.0','73.0',NULL,'ACTIVE',NULL),
(85,'74.0','74.0',NULL,'ACTIVE',NULL),
(86,'75.0','75.0',NULL,'ACTIVE',NULL),
(87,'76.0','76.0',NULL,'ACTIVE',NULL),
(88,'77.0','77.0',NULL,'ACTIVE',NULL),
(89,'78.0','78.0',NULL,'ACTIVE',NULL),
(90,'79.0','79.0',NULL,'ACTIVE',NULL),
(91,'80.0','80.0',NULL,'ACTIVE',NULL),
(92,'81.0','81.0',NULL,'ACTIVE',NULL),
(93,'82.0','82.0',NULL,'ACTIVE',NULL),
(94,'83.0','83.0',NULL,'ACTIVE',NULL),
(95,'84.0','84.0',NULL,'ACTIVE',NULL),
(96,'85.0','85.0',NULL,'ACTIVE',NULL),
(97,'86.0','86.0',NULL,'ACTIVE',NULL),
(98,'87.0','87.0',NULL,'ACTIVE',NULL),
(99,'88.0','88.0',NULL,'ACTIVE',NULL),
(100,'89.0','89.0',NULL,'ACTIVE',NULL),
(101,'1','1',NULL,'ACTIVE',NULL),
(102,'2','2',NULL,'ACTIVE',NULL),
(103,'3','3',NULL,'ACTIVE',NULL),
(104,'4','4',NULL,'ACTIVE',NULL),
(105,'5','5',NULL,'ACTIVE',NULL),
(106,'6','6',NULL,'ACTIVE',NULL),
(107,'7','7',NULL,'ACTIVE',NULL),
(108,'8','8',NULL,'ACTIVE',NULL),
(109,'9','9',NULL,'ACTIVE',NULL),
(110,'10','10',NULL,'ACTIVE',NULL),
(111,'11','11',NULL,'ACTIVE',NULL),
(112,'12','12',NULL,'ACTIVE',NULL),
(113,'13','13',NULL,'ACTIVE',NULL),
(114,'14','14',NULL,'ACTIVE',NULL),
(115,'15','15',NULL,'ACTIVE',NULL),
(116,'16','16',NULL,'ACTIVE',NULL),
(117,'17','17',NULL,'ACTIVE',NULL),
(118,'18','18',NULL,'ACTIVE',NULL),
(119,'19','19',NULL,'ACTIVE',NULL),
(120,'20','20',NULL,'ACTIVE',NULL),
(121,'21','21',NULL,'ACTIVE',NULL),
(122,'22','22',NULL,'ACTIVE',NULL),
(123,'23','23',NULL,'ACTIVE',NULL),
(124,'24','24',NULL,'ACTIVE',NULL),
(125,'25','25',NULL,'ACTIVE',NULL),
(126,'26','26',NULL,'ACTIVE',NULL),
(127,'27','27',NULL,'ACTIVE',NULL),
(128,'28','28',NULL,'ACTIVE',NULL),
(129,'29','29',NULL,'ACTIVE',NULL),
(130,'30','30',NULL,'ACTIVE',NULL),
(131,'31','31',NULL,'ACTIVE',NULL),
(132,'32','32',NULL,'ACTIVE',NULL),
(133,'33','33',NULL,'ACTIVE',NULL),
(134,'34','34',NULL,'ACTIVE',NULL),
(135,'35','35',NULL,'ACTIVE',NULL),
(136,'36','36',NULL,'ACTIVE',NULL),
(137,'37','37',NULL,'ACTIVE',NULL),
(138,'38','38',NULL,'ACTIVE',NULL),
(139,'39','39',NULL,'ACTIVE',NULL),
(140,'40','40',NULL,'ACTIVE',NULL),
(141,'41','41',NULL,'ACTIVE',NULL),
(142,'42','42',NULL,'ACTIVE',NULL),
(143,'43','43',NULL,'ACTIVE',NULL),
(144,'44','44',NULL,'ACTIVE',NULL),
(145,'45','45',NULL,'ACTIVE',NULL),
(146,'46','46',NULL,'ACTIVE',NULL),
(147,'47','47',NULL,'ACTIVE',NULL),
(148,'48','48',NULL,'ACTIVE',NULL),
(149,'49','49',NULL,'ACTIVE',NULL),
(150,'50','50',NULL,'ACTIVE',NULL),
(151,'51','51',NULL,'ACTIVE',NULL),
(152,'52','52',NULL,'ACTIVE',NULL),
(153,'53','53',NULL,'ACTIVE',NULL),
(154,'54','54',NULL,'ACTIVE',NULL),
(155,'55','55',NULL,'ACTIVE',NULL),
(156,'56','56',NULL,'ACTIVE',NULL),
(157,'57','57',NULL,'ACTIVE',NULL),
(158,'58','58',NULL,'ACTIVE',NULL),
(159,'59','59',NULL,'ACTIVE',NULL),
(160,'60','60',NULL,'ACTIVE',NULL),
(161,'61','61',NULL,'ACTIVE',NULL),
(162,'62','62',NULL,'ACTIVE',NULL),
(163,'63','63',NULL,'ACTIVE',NULL),
(164,'64','64',NULL,'ACTIVE',NULL),
(165,'65','65',NULL,'ACTIVE',NULL),
(166,'66','66',NULL,'ACTIVE',NULL),
(167,'67','67',NULL,'ACTIVE',NULL),
(168,'68','68',NULL,'ACTIVE',NULL),
(169,'69','69',NULL,'ACTIVE',NULL),
(170,'70','70',NULL,'ACTIVE',NULL),
(171,'71','71',NULL,'ACTIVE',NULL),
(172,'72','72',NULL,'ACTIVE',NULL),
(173,'73','73',NULL,'ACTIVE',NULL),
(174,'74','74',NULL,'ACTIVE',NULL),
(175,'75','75',NULL,'ACTIVE',NULL),
(176,'76','76',NULL,'ACTIVE',NULL),
(177,'77','77',NULL,'ACTIVE',NULL),
(178,'78','78',NULL,'ACTIVE',NULL),
(179,'79','79',NULL,'ACTIVE',NULL),
(180,'80','80',NULL,'ACTIVE',NULL),
(181,'81','81',NULL,'ACTIVE',NULL),
(182,'82','82',NULL,'ACTIVE',NULL),
(183,'83','83',NULL,'ACTIVE',NULL),
(184,'84','84',NULL,'ACTIVE',NULL),
(185,'85','85',NULL,'ACTIVE',NULL),
(186,'86','86',NULL,'ACTIVE',NULL),
(187,'87','87',NULL,'ACTIVE',NULL),
(188,'88','88',NULL,'ACTIVE',NULL),
(189,'89','89',NULL,'ACTIVE',NULL);

/*Table structure for table `student_attendance` */

DROP TABLE IF EXISTS `student_attendance`;

CREATE TABLE `student_attendance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `student_id` bigint(20) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_code` varchar(255) DEFAULT NULL,
  `attended` bigint(255) DEFAULT NULL,
  `explained_absence` bigint(255) DEFAULT NULL,
  `sessions` bigint(255) DEFAULT NULL,
  `attendance` double(65,2) DEFAULT NULL,
  `term` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `student_attendance` */

insert  into `student_attendance`(`id`,`student_id`,`course_name`,`course_code`,`attended`,`explained_absence`,`sessions`,`attendance`,`term`) values 
(1,101,'Mechanical Engineering','H3002U',2,3,20,25.00,NULL),
(2,102,'Elecl Eng and Elecc Eng','H5001U',13,0,20,65.00,NULL),
(3,103,'Mechanical Engineering','H3002U',4,8,16,75.00,NULL),
(4,104,'Elecl Eng and Elecc Eng','H5001U',16,0,21,76.20,NULL),
(5,105,'Computing for Digital Media','G5020U',11,0,14,78.60,NULL),
(6,106,'Mechanical Engineering','H3002U',11,0,18,61.10,NULL),
(7,107,'Elecl Eng and Elecc Eng','H5001U',11,0,20,55.00,NULL),
(8,108,'Computer Science','G5001U',0,0,14,0.00,NULL),
(9,109,'Comp for Bus and Mgmt','GH561U',4,0,14,28.60,NULL),
(10,110,'Elecl Eng and Elecc Eng','H5001U',10,0,19,52.60,NULL),
(11,111,'Elecl Eng and Elecc Eng','H5001U',10,0,19,52.60,NULL),
(12,112,'Mechanical Engineering','H3002U',1,0,20,5.00,NULL),
(13,113,'Mechanical Engineering','H3002U',6,0,20,30.00,NULL),
(14,114,'Mechanical Engineering','H3006U',9,0,20,45.00,NULL),
(15,115,'Computer Science','G5001U',0,0,14,0.00,NULL),
(16,116,'Computer Science','G5001U',9,0,14,64.30,NULL),
(17,117,'Computer Science','G5001U',11,0,14,78.60,NULL),
(18,118,'Computer Science','G5001U',11,0,14,78.60,NULL),
(19,119,'Comp for Bus and Mgmt','GH561U',4,0,14,28.60,NULL),
(20,120,'Computer Science (IP)','G40F0U',11,0,14,78.60,NULL),
(21,121,'Computer Science','G5001U',11,0,14,78.60,NULL),
(22,122,'Computing for Digital Media','G5020U',10,0,14,71.40,NULL),
(23,123,'Comp Sci and AI','G5005U',7,0,12,58.30,NULL),
(24,124,'Product Design (IP)','H7006U',7,0,16,43.80,NULL),
(25,125,'Computer Science (IP)','G40F0U',10,0,14,71.40,NULL),
(26,126,'Comp Sci and AI','G5005U',8,0,12,66.70,NULL),
(27,127,'Computing for Digital Media','G5020U',8,0,14,57.10,NULL),
(28,128,'Computer Engineering','H6001U',0,0,15,0.00,NULL),
(29,129,'Mechanical Engineering','H3002U',0,0,19,0.00,NULL),
(30,130,'Comp Sci and AI','G5005U',0,0,12,0.00,NULL),
(31,131,'Computing for Digital Media','G5020U',3,0,14,21.40,NULL),
(32,132,'Comp Sci and AI','G5005U',7,0,12,58.30,NULL),
(33,133,'Computer Science (IP)','G41F0U',8,1,12,75.00,NULL),
(34,134,'Computer Science','G5001U',0,0,14,0.00,NULL),
(35,135,'Mechanical Engineering','H3006U',1,0,18,5.60,NULL),
(36,136,'Computer Science','G5001U',11,0,14,78.60,NULL),
(37,137,'Product Design (IP)','H7006U',1,0,15,6.70,NULL),
(38,138,'Product Design (IP)','H7006U',11,1,16,75.00,NULL),
(39,139,'Mechanical Engineering','H3002U',15,0,20,75.00,NULL),
(40,140,'Comp Sci and AI','G5005U',9,0,12,75.00,NULL),
(41,141,'Comp for Bus and Mgmt','GH561U',0,0,14,0.00,NULL),
(42,142,'Elecl Eng and Elecc Eng (IP)','H60F0U',14,0,20,70.00,NULL),
(43,143,'Computer Science (IP)','G40F0U',8,0,14,57.10,NULL),
(44,144,'GAME','G5027U',6,0,14,42.90,NULL),
(45,145,'Computer Science','G5001U',0,0,14,0.00,NULL),
(46,146,'Elecl Eng and Elecc Eng','H5001U',13,0,19,68.40,NULL),
(47,147,'Computer Science','G5001U',6,0,14,42.90,NULL),
(48,148,'Comp Sci and AI (IP)','G42F0U',5,0,12,41.70,NULL),
(49,149,'Automotive Engineering','H3014U',16,0,20,80.00,NULL),
(50,150,'Computer Science','G5001U',10,0,14,71.40,NULL),
(51,151,'Mechanical Engineering','H3002U',16,0,20,80.00,NULL),
(52,152,'Computer Engineering (IP)','H63F0U',10,0,15,66.70,NULL),
(53,153,'Mechanical Engineering','H3002U',5,0,20,25.00,NULL),
(54,154,'Computing for Digital Media','G5020U',4,0,14,28.60,NULL),
(55,155,'GAME','G5027U',11,0,14,78.60,NULL),
(56,156,'Comp for Bus and Mgmt','GH561U',10,0,14,71.40,NULL),
(57,157,'Computer Science','G5001U',6,0,14,42.90,NULL),
(58,158,'Elecl Eng and Elecc Eng','H5001U',10,0,21,47.60,NULL),
(59,159,'Mechanical Engineering','H3002U',1,0,20,5.00,NULL),
(60,160,'Elecl Eng and Elecc Eng','H5001U',16,0,20,80.00,NULL),
(61,161,'Mechanical Engineering (IP)','H32F0U',15,0,19,78.90,NULL),
(62,162,'Computer Science','G5001U',11,0,14,78.60,NULL),
(63,163,'Comp Sci and AI','G5005U',8,0,12,66.70,NULL),
(64,164,'Elecl Eng and Elecc Eng','H5001U',16,0,20,80.00,NULL),
(65,165,'Comp Sci and AI','G5005U',4,4,12,66.70,NULL),
(66,166,'Comp for Dig Med (IP)','G45F0U',10,0,14,71.40,NULL),
(67,167,'GAME (IP)','G46F0U',9,0,14,64.30,NULL),
(68,168,'Mechanical Engineering','H3002U',9,0,20,45.00,NULL),
(69,169,'Computer Science','G5001U',9,0,14,64.30,NULL),
(70,170,'Comp for Dig Med (IP)','G45F0U',3,0,14,21.40,NULL),
(71,171,'Mechanical Engineering (IP)','H34F0U',13,0,20,65.00,NULL),
(72,172,'Elecl Eng and Elecc Eng (IP)','H60F0U',0,0,20,0.00,NULL),
(73,173,'Computing for Digital Media','G5020U',0,0,14,0.00,NULL),
(74,174,'Mechanical Engineering','H3002U',8,0,19,42.10,NULL),
(75,175,'Mechanical Engineering','H3002U',0,0,18,0.00,NULL),
(76,176,'Computing for Digital Media','G5020U',7,0,14,50.00,NULL),
(77,177,'Computer Science','G5001U',7,0,14,50.00,NULL),
(78,178,'Elecl Eng and Elecc Eng (IP)','H60F0U',7,0,20,35.00,NULL),
(79,179,'Mechanical Engineering (IP)','H32F0U',8,0,18,44.40,NULL),
(80,180,'Computer Science (IP)','G40F0U',9,0,14,64.30,NULL),
(81,181,'Product Design (IP)','H7006U',8,1,16,56.30,NULL),
(82,182,'Mechanical Engineering','H3002U',1,0,18,5.60,NULL),
(83,183,'Computer Science','G5001U',9,0,14,64.30,NULL),
(84,184,'GAME','G5027U',2,0,14,14.30,NULL),
(85,185,'Elecl Eng and Elecc Eng','H5001U',15,0,20,75.00,NULL),
(86,186,'V&E - Informatics','YY003U',6,0,10,60.00,NULL),
(87,187,'Comp Sci and AI','G5005U',7,1,12,66.70,NULL),
(88,188,'Automotive Engineering','H3014U',0,0,19,0.00,NULL),
(89,189,'Computer Science (IP)','G40F0U',3,0,14,21.40,NULL);

/*Table structure for table `user_login` */

DROP TABLE IF EXISTS `user_login`;

CREATE TABLE `user_login` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `inactive_date` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `user_login` */

insert  into `user_login`(`id`,`username`,`password`,`inactive_date`) values 
(1,'admin','admin',NULL),
(2,'admin1','admin1',NULL),
(3,'admin123123','123123',NULL),
(4,'shengaofeng123','123456',NULL);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  KEY `u_fk` (`id`),
  KEY `r_fk` (`rid`),
  CONSTRAINT `r_fk` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`),
  CONSTRAINT `u_fk` FOREIGN KEY (`id`) REFERENCES `user_login` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`rid`) values 
(1,1),
(2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
