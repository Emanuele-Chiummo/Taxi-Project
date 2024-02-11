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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `fiscal_code` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `mobile_phone` varchar(45) NOT NULL,
  `user_type` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `active` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `mobile_phone_UNIQUE` (`mobile_phone`),
  UNIQUE KEY `fiscal_code_UNIQUE` (`fiscal_code`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin','AdminLastName',NULL,'admin@example.com','12345678901','admin','admin',1),(2,'Cliente','ClienteLastName','CLIENTE123456789','cliente@example.com','9876543210','cliente','cliente',1),(8,'Tassista','TassistaLastName','TASSISTA123456789','tassista@example.com','5555555555','tassista','tassista',1),(9,'Alessio','Speranza','ALLMNN0050B7839R','alessio@example.com','56748976542','tassista','alessio',1),(12,'Emanuele','Chiummo','CHMMNL00B05F839F','emanuelechiummo@outlook.it','3338454907','cliente','emanuele',1),(13,'Ada','Acqua',NULL,'ada@example.com','3334455678','cliente','ada',1),(14,'Filippo','Chiummo',NULL,'filippo@example.com','3332454376','tassista','filippo',1),(15,'Mario','Giordano',NULL,'mario@example.com','3312434566','tassista','mario',0),(16,'Imma','Iannucci',NULL,'imma@example.com','3327656466','Cliente','imma',1),(21,'Maria Francesca','Chiummo',NULL,'mariafrancesca@example.com','33344455678','Cliente','mariafrancesca',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
