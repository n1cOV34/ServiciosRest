--
-- Estructura de tabla para la tabla `carros`
--

CREATE TABLE IF NOT EXISTS `carros` (
  `PLACA` varchar(50) NOT NULL,
  `MARCA` varchar(50) NOT NULL,
  `MODELO` varchar(50) NOT NULL,
  `COLOR` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrospartes`
--

CREATE TABLE IF NOT EXISTS `carrospartes` (
  `CARROSPARTES` varchar(50) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `PARTES_CODIGO` varchar(50) NOT NULL,
  `CARROS_PLACA` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partes`
--

CREATE TABLE IF NOT EXISTS `partes` (
  `CODIGO` varchar(50) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Indices de la tabla `carros`
--
ALTER TABLE `carros`
  ADD PRIMARY KEY (`PLACA`),
  ADD UNIQUE KEY `CAR_PLA_UN` (`PLACA`);

--
-- Indices de la tabla `carrospartes`
--
ALTER TABLE `carrospartes`
  ADD PRIMARY KEY (`CARROSPARTES`),
  ADD KEY `CARPAR_CAR_FK` (`CARROS_PLACA`),
  ADD KEY `CARPAR_PAR_FK` (`PARTES_CODIGO`);

--
-- Indices de la tabla `partes`
--
ALTER TABLE `partes`
  ADD PRIMARY KEY (`CODIGO`);

  
--
-- Filtros para la tabla `carrospartes`
--
ALTER TABLE `carrospartes`
  ADD CONSTRAINT `CARPAR_CAR_FK` FOREIGN KEY (`CARROS_PLACA`) REFERENCES `carros` (`PLACA`) ON DELETE CASCADE,
  ADD CONSTRAINT `CARPAR_PAR_FK` FOREIGN KEY (`PARTES_CODIGO`) REFERENCES `partes` (`CODIGO`) ON DELETE CASCADE;

