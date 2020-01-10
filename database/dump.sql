-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: tasks
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `tasks`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `tasks` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `tasks`;

--
-- Table structure for table `abstractentity`
--

DROP TABLE IF EXISTS `abstractentity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abstractentity` (
  `ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abstractentity`
--

LOCK TABLES `abstractentity` WRITE;
/*!40000 ALTER TABLE `abstractentity` DISABLE KEYS */;
/*!40000 ALTER TABLE `abstractentity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `companygroupid` int(10) unsigned zerofill NOT NULL DEFAULT '0000000001',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `company_fk01_idx` (`companygroupid`),
  CONSTRAINT `company_fk01` FOREIGN KEY (`companygroupid`) REFERENCES `companygroup` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companygroup`
--

DROP TABLE IF EXISTS `companygroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companygroup` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companygroup`
--

LOCK TABLES `companygroup` WRITE;
/*!40000 ALTER TABLE `companygroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `companygroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `observation`
--

DROP TABLE IF EXISTS `observation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `observation` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `sourceid` int(10) unsigned zerofill NOT NULL,
  `userid` int(10) unsigned zerofill NOT NULL,
  `observation` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `observation`
--

LOCK TABLES `observation` WRITE;
/*!40000 ALTER TABLE `observation` DISABLE KEYS */;
/*!40000 ALTER TABLE `observation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `companyid` int(10) unsigned zerofill NOT NULL,
  `name` varchar(45) NOT NULL,
  `projecttypeid` int(10) unsigned zerofill NOT NULL,
  `projectgroup` varchar(45) DEFAULT NULL,
  `projectstatusid` int(10) unsigned zerofill NOT NULL,
  `projectmanagerid` int(10) unsigned zerofill NOT NULL DEFAULT '0000000001',
  PRIMARY KEY (`id`),
  KEY `project_fk01_idx` (`companyid`),
  KEY `project_fk02_idx` (`projecttypeid`),
  KEY `project_fk03_idx` (`projectstatusid`),
  KEY `project_fk04_idx` (`projectmanagerid`),
  CONSTRAINT `project_fk01` FOREIGN KEY (`companyid`) REFERENCES `company` (`id`),
  CONSTRAINT `project_fk02` FOREIGN KEY (`projecttypeid`) REFERENCES `projecttype` (`id`),
  CONSTRAINT `project_fk03` FOREIGN KEY (`projectstatusid`) REFERENCES `projectstatus` (`id`),
  CONSTRAINT `project_fk04` FOREIGN KEY (`projectmanagerid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectstatus`
--

DROP TABLE IF EXISTS `projectstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projectstatus` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectstatus`
--

LOCK TABLES `projectstatus` WRITE;
/*!40000 ALTER TABLE `projectstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projecttype`
--

DROP TABLE IF EXISTS `projecttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projecttype` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projecttype`
--

LOCK TABLES `projecttype` WRITE;
/*!40000 ALTER TABLE `projecttype` DISABLE KEYS */;
/*!40000 ALTER TABLE `projecttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rule` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `BLOCKED` tinyint(1) DEFAULT '0',
  `CREATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (0000000001,'Project Admin',NULL,0,'2019-12-04 20:28:28','2019-12-04 20:28:28'),(0000000002,'Task Admin',NULL,0,'2019-12-04 20:28:28','2019-12-04 20:28:28'),(0000000003,'Task Performance',NULL,0,'2019-12-04 20:28:28','2019-12-04 20:28:28'),(0000000004,'Project Stakeholder',NULL,0,'2019-12-04 20:28:28','2019-12-04 20:28:28'),(0000000005,'Portifolio Admin',NULL,0,'2019-12-04 20:28:28','2019-12-04 20:28:28'),(0000000006,'Portifolio Stakeholder',NULL,0,'2019-12-04 20:28:28','2019-12-04 20:28:28');
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',0);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `projectid` int(10) unsigned zerofill NOT NULL,
  `projectphase` varchar(45) NOT NULL,
  `workpackage` varchar(45) DEFAULT NULL,
  `sprint` varchar(45) DEFAULT NULL,
  `tasktypeid` int(10) unsigned zerofill NOT NULL,
  `taskcreatorid` int(10) unsigned zerofill NOT NULL,
  `taskperformanceid` int(10) unsigned zerofill NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `taskstatusid` int(10) unsigned zerofill NOT NULL,
  `name` varchar(45) NOT NULL,
  `created` timestamp(1) NOT NULL DEFAULT CURRENT_TIMESTAMP(1),
  `updated` timestamp(1) NOT NULL DEFAULT CURRENT_TIMESTAMP(1) ON UPDATE CURRENT_TIMESTAMP(1),
  `estimatedwork` int(10) DEFAULT NULL,
  `estimatedstart` date DEFAULT NULL,
  `estimatedfinish` date DEFAULT NULL,
  `version` int(10) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `task_fk01_idx` (`projectid`),
  KEY `task_fk02_idx` (`tasktypeid`),
  KEY `task_fk03_idx` (`taskcreatorid`),
  KEY `task_fk04_idx` (`taskperformanceid`),
  KEY `task_fk05_idx` (`taskstatusid`),
  CONSTRAINT `task_fk01` FOREIGN KEY (`projectid`) REFERENCES `project` (`id`),
  CONSTRAINT `task_fk02` FOREIGN KEY (`tasktypeid`) REFERENCES `tasktype` (`id`),
  CONSTRAINT `task_fk03` FOREIGN KEY (`taskcreatorid`) REFERENCES `user` (`id`),
  CONSTRAINT `task_fk04` FOREIGN KEY (`taskperformanceid`) REFERENCES `user` (`id`),
  CONSTRAINT `task_fk05` FOREIGN KEY (`taskstatusid`) REFERENCES `taskstatus` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taskstatus`
--

DROP TABLE IF EXISTS `taskstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taskstatus` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taskstatus`
--

LOCK TABLES `taskstatus` WRITE;
/*!40000 ALTER TABLE `taskstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `taskstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasktimesheet`
--

DROP TABLE IF EXISTS `tasktimesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasktimesheet` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `taskid` int(10) unsigned zerofill NOT NULL,
  `userid` int(10) unsigned zerofill NOT NULL,
  `reportedwork` double NOT NULL,
  `jobstatusid` int(10) unsigned zerofill NOT NULL,
  `progressstatusreported` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasktimesheet`
--

LOCK TABLES `tasktimesheet` WRITE;
/*!40000 ALTER TABLE `tasktimesheet` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasktimesheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasktype`
--

DROP TABLE IF EXISTS `tasktype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasktype` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `standardCostPerHour` double DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasktype`
--

LOCK TABLES `tasktype` WRITE;
/*!40000 ALTER TABLE `tasktype` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasktype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `passwd` varchar(45) NOT NULL,
  `blocked` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercompany`
--

DROP TABLE IF EXISTS `usercompany`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usercompany` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned zerofill NOT NULL,
  `companyid` int(10) unsigned zerofill NOT NULL,
  `ruleid` int(10) unsigned zerofill NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `usercompany_un01` (`companyid`,`userid`) /*!80000 INVISIBLE */,
  KEY `usercompany_fk01_idx` (`userid`),
  KEY `usercompany_fk03_idx` (`ruleid`),
  CONSTRAINT `usercompany_fk01` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `usercompany_fk02` FOREIGN KEY (`companyid`) REFERENCES `company` (`id`),
  CONSTRAINT `usercompany_fk03` FOREIGN KEY (`ruleid`) REFERENCES `rule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercompany`
--

LOCK TABLES `usercompany` WRITE;
/*!40000 ALTER TABLE `usercompany` DISABLE KEYS */;
/*!40000 ALTER TABLE `usercompany` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workstatusreport`
--

DROP TABLE IF EXISTS `workstatusreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workstatusreport` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workstatusreport`
--

LOCK TABLES `workstatusreport` WRITE;
/*!40000 ALTER TABLE `workstatusreport` DISABLE KEYS */;
/*!40000 ALTER TABLE `workstatusreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `tasksmng`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `tasksmng` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `tasksmng`;

--
-- Table structure for table `abstractentity`
--

DROP TABLE IF EXISTS `abstractentity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abstractentity` (
  `ID` bigint(20) NOT NULL,
  `CREATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ISBLOCKED` tinyint(1) NOT NULL DEFAULT '0',
  `ISMASTERDATA` tinyint(1) NOT NULL DEFAULT '0',
  `NAME` varchar(100) NOT NULL,
  `UPDATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `WASDELETED` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abstractentity`
--

LOCK TABLES `abstractentity` WRITE;
/*!40000 ALTER TABLE `abstractentity` DISABLE KEYS */;
/*!40000 ALTER TABLE `abstractentity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `ID` bigint(20) NOT NULL,
  `COMPANYGROUPID` bigint(20) DEFAULT '1',
  `CREATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ISBLOCKED` tinyint(1) NOT NULL DEFAULT '0',
  `ISMASTERDATA` tinyint(1) NOT NULL DEFAULT '0',
  `NAME` varchar(100) NOT NULL,
  `UPDATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `WASDELETED` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companygroup`
--

DROP TABLE IF EXISTS `companygroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companygroup` (
  `ID` bigint(20) NOT NULL,
  `CREATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ISBLOCKED` tinyint(1) NOT NULL DEFAULT '0',
  `ISMASTERDATA` tinyint(1) NOT NULL DEFAULT '0',
  `NAME` varchar(100) NOT NULL,
  `UPDATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `WASDELETED` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companygroup`
--

LOCK TABLES `companygroup` WRITE;
/*!40000 ALTER TABLE `companygroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `companygroup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `ID` bigint(20) NOT NULL,
  `COMPANYID` bigint(20) DEFAULT '0',
  `CREATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ENTITYID` bigint(20) DEFAULT '0',
  `ISBLOCKED` tinyint(1) NOT NULL DEFAULT '0',
  `ISMASTERDATA` tinyint(1) NOT NULL DEFAULT '0',
  `NAME` varchar(100) NOT NULL,
  `PROJECTID` bigint(20) DEFAULT '0',
  `UPDATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `USERACTION` varchar(10) NOT NULL,
  `USERID` bigint(20) DEFAULT '0',
  `WASDELETED` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rule` (
  `ID` bigint(20) NOT NULL,
  `CREATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `ISBLOCKED` tinyint(1) NOT NULL DEFAULT '0',
  `ISMASTERDATA` tinyint(1) NOT NULL DEFAULT '0',
  `NAME` varchar(100) NOT NULL,
  `UPDATEDIN` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `WASDELETED` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (151,'2019-12-05 03:00:00',NULL,0,1,'System Admin','2019-12-04 03:00:00',0),(152,'2019-12-05 03:00:00',NULL,1,1,'Project Admin','2019-12-05 03:00:00',0),(153,'2019-12-05 03:00:00',NULL,0,1,'Task Admin','2019-12-04 03:00:00',0),(154,'2019-12-05 03:00:00',NULL,0,1,'Task Performance','2019-12-04 03:00:00',0),(155,'2019-12-05 03:00:00',NULL,0,1,'Project Stakeholder','2019-12-04 03:00:00',0),(156,'2019-12-05 03:00:00',NULL,0,1,'Portifolio Admin','2019-12-04 03:00:00',0),(157,'2019-12-05 03:00:00',NULL,0,1,'Portifolio Stakeholder','2019-12-04 03:00:00',0);
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',200);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-05 22:15:17
