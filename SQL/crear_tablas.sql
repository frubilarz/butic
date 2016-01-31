USE `buticdb` ;

-- -----------------------------------------------------
-- Table `buticdb`.`locales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buticdb`.`locales` ;

CREATE TABLE IF NOT EXISTS `buticdb`.`locales` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `numero` INT(11) NOT NULL,
  `telefono` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `buticdb`.`boletas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buticdb`.`boletas` ;

CREATE TABLE IF NOT EXISTS `buticdb`.`boletas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `monto` DOUBLE NOT NULL,
  `local_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_boletas_locales1_idx` (`local_id` ASC),
  CONSTRAINT `fk_boletas_locales1`
    FOREIGN KEY (`local_id`)
    REFERENCES `buticdb`.`locales` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `buticdb`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buticdb`.`clientes` ;

CREATE TABLE IF NOT EXISTS `buticdb`.`clientes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `rut` INT(11) NOT NULL,
  `fono` INT(11) NULL DEFAULT NULL,
  `mail` VARCHAR(100) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `direccion` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `rut_UNIQUE` (`rut` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `buticdb`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buticdb`.`productos` ;

CREATE TABLE IF NOT EXISTS `buticdb`.`productos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `stock` INT(11) NOT NULL DEFAULT '0',
  `valor` FLOAT NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `buticdb`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buticdb`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `buticdb`.`usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL,
  `rut` INT(10) UNSIGNED NULL DEFAULT NULL,
  `clave` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `rut_UNIQUE` (`rut` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `buticdb`.`carros_productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buticdb`.`carros_productos` ;

CREATE TABLE IF NOT EXISTS `buticdb`.`carros_productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NULL DEFAULT 0,
  `boleta_id` INT(11) NOT NULL DEFAULT 0,
  `producto_id` INT(11) NOT NULL,
  `clientes_id` INT(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `fk_carros_productos_boletas1_idx` (`boleta_id` ASC),
  INDEX `fk_carros_productos_productos1_idx` (`producto_id` ASC),
  INDEX `fk_carros_productos_clientes1_idx` (`clientes_id` ASC),
  CONSTRAINT `fk_carros_productos_boletas1`
    FOREIGN KEY (`boleta_id`)
    REFERENCES `buticdb`.`boletas` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_carros_productos_productos1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `buticdb`.`productos` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_carros_productos_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `buticdb`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `buticdb`.`fiados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `buticdb`.`fiados` ;

CREATE TABLE IF NOT EXISTS `buticdb`.`fiados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `clientes_id` INT(11) NOT NULL,
  `deuda` DOUBLE NULL,
  `ultimo_pago` DATE NULL,
  `ultimo_abono` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fiados_clientes1_idx` (`clientes_id` ASC),
  CONSTRAINT `fk_fiados_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `buticdb`.`clientes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
