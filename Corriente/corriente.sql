CREATE DATABASE `corriente` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE corriente;

CREATE TABLE `actividadproyecto` (
  `idActividadProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nombreActividadPryecto` varchar(50) NOT NULL,
  PRIMARY KEY (`idActividadProyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ramaproyecto` (
  `idRamaProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nombreRamaPryecto` varchar(50) NOT NULL,
  PRIMARY KEY (`idRamaProyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ramaactividadproyecto` (
  `idRamaActividadProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `idRamaProyecto` int(11) NOT NULL,
  `idActividadProyecto` int(11) NOT NULL,
  PRIMARY KEY (`idRamaActividadProyecto`),
  KEY `idRamaProyecto` (`idRamaProyecto`),
  KEY `idActividadProyecto` (`idActividadProyecto`),
  CONSTRAINT `ramaactividadproyecto_ibfk_1` FOREIGN KEY (`idRamaProyecto`) REFERENCES `ramaproyecto` (`idramaproyecto`),
  CONSTRAINT `ramaactividadproyecto_ibfk_2` FOREIGN KEY (`idActividadProyecto`) REFERENCES `actividadproyecto` (`idactividadproyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `paises` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `isoPais` char(2) DEFAULT NULL,
  `nombrePais` varchar(80) CHARACTER SET armscii8 COLLATE armscii8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=latin1;

CREATE TABLE `personas` (
  `id_personas` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_persona` varchar(50) NOT NULL,
  `apellido_persona` varchar(50) NOT NULL,
  `dni_persona` int(11) NOT NULL,
  `cuil_persona` int(11) NOT NULL,
  `fechaNacimiento_persona` date NOT NULL,
  `genero_persona` varchar(1) NOT NULL,
  `direccion_persona` varchar(30) NOT NULL,
  `telefono_persona` varchar(11) NOT NULL,
  `nroProyecto_persona` int(4) NOT NULL,
  `nombreProyecto_persona` varchar(50) NOT NULL,
  `dni1_persona` blob NOT NULL,
  `dni2_persona` blob NOT NULL,
  `imagenCuil_persona` blob NOT NULL,
  PRIMARY KEY (`id_personas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `proyectos` (
  `idProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nroProyecto` int(11) NOT NULL,
  `nombreProyecto` varchar(50) NOT NULL,
  `direccionProyecto` varchar(50) NOT NULL,
  `localidadProyecto` varchar(50) NOT NULL,
  `horaComienzoProyecto` int(11) NOT NULL,
  `horaFinalProyecto` int(11) NOT NULL,
  `idRamaActividadProyecto` int(11) NOT NULL,
  PRIMARY KEY (`idProyecto`),
  UNIQUE KEY `nroProyecto` (`nroProyecto`),
  KEY `idRamaActividadProyecto` (`idRamaActividadProyecto`),
  CONSTRAINT `proyectos_ibfk_1` FOREIGN KEY (`idRamaActividadProyecto`) REFERENCES `ramaactividadproyecto` (`idramaactividadproyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
