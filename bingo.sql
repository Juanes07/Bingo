-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: bingo
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ballot_game`
--

DROP TABLE IF EXISTS `ballot_game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ballot_game` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ballot` int NOT NULL,
  `game_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ballot_game`
--

LOCK TABLES `ballot_game` WRITE;
/*!40000 ALTER TABLE `ballot_game` DISABLE KEYS */;
INSERT INTO `ballot_game` VALUES (3,5,1),(4,10,1);
/*!40000 ALTER TABLE `ballot_game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartoon`
--

DROP TABLE IF EXISTS `cartoon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartoon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `game_id` int NOT NULL,
  `user_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `b` varchar(25) NOT NULL,
  `i` varchar(25) NOT NULL,
  `n` varchar(25) NOT NULL,
  `g` varchar(25) NOT NULL,
  `o` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cartoon_game1_idx` (`game_id`),
  CONSTRAINT `fk_cartoon_game1` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartoon`
--

LOCK TABLES `cartoon` WRITE;
/*!40000 ALTER TABLE `cartoon` DISABLE KEYS */;
INSERT INTO `cartoon` VALUES (1,1,'uiwertuertquiurkjdgs','9|11|15|6|4','16|28|26|29|20','40|33|00|41|36','55|52|49|50|57','66|65|69|62|72');
/*!40000 ALTER TABLE `cartoon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `status` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'2022-01-01','ACTIVE'),(2,'2022-03-12','ACTIVE'),(3,'2022-03-12','INACTIVE'),(4,'2022-03-11','ACTIVE');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game_has_user`
--

DROP TABLE IF EXISTS `game_has_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game_has_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `game_id` int NOT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `game_has_user_FK` (`game_id`),
  CONSTRAINT `game_has_user_FK` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game_has_user`
--

LOCK TABLES `game_has_user` WRITE;
/*!40000 ALTER TABLE `game_has_user` DISABLE KEYS */;
INSERT INTO `game_has_user` VALUES (1,1,'jkjgfsdhfgjsdfgkjeiurgjdfslkjgjlksdfgh'),(2,1,'aaaaaaaadfasdf'),(3,2,'bbbbbbbbfasjdflkjasdfjlas'),(4,2,'ccccccccsdfasdfasdf'),(5,3,'dddddfgsdhfjgkjsdfg'),(6,3,'eeeeeeegsjdfhgjshdfg'),(7,1,'uiwertuertquiurkjdgs');
/*!40000 ALTER TABLE `game_has_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-12 16:26:33
