-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: rehab
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Dumping data for table `contractors`
--

LOCK TABLES `contractors` WRITE;
/*!40000 ALTER TABLE `contractors` DISABLE KEYS */;
INSERT INTO `contractors` (`contractor_id`, `c_company_name`, `c_contact_last_name`, `c_contact_first_name`, `c_email`, `c_phone`, `c_street_address1`, `c_street_address2`, `c_city`, `c_state`, `c_zipcode`, `c_license`, `c_insurance`) VALUES (1,'Parker  Builds LCC','Parker','Neil','neil.parker@noemail.com','717-719-2346','1009 Cordelia Road','','Lancaster','PA','17605','DE 75-7051702','StatePlace\r'),(2,'Clutten Works','Clutten','Aaron','aclutten@chron.com','610-222-2370','29 Forest Dale Court','','Philadelphia','PA','19178','DE 17-2219115','NoState Insurance\r'),(3,'CH Construction','Hancox','Chase','chancoxu@purevolume.com','302-449-1596','4976 Little Fleur Center','','Wilmington','DE','19886','DE 42-4996259','Nationnarrow\r'),(4,'Yats Builds','Yatman','Sloan','syatman12@vistaprint.com','302-118-9465','47131 Pepper Wood Terrace','','Wilmington','DE','19897','DE 23-9926890','STG Insurance\r'),(5,'JW Repairs','Witchard','Jerome','jwitchard1d@businesswire.com','302-849-2871','1 Gulseth Trail','','Wilmington','DE','19886','DE 09-0137088','Empire Light\r'),(6,'Spenton LLC','Spenton','Ben','bspenton26@studiopress.com','410-381-9239','82 Fulton Center','','Elkton','MD','21921','DE 87-9398282','Nationnarrow\r'),(7,'MH Builds LLC','Morch','Herbert','hmorch2v@goo.gl','215-296-8115','06451 Park Meadow Parkway','','Philadelphia','PA','19136','DE 09-8466559','Empire Light\r'),(8,'Patch Repairs LLC','Harman','Tabina','tharman2y@patch.com','302-562-8324','5 Mayfield Plaza','','Newark','DE','19714','DE 66-0961418','STG Insurance\r'),(9,'Bonelle Construction','Bonelle','James','jbonelle43@biglobe.ne.jp','302-507-1438','2 Bayside Park','','Wilmington','DE','19897','DE 15-2873834','Empire Light\r'),(10,'Mitch Landscape & More','Mitchenson','Fernando','fmitchenson48@theglobeandmail.com','302-113-9898','061 Florence Road','','Newark','DE','19725','DE 64-4601767','NoState Insurance');
/*!40000 ALTER TABLE `contractors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `contractors_specialities`
--

LOCK TABLES `contractors_specialities` WRITE;
/*!40000 ALTER TABLE `contractors_specialities` DISABLE KEYS */;
INSERT INTO `contractors_specialities` (`contractor_speciality_id`, `cs_contractor`, `cs_speciality`) VALUES (1,10,7),(2,10,5),(3,10,1),(4,1,1),(5,1,2),(6,1,3),(7,1,4),(8,1,5),(9,1,6),(10,1,7),(11,1,8),(12,2,2),(13,2,3),(14,2,5),(15,3,1),(16,3,2),(17,3,5),(18,3,8),(19,3,7),(20,4,2),(21,4,3),(22,4,4),(23,4,5),(24,4,6),(25,4,8),(26,6,4),(27,6,6),(28,5,2),(29,5,3),(30,5,5),(31,7,1),(32,7,2),(33,7,3),(34,7,4),(35,7,5),(36,7,6),(37,7,8),(38,8,4),(39,8,5),(40,8,6),(41,9,1),(42,9,4),(43,9,6);
/*!40000 ALTER TABLE `contractors_specialities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `estimates`
--

LOCK TABLES `estimates` WRITE;
/*!40000 ALTER TABLE `estimates` DISABLE KEYS */;
/*!40000 ALTER TABLE `estimates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `properties`
--

LOCK TABLES `properties` WRITE;
/*!40000 ALTER TABLE `properties` DISABLE KEYS */;
INSERT INTO `properties` (`property_id`, `p_name`, `p_street_address1`, `p_street_address2`, `p_city`, `p_state`, `p_zipcode`, `p_purchase_date`, `p_purchase_price`, `p_goal_complete_date`, `p_total_budget`) VALUES (1,'Anderson','1871 Anderson Point','','Newark','DE','19714','2017-11-02',219000,'2018-06-30',40000),(2,'Bobwhite','19 Bobwhite Alley','','Newark','DE','19716','2017-10-05',90000,'2018-05-31',25000),(3,'Marquette','3904 Marquette Drive','','Wilmington','DE','19886','2017-07-25',175000,'2018-09-01',70000),(4,'Elgar','5803 Elgar Terrace','','Wilmington','DE','19810','2017-12-15',110000,'2018-04-30',12000);
/*!40000 ALTER TABLE `properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `specialities`
--

LOCK TABLES `specialities` WRITE;
/*!40000 ALTER TABLE `specialities` DISABLE KEYS */;
INSERT INTO `specialities` (`speciality_id`, `s_type`) VALUES (1,'Roofing and Siding\r'),(2,'Plumbing\r'),(3,'Flooring\r'),(4,'Electrical\r'),(5,'Painting and Drywall\r'),(6,'HVAC\r'),(7,'Landscaping\r'),(8,'Kitchen');
/*!40000 ALTER TABLE `specialities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-11 19:20:42
