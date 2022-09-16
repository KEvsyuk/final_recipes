CREATE DATABASE  IF NOT EXISTS `recipes_finalproject` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `recipes_finalproject`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: recipes_finalproject
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
  `ID` int DEFAULT NULL,
  `Recipe name` text,
  `winter` bool,
  `spring` bool,
  `summer` bool,
  `autumn` bool,
  `Ingridients` text,
  `Cooking time` text,
  `Instructions (in the link)` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,'Chicken Pesto Pizza',true,true,true,true,'pesto basil sauce, pre-baked pizza crust, chicken breast strips, artichoke hearts, cheese ','20 mins','https://www.allrecipes.com/recipe/57243/chicken-pesto-pizza/'),(2,'Salmon Foil-Pack Dinner',false,false,true,true,'sweet potato, zucchini, yellow squash, smoky mesquite seasoning, salmon fillet, lemon','30 mins','https://www.allrecipes.com/recipe/270338/salmon-foil-pack-dinner/'),(3,'Tomato Soup',false,false,true,true,'tomatoes, chicken broth, butter, sugar, onion, baking soda, whipping cream ','1 hr 20 mins','https://www.allrecipes.com/recipe/13381/tomato-soup-i/'),(4,'Classic Stuffed Peppers',false,false,true,true,'rice, extra-virgin olive oil, onion, tomato paste, garlic, ground beef, tomatoes','1 hr 20 mins','https://www.delish.com/cooking/recipe-ideas/a23014857/classic-stuffed-peppers-recipe/'),(5,'Arroz Con Pollo',true,true,true,true,'rice, onion, garlic, tomato paste, chicken broth, bell pappers, tomatoes','1 hr 20 mins','https://www.delish.com/cooking/nutrition/a27244890/best-arroz-con-pollo-recipe/'),(6,'Italian Sausage & Pepper Frittata Affogato',true,true,true,true,'eggs, milk, red bell pepper, onion, sweet Italian sausage, mozzarella','45 mins','https://www.delish.com/cooking/recipe-ideas/a41017400/italian-sausage-and-pepper-frittata-affogato-recipe/'),(7,'Pumpkin, Spinach and Ricotta Stuffed Shells',false,false,false,true,'pumpkin, olive oil, pasta shells, bacon, garlic, nutmeg, spinach, ricotta, parmesan, tomato sauce ','1 hr 10-15 mins','https://myfoodbook.com.au/recipes/show/pumpkin-spinach-and-ricotta-stuffed-shells'),(8,'Loaded Sweet Potato Skins',false,false,false,true,'sweet potato, sweet corn, spring onion, cheese, bacon, lime, coriander, sweet chilli sauce','1 hr 50 mins','https://myfoodbook.com.au/recipes/show/loaded-sweet-potato-skins'),(9,'Tofu Miso Soup',false,false,false,true,'miso paste, vegetable stock, spinach, soba noodles, snow peas, firm tofu, eggs, gochujang, black sesame seeds','40 mins','https://myfoodbook.com.au/recipes/show/tofu-miso-soup');
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-14 21:52:37
