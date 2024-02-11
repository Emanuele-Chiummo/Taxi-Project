-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: taxi_management
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_location_id` int NOT NULL,
  `end_location_id` int NOT NULL,
  `km` decimal(5,2) NOT NULL,
  `rates_id` int NOT NULL,
  `active` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_courses_locations_start_idx` (`start_location_id`),
  KEY `FK_courses_locations_end_idx` (`end_location_id`),
  KEY `FK_courses_rates_idx` (`rates_id`),
  CONSTRAINT `FK_courses_locations_end` FOREIGN KEY (`end_location_id`) REFERENCES `locations` (`id`),
  CONSTRAINT `FK_courses_locations_start` FOREIGN KEY (`start_location_id`) REFERENCES `locations` (`id`),
  CONSTRAINT `FK_courses_rates` FOREIGN KEY (`rates_id`) REFERENCES `rates` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (6,12,11,15.70,80,1),(7,12,13,15.50,6,1),(8,13,14,8.00,7,1),(15,20,19,0.00,31,1),(16,22,21,0.00,32,1),(24,38,37,20.00,40,1),(25,41,40,20.00,42,1),(28,51,50,15.50,49,1),(29,54,53,20.00,51,0),(30,56,55,20.00,53,0),(31,58,57,20.00,55,0),(32,60,59,20.00,56,1),(33,12,19,15.70,57,1),(34,61,66,20.00,58,1),(35,12,13,20.00,61,0),(38,67,66,25.00,69,1),(39,23,24,15.70,70,1),(40,68,22,27.00,71,1);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-11 13:50:46
