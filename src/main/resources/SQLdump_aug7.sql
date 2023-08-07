/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 8.0.34 : Database - erp_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`erp_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `erp_db`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `d_no` varchar(50) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `pin_code` int DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `address` */

insert  into `address`(`address_id`,`d_no`,`street`,`city`,`state`,`pin_code`) values 
(1,'123','Main Street','New York','New York',10001),
(2,'789','Business Avenue','San Francisco','California',94105),
(3,'45','Farm Road','Rural Town','Texas',78901),
(4,'700','University Street','College City','Washington',98052),
(5,'222','Beach House Road','Paradise Island','Hawaii',96701),
(6,'67','Traveler Lane','Nomad City','Traveling',0),
(7,'456','Corporate Park','Business City','California',90210),
(8,'14','Apartment Complex','Metropolis','Cityville',54321),
(9,'1','Famous Monument Road','Landmark City','Historic State',11111),
(10,'999','Remote Valley','Isolated Town','Unknown State',99999),
(11,'300','Mall Street','Shopping City','California',90210),
(12,'456','Market Lane','Busy Market','New York',10001),
(13,'1001','Suburb Street','Suburban Town','Texas',78901),
(14,'777','Tourist Road','Tourist Haven','Hawaii',96701),
(15,'567','Downtown Plaza','City Center','California',94105),
(16,'88','Residential Street','Family Town','Texas',78901),
(17,'999','Business Complex','Commercial City','California',90210),
(18,'1234','Tech Hub Street','Tech City','Washington',98052),
(19,'4567','Tourist Spot Road','Tourist Central','Hawaii',96701),
(20,'22B','Tech Park Avenue','Innovation City','Washington',98052),
(21,'555','Business District','Commercial City','California',90210),
(22,'777','Industrial Road','Manufacturing Town','Texas',78901),
(23,'999','Tech Park Street','Innovation City','Washington',98052),
(24,'1234','Trade Center Avenue','Commerce City','New York',10001),
(25,'77','Farmland Lane','Agriculture Town','Texas',78901),
(26,'456','Tourist Spot Road','Tourist Central','Hawaii',96701),
(27,'321','Commercial Complex','Business City','California',90210),
(28,'111','Education Street','College City','Washington',98052),
(29,'888','Healthcare Avenue','Medical City','New York',10001),
(30,'444','Logistics Lane','Transport City','California',94105),
(31,'123','Supplier Street','Commercial City','California',90210),
(32,'456','Supplier Lane','Business City','Washington',98052),
(33,'789','Supplier Road','Manufacturing Town','Texas',78901),
(34,'321','Supplier Avenue','Commerce City','New York',10001),
(35,'654','Supplier Lane','Agriculture Town','Texas',78901),
(36,'987','Supplier Spot Road','Tourist Central','Hawaii',96701),
(37,'741','Supplier Complex','Business City','California',90210),
(38,'852','Supplier Avenue','College City','Washington',98052),
(39,'963','Supplier Street','Medical City','New York',10001),
(40,'753','Supplier Lane','Transport City','California',94105),
(41,'101','Main Street','New York','NY',10001),
(42,'201','First Avenue','Los Angeles','CA',90001),
(43,'15A','Broadway','Chicago','IL',60601),
(44,'22B','Elm Street','Houston','TX',77001),
(45,'105','Park Avenue','San Francisco','CA',94101),
(46,'301','Main Road','Seattle','WA',98101),
(47,'2C','Ocean Drive','Miami','FL',33101),
(48,'18X','Denver','Dallas','TX',75201),
(49,'90','Mountain View','Denver','CO',80201),
(50,'42','Sunset Boulevard','Las Vegas','NV',89101),
(51,'123a','Main Street','Cityville','Stateville',12345),
(52,'789','Tech Road','Techtown','Technia',54321),
(53,'456','Service Avenue','Service City','Service State',67890),
(54,'246','Consultant Road','Consultant City','Consultant State',13579),
(55,'789','Manufacture Street','Mfgville','Mfgstate',54321),
(56,'987','Food Street','Foodville','Food State',24680),
(57,'456','Fashion Avenue','Fashion City','Fashion State',54321),
(58,'789','Software Road','Software City','Software State',67890),
(59,'123','Electronics Street','Electronicsville','Electronia',13579),
(60,'789','Logistics Avenue','Logistics City','Logistics State',24680),
(61,'789','Store Street','Store City','Store State',54321),
(66,'456','Maple Avenue','Townsville','Stateland',54321),
(67,'456','Service Avenue','Service City','Service State',67890),
(68,'88','Residential Street','Family Town','Texas',78901),
(69,'321','Supplier Avenue','Commerce City','New York',10001),
(70,'90','Mountain View','Denver','CO',80201);

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `website` varchar(100) DEFAULT NULL,
  `gst` varchar(25) DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  PRIMARY KEY (`company_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `company_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `company` */

insert  into `company`(`company_id`,`company_name`,`type`,`website`,`gst`,`address_id`) values 
(1,'Tech Solutions Inc.','Software Development','www.techsolutions.com','ABC123GST',1),
(2,'SuperMart','Retail','www.supermart.com','XYZ456GST',2),
(3,'BuildWell Constructions','Construction','www.buildwellconstructions.com','DEF789GST',3),
(4,'Expert Consultants','Consulting','www.expertconsultants.com','GHI101GST',4),
(5,'Innovative Technologies','Technology','www.innovativetechnologies.com','JKL111GST',5),
(6,'Precision Manufacturing','Manufacturing','www.precisionmanufacturing.com','MNO222GST',6),
(7,'eShopNow','E-commerce','www.eshopnow.com','PQR333GST',7),
(8,'PharmaCure','Pharmaceutical','http://www.pharmacure.com','STU444GST',8),
(9,'MoneyWise Financials','Financial Services','www.moneywisefinancials.com','VWX555GST',9),
(10,'Grand Hotel Group','Hospitality','www.grandhotelgroup.com','YZA666GST',10),
(11,'ABC Corporation','Retail','www.abc-corp.com','ABC123456789',51),
(12,'XYZ Tech Solutions','Technology','www.xyztech.com','XYZ987654321',52),
(13,'EFG Services','Services','www.efg-services.com','EFG654321987',53),
(14,'PQR Consulting','Consulting','www.pqr-consulting.com','PQR789321456',54),
(15,'123 Manufacturing','Manufacturing','www.123mfg.com','MFG456123789',55),
(16,'LMN Food Industries','Food','www.lmnfoods.com','LMN321789654',56),
(17,'GH Fashion','Retail','www.ghi-fashion.com','GHI987654321',57),
(18,'MNO Software Solutions','Technology','www.mno-software.com','MNO654321987',58),
(19,'RST Electronics','Electronics','www.rst-electronics.com','RST321789654',59),
(20,'UVW Logistics','Logistics','www.uvw-logistics.com','UVW789321456',60),
(21,'EFG Services','Services','www.efg-services.com','EFG654321987',67);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `display_name` varchar(100) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `address_id` (`address_id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer` */

insert  into `customer`(`customer_id`,`first_name`,`last_name`,`display_name`,`dob`,`age`,`email`,`phone_number`,`address_id`,`store_id`) values 
(1,'John','Doe','JohnDoe','1990-01-15',31,'john.doe@example.com','+1 (123) 456-7890',41,1),
(2,'Alice','Smith','AliceSmith','1985-03-20',36,'alice.smith@example.com','+1 (987) 654-3210',42,3),
(3,'Bob','Johnson','BobJohnson','1995-06-10',26,'bob.johnson@example.com','+1 (555) 123-4567',43,5),
(4,'Emily','Williams','EmilyWilliams','1988-12-05',33,'emily.williams@example.com','+1 (999) 888-7777',44,7),
(5,'Michael','Brown','MichaelBrown','1992-04-25',29,'michael.brown@example.com','+1 (111) 222-3333',45,9),
(6,'Sarah','Davis','SarahDavis','1999-07-02',24,'sarah.davis@example.com','+1 (444) 555-6666',46,11),
(7,'David','Matthew','DavidMiller','1996-08-21',30,'david.miller@example.com','+1 (777) 888-9999',47,13),
(8,'Emma','Wilson','EmmaWilson','1987-11-08',34,'emma.wilson@example.com','+1 (222) 333-4444',48,15),
(9,'James','Anderson','JamesAnderson','1993-02-18',28,'james.anderson@example.com','+1 (666) 777-8888',49,17),
(10,'Olivia','Taylor','OliviaTaylor','1996-10-30',27,'olivia.taylor@example.com','+1 (888) 999-0000',50,19),
(11,'Peter','Maguire','JamesAnderson','1993-02-18',28,'james.anderson@example.com','+1 (666) 777-8888',70,17);

/*Table structure for table `purchase_invoice` */

DROP TABLE IF EXISTS `purchase_invoice`;

CREATE TABLE `purchase_invoice` (
  `purchase_invoice_id` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `purchase_date` varchar(10) DEFAULT NULL,
  `purchase_invoice_no` varchar(50) DEFAULT NULL,
  `supplier_invoice_no` varchar(50) DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  PRIMARY KEY (`purchase_invoice_id`),
  KEY `company_id` (`company_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `purchase_invoice_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `purchase_invoice_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `purchase_invoice` */

insert  into `purchase_invoice`(`purchase_invoice_id`,`amount`,`purchase_date`,`purchase_invoice_no`,`supplier_invoice_no`,`company_id`,`supplier_id`) values 
(1,1700,'2023-08-01','INV001','SUPINV001',1,1),
(2,2000,'2023-08-02','INV002','SUPINV002',2,2),
(3,2200,'2023-08-03','INV003','SUPINV003',3,3),
(4,1500,'2023-08-04','INV004','SUPINV004',4,4),
(5,1800,'2023-08-05','INV005','SUPINV005',5,5),
(6,1900,'2023-08-06','INV006','SUPINV006',6,6),
(7,2100,'2023-08-07','INV007','SUPINV007',7,7),
(8,1600,'2023-08-08','INV008','SUPINV008',8,8),
(9,1300,'2023-08-09','INV009','SUPINV009',9,9),
(10,2400,'2023-08-10','INV010','SUPINV010',10,10),
(11,1500,'2023-08-11','INV011','SUPINV011',1,11),
(12,2200,'2023-08-12','INV012','SUPINV012',2,12),
(13,1800,'2023-08-13','INV013','SUPINV013',3,13),
(14,1300,'2023-08-14','INV014','SUPINV014',4,14),
(15,1900,'2023-08-15','INV015','SUPINV015',5,15),
(16,2500,'2023-08-16','INV016','SUPINV016',6,16),
(17,2100,'2023-08-17','INV017','SUPINV017',7,17),
(18,1700,'2023-08-18','INV018','SUPINV018',8,18),
(19,1400,'2023-08-19','INV019','SUPINV019',9,19),
(20,2300,'2023-08-21','INV020','SUPINV020',10,20),
(24,1000,'2023-08-05','INV-2023-001','SUPP-INV-001',1,5),
(25,2500,'2023-08-16','INV016','SUPINV016',6,16);

/*Table structure for table `purchase_invoice_items` */

DROP TABLE IF EXISTS `purchase_invoice_items`;

CREATE TABLE `purchase_invoice_items` (
  `purchase_invoice_items_id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `stock_item_id` int DEFAULT NULL,
  `purchase_invoice_id` int DEFAULT NULL,
  PRIMARY KEY (`purchase_invoice_items_id`),
  KEY `store_id` (`store_id`),
  KEY `stock_item_id` (`stock_item_id`),
  KEY `purchase_invoice_id` (`purchase_invoice_id`),
  CONSTRAINT `purchase_invoice_items_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`),
  CONSTRAINT `purchase_invoice_items_ibfk_2` FOREIGN KEY (`stock_item_id`) REFERENCES `stock_item` (`stock_item_id`),
  CONSTRAINT `purchase_invoice_items_ibfk_3` FOREIGN KEY (`purchase_invoice_id`) REFERENCES `purchase_invoice` (`purchase_invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `purchase_invoice_items` */

insert  into `purchase_invoice_items`(`purchase_invoice_items_id`,`quantity`,`amount`,`store_id`,`stock_item_id`,`purchase_invoice_id`) values 
(1,10,100,1,1,1),
(2,5,50,2,2,1),
(3,12,180,4,4,2),
(4,15,300,5,5,3),
(5,20,400,6,6,3),
(6,5,100,7,7,4),
(7,10,200,8,8,4),
(8,10,250,9,9,5),
(9,15,350,10,10,5),
(10,8,120,11,11,6),
(11,12,180,12,12,6),
(12,10,300,13,13,7),
(13,20,400,14,14,7),
(14,5,120,15,15,8),
(15,15,250,16,16,8),
(16,10,350,17,17,9),
(17,25,450,18,18,9),
(18,12,300,19,19,10),
(19,18,400,20,20,10),
(20,5,50,1,1,11),
(21,10,100,2,2,11),
(22,8,120,3,3,12),
(23,12,180,4,4,12),
(24,15,300,5,5,13),
(25,20,400,6,6,13),
(26,5,100,7,7,14),
(27,10,200,8,8,14),
(28,12,150,9,9,15),
(29,18,225,10,10,15),
(30,10,500,11,11,16),
(31,15,330,12,12,16),
(32,8,160,13,13,17),
(33,12,240,14,14,17),
(34,10,250,15,15,18),
(35,15,375,16,16,18),
(36,8,180,17,17,19),
(37,12,270,18,18,19),
(38,10,300,19,19,20),
(39,18,540,20,20,20);

/*Table structure for table `purchase_order` */

DROP TABLE IF EXISTS `purchase_order`;

CREATE TABLE `purchase_order` (
  `purchase_order_id` int NOT NULL AUTO_INCREMENT,
  `total_amount` double DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  PRIMARY KEY (`purchase_order_id`),
  KEY `store_id` (`store_id`),
  KEY `company_id` (`company_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `purchase_order_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`),
  CONSTRAINT `purchase_order_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `purchase_order_ibfk_3` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `purchase_order` */

insert  into `purchase_order`(`purchase_order_id`,`total_amount`,`store_id`,`company_id`,`supplier_id`) values 
(1,500,1,1,11),
(2,1500,1,1,1),
(3,1200,3,3,13),
(4,600,4,4,14),
(5,900,5,5,15),
(6,850,6,6,16),
(7,1100,7,7,17),
(8,480,8,8,18),
(9,700,9,9,19),
(10,620,10,10,20),
(13,1100,7,7,17);

/*Table structure for table `purchase_order_items` */

DROP TABLE IF EXISTS `purchase_order_items`;

CREATE TABLE `purchase_order_items` (
  `purchase_order_items_id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `stock_item_id` int DEFAULT NULL,
  `purchase_order_id` int DEFAULT NULL,
  PRIMARY KEY (`purchase_order_items_id`),
  KEY `store_id` (`store_id`),
  KEY `stock_item_id` (`stock_item_id`),
  KEY `purchase_order_id` (`purchase_order_id`),
  CONSTRAINT `purchase_order_items_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`),
  CONSTRAINT `purchase_order_items_ibfk_2` FOREIGN KEY (`stock_item_id`) REFERENCES `stock_item` (`stock_item_id`),
  CONSTRAINT `purchase_order_items_ibfk_3` FOREIGN KEY (`purchase_order_id`) REFERENCES `purchase_order` (`purchase_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `purchase_order_items` */

insert  into `purchase_order_items`(`purchase_order_items_id`,`quantity`,`store_id`,`stock_item_id`,`purchase_order_id`) values 
(1,50,1,1,1),
(2,30,1,2,1),
(3,25,2,3,2),
(4,40,2,4,2),
(5,70,3,5,3),
(6,90,3,6,3),
(7,60,4,7,4),
(8,35,4,8,4),
(9,45,5,9,5),
(10,50,5,10,5),
(11,40,6,11,6),
(12,30,6,12,6),
(13,50,7,13,7),
(14,60,7,14,7),
(15,80,8,15,8),
(16,70,8,16,8),
(17,65,9,17,9),
(18,55,9,18,9),
(19,75,10,19,10),
(20,40,10,20,10);

/*Table structure for table `sales_invoice` */

DROP TABLE IF EXISTS `sales_invoice`;

CREATE TABLE `sales_invoice` (
  `sales_invoice_id` int NOT NULL AUTO_INCREMENT,
  `total_amount` double DEFAULT NULL,
  `sales_date` int DEFAULT NULL,
  `sales_invoice_no` varchar(50) DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`sales_invoice_id`),
  KEY `company_id` (`company_id`),
  KEY `customer_id` (`customer_id`),
  KEY `store_id` (`store_id`),
  CONSTRAINT `sales_invoice_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `sales_invoice_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `sales_invoice_ibfk_3` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sales_invoice` */

insert  into `sales_invoice`(`sales_invoice_id`,`total_amount`,`sales_date`,`sales_invoice_no`,`company_id`,`customer_id`,`store_id`) values 
(1,150.25,20230801,'INV20230801',1,1,1),
(2,250.5,20230802,'INV20230802',2,2,3),
(3,180.75,20230803,'INV20230803',3,3,5),
(4,300,20230804,'INV20230804',4,4,7),
(5,120.8,20230805,'INV20230805',5,5,9),
(6,80.6,20230806,'INV20230806',6,6,11),
(7,350.4,20230807,'INV20230807',7,7,13),
(8,420.2,20230808,'INV20230808',8,8,15),
(9,200.3,20230809,'INV20230809',9,9,17),
(10,180.9,20230811,'INV20230810',10,10,19),
(12,300,20230804,'INV20230804',4,4,7),
(13,420.2,20230808,'INV20230808',8,8,15);

/*Table structure for table `sales_items` */

DROP TABLE IF EXISTS `sales_items`;

CREATE TABLE `sales_items` (
  `sales_items_id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `sales_invoice_id` int DEFAULT NULL,
  PRIMARY KEY (`sales_items_id`),
  KEY `sales_invoice_id` (`sales_invoice_id`),
  CONSTRAINT `sales_items_ibfk_1` FOREIGN KEY (`sales_invoice_id`) REFERENCES `sales_invoice` (`sales_invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `sales_items` */

insert  into `sales_items`(`sales_items_id`,`quantity`,`amount`,`sales_invoice_id`) values 
(1,2,50.25,1),
(2,3,75.5,1),
(3,1,30.5,2),
(4,4,100,2),
(5,2,90.75,3),
(6,5,150,3),
(7,1,60.8,4),
(8,2,40,4),
(9,3,40.6,5),
(10,1,40,5),
(11,2,70.4,6),
(12,2,10.2,6),
(13,3,80.2,7),
(14,2,90,7),
(15,1,60.3,8),
(16,3,80,8),
(17,2,40.9,9),
(18,1,100,9),
(19,3,10.8,10),
(20,4,30,10);

/*Table structure for table `stock_inventory` */

DROP TABLE IF EXISTS `stock_inventory`;

CREATE TABLE `stock_inventory` (
  `stock_inventory_id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `last_stock_date` varchar(10) DEFAULT NULL,
  `stock_item_id` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `supplier_id` int DEFAULT NULL,
  PRIMARY KEY (`stock_inventory_id`),
  KEY `stock_item_id` (`stock_item_id`),
  KEY `store_id` (`store_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `stock_inventory_ibfk_1` FOREIGN KEY (`stock_item_id`) REFERENCES `stock_item` (`stock_item_id`),
  CONSTRAINT `stock_inventory_ibfk_2` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`),
  CONSTRAINT `stock_inventory_ibfk_3` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `stock_inventory` */

insert  into `stock_inventory`(`stock_inventory_id`,`quantity`,`last_stock_date`,`stock_item_id`,`store_id`,`supplier_id`) values 
(1,100,'2023-08-01',1,1,1),
(2,80,'2023-08-01',2,1,2),
(3,150,'2023-08-01',3,2,3),
(4,120,'2023-08-01',4,2,4),
(5,200,'2023-08-01',5,3,5),
(6,180,'2023-08-01',6,3,6),
(7,90,'2023-08-01',7,4,7),
(8,70,'2023-08-01',8,4,8),
(9,120,'2023-08-01',9,5,9),
(10,100,'2023-08-01',10,5,10),
(11,70,'2023-08-01',11,6,11),
(12,60,'2023-08-01',12,6,12),
(13,100,'2023-08-01',13,7,13),
(14,90,'2023-08-01',14,7,14),
(15,50,'2023-08-01',15,8,15),
(16,40,'2023-08-01',16,8,16),
(17,80,'2023-08-01',17,9,17),
(18,70,'2023-08-01',18,9,18),
(19,110,'2023-08-01',19,10,19),
(20,100,'2023-08-01',20,10,20),
(21,100,'2023-08-01',1,1,11),
(22,50,'2023-08-01',2,1,11),
(23,75,'2023-08-01',3,2,12),
(24,60,'2023-08-01',4,2,12),
(25,200,'2023-08-01',5,3,13),
(27,100,'2023-08-01',6,3,13),
(28,150,'2023-08-01',7,4,14),
(29,80,'2023-08-01',8,4,14),
(30,50,'2023-08-01',9,5,15),
(31,30,'2023-08-01',10,5,15),
(32,80,'2023-08-02',11,6,16),
(33,40,'2023-08-02',12,6,16),
(34,120,'2023-08-02',13,7,17),
(35,60,'2023-08-02',14,7,17),
(36,90,'2023-08-02',15,8,18),
(37,45,'2023-08-02',16,8,18),
(38,60,'2023-08-02',17,9,19),
(39,30,'2023-08-02',18,9,19),
(40,100,'2023-08-02',19,10,20),
(41,50,'2023-08-02',20,10,20),
(47,100,'2023-08-01',13,7,13);

/*Table structure for table `stock_item` */

DROP TABLE IF EXISTS `stock_item`;

CREATE TABLE `stock_item` (
  `stock_item_id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(100) DEFAULT NULL,
  `item_type` varchar(50) DEFAULT NULL,
  `brand_name` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `mfd` varchar(10) DEFAULT NULL,
  `exd` varchar(10) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  PRIMARY KEY (`stock_item_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `stock_item_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `stock_item` */

insert  into `stock_item`(`stock_item_id`,`item_name`,`item_type`,`brand_name`,`price`,`mfd`,`exd`,`DESCRIPTION`,`company_id`) values 
(1,'Laptop','Electronics','TechMax',1200,'2023-01-15','2026-01-15','High-performance laptop',1),
(2,'Smartphone','Electronics','GadgetTech',700,'2023-03-20','2026-03-20','Flagship smartphone model',1),
(3,'Toothpaste','Personal Care','DentalFresh',2.5,'2023-05-10','2024-12-10','Mint-flavored toothpaste',2),
(4,'Shampoo','Personal Care','SilkyLocks',5,'2023-04-22','2025-04-22','Moisturizing shampoo',2),
(5,'Cement','Construction-Material','BuildStrong',50,'2022-11-05','2025-11-05','High-quality cement',3),
(6,'Paint','Construction Material','ColorSplash',25,'2023-02-12','2024-02-12','Interior paint',3),
(7,'Business Consultation','Service','ExpertAdvice',250,'2023-07-01','2023-12-31','Professional business consultation',4),
(8,'Legal Advisory','Service','LegalEagle',150,'2023-08-05','2024-08-05','Legal advice and support',4),
(9,'Wireless Earbuds','Electronics','SoundBeats',80,'2023-06-15','2025-06-15','Noise-canceling earbuds',5),
(10,'Smart Watch','Electronics','TechWear',150,'2023-07-20','2025-07-20','Fitness tracking smartwatch',5),
(11,'Metal Plates','Raw Material','MetalTech',35,'2023-06-10','2025-06-10','High-quality metal plates',6),
(12,'Screws','Hardware','FastFix',2.5,'2023-07-15','2025-07-15','Assorted screws for construction',6),
(13,'Wireless Mouse','Electronics','TechMouse',20,'2023-08-20','2025-08-20','Ergonomic wireless mouse',7),
(14,'External Hard Drive','Electronics','DataVault',100,'2023-09-25','2025-09-25','Portable external storage',7),
(15,'Pain Relief Gel','Medicine','PainEase',15,'2023-10-01','2025-10-01','Fast-acting pain relief gel',8),
(16,'Cold & Flu Tablets','Medicine','ColdCure',8.5,'2023-11-05','2025-11-05','Effective cold and flu relief',8),
(17,'Investment Guide','Book','FinanceBook',25,'2023-12-10','2025-12-10','Comprehensive investment guide',9),
(18,'Retirement Planning Service','Service','RetireWise',300,'2023-12-20','2024-12-20','Personalized retirement planning',9),
(19,'Luxury Suite','Accommodation','GrandSuite',1000,'2024-01-05','2025-01-05','Spacious and elegant suite',10),
(20,'Fine Dining Experience','Hospitality','GourmetDine',100,'2024-02-10','2025-02-10','Gourmet dining at its best',10),
(21,'Smartphone','Electronics','ABC Tech',499.99,'2023-08-04','2024-08-04','A high-end smartphone with advanced features.',1),
(24,'Cold & Flu Tablets','Medicine','ColdCure',8.5,'2023-11-05','2025-11-05','Effective cold and flu relief',8);

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `store_id` int NOT NULL AUTO_INCREMENT,
  `store_name` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  PRIMARY KEY (`store_id`),
  KEY `company_id` (`company_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `store_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `store_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `store` */

insert  into `store`(`store_id`,`store_name`,`branch`,`company_id`,`address_id`) values 
(1,'Tech Solutions - NYC','Main Branch',1,1),
(2,'Tech Solutions - CA','Tech Park Branch',1,11),
(3,'SuperMart - SF','Downtown Branch',2,2),
(4,'SuperMart - NY','City Center Branch',2,12),
(5,'BuildWell - Rural Town','Main Office',3,3),
(6,'BuildWell-TX','Suburb Outlet',3,13),
(7,'Expert Consultants - BC','Corporate Branch',4,4),
(8,'Expert Consultants - WA','Tech Hub Branch',4,14),
(9,'Innovative Tech - CC','Campus Branch',5,5),
(10,'Innovative Tech - HI','Tourist Area Outlet',5,15),
(11,'Precision Manufacturing - IA','Factory Outlet',6,6),
(12,'Precision Manufacturing - CA','Commercial Branch',6,16),
(13,'eShopNow - SC','Mall Outlet',7,7),
(14,'eShopNow - TX','Residential Branch',7,17),
(15,'PharmaCure - Landmark','Research Center',8,8),
(16,'PharmaCure - WA','City Outlet',8,18),
(17,'MoneyWise - Metropolis','City Center Branch',9,9),
(18,'MoneyWise - HI','Tourist Central Branch',9,19),
(19,'Grand Hotel - Paradise','Beachfront Resort',10,10),
(20,'Grand Hotel - CA','Business Park Resort',10,20),
(21,'Store A','Branch 1',11,61),
(26,'Precision Manufacturing - CA','Commercial Branch',6,68);

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `supplier_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  PRIMARY KEY (`supplier_id`),
  KEY `store_id` (`store_id`),
  KEY `company_id` (`company_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `supplier_ibfk_1` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`),
  CONSTRAINT `supplier_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `supplier_ibfk_3` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `supplier` */

insert  into `supplier`(`supplier_id`,`first_name`,`last_name`,`email`,`phone_number`,`store_id`,`company_id`,`address_id`) values 
(1,'John','Doe','john.doe@example.com','123-456-7890',1,NULL,NULL),
(2,'Jane','Doe','jane.doe@example.com','555-987-6543',1,2,22),
(3,'Michael','Johnson','michael.johnson@example.com','777-456-7890',2,3,23),
(4,'Sara','Williams','sara.williams@example.com','777-123-4567',2,4,24),
(5,'Robert','Brown','robert.brown@example.com','999-234-5678',3,5,25),
(6,'Emily','Anderson','emily.anderson@example.com','998-876-5432',3,6,26),
(7,'David','Lee','david.lee@example.com','123-987-6543',4,7,27),
(8,'Olivia','Miller','olivia.miller@example.com','123-234-5678',4,8,28),
(9,'William','Wilson','william.wilson@example.com','321-876-5432',5,9,29),
(10,'Sophia','Harris','sophia.harris@example.com','321-234-5678',5,10,30),
(11,'Michael','Brown','michael.brown@example.com','555-555-5555',6,1,31),
(12,'Emma','Davis','emma.davis@example.com','666-666-6666',6,2,32),
(13,'Daniel','Martin','daniel.martin@example.com','777-777-7777',7,3,33),
(14,'Isabella','Garcia','isabella.garcia@example.com','888-888-8888',7,4,34),
(15,'Ethan','Martinez','ethan.martinez@example.com','999-999-9999',8,5,35),
(16,'Ava','Robinson','ava.robinson@example.com','111-111-1111',8,6,36),
(17,'Alexander','Clark','alexander.clark@example.com','222-222-2222',9,7,37),
(18,'Mia','Rodriguez','mia.rodriguez@example.com','333-333-3333',9,8,38),
(19,'Benjamin','Lewis','benjamin.lewis@example.com','444-444-4444',10,9,39),
(20,'Abigail','Perez','abigail.perez@example.com','555-555-5555',10,10,40),
(31,'John','Doe','johndoe@example.com','+1 (555) 123-4567',1,1,66),
(35,'Isabella','Garcia','isabella.garcia@example.com','888-888-8888',7,4,69);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
