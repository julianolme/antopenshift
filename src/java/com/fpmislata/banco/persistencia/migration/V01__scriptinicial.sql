

CREATE TABLE IF NOT EXISTS `cuentaBancaria` (
  `idCuentaBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `numeroCuentaBancaria` varchar(50) DEFAULT NULL,
  `saldoCuentaBancaria` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idCuentaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `tarjetacredito` (
  `idTarjetaCredito` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(50) DEFAULT NULL,
  `mesCaducidad` int(11) DEFAULT NULL,
  `anyoCaducidad` int(11) DEFAULT NULL,
  `nombreTitular` varchar(150) DEFAULT NULL,
  `cvv` int(11) DEFAULT NULL,
  `tipoTarjeta` varchar(50) DEFAULT NULL,
  `idCuentaBancaria` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTarjetaCredito`),
  CONSTRAINT `FK_tarjetacredito_cuentabancaria` FOREIGN KEY (`idCuentaBancaria`) REFERENCES `cuentaBancaria` (`idCuentaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
