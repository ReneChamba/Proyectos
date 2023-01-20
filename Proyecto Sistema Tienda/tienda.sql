DROP DATABASE IF EXISTS proyecto_tienda;
CREATE DATABASE  proyecto_tienda;
USE proyecto_tienda;

-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto_tienda
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `colores`
--

DROP TABLE IF EXISTS `colores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colores` (
  `Nombre_Color` text COLLATE utf8_unicode_ci,
  `Rojo` int(11) DEFAULT NULL,
  `Verde` int(11) DEFAULT NULL,
  `Azul` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colores`
--

LOCK TABLES `colores` WRITE;
/*!40000 ALTER TABLE `colores` DISABLE KEYS */;
INSERT INTO `colores` VALUES ('Aceituna',128,128,0),('Amarillo',255,255,0),('Azul',0,0,255),('Azul claro',135,206,250),('Beige',245,245,220),('Blanco',255,255,255),('Chocolate',210,105,30),('Cian',0,255,255),('Marrón',244,164,96),('Morado claro',220,48,171),('Naranja',255,165,0),('Negro',0,0,0),('Púrpura',128,0,128),('Rojo',255,0,0),('Rosado',255,105,180),('Salmón',250,128,114),('Turquesa',64,224,208),('Verde',0,255,0),('Verde Claro',88,96,0),('Verde suabe',68,135,116),('Violeta',238,130,238),('THISTLE',216,191,216),('DARKKHAKI',189,183,107),('KHAKI',240,230,140),('MOCCASIN',255,228,181),('GOLD',255,215,0),('TOMATO',255,99,71),('CORAL',255,127,80),('INDIANRED',205,92,92),('DARKBLUE',72,61,139),('FORESTGREEN',34,139,34),('AQUAMARINE',127,255,212),('DEEPSKYBLUE',0,191,255),('TAN',210,180,140),('ROSYBROWN',188,143,143),('MISTYROSE',255,228,225),('DARKSLATEGRAY',47,79,79);
/*!40000 ALTER TABLE `colores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta_usuarios`
--

DROP TABLE IF EXISTS `cuenta_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta_usuarios` (
  `ID_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `CEDULA` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NOMBRE` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `APELLIDO` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CORREO` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TIPO_CUENTA` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `USUARIO` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CONTRASENA` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ESTADO` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta_usuarios`
--

LOCK TABLES `cuenta_usuarios` WRITE;
/*!40000 ALTER TABLE `cuenta_usuarios` DISABLE KEYS */;
INSERT INTO `cuenta_usuarios` VALUES (5,'0910454925','santos','chamba','santosjusto@gmail.com','Administrador','santoschamba2019','santoschamba2019','AC'),(6,'1723774640','ronny','chamba','ronnychamba96@gmail.com','Empleado','ronnyrene2020','losmaspepas2020','AC');
/*!40000 ALTER TABLE `cuenta_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nombre_funciones`
--

DROP TABLE IF EXISTS `nombre_funciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nombre_funciones` (
  `ID_FUNCIONES` int(11) NOT NULL AUTO_INCREMENT,
  `COLOR_ITEMS_PADRE` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `COLOR_ITEMS_HIJOS` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `COLOR_FONDO` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `COLOR_BARRA` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ESTADO` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID_FUNCIONES`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nombre_funciones`
--

LOCK TABLES `nombre_funciones` WRITE;
/*!40000 ALTER TABLE `nombre_funciones` DISABLE KEYS */;
INSERT INTO `nombre_funciones` VALUES (1,'Negro','Negro','Negro','Negro','DESACTIVADO'),(2,'TOMATO','Negro','Marrón','Beige','ACTIVADO');
/*!40000 ALTER TABLE `nombre_funciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor_categoria`
--

DROP TABLE IF EXISTS `proveedor_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor_categoria` (
  `ID_PROVEDO_CATEGORIA` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORIA` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'DESCONOCIDO',
  `PROVEEDOR` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'DESCONOCIDO',
  PRIMARY KEY (`ID_PROVEDO_CATEGORIA`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor_categoria`
--

LOCK TABLES `proveedor_categoria` WRITE;
/*!40000 ALTER TABLE `proveedor_categoria` DISABLE KEYS */;
INSERT INTO `proveedor_categoria` VALUES (49,'ALCOHOL','DESCONOCIDO'),(50,'VIVERES','DESCONOCIDO'),(51,'GRANOS','DESCONOCIDO'),(52,'HOGAR','DESCONOCIDO'),(53,'DESCONOCIDO','PILSENER'),(54,'DESCONOCIDO','HAGIS'),(55,'DESCONOCIDO','PEPSI'),(56,'DESCONOCIDO','COCA COLA'),(57,'GASEOSAS','DESCONOCIDO'),(58,'LIBRERIA','DESCONOCIDO'),(59,'DESCONOCIDO','PURO SA'),(60,'DESCONOCIDO','MANABI'),(61,'DESCONOCIDO','FID_CAYEMBE'),(62,'DESCONOCIDO','HOLGIN'),(63,'ASEO','DESCONOCIDO'),(64,'DESCONOCIDO','FAMILIA'),(65,'EMBUTIDOS','DESCONOCIDO');
/*!40000 ALTER TABLE `proveedor_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restablecer`
--

DROP TABLE IF EXISTS `restablecer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restablecer` (
  `ID_SISTEMA` int(11) NOT NULL AUTO_INCREMENT,
  `TITULO` varchar(80) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `INICIO` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TIENDA` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CONFIGURACION` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ESTADISTICA` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ESTADO` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID_SISTEMA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restablecer`
--

LOCK TABLES `restablecer` WRITE;
/*!40000 ALTER TABLE `restablecer` DISABLE KEYS */;
INSERT INTO `restablecer` VALUES (1,'SISTEMA DE VENTAS','Inicio','Tienda','Configuración','Estadísticas','ACTIVO'),(2,'PROYECTO RONNY','EMPESAR','ABARROTES','CONFIGURAR','GRAFICOS','DESACTIVADO');
/*!40000 ALTER TABLE `restablecer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_clientes`
--

DROP TABLE IF EXISTS `tabla_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_clientes` (
  `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NOMBRE` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CEDULA` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CELULAR` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SALDO_PENDIENTE` double NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_clientes`
--

LOCK TABLES `tabla_clientes` WRITE;
/*!40000 ALTER TABLE `tabla_clientes` DISABLE KEYS */;
INSERT INTO `tabla_clientes` VALUES (2,'CLI:0189','RONNY','1723774640','0981806210',26.75);
/*!40000 ALTER TABLE `tabla_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_codigo`
--

DROP TABLE IF EXISTS `tabla_codigo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_codigo` (
  `ID_CODIGO` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CODIGO_PROVEEDOR` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CODIGO_CLIENTE` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NUMERO` int(11) NOT NULL,
  PRIMARY KEY (`ID_CODIGO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_codigo`
--

LOCK TABLES `tabla_codigo` WRITE;
/*!40000 ALTER TABLE `tabla_codigo` DISABLE KEYS */;
INSERT INTO `tabla_codigo` VALUES (1,'COD:0','PROVE:0','CLI:0',195);
/*!40000 ALTER TABLE `tabla_codigo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_listar_venta`
--

DROP TABLE IF EXISTS `tabla_listar_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_listar_venta` (
  `ID_LISTA` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO_REGISTRO` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `CODIGO_PROVEEDOR` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `PRODUCTO` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `PRECIO` double NOT NULL,
  `TOTAL` double NOT NULL,
  PRIMARY KEY (`ID_LISTA`)
) ENGINE=InnoDB AUTO_INCREMENT=203 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_listar_venta`
--

LOCK TABLES `tabla_listar_venta` WRITE;
/*!40000 ALTER TABLE `tabla_listar_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_listar_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_nuevo_ingresos`
--

DROP TABLE IF EXISTS `tabla_nuevo_ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_nuevo_ingresos` (
  `ID_INGRESOS` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` date NOT NULL,
  `FECHA_DATE` datetime DEFAULT NULL,
  `CODIGO_PRODUCTO` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `PRODUCTO` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `PRECIO` double NOT NULL,
  `TOTAL` double NOT NULL,
  PRIMARY KEY (`ID_INGRESOS`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_nuevo_ingresos`
--

LOCK TABLES `tabla_nuevo_ingresos` WRITE;
/*!40000 ALTER TABLE `tabla_nuevo_ingresos` DISABLE KEYS */;
INSERT INTO `tabla_nuevo_ingresos` VALUES (143,'2020-03-05','2020-03-05 03:24:39','COD:0186','FRUTARIS',1,1,1),(144,'2020-03-05','2020-03-05 03:25:18','COD:0187','SALCHICHA',1,2,2),(145,'2020-03-05','2020-03-05 03:26:55','COD:0186','FRUTARIS',1,0.75,0.75),(146,'2020-03-05','2020-03-05 03:26:55','COD:0187','SALCHICHA',1,2,2),(147,'2020-03-05','2020-03-05 03:26:55','COD:0186','FRUTARIS',1,0.75,0.75),(148,'2020-03-05','2020-03-05 03:28:07','COD:0187','SALCHICHA',1,2,2),(149,'2020-03-05','2020-03-05 03:28:07','COD:0186','FRUTARIS',1,0.75,0.75),(150,'2020-03-05','2020-03-05 03:28:07','COD:0184','PILSENER LIGTH',1,3,3),(151,'2020-03-05','2020-03-05 03:28:07','COD:0184','PILSENER LIGTH',1,3,3),(152,'2020-03-05','2020-03-05 03:44:56','COD:0184','PILSENER LIGTH',1,3,3),(153,'2020-03-05','2020-03-05 03:44:56','COD:0186','FRUTARIS',1,0.75,0.75),(154,'2020-03-05','2020-03-05 03:44:56','COD:0187','SALCHICHA',1,2,2),(155,'2020-03-05','2020-03-05 04:19:14','COD:0186','FRUTARIS',1,0.75,0.75),(156,'2020-03-05','2020-03-05 04:19:32','COD:0186','FRUTARIS',1,2.5,2.5),(157,'2020-03-05','2020-03-05 04:20:07','COD:0186','FRUTARIS',3,3.5,10.5),(158,'2020-03-05','2020-03-05 04:21:18','COD:0186','FRUTARIS',1,0.75,0.75),(159,'2020-03-05','2020-03-05 04:21:22','COD:0186','FRUTARIS',1,0.75,0.75),(160,'2020-03-20','2020-03-20 01:52:13','COD:0187','SALCHICHA',1,2,2),(161,'2020-03-20','2020-03-20 01:52:33','COD:0184','PILSENER LIGTH',1,3,3),(162,'2020-03-20','2020-03-20 01:52:33','COD:0186','FRUTARIS',1,0.75,0.75),(163,'2020-03-20','2020-03-20 01:52:33','COD:0187','SALCHICHA',1,2,2),(164,'2020-03-20','2020-03-20 01:53:23','COD:0186','FRUTARIS',1,0.75,0.75),(165,'2020-03-20','2020-03-20 01:53:23','COD:0187','SALCHICHA',1,2,2),(166,'2020-03-20','2020-03-20 01:53:23','COD:0187','SALCHICHA',1,2,2),(167,'2020-03-20','2020-03-20 01:53:45','COD:0186','FRUTARIS',1,0.75,0.75),(168,'2020-03-20','2020-03-20 01:53:45','COD:0187','SALCHICHA',1,2,2),(169,'2020-03-27','2020-03-27 05:27:19','COD:0184','PILSENER LIGTH',1,3,3),(170,'2020-03-27','2020-03-27 05:28:12','COD:0187','SALCHICHA',1,2,2),(171,'2020-03-27','2020-03-27 05:28:12','COD:0186','FRUTARIS',1,0.75,0.75),(172,'2020-03-27','2020-03-27 05:28:12','COD:0186','FRUTARIS',1,0.75,0.75);
/*!40000 ALTER TABLE `tabla_nuevo_ingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_productos_proveedores`
--

DROP TABLE IF EXISTS `tabla_productos_proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_productos_proveedores` (
  `ID_PRODUCTOS` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO_PROVEEDOR` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CATEGORIA` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `PRODUCTO` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CODIGO_REGI_PRODUCTO` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `FECHA_REGISTRO` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `PRECIO` double NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `EGRESOS` double NOT NULL,
  `PRODUCTOS_VENDIDOS` int(11) NOT NULL DEFAULT '0',
  `INGRESOS_POR_PROD_VENDIDOS` double NOT NULL DEFAULT '0',
  `GANANCIAS` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID_PRODUCTOS`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_productos_proveedores`
--

LOCK TABLES `tabla_productos_proveedores` WRITE;
/*!40000 ALTER TABLE `tabla_productos_proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_productos_proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_proveedor`
--

DROP TABLE IF EXISTS `tabla_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_proveedor` (
  `ID_PROVEEDOR` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA_REGISTRO` date NOT NULL,
  `CODIGO` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CEDULA` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NOMBRE` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `EMPRESA` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DIRECCION` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `PROVINCIA` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CORREO` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TLF_FIJO` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'DESCONOCIDO',
  `CELULAR` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'DESCONOCIDO',
  PRIMARY KEY (`ID_PROVEEDOR`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_proveedor`
--

LOCK TABLES `tabla_proveedor` WRITE;
/*!40000 ALTER TABLE `tabla_proveedor` DISABLE KEYS */;
INSERT INTO `tabla_proveedor` VALUES (7,'2020-02-13','PROVE:093','1723774640','ronny','coca cola','calle galapagos','Santo Domingo de los Tsáchilas','ronny@gmail.com','4343434','4343434'),(9,'2020-02-13','PROVE:097','423434234234','luis','pronaca','santoss','Santo Domingo de los Tsáchilas','dsvdscsd','42342343','423423432'),(10,'2020-02-16','PROVE:0110','1234567890','rene','pilsener','centro paqrque','Santo Domingo de los Tsáchilas','reneee@gmail.com','3232323232','32323232'),(11,'2020-02-18','PROVE:0117','1234567890','rene','ranchito','la lorena','Santo Domingo de los Tsáchilas','ronny@gamil.com','545343','1234567890');
/*!40000 ALTER TABLE `tabla_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tablas_ventas`
--

DROP TABLE IF EXISTS `tablas_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tablas_ventas` (
  `ID_VENTAS` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DATE` date NOT NULL,
  `CODIGO_REGISTRO` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CATEGORIA` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `PROVEEDOR` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CODIGO_PROVEEDOR` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `PRODUCTO` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `EGRESOS_COMPRAS` double NOT NULL,
  `PRECIO` double NOT NULL,
  `INGRESOS` double NOT NULL,
  `DISPONIBLES` int(11) NOT NULL,
  `GANANCIAS` double NOT NULL,
  PRIMARY KEY (`ID_VENTAS`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablas_ventas`
--

LOCK TABLES `tablas_ventas` WRITE;
/*!40000 ALTER TABLE `tablas_ventas` DISABLE KEYS */;
INSERT INTO `tablas_ventas` VALUES (136,'05/03/2020  03:19:15','2020-03-05','COD:0184','ALCOHOL','pilsener','PROVE:0110','PILSENER LIGTH',24,50,3,15,19,-35),(138,'05/03/2020  03:20:31','2020-03-05','COD:0186','ALCOHOL','coca cola','PROVE:093','FRUTARIS',20,10,0.75,23,3,13),(139,'05/03/2020  03:21:00','2020-03-05','COD:0187','EMBUTIDOS','pronaca','PROVE:097','SALCHICHA',30,20,2,20,20,0),(140,'27/03/2020  05:29:35','2020-03-27','COD:0193','ALCOHOL','pilsener','PROVE:0110','BENETO',20,20,2,0,20,0);
/*!40000 ALTER TABLE `tablas_ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-15 10:59:28
