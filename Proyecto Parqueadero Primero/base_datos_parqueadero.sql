-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-02-2020 a las 04:29:46
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `base_datos_parqueadero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autos_cancelados`
--

CREATE TABLE `autos_cancelados` (
  `Registro` int(11) NOT NULL,
  `Placa` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Nombre_Propietario` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Tipo_Vehiculo` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Fecha_Ingreso` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Fecha_Cancelada` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Fecha_Date` date DEFAULT NULL,
  `hora` int(11) DEFAULT NULL,
  `minutos` int(11) DEFAULT NULL,
  `segundos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `autos_cancelados`
--

INSERT INTO `autos_cancelados` (`Registro`, `Placa`, `Nombre_Propietario`, `Tipo_Vehiculo`, `Fecha_Ingreso`, `Fecha_Cancelada`, `Fecha_Date`, `hora`, `minutos`, `segundos`) VALUES
(24, 'MLP-456', 'MILENA', 'Tracktor', '04/01/2020   02:58:48 PM', '04/01/2020   03:08:40', '2020-01-04', 15, 8, 40),
(25, 'LLL-963', 'RER', 'Motocicleta', '04/01/2020   02:58:34 PM', '04/01/2020   03:08:45', '2020-01-04', 15, 8, 45),
(26, 'CNS-234', 'SONIA', 'Tracktor', '05/01/2020   12:24:57 AM', '05/01/2020   12:25:42', '2020-01-05', 0, 25, 42),
(27, 'DFG-134', 'ALEJANDRA', 'Cuadron', '05/01/2020   12:24:37 AM', '05/01/2020   12:28:16', '2020-01-05', 0, 28, 16),
(28, 'KLO-964', 'KARIJK', 'Motocicleta', '04/01/2020   02:58:25 PM', '05/01/2020   01:18:39', '2020-01-05', 1, 18, 39),
(30, 'QOL-914', 'RAMIRO', 'Motocicleta', '04/01/2020   02:57:51 PM', '05/01/2020   01:18:48', '2020-01-05', 1, 18, 48),
(31, 'FIO-965', 'FIORELLA', 'Motocicleta', '30/12/2019   11:04:00 AM', '05/01/2020   01:18:54', '2020-01-05', 1, 18, 54),
(33, 'REV-123', 'RODRIGO', 'Tracktor', '06/01/2020   11:50:01 AM', '06/01/2020   11:57:18', '2020-01-06', 11, 57, 18),
(34, 'FFF-635', 'PEDRIRES', 'Tracktor', '06/01/2020   04:29:59 PM', '07/01/2020   10:47:48', '2020-01-07', 10, 47, 48),
(35, 'LOP-894', 'WILMER', 'Motocicleta', '08/01/2020   12:05:09 PM', '08/01/2020   12:14:26', '2020-01-08', 12, 14, 26),
(36, 'JMS-123', 'JULLEYDY', 'Bicicleta', '14/01/2020   02:15:07 PM', '14/01/2020   02:24:22', '2020-01-14', 14, 24, 22),
(37, 'ZXÑ-675', 'RRTE', 'Tracktor', '25/01/2020   01:33:55 PM', '25/01/2020   01:37:44', '2020-01-25', 13, 37, 44),
(38, 'VVV-963', 'VASQUES', 'Camión', '25/01/2020   01:33:36 PM', '28/01/2020   02:03:44', '2020-01-28', 14, 3, 44),
(39, 'CCC-454', 'PEDRO', 'Camión', '04/02/2020   10:24:40 PM', '04/02/2020   10:27:27', '2020-02-04', 22, 27, 27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autos_ingreso`
--

CREATE TABLE `autos_ingreso` (
  `Registro` int(11) NOT NULL,
  `Placa` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre_Propietario` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Tipo_Vehiculo` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_Date` date NOT NULL,
  `Fecha_Ingreso` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Agno` int(11) NOT NULL,
  `Mes` int(11) NOT NULL,
  `Dia` int(11) NOT NULL,
  `Hora_Entrada` int(11) NOT NULL,
  `Minutos` int(11) NOT NULL,
  `Segundos` int(11) NOT NULL,
  `Total_Cobrar` double NOT NULL,
  `Pagado` varchar(2) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `autos_ingreso`
--

INSERT INTO `autos_ingreso` (`Registro`, `Placa`, `Nombre_Propietario`, `Tipo_Vehiculo`, `Fecha_Date`, `Fecha_Ingreso`, `Agno`, `Mes`, `Dia`, `Hora_Entrada`, `Minutos`, `Segundos`, `Total_Cobrar`, `Pagado`) VALUES
(52, 'REN-123', 'JUAN', 'Camión', '2020-02-04', '04/02/2020   10:24:31 PM', 2020, 2, 4, 22, 24, 31, 0, 'NO'),
(53, 'PER-123', 'PERT', 'Camión', '2019-12-27', '27/12/2019   11:04:41 AM', 2019, 12, 27, 11, 4, 41, 293, 'SI'),
(54, 'JUN-932', 'RAMDEW', 'Camión', '2019-12-24', '24/12/2019   10:53:46 AM', 2019, 12, 24, 10, 53, 46, 11, 'SI'),
(55, 'REN-789', 'JUAN', 'Motocicleta', '2019-12-22', '22/12/2019   03:32:55 PM', 2019, 12, 22, 15, 32, 55, 1, 'SI'),
(56, 'LLL-963', 'RER', 'Motocicleta', '2020-01-04', '04/01/2020   02:58:34 PM', 2020, 1, 4, 14, 58, 34, 0.1, 'SI'),
(57, 'ZZZ-691', 'LOOSS', 'Motocicleta', '2019-12-29', '29/12/2019   11:35:30 AM', 2019, 12, 29, 11, 35, 30, 98.5, 'SI'),
(58, 'LOP-894', 'WILMER', 'Motocicleta', '2020-01-08', '08/01/2020   12:05:09 PM', 2020, 1, 8, 12, 5, 9, 0.1, 'SI'),
(59, 'QOL-914', 'RAMIRO', 'Motocicleta', '2020-01-08', '08/01/2020   01:46:29 PM', 2020, 1, 8, 13, 46, 29, 0, 'NO'),
(60, 'CCC-454', 'PEDRO', 'Camión', '2020-02-04', '04/02/2020   10:24:40 PM', 2020, 2, 4, 22, 24, 40, 0.1, 'SI'),
(61, 'VVV-963', 'VASQUES', 'Camión', '2020-01-25', '25/01/2020   01:33:36 PM', 2020, 1, 25, 13, 33, 36, 0.1, 'SI'),
(62, 'SSS-693', 'KILLII', 'Trailer', '2020-01-08', '08/01/2020   01:46:22 PM', 2020, 1, 8, 13, 46, 22, 1087.5, 'SI'),
(63, 'AAA-364', 'MAYRA', 'Motocicleta', '2019-12-23', '23/12/2019   09:57:58 PM', 2019, 12, 23, 21, 57, 58, 157.5, 'SI'),
(64, 'TTT-456', 'FARIAS', 'Motocicleta', '2020-01-17', '17/01/2020   03:30:29 PM', 2020, 1, 17, 15, 30, 29, 0, 'NO'),
(65, 'WEE-645', 'MARCOS', 'Tracktor', '2020-01-06', '06/01/2020   04:29:51 PM', 2020, 1, 6, 16, 29, 51, 1839.25, 'SI'),
(66, 'WSE-631', 'LOPESS', 'BUS', '2019-12-24', '24/12/2019   10:54:27 AM', 2019, 12, 24, 10, 54, 27, 486, 'SI'),
(67, 'LKH-961', 'JUANSE', 'Bicicleta', '2019-12-26', '26/12/2019   04:37:31 PM', 2019, 12, 26, 16, 37, 31, 2, 'SI'),
(68, 'XCV-456', 'XAVIER', 'Motocicleta', '2019-12-24', '24/12/2019   03:26:17 PM', 2019, 12, 24, 15, 26, 17, 214.5, 'SI'),
(69, 'BBB-787', 'BILMA', 'Tracktor', '2020-01-04', '04/01/2020   02:58:05 PM', 2020, 1, 4, 14, 58, 5, 2012.5, 'SI'),
(70, 'CNB-154', 'CARLOS', 'Vehiculo Liviano', '2019-12-28', '28/12/2019   10:08:52 AM', 2019, 12, 28, 10, 8, 52, 8.25, 'SI'),
(71, 'FFF-635', 'PEDRIRES', 'Tracktor', '2020-01-06', '06/01/2020   04:29:59 PM', 2020, 1, 6, 16, 29, 59, 0.1, 'SI'),
(72, 'AAR-965', 'SUA', 'BUS', '2019-12-26', '26/12/2019   11:05:05 AM', 2019, 12, 26, 11, 5, 5, 18, 'SI'),
(73, 'SEB-963', 'LOPESS', 'Cuadron', '2019-12-28', '28/12/2019   10:07:46 AM', 2019, 12, 28, 10, 7, 46, 617.5, 'SI'),
(74, 'VBB-369', 'RUIS', 'Cuadron', '2020-01-08', '08/01/2020   09:53:33 PM', 2020, 1, 8, 21, 53, 33, 0, 'NO'),
(75, 'QWE-412', 'KARINA', 'BUS', '2020-01-08', '08/01/2020   01:57:08 PM', 2020, 1, 8, 13, 57, 8, 0, 'NO'),
(76, 'YAN-365', 'WENDI', 'Camión', '2020-01-17', '17/01/2020   03:30:37 PM', 2020, 1, 17, 15, 30, 37, 0, 'NO'),
(77, 'CVB-645', 'CARLOS', 'BUS', '2020-01-25', '25/01/2020   01:33:30 PM', 2020, 1, 25, 13, 33, 30, 326.25, 'SI'),
(78, 'LIM-466', 'RENE', 'BUS', '2019-12-26', '26/12/2019   05:07:21 PM', 2019, 12, 26, 17, 7, 21, 270, 'SI'),
(79, 'CAR-456', 'CARLOS', 'Cuadron', '2019-12-27', '27/12/2019   10:08:24 AM', 2019, 12, 27, 10, 8, 24, 737.5, 'SI'),
(80, 'DEF-789', 'MAY', 'Cuadron', '2020-01-04', '04/01/2020   02:57:38 PM', 2020, 1, 4, 14, 57, 38, 312.5, 'SI'),
(81, 'QUI-789', 'ROBERTO', 'BUS', '2019-12-27', '27/12/2019   10:08:53 AM', 2019, 12, 27, 10, 8, 53, 590, 'SI'),
(82, 'SAD-789', 'SALVADOR', 'Vehiculo Liviano', '2019-12-27', '27/12/2019   11:05:00 AM', 2019, 12, 27, 11, 5, 0, 114.75, 'SI'),
(83, 'FGY-464', 'FARIAS', 'Tracktor', '2019-12-27', '27/12/2019   05:25:26 PM', 2019, 12, 27, 17, 25, 26, 702.5, 'SI'),
(84, 'KLO-964', 'KARIJK', 'Motocicleta', '2020-01-17', '17/01/2020   03:30:47 PM', 2020, 1, 17, 15, 30, 47, 0, 'NO'),
(85, 'PLO-784', 'PALOA', 'BUS', '2019-12-27', '27/12/2019   05:26:00 PM', 2019, 12, 27, 17, 26, 0, 562, 'SI'),
(86, 'SWE-784', 'SANTIS', 'Bicicleta', '2019-12-27', '27/12/2019   05:26:13 PM', 2019, 12, 27, 17, 26, 13, 421.5, 'SI'),
(87, 'MLP-456', 'CARMEN', 'Bicicleta', '2020-01-08', '08/01/2020   01:46:51 PM', 2020, 1, 8, 13, 46, 51, 0, 'NO'),
(88, 'WER-456', 'WEIRO', 'Camión', '2019-12-28', '28/12/2019   05:14:06 PM', 2019, 12, 28, 17, 14, 6, 233, 'SI'),
(89, 'ASD-123', 'GATO', 'Trailer', '2019-12-28', '28/12/2019   05:14:18 PM', 2019, 12, 28, 17, 14, 18, 349.5, 'SI'),
(90, 'PFO-894', 'RENI', 'Camión', '2019-12-28', '28/12/2019   11:28:11 PM', 2019, 12, 28, 23, 28, 11, 221, 'SI'),
(91, 'API-694', 'JUANSEEE', 'Bicicleta', '2019-12-28', '28/12/2019   11:28:26 PM', 2019, 12, 28, 23, 28, 26, 331.5, 'SI'),
(92, 'QPO-364', 'LLANE', 'Trailer', '2019-12-28', '28/12/2019   11:28:43 PM', 2019, 12, 28, 23, 28, 43, 331.5, 'SI'),
(93, 'CIO-165', 'PLATI', 'Trailer', '2019-12-28', '28/12/2019   11:28:57 PM', 2019, 12, 28, 23, 28, 57, 109.5, 'SI'),
(94, 'KOP-964', 'SANTOS', 'BUS', '2019-12-29', '29/12/2019   11:35:06 AM', 2019, 12, 29, 11, 35, 6, 394, 'SI'),
(95, 'QER-451', 'LOPILATO', 'Tracktor', '2019-12-29', '29/12/2019   11:35:23 AM', 2019, 12, 29, 11, 35, 23, 492.5, 'SI'),
(96, 'LPI-454', 'MILLLO', 'Trailer', '2020-01-08', '08/01/2020   09:53:27 PM', 2020, 1, 8, 21, 53, 27, 0, 'NO'),
(97, 'KIL-485', 'RAMIRO', 'Motocicleta', '2019-12-29', '29/12/2019   12:49:28 PM', 2019, 12, 29, 12, 49, 28, 102.5, 'SI'),
(98, 'MLO-457', 'JANDRY', 'Tracktor', '2019-12-29', '29/12/2019   12:49:52 PM', 2019, 12, 29, 12, 49, 52, 485, 'SI'),
(99, 'SQP-457', 'VIVIANA', 'BUS', '2019-12-29', '29/12/2019   12:50:14 PM', 2019, 12, 29, 12, 50, 14, 388, 'SI'),
(100, 'TUI-895', 'SANDROP', 'Tracktor', '2019-12-29', '29/12/2019   07:14:06 PM', 2019, 12, 29, 19, 14, 6, 452.5, 'SI'),
(101, 'LNM-944', 'RITA', 'Cuadron', '2019-12-29', '29/12/2019   07:14:27 PM', 2019, 12, 29, 19, 14, 27, 452.5, 'SI'),
(102, 'PCN-621', 'PLO', 'Motocicleta', '2019-12-29', '29/12/2019   09:45:09 PM', 2019, 12, 29, 21, 45, 9, 93.5, 'SI'),
(103, 'WTY-954', 'YAMI', 'Cuadron', '2019-12-29', '29/12/2019   09:45:24 PM', 2019, 12, 29, 21, 45, 24, 440, 'SI'),
(104, 'FIO-965', 'FIORELLA', 'Motocicleta', '2019-12-30', '30/12/2019   11:04:00 AM', 2019, 12, 30, 11, 4, 0, 0.1, 'SI'),
(105, 'NMB-841', 'NAIROBVI', 'Cuadron', '2020-01-13', '13/01/2020   10:33:54 AM', 2020, 1, 13, 10, 33, 54, 3, 'SI'),
(106, 'GKL-898', 'GONZALES', 'BUS', '2020-01-02', '02/01/2020   01:44:23 PM', 2020, 1, 2, 13, 44, 23, 164, 'SI'),
(107, 'PKL-942', 'EVELYN', 'Tracktor', '2019-12-30', '30/12/2019   11:05:01 AM', 2019, 12, 30, 11, 5, 1, 372.5, 'SI'),
(108, 'XMP-485', 'XAMP', 'Camión', '2019-12-30', '30/12/2019   11:42:34 AM', 2019, 12, 30, 11, 42, 34, 0.1, 'SI'),
(109, 'FKO-894', 'SEBASTIAN', 'Trailer', '2019-12-30', '30/12/2019   11:48:03 AM', 2019, 12, 30, 11, 48, 3, 0.1, 'SI'),
(110, 'HJL-987', 'HUGO', 'Bicicleta', '2020-01-04', '04/01/2020   02:58:18 PM', 2020, 1, 4, 14, 58, 18, 45, 'SI'),
(111, 'KOL-964', 'KARLASS', 'Bicicleta', '2019-12-30', '30/12/2019   11:48:31 AM', 2019, 12, 30, 11, 48, 31, 0.1, 'SI'),
(112, 'BGH-954', 'BRAYAN', 'Bicicleta', '2019-12-30', '30/12/2019   11:49:05 AM', 2019, 12, 30, 11, 49, 5, 222, 'SI'),
(113, 'THJ-454', 'TANIA', 'Bicicleta', '2019-12-30', '30/12/2019   04:23:19 PM', 2019, 12, 30, 16, 23, 19, 0.1, 'SI'),
(114, 'GHJ-456', 'RENE', 'BUS', '2020-01-14', '14/01/2020   02:20:07 PM', 2020, 1, 14, 14, 20, 7, 4.5, 'SI'),
(115, 'SWD-456', 'SANDEI', 'Motocicleta', '2019-12-31', '31/12/2019   02:10:17 PM', 2019, 12, 31, 14, 10, 17, 0, 'SI'),
(116, 'PÑÑ-789', 'PEÑA', 'Camión', '2019-12-31', '31/12/2019   03:04:36 PM', 2019, 12, 31, 15, 4, 36, 5, 'SI'),
(117, 'PFB-454', 'RENE', 'Camión', '2019-12-31', '31/12/2019   05:50:28 PM', 2019, 12, 31, 17, 50, 28, 0.1, 'SI'),
(118, 'BPL-455', 'ROCIO', 'Bicicleta', '2019-12-31', '31/12/2019   06:05:45 PM', 2019, 12, 31, 18, 5, 45, 130.5, 'SI'),
(119, 'DHY-415', 'WISIN', 'Trailer', '2020-01-02', '02/01/2020   01:44:57 PM', 2020, 1, 2, 13, 44, 57, 64.5, 'SI'),
(120, 'GBN-145', 'GABRIEL', 'Bicicleta', '2020-01-02', '02/01/2020   01:45:11 PM', 2020, 1, 2, 13, 45, 11, 0.1, 'SI'),
(121, 'LPO-454', 'LORETO', 'Tracktor', '2020-01-02', '02/01/2020   01:45:24 PM', 2020, 1, 2, 13, 45, 24, 0.1, 'SI'),
(122, 'FRE-234', 'FRANCO', 'Bicicleta', '2020-01-03', '03/01/2020   11:29:02 AM', 2020, 1, 3, 11, 29, 2, 0.1, 'SI'),
(123, 'GFV-456', 'GABRIELA', 'Tracktor', '2020-01-08', '08/01/2020   01:46:43 PM', 2020, 1, 8, 13, 46, 43, 1426.25, 'SI'),
(124, 'JDF-ERER', 'JULIO', 'Camión', '2020-01-03', '03/01/2020   10:15:09 PM', 2020, 1, 3, 22, 15, 9, 5, 'SI'),
(125, 'RTV-343', 'RUTH', 'Camión', '2020-01-25', '25/01/2020   01:33:18 PM', 2020, 1, 25, 13, 33, 18, 290, 'SI'),
(126, 'DVB-434', 'DAVID', 'Cuadron', '2020-01-03', '03/01/2020   11:28:26 PM', 2020, 1, 3, 23, 28, 26, 7.5, 'SI'),
(127, 'SVB-343', 'SEBATIAN', 'Cuadron', '2020-01-03', '03/01/2020   11:31:56 PM', 2020, 1, 3, 23, 31, 56, 5, 'SI'),
(128, 'DFG-134', 'ALEJANDRA', 'Cuadron', '2020-01-05', '05/01/2020   12:24:37 AM', 2020, 1, 5, 0, 24, 37, 0.1, 'SI'),
(129, 'TYU-344', 'MARIA', 'Tracktor', '2020-01-04', '04/01/2020   01:14:54 AM', 2020, 1, 4, 1, 14, 54, 0.1, 'SI'),
(130, 'VSA-123', 'VANESSA', 'Avion', '2020-01-04', '04/01/2020   01:17:09 AM', 2020, 1, 4, 1, 17, 9, 0.1, 'SI'),
(131, 'RET-123', 'RETER', 'Cuadron', '2020-01-04', '04/01/2020   01:24:04 AM', 2020, 1, 4, 1, 24, 4, 5, 'SI'),
(132, 'CNS-234', 'SONIA', 'Tracktor', '2020-01-05', '05/01/2020   12:24:57 AM', 2020, 1, 5, 0, 24, 57, 0.1, 'SI'),
(133, 'MNO-243', 'MARIA', 'Cuadron', '2020-01-05', '05/01/2020   06:20:50 PM', 2020, 1, 5, 18, 20, 50, 0.1, 'SI'),
(134, 'REV-123', 'RODRIGO', 'Tracktor', '2020-01-06', '06/01/2020   11:50:01 AM', 2020, 1, 6, 11, 50, 1, 0.1, 'SI'),
(135, 'FGM-234', 'HENRY', 'Tracktor', '2020-01-07', '07/01/2020   10:41:43 AM', 2020, 1, 7, 10, 41, 43, 5, 'SI'),
(136, 'REM-345', 'ROMARIO', 'Motocicleta', '2020-01-08', '08/01/2020   12:05:00 PM', 2020, 1, 8, 12, 5, 0, 0, 'NO'),
(137, 'JBN-544', 'MARIA', 'Tracktor', '2020-01-08', '08/01/2020   12:09:48 PM', 2020, 1, 8, 12, 9, 48, 5, 'SI'),
(138, 'DEP-345', 'DANIEL', 'Motocicleta', '2020-01-08', '08/01/2020   01:57:29 PM', 2020, 1, 8, 13, 57, 29, 0, 'NO'),
(139, 'WQE-434', 'WILMER', 'Trailer', '2020-01-08', '08/01/2020   01:57:46 PM', 2020, 1, 8, 13, 57, 46, 0, 'NO'),
(140, 'XPL-254', 'XAVIER', 'Motocicleta', '2020-01-08', '08/01/2020   01:58:02 PM', 2020, 1, 8, 13, 58, 2, 0, 'NO'),
(141, 'LMF-343', 'LEOANARDO', 'Tricimoto', '2020-01-08', '08/01/2020   01:58:27 PM', 2020, 1, 8, 13, 58, 27, 0, 'NO'),
(142, 'WMS-323', 'MATIAS', 'Camión', '2020-01-08', '08/01/2020   01:58:45 PM', 2020, 1, 8, 13, 58, 45, 0, 'NO'),
(143, 'SXL-093', 'SONIA', 'Tricimoto', '2020-01-08', '08/01/2020   01:59:12 PM', 2020, 1, 8, 13, 59, 12, 0, 'NO'),
(144, 'LCB-342', 'CARLOS', 'BUS', '2020-01-08', '08/01/2020   01:59:45 PM', 2020, 1, 8, 13, 59, 45, 0, 'NO'),
(145, 'WXP-345', 'PABLO', 'Tracktor', '2020-01-08', '08/01/2020   01:59:58 PM', 2020, 1, 8, 13, 59, 58, 0, 'NO'),
(146, 'JKO-234', 'JACINTO', 'Cuadron', '2020-01-08', '08/01/2020   02:00:20 PM', 2020, 1, 8, 14, 0, 20, 0, 'NO'),
(147, 'XDL-786', 'DARIMI', 'Tracktor', '2020-01-08', '08/01/2020   09:53:48 PM', 2020, 1, 8, 21, 53, 48, 0, 'NO'),
(148, 'JMS-123', 'JULLEYDY', 'Bicicleta', '2020-01-14', '14/01/2020   02:15:07 PM', 2020, 1, 14, 14, 15, 7, 0.1, 'SI'),
(149, 'CFM-456', 'FARIAS', 'Motocicleta', '2020-01-17', '17/01/2020   03:31:05 PM', 2020, 1, 17, 15, 31, 5, 0, 'NO'),
(150, 'YNM-455', 'YAJARIA', 'Trailer', '2020-01-17', '17/01/2020   03:32:54 PM', 2020, 1, 17, 15, 32, 54, 0, 'NO'),
(151, 'DCV-345', 'DANIEL', 'Trailer', '2020-01-17', '17/01/2020   03:33:14 PM', 2020, 1, 17, 15, 33, 14, 1312.5, 'SI'),
(152, 'QSD-490', 'TAINI', 'BUS', '2020-01-17', '17/01/2020   03:33:31 PM', 2020, 1, 17, 15, 33, 31, 1181.25, 'SI'),
(153, 'GVB-344', 'VILMAN', 'BUS', '2020-01-17', '17/01/2020   03:35:39 PM', 2020, 1, 17, 15, 35, 39, 1181.25, 'SI'),
(154, 'ZXÑ-675', 'RRTE', 'Tracktor', '2020-01-25', '25/01/2020   01:33:55 PM', 2020, 1, 25, 13, 33, 55, 0.1, 'SI'),
(155, 'CVB-87E', 'CARMEN', 'avion', '2020-01-29', '29/01/2020   01:33:39 PM', 2020, 1, 29, 13, 33, 39, 0, 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auto_salida`
--

CREATE TABLE `auto_salida` (
  `Registro` int(11) NOT NULL,
  `Placa` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre_Propietario` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Tipo_Vehiculo` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Costo_Vehiculo` double NOT NULL,
  `Fecha_Date` date NOT NULL,
  `Hora_Salida` int(11) NOT NULL,
  `Minutos_Salida` int(11) NOT NULL,
  `Segundos_Salida` int(11) NOT NULL,
  `Fecha_Ingreso` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha_Salida` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Total_Dias` int(11) NOT NULL,
  `Total_Horas` int(11) NOT NULL,
  `Total_Minutos` int(11) NOT NULL,
  `Tota_en_Horas` int(11) NOT NULL,
  `Total_Cobrar` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `auto_salida`
--

INSERT INTO `auto_salida` (`Registro`, `Placa`, `Nombre_Propietario`, `Tipo_Vehiculo`, `Costo_Vehiculo`, `Fecha_Date`, `Hora_Salida`, `Minutos_Salida`, `Segundos_Salida`, `Fecha_Ingreso`, `Fecha_Salida`, `Total_Dias`, `Total_Horas`, `Total_Minutos`, `Tota_en_Horas`, `Total_Cobrar`) VALUES
(61, 'LLL-963', 'RER', 'Motocicleta', 1, '2019-12-22', 15, 58, 47, '22/12/2019   03:58:02 PM', '22/12/2019   03:58:47 PM', 0, 0, 0, 0, 1),
(64, 'CCC-454', 'PEDRO', 'Cuadron', 5, '2019-12-23', 10, 54, 44, '23/12/2019   10:53:38 AM', '23/12/2019   10:54:44 AM', 0, 0, 1, 0, 5),
(66, 'REN-123', 'JUAN', 'Camión', 3.5, '2019-12-23', 14, 16, 14, '22/12/2019   04:05:57 PM', '23/12/2019   02:16:14 PM', 0, 22, 11, 22, 78.75),
(67, 'PER-123', 'PERT', 'Camión', 3.5, '2019-12-23', 14, 16, 18, '22/12/2019   04:06:00 PM', '23/12/2019   02:16:18 PM', 0, 22, 10, 22, 77),
(68, 'VVV-963', 'VASQUES', 'BUS', 4, '2019-12-23', 22, 2, 10, '23/12/2019   10:56:48 AM', '23/12/2019   10:02:10 PM', 0, 11, 6, 11, 44),
(69, 'SSS-693', 'KILLII', 'Trailer', 3, '2019-12-23', 22, 11, 46, '23/12/2019   09:57:45 PM', '23/12/2019   10:11:46 PM', 0, 0, 14, 0, 3),
(70, 'SSS-693', 'KILLII', 'Trailer', 3, '2019-12-24', 10, 57, 23, '24/12/2019   10:54:14 AM', '24/12/2019   10:57:23 AM', 0, 0, 3, 0, 3),
(71, 'REN-123', 'JUAN', 'Camión', 2, '2019-12-24', 15, 56, 18, '23/12/2019   09:57:24 PM', '24/12/2019   03:56:18 PM', 0, 17, 59, 17, 35),
(72, 'JUN-932', 'RAMDEW', 'Camión', 2, '2019-12-24', 16, 14, 27, '24/12/2019   10:53:46 AM', '24/12/2019   04:14:27 PM', 0, 5, 21, 5, 11),
(73, 'TTT-456', 'FARIAS', 'Motocicleta', 1, '2019-12-24', 18, 59, 24, '24/12/2019   10:53:28 AM', '24/12/2019   06:59:24 PM', 0, 5, 6, 29, 29),
(74, 'CNB-154', 'CARLOS', 'Vehiculo Liviano', 1.5, '2019-12-24', 19, 1, 8, '24/12/2019   04:14:09 PM', '24/12/2019   07:01:08 PM', 0, 2, 47, 2, 3.75),
(75, 'LLL-963', 'RER', 'Motocicleta', 1, '2019-12-24', 19, 4, 9, '22/12/2019   04:06:06 PM', '24/12/2019   07:04:09 PM', 2, 2, 58, 50, 50.5),
(76, 'CNB-154', 'CARLOS', 'Vehiculo Liviano', 1.5, '2019-12-24', 19, 7, 20, '24/12/2019   07:06:47 PM', '24/12/2019   07:07:20 PM', 0, 0, 1, 0, 1.5),
(77, 'ZZZ-691', 'LOOSS', 'Motocicleta', 1, '2019-12-26', 11, 13, 26, '22/12/2019   04:06:22 PM', '26/12/2019   11:13:26 AM', 3, 19, 7, 91, 91),
(79, 'SEB-963', 'LOPESS', 'Cuadron', 5, '2019-12-26', 15, 45, 49, '26/12/2019   02:30:35 PM', '26/12/2019   03:45:49 PM', 0, 1, 15, 1, 7.5),
(80, 'SSS-693', 'KILLII', 'Trailer', 3, '2019-12-26', 15, 46, 58, '26/12/2019   02:30:20 PM', '26/12/2019   03:46:58 PM', 0, 1, 16, 1, 4.5),
(82, 'LKH-961', 'JUANSE', 'Bicicleta', 1, '2019-12-26', 16, 36, 40, '24/12/2019   10:54:43 AM', '26/12/2019   04:36:40 PM', 2, 5, 42, 53, 53.5),
(83, 'LKH-961', 'JUANSE', 'Bicicleta', 2, '2019-12-26', 17, 3, 32, '26/12/2019   04:37:31 PM', '26/12/2019   05:03:32 PM', 0, 0, 26, 0, 2),
(84, 'YAN-365', 'WENDI', 'Camión', 2, '2019-12-26', 17, 3, 58, '26/12/2019   04:32:02 PM', '26/12/2019   05:03:58 PM', 0, 0, 31, 0, 2),
(85, 'REN-123', 'JUAN', 'Camión', 2, '2019-12-26', 17, 4, 11, '26/12/2019   11:04:24 AM', '26/12/2019   05:04:11 PM', 0, 6, 0, 6, 12),
(86, 'DEF-789', 'MAY', 'Cuadron', 5, '2019-12-27', 11, 6, 8, '27/12/2019   10:08:38 AM', '27/12/2019   11:06:08 AM', 0, 0, 58, 0, 5),
(87, 'REN-123', 'JUAN', 'Camión', 2, '2019-12-28', 13, 10, 8, '26/12/2019   05:04:21 PM', '28/12/2019   01:10:08 PM', 1, 20, 6, 44, 88),
(88, 'MLP-456', 'MILENA', 'Tracktor', 5, '2019-12-28', 13, 10, 23, '28/12/2019   10:09:18 AM', '28/12/2019   01:10:23 PM', 0, 3, 1, 3, 15),
(89, 'CNB-154', 'CARLOS', 'Vehiculo Liviano', 1.5, '2019-12-28', 15, 41, 42, '28/12/2019   10:08:52 AM', '28/12/2019   03:41:42 PM', 0, 5, 33, 5, 8.25),
(90, 'LPI-454', 'MILTON', 'Bicicleta', 3, '2019-12-29', 12, 30, 55, '29/12/2019   11:36:08 AM', '29/12/2019   12:30:55 PM', 0, 0, 54, 0, 3),
(91, 'WSE-631', 'LOPESS', 'BUS', 4, '2019-12-29', 12, 51, 14, '24/12/2019   10:54:27 AM', '29/12/2019   12:51:14 PM', 5, 1, 57, 121, 486),
(92, 'LIM-466', 'RENE', 'BUS', 4, '2019-12-29', 12, 51, 20, '26/12/2019   05:07:21 PM', '29/12/2019   12:51:20 PM', 2, 19, 44, 67, 270),
(93, 'LOP-894', 'WILMER', 'Motocicleta', 1, '2019-12-29', 21, 44, 26, '28/12/2019   10:07:59 AM', '29/12/2019   09:44:26 PM', 1, 21, 37, 45, 45.5),
(94, 'AAA-364', 'MAYRA', 'Motocicleta', 1, '2019-12-30', 11, 50, 9, '23/12/2019   09:57:58 PM', '30/12/2019   11:50:09 AM', 6, 13, 53, 157, 157.5),
(95, 'CIO-165', 'PLATI', 'Trailer', 3, '2019-12-30', 11, 50, 26, '28/12/2019   11:28:57 PM', '30/12/2019   11:50:26 AM', 1, 12, 22, 36, 109.5),
(96, 'SAD-789', 'SALVADOR', 'Vehiculo Liviano', 1.5, '2019-12-30', 15, 36, 58, '27/12/2019   11:05:00 AM', '30/12/2019   03:36:58 PM', 3, 4, 31, 76, 114.75),
(97, 'PÑÑ-789', 'PEÑA', 'Camión', 2, '2019-12-31', 17, 59, 26, '31/12/2019   03:04:36 PM', '31/12/2019   05:59:26 PM', 0, 2, 55, 2, 5),
(98, 'GBN-145', 'GABO', 'Bicicleta', 3, '2019-12-31', 20, 42, 59, '31/12/2019   07:48:36 PM', '31/12/2019   08:42:59 PM', 0, 0, 54, 0, 3),
(99, 'WEE-645', 'MARCOS', 'Tracktor', 5, '2020-01-02', 13, 48, 58, '24/12/2019   10:53:59 AM', '02/01/2020   01:48:58 PM', 9, 2, 55, 218, 1092.5),
(100, 'QOL-914', 'RAMIRO', 'Motocicleta', 1, '2020-01-02', 13, 49, 3, '24/12/2019   10:54:09 AM', '02/01/2020   01:49:03 PM', 9, 2, 55, 218, 218.5),
(101, 'XCV-456', 'XAVIER', 'Motocicleta', 1, '2020-01-02', 13, 49, 5, '24/12/2019   03:26:17 PM', '02/01/2020   01:49:05 PM', 8, 22, 23, 214, 214.5),
(102, 'CCC-454', 'PEDRO', 'Bicicleta', 3, '2020-01-02', 13, 49, 9, '24/12/2019   04:13:46 PM', '02/01/2020   01:49:09 PM', 8, 21, 36, 213, 640.5),
(103, 'CVB-645', 'CARLOS', 'BUS', 4, '2020-01-02', 13, 49, 13, '26/12/2019   05:04:32 PM', '02/01/2020   01:49:13 PM', 6, 20, 45, 164, 658),
(104, 'CAR-456', 'CARLOS', 'Cuadron', 5, '2020-01-02', 13, 49, 16, '27/12/2019   10:08:24 AM', '02/01/2020   01:49:16 PM', 6, 3, 41, 147, 737.5),
(105, 'FFF-635', 'PEDRIRES', 'Tracktor', 5, '2020-01-02', 13, 49, 26, '26/12/2019   11:03:49 AM', '02/01/2020   01:49:26 PM', 7, 2, 46, 170, 852.5),
(106, 'VVV-963', 'VASQUES', 'BUS', 4, '2020-01-02', 13, 49, 34, '26/12/2019   11:04:14 AM', '02/01/2020   01:49:34 PM', 7, 2, 45, 170, 682),
(107, 'VBB-369', 'RUIS', 'Cuadron', 5, '2020-01-02', 13, 50, 1, '26/12/2019   04:31:04 PM', '02/01/2020   01:50:01 PM', 6, 21, 18, 165, 827.5),
(108, 'QWE-412', 'KARINA', 'BUS', 4, '2020-01-02', 13, 51, 27, '26/12/2019   04:31:22 PM', '02/01/2020   01:51:27 PM', 6, 21, 20, 165, 662),
(109, 'SSS-693', 'KILLII', 'Trailer', 3, '2020-01-02', 13, 51, 30, '26/12/2019   04:31:41 PM', '02/01/2020   01:51:30 PM', 6, 21, 20, 165, 496.5),
(110, 'QUI-789', 'ROBERTO', 'BUS', 4, '2020-01-02', 13, 51, 38, '27/12/2019   10:08:53 AM', '02/01/2020   01:51:38 PM', 6, 3, 43, 147, 590),
(111, 'PER-123', 'PERT', 'Camión', 2, '2020-01-02', 13, 51, 41, '27/12/2019   11:04:41 AM', '02/01/2020   01:51:41 PM', 6, 2, 47, 146, 293),
(112, 'FGY-464', 'FARIAS', 'Tracktor', 5, '2020-01-02', 13, 51, 45, '27/12/2019   05:25:26 PM', '02/01/2020   01:51:45 PM', 5, 20, 26, 140, 702.5),
(113, 'KLO-964', 'KARIJK', 'Motocicleta', 1, '2020-01-02', 13, 52, 21, '27/12/2019   05:25:40 PM', '02/01/2020   01:52:21 PM', 5, 20, 27, 140, 140.5),
(114, 'PLO-784', 'PALOA', 'BUS', 4, '2020-01-02', 13, 52, 25, '27/12/2019   05:26:00 PM', '02/01/2020   01:52:25 PM', 5, 20, 26, 140, 562),
(115, 'SWE-784', 'SANTIS', 'Bicicleta', 3, '2020-01-02', 13, 52, 28, '27/12/2019   05:26:13 PM', '02/01/2020   01:52:28 PM', 5, 20, 26, 140, 421.5),
(116, 'SEB-963', 'LOPESS', 'Cuadron', 5, '2020-01-02', 13, 52, 32, '28/12/2019   10:07:46 AM', '02/01/2020   01:52:32 PM', 5, 3, 45, 123, 617.5),
(117, 'LLL-963', 'RER', 'Motocicleta', 1, '2020-01-02', 13, 52, 35, '28/12/2019   10:08:31 AM', '02/01/2020   01:52:35 PM', 5, 3, 44, 123, 123.5),
(118, 'WER-456', 'WEIRO', 'Camión', 2, '2020-01-02', 13, 52, 44, '28/12/2019   05:14:06 PM', '02/01/2020   01:52:44 PM', 4, 20, 38, 116, 233),
(119, 'WTY-954', 'YAMI', 'Cuadron', 5, '2020-01-02', 13, 52, 53, '29/12/2019   09:45:24 PM', '02/01/2020   01:52:53 PM', 3, 16, 7, 88, 440),
(120, 'LNM-944', 'RITA', 'Cuadron', 5, '2020-01-02', 13, 53, 2, '29/12/2019   07:14:27 PM', '02/01/2020   01:53:02 PM', 3, 18, 38, 90, 452.5),
(121, 'API-694', 'JUANSEEE', 'Bicicleta', 3, '2020-01-02', 13, 53, 31, '28/12/2019   11:28:26 PM', '02/01/2020   01:53:31 PM', 4, 14, 25, 110, 331.5),
(122, 'KOP-964', 'SANTOS', 'BUS', 4, '2020-01-02', 13, 53, 39, '29/12/2019   11:35:06 AM', '02/01/2020   01:53:39 PM', 4, 2, 18, 98, 394),
(123, 'ZZZ-691', 'LOOSS', 'Motocicleta', 1, '2020-01-02', 13, 53, 47, '29/12/2019   11:35:30 AM', '02/01/2020   01:53:47 PM', 4, 2, 18, 98, 98.5),
(124, 'TTT-456', 'FARIAS', 'Motocicleta', 1, '2020-01-02', 13, 53, 54, '29/12/2019   07:13:54 PM', '02/01/2020   01:53:54 PM', 3, 18, 40, 90, 90.5),
(125, 'MLP-456', 'MILENA', 'Tracktor', 5, '2020-01-02', 13, 54, 4, '29/12/2019   12:49:35 PM', '02/01/2020   01:54:04 PM', 4, 1, 5, 97, 485),
(126, 'QER-451', 'LOPILATO', 'Tracktor', 5, '2020-01-02', 13, 54, 14, '29/12/2019   11:35:23 AM', '02/01/2020   01:54:14 PM', 4, 2, 19, 98, 492.5),
(127, 'ASD-123', 'GATO', 'Trailer', 3, '2020-01-02', 13, 54, 42, '28/12/2019   05:14:18 PM', '02/01/2020   01:54:42 PM', 4, 20, 40, 116, 349.5),
(128, 'MLO-457', 'JANDRY', 'Tracktor', 5, '2020-01-02', 13, 54, 53, '29/12/2019   12:49:52 PM', '02/01/2020   01:54:53 PM', 4, 1, 5, 97, 485),
(129, 'BPL-455', 'ROCIO', 'Bicicleta', 3, '2020-01-02', 13, 55, 25, '31/12/2019   06:05:45 PM', '02/01/2020   01:55:25 PM', 1, 19, 50, 43, 130.5),
(130, 'REN-123', 'JUAN', 'Camión', 2, '2020-01-02', 13, 55, 31, '29/12/2019   11:35:45 AM', '02/01/2020   01:55:31 PM', 4, 2, 20, 98, 197),
(131, 'SQP-457', 'VIVIANA', 'BUS', 4, '2020-01-02', 13, 55, 37, '29/12/2019   12:50:14 PM', '02/01/2020   01:55:37 PM', 4, 1, 5, 97, 388),
(132, 'TUI-895', 'SANDROP', 'Tracktor', 5, '2020-01-02', 13, 55, 41, '29/12/2019   07:14:06 PM', '02/01/2020   01:55:41 PM', 3, 18, 41, 90, 452.5),
(133, 'QPO-364', 'LLANE', 'Trailer', 3, '2020-01-02', 13, 55, 45, '28/12/2019   11:28:43 PM', '02/01/2020   01:55:45 PM', 4, 14, 27, 110, 331.5),
(134, 'BGH-954', 'BRAYAN', 'Bicicleta', 3, '2020-01-02', 13, 55, 54, '30/12/2019   11:49:05 AM', '02/01/2020   01:55:54 PM', 3, 2, 6, 74, 222),
(135, 'HJL-987', 'HUGO', 'Cuadron', 5, '2020-01-02', 13, 56, 1, '30/12/2019   11:48:19 AM', '02/01/2020   01:56:01 PM', 3, 2, 7, 74, 370),
(136, 'PKL-942', 'EVELYN', 'Tracktor', 5, '2020-01-02', 13, 56, 14, '30/12/2019   11:05:01 AM', '02/01/2020   01:56:14 PM', 3, 2, 51, 74, 372.5),
(137, 'PFO-894', 'RENI', 'Camión', 2, '2020-01-02', 13, 57, 4, '28/12/2019   11:28:11 PM', '02/01/2020   01:57:04 PM', 4, 14, 28, 110, 221),
(138, 'KIL-485', 'RAMIRO', 'Motocicleta', 1, '2020-01-02', 19, 13, 49, '29/12/2019   12:49:28 PM', '02/01/2020   07:13:49 PM', 4, 6, 24, 102, 102.5),
(139, 'PCN-621', 'PLO', 'Motocicleta', 1, '2020-01-02', 19, 13, 53, '29/12/2019   09:45:09 PM', '02/01/2020   07:13:53 PM', 3, 21, 28, 93, 93.5),
(140, 'NMB-841', 'NAIROBVI', 'Cuadron', 5, '2020-01-02', 19, 13, 58, '30/12/2019   11:04:16 AM', '02/01/2020   07:13:58 PM', 3, 8, 9, 80, 400),
(141, 'LPI-454', 'MILLLO', 'Trailer', 3, '2020-01-02', 19, 14, 10, '31/12/2019   06:05:20 PM', '02/01/2020   07:14:10 PM', 2, 1, 9, 49, 147),
(142, 'DHY-415', 'WISIN', 'Trailer', 3, '2020-01-03', 11, 21, 0, '02/01/2020   01:44:57 PM', '03/01/2020   11:21:00 AM', 0, 21, 36, 21, 64.5),
(143, 'GKL-898', 'GONZALES', 'BUS', 4, '2020-01-03', 23, 53, 55, '02/01/2020   01:44:23 PM', '03/01/2020   11:53:55 PM', 1, 17, 9, 41, 164),
(144, 'SVB-343', 'SEBATIAN', 'Cuadron', 5, '2020-01-03', 23, 55, 28, '03/01/2020   11:31:56 PM', '03/01/2020   11:55:28 PM', 0, 0, 24, 0, 5),
(145, 'DVB-434', 'DAVID', 'Cuadron', 5, '2020-01-04', 0, 55, 28, '03/01/2020   11:28:26 PM', '04/01/2020   12:55:28 AM', 0, 1, 27, 1, 7.5),
(146, 'RTV-343', 'RUTH', 'Camión', 2, '2020-01-04', 0, 55, 39, '03/01/2020   11:20:35 PM', '04/01/2020   12:55:39 AM', 0, 1, 35, 1, 3),
(147, 'JDF-ERER', 'JULIO', 'Camión', 2, '2020-01-04', 1, 1, 55, '03/01/2020   10:15:09 PM', '04/01/2020   01:01:55 AM', 0, 2, 46, 2, 5),
(148, 'RET-123', 'RETER', 'Cuadron', 5, '2020-01-04', 1, 24, 53, '04/01/2020   01:24:04 AM', '04/01/2020   01:24:53 AM', 0, 0, 0, 0, 5),
(149, 'REN-123', 'JUAN', 'Camión', 2, '2020-01-04', 1, 26, 0, '04/01/2020   01:13:59 AM', '04/01/2020   01:26:00 AM', 0, 0, 12, 0, 2),
(150, 'REV-123', 'RODRIGO', 'Tracktor', 5, '2020-01-06', 11, 44, 48, '06/01/2020   11:40:45 AM', '06/01/2020   11:44:48 AM', 0, 0, 4, 0, 5),
(151, 'HJL-987', 'HUGO', 'Bicicleta', 1, '2020-01-06', 12, 4, 22, '04/01/2020   02:58:18 PM', '06/01/2020   12:04:22 PM', 1, 21, 6, 45, 45),
(152, 'CCC-454', 'PEDRO', 'Bicicleta', 1, '2020-01-06', 12, 4, 53, '04/01/2020   02:57:45 PM', '06/01/2020   12:04:53 PM', 1, 21, 7, 45, 45),
(153, 'FGM-234', 'HENRY', 'Tracktor', 5, '2020-01-07', 10, 42, 12, '07/01/2020   10:41:43 AM', '07/01/2020   10:42:12 AM', 0, 0, 1, 0, 5),
(154, 'JBN-544', 'MARIA', 'Tracktor', 5, '2020-01-08', 12, 10, 15, '08/01/2020   12:09:48 PM', '08/01/2020   12:10:15 PM', 0, 0, 1, 0, 5),
(155, 'NMB-841', 'NAIROBVI', 'Cuadron', 3, '2020-01-13', 10, 34, 20, '13/01/2020   10:33:54 AM', '13/01/2020   10:34:20 AM', 0, 0, 1, 0, 3),
(156, 'GHJ-456', 'RENE', 'BUS', 4.5, '2020-01-14', 14, 21, 34, '14/01/2020   02:20:07 PM', '14/01/2020   02:21:34 PM', 0, 0, 1, 0, 4.5),
(157, 'REN-123', 'JUAN', 'Camión', 4, '2020-01-17', 15, 31, 50, '04/01/2020   02:57:30 PM', '17/01/2020   03:31:50 PM', 13, 0, 34, 312, 1250),
(158, 'DEF-789', 'MAY', 'Cuadron', 1, '2020-01-17', 15, 31, 54, '04/01/2020   02:57:38 PM', '17/01/2020   03:31:54 PM', 13, 0, 34, 312, 312.5),
(159, 'VVV-963', 'VASQUES', 'BUS', 4.5, '2020-01-17', 15, 31, 58, '04/01/2020   02:57:59 PM', '17/01/2020   03:31:58 PM', 13, 0, 34, 312, 1406.25),
(160, 'CCC-454', 'PEDRO', 'Bicicleta', 1.5, '2020-01-17', 15, 32, 5, '06/01/2020   12:07:42 PM', '17/01/2020   03:32:05 PM', 11, 3, 25, 267, 401.25),
(161, 'SSS-693', 'KILLII', 'Trailer', 5, '2020-01-17', 15, 32, 9, '08/01/2020   01:46:22 PM', '17/01/2020   03:32:09 PM', 9, 1, 46, 217, 1087.5),
(162, 'GFV-456', 'GABRIELA', 'Tracktor', 3.5, '2020-01-25', 13, 40, 5, '08/01/2020   01:46:43 PM', '25/01/2020   01:40:05 PM', 16, 23, 54, 407, 1426.25),
(163, 'CVB-645', 'CARLOS', 'BUS', 4.5, '2020-01-28', 14, 2, 4, '25/01/2020   01:33:30 PM', '28/01/2020   02:02:04 PM', 3, 0, 29, 72, 326.25),
(164, 'QSD-490', 'TAINI', 'BUS', 4.5, '2020-01-28', 14, 2, 9, '17/01/2020   03:33:31 PM', '28/01/2020   02:02:09 PM', 10, 22, 29, 262, 1181.25),
(165, 'DCV-345', 'DANIEL', 'Trailer', 5, '2020-01-28', 14, 2, 12, '17/01/2020   03:33:14 PM', '28/01/2020   02:02:12 PM', 10, 22, 29, 262, 1312.5),
(166, 'BBB-787', 'BILMA', 'Tracktor', 3.5, '2020-01-28', 14, 2, 19, '04/01/2020   02:58:05 PM', '28/01/2020   02:02:19 PM', 23, 23, 4, 575, 2012.5),
(167, 'GVB-344', 'VILMAN', 'BUS', 4.5, '2020-01-28', 14, 2, 28, '17/01/2020   03:35:39 PM', '28/01/2020   02:02:28 PM', 10, 22, 27, 262, 1181.25),
(168, 'WEE-645', 'MARCOS', 'Tracktor', 3.5, '2020-01-28', 14, 2, 34, '06/01/2020   04:29:51 PM', '28/01/2020   02:02:34 PM', 21, 21, 33, 525, 1839.25),
(169, 'RTV-343', 'RUTH', 'Camión', 4, '2020-01-28', 14, 3, 56, '25/01/2020   01:33:18 PM', '28/01/2020   02:03:56 PM', 3, 0, 30, 72, 290);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colores`
--

CREATE TABLE `colores` (
  `Nombre_Color` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Rojo` int(11) NOT NULL,
  `Verde` int(11) NOT NULL,
  `Azul` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `colores`
--

INSERT INTO `colores` (`Nombre_Color`, `Rojo`, `Verde`, `Azul`) VALUES
('Aceituna', 128, 128, 0),
('Amarillo', 255, 255, 0),
('Azul', 0, 0, 255),
('Azul claro', 135, 206, 250),
('Beige', 245, 245, 220),
('Blanco', 255, 255, 255),
('carmen', 120, 153, 109),
('celester', 126, 192, 221),
('Chocolate', 210, 105, 30),
('Cian', 0, 255, 255),
('Marrón', 244, 164, 96),
('Morado claro', 220, 48, 171),
('Naranja', 255, 165, 0),
('Negro', 0, 0, 0),
('Púrpura', 128, 0, 128),
('rene', 122, 0, 255),
('Rojo', 255, 0, 0),
('Rosado', 255, 105, 180),
('Salmón', 250, 128, 114),
('Turquesa', 64, 224, 208),
('Verde', 0, 255, 0),
('Verde Claro', 88, 96, 0),
('Verde suabe', 68, 135, 116),
('Violeta', 238, 130, 238);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colores_nombres_funciones`
--

CREATE TABLE `colores_nombres_funciones` (
  `Color_Fondo` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Color_Letra_Funciones` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Color_Letra_Titulos` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Color_Fondo_Titulos` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Color_Bordes` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `colores_nombres_funciones`
--

INSERT INTO `colores_nombres_funciones` (`Color_Fondo`, `Color_Letra_Funciones`, `Color_Letra_Titulos`, `Color_Fondo_Titulos`, `Color_Bordes`) VALUES
('Beige', 'Chocolate', 'Turquesa', 'Aceituna', 'Chocolate');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_de_vehiculo`
--

CREATE TABLE `tipo_de_vehiculo` (
  `Nombre_Vehiculo` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `Valor_Vahiculo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_de_vehiculo`
--

INSERT INTO `tipo_de_vehiculo` (`Nombre_Vehiculo`, `Valor_Vahiculo`) VALUES
('avion', 10),
('Bicicleta', 1.5),
('BUS', 4.5),
('Camión', 4),
('Cuadron', 1),
('Motocicleta', 1.5),
('Tracktor', 3.5),
('Trailer', 5),
('Tricimoto', 1.5),
('Vehiculo Liviano', 2.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `Tipo_Usuario` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Usuario` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`Tipo_Usuario`, `Usuario`) VALUES
('Admin', 'servidor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Cedula` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Nombres` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Correo_electronico` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Usuario` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Contrasena` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Tipo_Usuario` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `Estado` varchar(3) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Cedula`, `Nombres`, `Apellidos`, `Telefono`, `Direccion`, `Correo_electronico`, `Usuario`, `Contrasena`, `Tipo_Usuario`, `Estado`) VALUES
('1306253384', 'RRRRR', 'EEEEE', '5454545454', 'CSRMNE', 'reneronny@gmail.com', 'ronnyrene123', 'carmenrene123', 'Empleado', 'AC'),
('1313544254', 'MARIA NAYELI', 'REYNA MENDOZA', '0992179115', 'EL CARMEN', 'mariareyna1990@gmail.com', 'nayeli2019', 'nayeli2019', 'Empleado', 'AC'),
('1313646893', 'MILENA', 'MEJIA', '0985154545', 'EL CARMEN', 'milena@gmail.com', 'milena2019', 'milena2019', 'Empleado', 'AC'),
('1351087570', 'JULLEYDY', 'SOLORZANO', '0960584568', 'CERCA DE MI VECINO', 'Jully123@gmail.com', 'JulleydySolorzano123', 'solorzano123', 'Empleado', 'AC'),
('1723774640', 'RONNY', 'CHAMBA', '0981806210', 'STO DGO', 'ronnychamba96@gmail.com', 'ronnyrene2019', 'losmaspepas2018', 'Admin', 'AC');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autos_cancelados`
--
ALTER TABLE `autos_cancelados`
  ADD PRIMARY KEY (`Registro`);

--
-- Indices de la tabla `autos_ingreso`
--
ALTER TABLE `autos_ingreso`
  ADD PRIMARY KEY (`Registro`);

--
-- Indices de la tabla `auto_salida`
--
ALTER TABLE `auto_salida`
  ADD PRIMARY KEY (`Registro`);

--
-- Indices de la tabla `colores`
--
ALTER TABLE `colores`
  ADD PRIMARY KEY (`Nombre_Color`);

--
-- Indices de la tabla `tipo_de_vehiculo`
--
ALTER TABLE `tipo_de_vehiculo`
  ADD PRIMARY KEY (`Nombre_Vehiculo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Cedula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autos_cancelados`
--
ALTER TABLE `autos_cancelados`
  MODIFY `Registro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT de la tabla `autos_ingreso`
--
ALTER TABLE `autos_ingreso`
  MODIFY `Registro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=156;

--
-- AUTO_INCREMENT de la tabla `auto_salida`
--
ALTER TABLE `auto_salida`
  MODIFY `Registro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=170;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
