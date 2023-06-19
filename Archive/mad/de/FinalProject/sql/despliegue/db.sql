USE `tparkdb` ;


CREATE TABLE IF NOT EXISTS `Atraccion` (
  `idAtraccion` INT NOT NULL AUTO_INCREMENT,
  `idFoto` INT NULL,
  `Descripcion` VARCHAR(45) NULL,
  `id_Fabricante` INT NULL,
  `Intensidad` INT NULL,
  `Valoracion` INT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAtraccion`)
);

CREATE TABLE IF NOT EXISTS `Fabricante` (
	`id_Fabricante` INT NOT NULL AUTO_INCREMENT,
	`Nombre_Fabricante` VARCHAR(45) NOT NULL,
	PRIMARY KEY (`id_Fabricante`)
);

CREATE TABLE IF NOT EXISTS `Parque` (
  `idParque` INT NOT NULL AUTO_INCREMENT,
  `Nombre_Parque` VARCHAR(45) NOT NULL,
  `idFoto` INT NULL,
  `Descripcion` VARCHAR(45) NULL,
  `Ubicacion` VARCHAR(45) NULL,
  `Fecha_Apertura` DATE NULL,
  `Fecha_Cierre` DATE NULL,
  PRIMARY KEY (`idParque`)
);

CREATE TABLE IF NOT EXISTS `Registro de Servicios` (
  `idAtraccion` INT NOT NULL,
  `idParque` INT NOT NULL,
  `Fecha_Apertura` DATE NOT NULL,
  `Fecha_Cierre` DATE NULL,
  PRIMARY KEY (`idAtraccion`, `idParque`)
);

CREATE TABLE IF NOT EXISTS `Registro de incidencias` (
  `idAtraccion` INT NOT NULL,
  `idParque` INT NOT NULL,
  `Fecha_Incidencia` DATE NULL,
  `Descripcion_Incidencia` VARCHAR(45) NULL,
  PRIMARY KEY (`idAtraccion`, `idParque`)
);

CREATE TABLE IF NOT EXISTS `Foto` (
  `idFoto` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idFoto`)
);


ALTER TABLE `Atraccion`
	ADD FOREIGN KEY (`idFoto`) REFERENCES `Foto`(`idFoto`);
ALTER TABLE `Parque`
	ADD FOREIGN KEY (`idFoto`) REFERENCES `Foto`(`idFoto`);

ALTER TABLE `Atraccion`
	ADD FOREIGN KEY (`id_Fabricante`) REFERENCES `Fabricante`(`id_Fabricante`);

ALTER TABLE `Registro de Servicios`
	ADD FOREIGN KEY (`idAtraccion`) REFERENCES `Atraccion`(`idAtraccion`),
	ADD FOREIGN KEY (`idParque`) REFERENCES `Parque`(`idParque`);
ALTER TABLE `Registro de incidencias`
	ADD FOREIGN KEY (`idAtraccion`) REFERENCES `Atraccion`(`idAtraccion`),
	ADD FOREIGN KEY (`idParque`) REFERENCES `Parque`(`idParque`);
