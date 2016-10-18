CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	5.5.50

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
-- Table structure for table `carparking`
--

DROP TABLE IF EXISTS `carparking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carparking` (
  `car_no` varchar(64) NOT NULL,
  `car_type` varchar(60) NOT NULL,
  `owner_name` varchar(124) NOT NULL,
  `ower_mbl_no` varchar(20) NOT NULL,
  `check_in` timestamp NULL DEFAULT NULL,
  `check_out` timestamp NULL DEFAULT NULL,
  `parked_time_inminitues` decimal(10,0) DEFAULT NULL,
  `parked_time_inhours` decimal(10,0) DEFAULT NULL,
  `parked_time_indays` decimal(10,0) DEFAULT NULL,
  `parking_charge` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`car_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carparking`
--

LOCK TABLES `carparking` WRITE;
/*!40000 ALTER TABLE `carparking` DISABLE KEYS */;
INSERT INTO `carparking` VALUES ('1234','AUDI 7S','Arjun Allu','9889889889','2016-10-12 10:16:37',NULL,NULL,NULL,NULL,NULL),('1432','Nano','Chapala Kiran','9884120779','2016-10-13 05:19:54',NULL,NULL,NULL,NULL,NULL),('6664','AUDI 5S','Naresh Dasari','9884120779','2016-10-12 07:16:55','2016-10-17 14:24:57',7628,127,5,359),('8899','AUDI 5S','Naresh Dasari','9884120779','2016-09-17 13:35:50','2016-10-17 13:35:50',43200,720,30,2070),('9999','Ferrari','Harish Emp','9663411755','2016-10-12 19:07:04',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `carparking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-18 12:42:14
