-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 07-10-2022 a las 15:46:30
-- Versión del servidor: 10.9.3-MariaDB-1:10.9.3+maria~ubu2204-log
-- Versión de PHP: 8.0.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `23_db_Daniel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Coches`
--

CREATE TABLE `Coches` (
  `Matricula` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Coches`
--

INSERT INTO `Coches` (`Matricula`) VALUES
('0000AAA'),
('1111BBB'),
('2222CCC'),
('3333DDD'),
('4444EEE'),
('6666DVL'),
('6969XDD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Contratos`
--

CREATE TABLE `Contratos` (
  `ID` int(10) UNSIGNED NOT NULL,
  `Comprador` int(11) UNSIGNED NOT NULL,
  `Vendedor` int(11) UNSIGNED NOT NULL,
  `Vehiculo` char(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Contratos`
--

INSERT INTO `Contratos` (`ID`, `Comprador`, `Vendedor`, `Vehiculo`) VALUES
(2, 6, 4, '6969XDD'),
(4, 2, 7, '4444EEE'),
(5, 9, 3, '2222CCC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Personas`
--

CREATE TABLE `Personas` (
  `ID` int(10) UNSIGNED NOT NULL,
  `Nombre` char(50) NOT NULL,
  `Apellido` char(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Personas`
--

INSERT INTO `Personas` (`ID`, `Nombre`, `Apellido`) VALUES
(1, 'Daniel', 'Piriz Cacho'),
(2, 'Agapito', 'Disousa'),
(3, 'John', 'Doe'),
(4, 'Nicholas', 'P. Wilde'),
(5, 'Jeremy', 'Fidgerald'),
(6, 'Gordon', 'Freeman'),
(7, 'Super', 'Mario Mario'),
(8, 'Gina', 'Cross'),
(9, 'Isaac', 'Kleiner'),
(10, 'El raton', 'Del Jose');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Coches`
--
ALTER TABLE `Coches`
  ADD PRIMARY KEY (`Matricula`),
  ADD UNIQUE KEY `Matricula` (`Matricula`);

--
-- Indices de la tabla `Contratos`
--
ALTER TABLE `Contratos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Comprador` (`Comprador`),
  ADD KEY `Vendedor` (`Vendedor`),
  ADD KEY `Vehiculo` (`Vehiculo`);

--
-- Indices de la tabla `Personas`
--
ALTER TABLE `Personas`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Contratos`
--
ALTER TABLE `Contratos`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `Personas`
--
ALTER TABLE `Personas`
  MODIFY `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Contratos`
--
ALTER TABLE `Contratos`
  ADD CONSTRAINT `Comprador` FOREIGN KEY (`Comprador`) REFERENCES `Personas` (`ID`),
  ADD CONSTRAINT `Contratos_ibfk_1` FOREIGN KEY (`Vehiculo`) REFERENCES `Coches` (`Matricula`),
  ADD CONSTRAINT `Vendedor` FOREIGN KEY (`Vendedor`) REFERENCES `Personas` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
