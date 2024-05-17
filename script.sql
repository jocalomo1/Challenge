CREATE DATABASE challenge;

USE challenge;
CREATE TABLE `challenge`.`bitacora` (
  `idBitacora` INT NOT NULL AUTO_INCREMENT,
  `ip_origen` VARCHAR(45) NOT NULL,
  `fecha_movimiento` DATETIME NULL,
  `accion` VARCHAR(100) NULL,
  PRIMARY KEY (`idBitacora`));

SELECT * FROM challenge.bitacora;