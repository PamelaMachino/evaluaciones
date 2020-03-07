-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-03-2020 a las 01:17:15
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cine`
--

CREATE TABLE `cine` (
  `nombCine` char(50) NOT NULL,
  `direccion` char(50) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cine`
--

INSERT INTO `cine` (`nombCine`, `direccion`, `telefono`) VALUES
('cineediondo', 'queteim', 2222);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE `funcion` (
  `idFuncion` bigint(20) NOT NULL,
  `dia` char(9) NOT NULL,
  `hora` time NOT NULL,
  `id_Sala` bigint(20) NOT NULL,
  `id_Pel` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `funcion`
--

INSERT INTO `funcion` (`idFuncion`, `dia`, `hora`, `id_Sala`, `id_Pel`) VALUES
(1, 'lunes', '16:01:41', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opinion`
--

CREATE TABLE `opinion` (
  `id_Pelic` bigint(20) NOT NULL,
  `idOpinion` bigint(20) NOT NULL,
  `nombreOp` char(50) DEFAULT NULL,
  `edadOp` tinyint(4) DEFAULT NULL,
  `fechaOp` date NOT NULL,
  `calificacionOp` char(12) NOT NULL,
  `comentario` char(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `idPelicula` bigint(20) NOT NULL,
  `tituloDistrib` char(50) NOT NULL,
  `tituloOriginal` char(50) NOT NULL,
  `genero` char(20) NOT NULL,
  `idioma` char(15) NOT NULL,
  `subEsp` char(2) NOT NULL,
  `pais` char(20) DEFAULT NULL,
  `año` smallint(6) DEFAULT NULL,
  `url` char(50) DEFAULT NULL,
  `duracion` time NOT NULL,
  `calificacion` char(23) NOT NULL,
  `fechaEstreno` date NOT NULL,
  `resumen` varchar(1316) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`idPelicula`, `tituloDistrib`, `tituloOriginal`, `genero`, `idioma`, `subEsp`, `pais`, `año`, `url`, `duracion`, `calificacion`, `fechaEstreno`, `resumen`) VALUES
(1, 'wnfeo', 'wnhorroroso', 'feoql', 'elfeo', 'no', 'chile', 2005, NULL, '02:30:00', '+18', '2020-03-24', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id_Pelicula` bigint(20) NOT NULL,
  `nombPer` char(50) NOT NULL,
  `cargo` char(14) NOT NULL,
  `nacionalidad` char(30) DEFAULT NULL,
  `cantPelDirig` smallint(6) DEFAULT NULL,
  `cantPelAct` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personaje`
--

CREATE TABLE `personaje` (
  `idPersonaje` bigint(20) NOT NULL,
  `nombPersonaje` char(50) NOT NULL,
  `nomb_Per` char(50) NOT NULL,
  `id_Peli` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `promocion`
--

CREATE TABLE `promocion` (
  `idPromocion` bigint(20) NOT NULL,
  `descripcion` char(100) NOT NULL,
  `descuento` tinyint(4) NOT NULL,
  `id_Funcion` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `nomb_Cine` char(50) NOT NULL,
  `idSala` bigint(20) NOT NULL,
  `nombSala` char(10) NOT NULL,
  `cantButacas` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`nomb_Cine`, `idSala`, `nombSala`, `cantButacas`) VALUES
('cineediondo', 2, 'dw', 20);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cine`
--
ALTER TABLE `cine`
  ADD PRIMARY KEY (`nombCine`);

--
-- Indices de la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD PRIMARY KEY (`idFuncion`),
  ADD KEY `id_Sala` (`id_Sala`),
  ADD KEY `id_Pel` (`id_Pel`);

--
-- Indices de la tabla `opinion`
--
ALTER TABLE `opinion`
  ADD PRIMARY KEY (`idOpinion`,`id_Pelic`),
  ADD KEY `id_Pelic` (`id_Pelic`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`idPelicula`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`nombPer`),
  ADD KEY `id_Pelicula` (`id_Pelicula`);

--
-- Indices de la tabla `personaje`
--
ALTER TABLE `personaje`
  ADD PRIMARY KEY (`idPersonaje`),
  ADD KEY `id_Peli` (`id_Peli`);

--
-- Indices de la tabla `promocion`
--
ALTER TABLE `promocion`
  ADD PRIMARY KEY (`idPromocion`),
  ADD KEY `id_Funcion` (`id_Funcion`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`idSala`),
  ADD KEY `nomb_Cine` (`nomb_Cine`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `funcion`
--
ALTER TABLE `funcion`
  MODIFY `idFuncion` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `opinion`
--
ALTER TABLE `opinion`
  MODIFY `idOpinion` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `idPelicula` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `promocion`
--
ALTER TABLE `promocion`
  MODIFY `idPromocion` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `idSala` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD CONSTRAINT `funcion_ibfk_1` FOREIGN KEY (`id_Sala`) REFERENCES `sala` (`idSala`),
  ADD CONSTRAINT `funcion_ibfk_2` FOREIGN KEY (`id_Pel`) REFERENCES `pelicula` (`idPelicula`);

--
-- Filtros para la tabla `opinion`
--
ALTER TABLE `opinion`
  ADD CONSTRAINT `opinion_ibfk_1` FOREIGN KEY (`id_Pelic`) REFERENCES `pelicula` (`idPelicula`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`id_Pelicula`) REFERENCES `pelicula` (`idPelicula`);

--
-- Filtros para la tabla `personaje`
--
ALTER TABLE `personaje`
  ADD CONSTRAINT `personaje_ibfk_1` FOREIGN KEY (`id_Peli`) REFERENCES `pelicula` (`idPelicula`);

--
-- Filtros para la tabla `promocion`
--
ALTER TABLE `promocion`
  ADD CONSTRAINT `promocion_ibfk_1` FOREIGN KEY (`id_Funcion`) REFERENCES `funcion` (`idFuncion`);

--
-- Filtros para la tabla `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `sala_ibfk_1` FOREIGN KEY (`nomb_Cine`) REFERENCES `cine` (`nombCine`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
