

-- MariaDB dump 10.17  Distrib 10.4.6-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: nuevo_parqueadero
-- ------------------------------------------------------
-- Server version	10.4.6-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `nuevo_parqueadero`
--
DROP DATABASE  IF EXISTS `nuevo_parqueadero` ;
CREATE DATABASE /*!32312 IF NOT EXISTS*/ `nuevo_parqueadero` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `nuevo_parqueadero`;

--
-- Table structure for table `autos_cancelados`
--

DROP TABLE IF EXISTS `autos_cancelados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autos_cancelados` (
  `Registro` int(11) NOT NULL AUTO_INCREMENT,
  `Placa` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Nombre_Propietario` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Tipo_Vehiculo` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Fecha_Ingreso` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Fecha_Cancelada` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Fecha_Date` date DEFAULT NULL,
  `hora` int(11) DEFAULT NULL,
  `minutos` int(11) DEFAULT NULL,
  `segundos` int(11) DEFAULT NULL,
  PRIMARY KEY (`Registro`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autos_cancelados`
--

LOCK TABLES `autos_cancelados` WRITE;
/*!40000 ALTER TABLE `autos_cancelados` DISABLE KEYS */;
INSERT INTO `autos_cancelados` VALUES (24,'MLP-456','MILENA','Tracktor','04/01/2020   02:58:48 PM','04/01/2020   03:08:40','2020-01-04',15,8,40),(25,'LLL-963','RER','Motocicleta','04/01/2020   02:58:34 PM','04/01/2020   03:08:45','2020-01-04',15,8,45),(26,'CNS-234','SONIA','Tracktor','05/01/2020   12:24:57 AM','05/01/2020   12:25:42','2020-01-05',0,25,42),(27,'DFG-134','ALEJANDRA','Cuadron','05/01/2020   12:24:37 AM','05/01/2020   12:28:16','2020-01-05',0,28,16),(28,'KLO-964','KARIJK','Motocicleta','04/01/2020   02:58:25 PM','05/01/2020   01:18:39','2020-01-05',1,18,39),(30,'QOL-914','RAMIRO','Motocicleta','04/01/2020   02:57:51 PM','05/01/2020   01:18:48','2020-01-05',1,18,48),(31,'FIO-965','FIORELLA','Motocicleta','30/12/2019   11:04:00 AM','05/01/2020   01:18:54','2020-01-05',1,18,54),(33,'REV-123','RODRIGO','Tracktor','06/01/2020   11:50:01 AM','06/01/2020   11:57:18','2020-01-06',11,57,18),(34,'FFF-635','PEDRIRES','Tracktor','06/01/2020   04:29:59 PM','07/01/2020   10:47:48','2020-01-07',10,47,48),(35,'LOP-894','WILMER','Motocicleta','08/01/2020   12:05:09 PM','08/01/2020   12:14:26','2020-01-08',12,14,26),(36,'JMS-123','JULLEYDY','Bicicleta','14/01/2020   02:15:07 PM','14/01/2020   02:24:22','2020-01-14',14,24,22),(37,'ZXÑ-675','RRTE','Tracktor','25/01/2020   01:33:55 PM','25/01/2020   01:37:44','2020-01-25',13,37,44),(38,'VVV-963','VASQUES','Camión','25/01/2020   01:33:36 PM','28/01/2020   02:03:44','2020-01-28',14,3,44),(39,'CCC-454','PEDRO','Camión','04/02/2020   10:24:40 PM','04/02/2020   10:27:27','2020-02-04',22,27,27);
/*!40000 ALTER TABLE `autos_cancelados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colores`
--

DROP TABLE IF EXISTS `colores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colores` (
  `Nombre_Color` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Rojo` int(11) NOT NULL,
  `Verde` int(11) NOT NULL,
  `Azul` int(11) NOT NULL,
  PRIMARY KEY (`Nombre_Color`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colores`
--

LOCK TABLES `colores` WRITE;
/*!40000 ALTER TABLE `colores` DISABLE KEYS */;
INSERT INTO `colores` VALUES ('Aceituna',128,128,0),('Amarillo',255,255,0),('Azul',0,0,255),('Azul claro',135,206,250),('Beige',245,245,220),('Blanco',255,255,255),('Brown',165,42,42),('Chocolate',210,105,30),('Cian',0,255,255),('Crimson',220,20,60),('Darkblue',0,0,139),('Darkgoldenrod',184,134,11),('Darkgray',169,169,169),('Darkhaki',189,183,107),('Darkmagenta',139,0,139),('Darkorange',255,140,0),('Darkred',139,0,0),('Darkturquoise',0,206,209),('Dogerblue',30,144,255),('Firebrick',178,34,34),('Foresgreen',34,139,34),('Gold',255,215,0),('Hotpink',255,105,180),('Khaki',240,230,140),('Maroon',128,0,0),('Marrón',244,164,96),('Morado claro',220,48,171),('Naranja',255,165,0),('Negro',0,0,0),('Orangered',255,69,0),('Predeterminado',60,63,65),('Púrpura',128,0,128),('Rebeccapurple',102,51,153),('Rojo',255,0,0),('Rosado',255,105,180),('Rosybrown',188,143,143),('Royalblue',65,105,225),('Saddlebrown',139,69,19),('Salmón',250,128,114),('Snow',255,250,250),('Turquesa',64,224,208),('Verde',0,255,0),('Verde Claro',88,96,0),('Verde suabe',68,135,116),('Violeta',238,130,238),('Whitesmoke',245,245,245);
/*!40000 ALTER TABLE `colores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colores_nombres_funciones`
--

DROP TABLE IF EXISTS `colores_nombres_funciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colores_nombres_funciones` (
  `ID_FUNCIONES` int(11) NOT NULL AUTO_INCREMENT,
  `TEXTO_MENU` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `TEXTO_SUBMENU` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `TEXTO_EMPRESA` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `FONDO_PANTALLA` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `FONDO_BARRA_MENU` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `FONDO_BARRA_HERRAMIENTAS` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `FONDO_BARRA_ESTADO` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `FONDO_FUN_BTN_HERRAMIENTAS` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `FONDO_FUN_BTN_ESTADO` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `BORDE_HERRAMIENTAS` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `BORDE_ESTADO` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID_FUNCIONES`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colores_nombres_funciones`
--

LOCK TABLES `colores_nombres_funciones` WRITE;
/*!40000 ALTER TABLE `colores_nombres_funciones` DISABLE KEYS */;
INSERT INTO `colores_nombres_funciones` VALUES (1,'Darkgoldenrod','Crimson','Verde Claro','Darkred','Darkgray','Darkred','Darkred','Predeterminado','Beige','Darkred','Darkred');
/*!40000 ALTER TABLE `colores_nombres_funciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_autos_ingresos`
--

DROP TABLE IF EXISTS `tabla_autos_ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabla_autos_ingresos` (
  `ID_INGRESOS` int(11) NOT NULL AUTO_INCREMENT,
  `DATE_REGISTRO` date NOT NULL,
  `FECHA_REGISTRO` datetime NOT NULL,
  `PROPIETARIO` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `PLACA` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TIPO_VEHICULO` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `MOTIVO` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `PRECIO_LAVADO` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `PRECIO_PARQUEO` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `PRECIO_HORA` double NOT NULL,
  `ESTADO` varchar(5) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID_INGRESOS`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_autos_ingresos`
--

LOCK TABLES `tabla_autos_ingresos` WRITE;
/*!40000 ALTER TABLE `tabla_autos_ingresos` DISABLE KEYS */;
INSERT INTO `tabla_autos_ingresos` VALUES (75,'2020-04-13','2020-04-13 15:56:17','JILBERTO','GHJ-345','CAMIONETA','Parqueo','Ninguna','Por definir',4,'NO'),(76,'2020-04-13','2020-04-13 19:41:09','RENE','REN-123','MOTOCICLETA','Parqueo','Ninguna','Por definir',10,'NO'),(77,'2020-04-13','2020-04-13 19:41:21','TERESA','TRE-567','MOTOCICLETA','Lavado','10','Ninguna',10,'NO'),(78,'2020-04-13','2020-04-13 19:41:35','LOLIANA','LOI-345','MOTOCICLETA','Lavado + Parqueo','5','Por definir',10,'NO'),(80,'2020-04-13','2020-04-13 19:41:56','HELSINKI','HJKL-456','MOTOCICLETA','Lavado','3','Ninguna',10,'NO'),(81,'2020-04-13','2020-04-13 19:42:05','KAREN','LOK-123','MOTOCICLETA','Parqueo','Ninguna','Por definir',10,'NO'),(82,'2020-04-14','2020-04-14 09:33:32','LERM','SD-567','BUS','Parqueo','Ninguna','Por definir',7,'NO');
/*!40000 ALTER TABLE `tabla_autos_ingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_autos_salidos`
--

DROP TABLE IF EXISTS `tabla_autos_salidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabla_autos_salidos` (
  `ID_REGISTRO` int(11) NOT NULL AUTO_INCREMENT,
  `SALIDA_DATE` date NOT NULL,
  `FECHA_INGRESO` datetime NOT NULL,
  `FECHA_SALIDA` datetime NOT NULL,
  `PLACA` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `TIPO_VEHICULO` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `PRECIO_HORA` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TOTAL_HORAS` int(11) NOT NULL,
  `TOTAL_MINUTOS` int(11) NOT NULL,
  `COBRADO` double NOT NULL,
  PRIMARY KEY (`ID_REGISTRO`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_autos_salidos`
--

LOCK TABLES `tabla_autos_salidos` WRITE;
/*!40000 ALTER TABLE `tabla_autos_salidos` DISABLE KEYS */;
INSERT INTO `tabla_autos_salidos` VALUES (28,'2020-04-05','2020-04-05 14:35:39','2020-04-05 14:44:45','BGH-456','MOTOCICLETA','10',0,9,10),(29,'2020-04-05','2020-04-05 16:17:35','2020-04-05 18:05:22','HJK-878','MOTOCICLETA','10',1,47,20),(30,'2020-04-05','2020-04-05 18:05:42','2020-04-05 18:06:23','MKL-345','MOTOCICLETA','10',0,0,10),(31,'2020-04-06','2020-04-06 14:31:52','2020-04-06 14:32:20','DER-567','BICICLETA','5',0,0,5),(32,'2020-04-07','2020-04-07 17:29:47','2020-04-07 17:32:05','RUD-234','BUS','7',0,2,7),(33,'2020-04-07','2020-04-07 17:32:22','2020-04-07 19:57:49','RUD-234','BUS','7',2,25,17.5),(34,'2020-04-07','2020-04-07 17:23:52','2020-04-07 21:43:50','LOK-123','BUS','7',4,19,31.5),(35,'2020-04-08','2020-04-08 15:37:33','2020-04-08 19:10:09','YHG-345','CAMION','3',3,32,10.5),(36,'2020-04-10','2020-04-10 13:55:13','2020-04-10 14:15:40','JKI-345','AVION','40',0,20,40),(37,'2020-04-11','2020-04-07 17:27:26','2020-04-11 10:58:40','GTL-234','CAMIONETA','4',89,31,358),(38,'2020-04-11','2020-04-05 18:06:00','2020-04-11 11:08:40','DFM-234','MOTOCICLETA','10',137,2,1372.5),(39,'2020-04-11','2020-04-11 14:04:30','2020-04-11 18:03:57','LOK-67','MOTOCICLETA','10',3,59,40),(40,'2020-04-11','2020-04-11 13:58:24','2020-04-11 18:32:56','REN-123','MOTOCICLETA','10',4,34,45),(41,'2020-04-11','2020-04-11 19:08:34','2020-04-11 19:08:44','PER-567','MOTOCICLETA','10',0,0,10),(42,'2020-04-12','2020-04-12 12:18:19','2020-04-12 12:58:30','TAR-567','MOTOCICLETA','10',0,40,10),(43,'2020-04-12','2020-04-12 12:59:22','2020-04-12 12:59:27','TYU-890','MOTOCICLETA','10',0,0,10),(44,'2020-04-12','2020-04-12 13:03:14','2020-04-12 13:03:25','POL-789','MOTOCICLETA','10',0,0,10),(45,'2020-04-13','2020-04-12 15:14:29','2020-04-13 12:11:34','TUI-345','BUS','7',20,57,147),(46,'2020-04-13','2020-04-13 12:01:28','2020-04-13 12:17:33','HIO-123','MOTOCICLETA','10',0,16,10),(47,'2020-04-14','2020-04-13 19:41:43','2020-04-14 09:34:46','BIN-345','MOTOCICLETA','10',13,53,140);
/*!40000 ALTER TABLE `tabla_autos_salidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_lavado`
--

DROP TABLE IF EXISTS `tabla_lavado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabla_lavado` (
  `ID_LAVADO` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA_DATE` date NOT NULL,
  `FECHA_REGISTRO` datetime NOT NULL,
  `PLACA` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `TIPO_VEHICULO` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `COBRADO` double NOT NULL,
  PRIMARY KEY (`ID_LAVADO`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_lavado`
--

LOCK TABLES `tabla_lavado` WRITE;
/*!40000 ALTER TABLE `tabla_lavado` DISABLE KEYS */;
INSERT INTO `tabla_lavado` VALUES (1,'2020-04-11','2020-04-11 14:04:49','YAN-567','MOTOCICLETA',56),(2,'2020-04-11','2020-04-11 13:59:37','JUA-567','MOTOCICLETA',34),(3,'2020-04-11','2020-04-11 18:35:54','RER-123','MOTOCICLETA',20),(4,'2020-04-11','2020-04-11 19:10:53','REN-123','MOTOCICLETA',45),(5,'2020-04-12','2020-04-12 13:03:47','KIL-567','MOTOCICLETA',20),(6,'2020-04-12','2020-04-12 20:41:49','ASD-123','MOTOCICLETA',10),(7,'2020-04-13','2020-04-13 12:03:14','BNM-567','TRICIMOTO',50),(8,'2020-04-13','2020-04-13 12:18:12','MOR-123','MOTOCICLETA',80),(9,'2020-04-12','2020-04-12 15:13:54','REN-564','MOTOCICLETA',5);
/*!40000 ALTER TABLE `tabla_lavado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_lavado_mas_parqueo`
--

DROP TABLE IF EXISTS `tabla_lavado_mas_parqueo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabla_lavado_mas_parqueo` (
  `ID_REGISTRO` int(11) NOT NULL AUTO_INCREMENT,
  `SALIDA_DATE` date NOT NULL,
  `FECHA_INGRESO` datetime NOT NULL,
  `FECHA_SALIDA` datetime NOT NULL,
  `PLACA` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `TIPO_VEHICULO` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `PRECIO_HORA` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TOTAL_HORAS` int(11) NOT NULL,
  `TOTAL_MINUTOS` int(11) NOT NULL,
  `COBRADO_PARQUEO` double NOT NULL,
  `COBRADO_LAVADO` double NOT NULL,
  `COBRADO` double NOT NULL,
  PRIMARY KEY (`ID_REGISTRO`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_lavado_mas_parqueo`
--

LOCK TABLES `tabla_lavado_mas_parqueo` WRITE;
/*!40000 ALTER TABLE `tabla_lavado_mas_parqueo` DISABLE KEYS */;
INSERT INTO `tabla_lavado_mas_parqueo` VALUES (39,'2020-04-11','2020-04-11 14:00:35','2020-04-11 18:01:05','FRT-567','MOTOCICLETA','10',4,0,42.5,45,87.5),(40,'2020-04-11','2020-04-11 18:42:45','2020-04-11 18:43:12','YUI-678','MOTOCICLETA','10',0,0,10,56,66),(41,'2020-04-11','2020-04-11 19:13:58','2020-04-11 22:42:11','LOL-123','MOTOCICLETA','10',3,28,35,23,58),(42,'2020-04-12','2020-04-12 13:04:24','2020-04-12 13:04:33','MIA-345','MOTOCICLETA','10',0,0,10,89,99),(43,'2020-04-13','2020-04-11 19:26:16','2020-04-13 12:11:27','GUI-123','BUS','7',40,45,287,30,317),(44,'2020-04-13','2020-04-13 12:12:59','2020-04-13 12:13:05','JUK-899','MOTOCICLETA','10',0,0,10,67,77);
/*!40000 ALTER TABLE `tabla_lavado_mas_parqueo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_sistema`
--

DROP TABLE IF EXISTS `tabla_sistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabla_sistema` (
  `ID_NOMBRE` int(11) NOT NULL AUTO_INCREMENT,
  `MENU_INICIO` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `MENU_FUNCIONES` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `MENU_CONFIGURACION` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `MENU_SISTEMA` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `MENU_RESPALDOS` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TITULO` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `LETRA_FAMILIA` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ESTILO` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `TAMANO` int(11) NOT NULL,
  PRIMARY KEY (`ID_NOMBRE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_sistema`
--

LOCK TABLES `tabla_sistema` WRITE;
/*!40000 ALTER TABLE `tabla_sistema` DISABLE KEYS */;
INSERT INTO `tabla_sistema` VALUES (1,'Inicio','Funciones','Configuración','Sistema','Documentos','Parking','Arial Black','Normal',18);
/*!40000 ALTER TABLE `tabla_sistema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_tipo_vehiculos`
--

DROP TABLE IF EXISTS `tabla_tipo_vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabla_tipo_vehiculos` (
  `ID_TIPO_VEHICULO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `PRECIO_HORA` double NOT NULL,
  PRIMARY KEY (`ID_TIPO_VEHICULO`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_tipo_vehiculos`
--

LOCK TABLES `tabla_tipo_vehiculos` WRITE;
/*!40000 ALTER TABLE `tabla_tipo_vehiculos` DISABLE KEYS */;
INSERT INTO `tabla_tipo_vehiculos` VALUES (1,'MOTOCICLETA',10),(2,'CAMION',15),(6,'BICICLETA',2),(7,'BUS',7),(8,'TRICIMOTO',7),(9,'CAMIONETA',4),(14,'AVION',40);
/*!40000 ALTER TABLE `tabla_tipo_vehiculos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_usuarios`
--

DROP TABLE IF EXISTS `tabla_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabla_usuarios` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `CEDULA` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `NOMBRE` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `CUENTA` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `CONTRASENA` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `TIPO_CUENTA` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_usuarios`
--

LOCK TABLES `tabla_usuarios` WRITE;
/*!40000 ALTER TABLE `tabla_usuarios` DISABLE KEYS */;
INSERT INTO `tabla_usuarios` VALUES (4,'1723774640','pedro','pedrojuan123','losmasvacanes1234','Admin'),(5,'0910454925','SANTOS','santos2020','santoschamba2020','Empleado');
/*!40000 ALTER TABLE `tabla_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-14 23:36:31
