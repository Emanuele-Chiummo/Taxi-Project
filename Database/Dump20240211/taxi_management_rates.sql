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
-- Table structure for table `rates`
--

DROP TABLE IF EXISTS `rates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rates` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rates_type` varchar(45) NOT NULL,
  `amount` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rates`
--

LOCK TABLES `rates` WRITE;
/*!40000 ALTER TABLE `rates` DISABLE KEYS */;
INSERT INTO `rates` VALUES (6,'u',25.00),(7,'u',22.00),(8,'u',10.00),(10,'u',25.00),(11,'u',25.00),(12,'u',25.00),(13,'u',25.00),(14,'u',25.00),(15,'u',25.00),(16,'u',25.00),(17,'u',25.00),(18,'u',25.00),(19,'u',25.00),(20,'u',25.00),(21,'u',25.00),(22,'u',25.00),(23,'u',31.00),(24,'u',31.00),(25,'u',31.00),(27,'u',31.00),(28,'u',35.00),(29,'u',35.00),(30,'u',27.00),(31,'u',31.00),(32,'urbana',16.00),(33,'urbana',18.00),(34,'urbana',18.00),(35,'urbana',15.00),(36,'urbana',18.00),(37,'urbana',18.00),(38,'urbana',18.00),(39,'urbana',18.00),(40,'urbana',18.00),(42,'urbana',18.00),(47,'urbana',18.00),(48,'urbana',18.00),(49,'urbana',18.00),(51,'urbana',18.00),(52,'u',30.00),(53,'urbana',18.00),(54,'u',30.00),(55,'urbana',18.00),(56,'urbana',18.00),(57,'urbana',10.99),(58,'urbana',14.00),(59,'u',30.00),(60,'u',30.00),(61,'urbana',14.00),(62,'u',30.00),(63,'u',30.00),(64,'u',30.00),(65,'u',30.00),(66,'u',30.00),(67,'u',30.00),(68,'u',34.00),(69,'urbana',17.50),(70,'urbana',10.99),(71,'urbana',18.90),(72,'u',36.00),(73,'u',36.00),(74,'u',36.00),(75,'u',36.00),(76,'u',36.00),(77,'u',36.00),(78,'u',36.00),(79,'u',36.00),(80,'u',36.00);
/*!40000 ALTER TABLE `rates` ENABLE KEYS */;
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
