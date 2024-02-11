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
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requests` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `taxi_id` int DEFAULT NULL,
  `date` datetime NOT NULL,
  `state` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_requests_courses_idx` (`course_id`),
  KEY `FK_requests_taxi_idx` (`taxi_id`),
  CONSTRAINT `FK_requests_courses` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  CONSTRAINT `FK_requests_taxi` FOREIGN KEY (`taxi_id`) REFERENCES `taxi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES (1,6,NULL,'2024-01-10 00:00:00','Rifiutata'),(8,6,NULL,'2024-01-18 00:00:00','Rifiutata'),(9,6,NULL,'2024-01-19 00:00:00','Rifiutata'),(10,6,NULL,'2024-01-18 00:00:00','Accettata'),(11,6,NULL,'2024-01-20 00:00:00','Accettata'),(12,6,NULL,'2024-01-21 00:00:00','Accettata'),(13,6,9,'2024-01-22 00:00:00','Accettata'),(14,6,NULL,'2024-01-22 00:00:00','Accettata'),(15,6,33,'2024-01-23 00:00:00','Accettata'),(16,6,30,'2024-01-26 00:00:00','Accettata'),(17,8,30,'2024-01-25 00:00:00','Accettata'),(19,8,30,'2024-01-25 00:00:00','Accettata'),(20,8,30,'2024-01-26 00:00:00','Accettata'),(21,6,33,'2024-01-26 00:00:00','Accettata'),(22,6,33,'2024-01-26 00:00:00','Rifiutata'),(23,6,22,'2024-01-29 00:00:00','Accettata'),(24,6,34,'2024-01-28 00:00:00','Accettata'),(25,6,34,'2024-01-28 00:00:00','Accettata'),(56,39,33,'2024-01-30 00:00:00','Accettata'),(57,8,NULL,'2024-02-02 00:00:00','Richiesta'),(58,8,NULL,'2024-02-11 00:00:00','Richiesta');
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
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
