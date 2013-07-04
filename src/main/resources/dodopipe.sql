-- MySQL dump 10.13  Distrib 5.5.31, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: dodopipe
-- ------------------------------------------------------
-- Server version	5.5.31-0ubuntu0.12.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aa`
--

DROP TABLE IF EXISTS `aa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aa` (
  `asd` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aa`
--

LOCK TABLES `aa` WRITE;
/*!40000 ALTER TABLE `aa` DISABLE KEYS */;
INSERT INTO `aa` VALUES ('2013-06-23 03:11:11');
/*!40000 ALTER TABLE `aa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `askfor_leave`
--

DROP TABLE IF EXISTS `askfor_leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `askfor_leave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `reason` varchar(50) DEFAULT NULL,
  `startDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `endDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `note` varchar(20) DEFAULT NULL,
  `leaveDate` date DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `askfor_leave`
--

LOCK TABLES `askfor_leave` WRITE;
/*!40000 ALTER TABLE `askfor_leave` DISABLE KEYS */;
INSERT INTO `askfor_leave` VALUES (11,'admin','ljjlkljklj','2013-07-01 02:14:41','2012-06-27 05:00:00','disagree',NULL,'hhjkj'),(12,'Fukai.Ding','dssdv','2013-07-01 02:14:09','2012-06-27 05:00:00','agree',NULL,''),(13,'admin','hrhwrthreghsdgh','2012-06-26 16:53:12','2012-06-27 05:00:00','no-reply',NULL,NULL);
/*!40000 ALTER TABLE `askfor_leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `check_time`
--

DROP TABLE IF EXISTS `check_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `check_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `check_first` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `check_second` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `time` double(2,1) DEFAULT '0.0',
  `data` date DEFAULT NULL,
  `flag` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `check_time`
--

LOCK TABLES `check_time` WRITE;
/*!40000 ALTER TABLE `check_time` DISABLE KEYS */;
INSERT INTO `check_time` VALUES (64,'admin','2013-06-28 10:16:24','2013-06-28 10:37:45',0.4,'2013-06-28','2'),(65,'Fukai.Ding','2013-07-01 00:55:20','2013-07-01 08:35:14',7.7,'2013-07-01','2'),(66,'admin','2013-07-01 00:55:51','2013-07-01 08:35:14',7.7,'2013-07-01','2'),(67,'Fukai.Ding','2013-07-02 06:48:34','2013-07-02 10:44:46',3.8,'2013-07-02','2'),(68,'admin','2013-07-02 06:54:38','2013-07-02 10:44:46',3.8,'2013-07-02','2'),(69,'Fukai.Ding','2013-07-03 01:26:31','2013-07-03 01:26:31',0.0,'2013-07-03','1'),(70,'admin','2013-07-03 01:30:09','2013-07-03 01:30:09',0.0,'2013-07-03','1');
/*!40000 ALTER TABLE `check_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (13,'admin','admin','HR'),(14,'Karl.Li','likar','Employee'),(20,'Fukai.Ding','dingfukai','Employee');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolerights`
--

DROP TABLE IF EXISTS `rolerights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rolerights` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(10) DEFAULT NULL,
  `rights` varchar(20) DEFAULT NULL,
  `url` varchar(30) DEFAULT NULL,
  `params` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolerights`
--

LOCK TABLES `rolerights` WRITE;
/*!40000 ALTER TABLE `rolerights` DISABLE KEYS */;
INSERT INTO `rolerights` VALUES (1,'HR','Ask for leave','leave','name=${user.username}'),(2,'HR','Check','checkin','falgCheck=${check.flag}&name=${user.username}'),(3,'HR','View leave message','viewLeaveMessage','name=${user.username}'),(4,'HR','View attendance msg','viewCheckMessage','name=${user.username}'),(5,'HR','Leave management','leaveManagement',NULL),(6,'HR','Attendance managemen','attendancemanagement',NULL),(7,'Employee','Check','checkin','falgCheck=${check.flag}&name=${user.username}'),(8,'Employee','Ask for leave','leave','name=${user.username}'),(9,'Employee','View leave message','viewLeaveMessage','name=${user.username}'),(10,'Employee','View attendance msg','viewCheckMessage','name=${user.username}');
/*!40000 ALTER TABLE `rolerights` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-04 10:36:11
