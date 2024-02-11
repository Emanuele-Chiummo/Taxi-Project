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
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `gps` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (11,'Piazza Garibaldi','12.3456,78.9101'),(12,'Via Toledo','12.3456,78.9101'),(13,'Piazza Plebiscito','123456.85.91011'),(14,'Piazza Dante','1234.5678.9088'),(19,'Aereoporto Capodichino','234567897654332'),(20,'Stazione Centrale','2345678976543'),(21,'Ospedale Cardarelli',''),(22,'Piazza Quattro Giornate',''),(23,'Piazza Vanvitelli',' '),(24,'Piazza Cavour',' '),(27,'Piazza Carlo 3',' '),(37,'Piazza Nazionale',' '),(38,'Piazza Medaglie d\'oro',' '),(40,'Piazza tre cavalieri',' '),(41,'Piazza Giulio Cesare',' '),(46,'Piazza Vanvitelli',' '),(48,'Piazza Giulio Alvino',' '),(50,'Piazza Giulio Alvino',' '),(51,'Piazza Cavour',' '),(53,'Piazza Pluto',' '),(54,'Piazza Frankk',' '),(55,'20',' '),(56,'22',' '),(57,'23',' '),(58,'12',' '),(59,'Piazza Cavour',' '),(60,'Via Toledo',' '),(61,'Corso Meridionale',''),(66,'Viale dei Pini',''),(67,'Corso Novara',''),(68,'Corso Garibaldi','');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
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
