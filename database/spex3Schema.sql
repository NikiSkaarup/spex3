-- MySQL Script generated by MySQL Workbench
-- 09/11/16 05:25:57
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema spex3
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `spex3` ;

-- -----------------------------------------------------
-- Schema spex3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spex3` DEFAULT CHARACTER SET utf8 ;
USE `spex3` ;

-- -----------------------------------------------------
-- Table `spex3`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spex3`.`users` ;

CREATE TABLE IF NOT EXISTS `spex3`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `balance` DECIMAL(16,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spex3`.`parts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spex3`.`parts` ;

CREATE TABLE IF NOT EXISTS `spex3`.`parts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `topping` TINYINT(1) NOT NULL DEFAULT 0,
  `bottom` TINYINT(1) NOT NULL DEFAULT 0,
  `price` DECIMAL(16,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spex3`.`cupcakes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spex3`.`cupcakes` ;

CREATE TABLE IF NOT EXISTS `spex3`.`cupcakes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `toppingId` INT NOT NULL DEFAULT 0,
  `bottomId` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `toppingToPartsId_idx` (`toppingId` ASC),
  INDEX `bottomToPartsId_idx` (`bottomId` ASC),
  CONSTRAINT `toppingToPartsId`
    FOREIGN KEY (`toppingId`)
    REFERENCES `spex3`.`parts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `bottomToPartsId`
    FOREIGN KEY (`bottomId`)
    REFERENCES `spex3`.`parts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spex3`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spex3`.`orders` ;

CREATE TABLE IF NOT EXISTS `spex3`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `pickedUp` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `userIdToUsersID_idx` (`userId` ASC),
  CONSTRAINT `userIdToUsersID`
    FOREIGN KEY (`userId`)
    REFERENCES `spex3`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spex3`.`orderlines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spex3`.`orderlines` ;

CREATE TABLE IF NOT EXISTS `spex3`.`orderlines` (
  `cupcakeId` INT NOT NULL,
  `orderId` INT NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`orderId`, `cupcakeId`),
  INDEX `cupcakeToCupcakesId_idx` (`cupcakeId` ASC),
  CONSTRAINT `cupcakeToCupcakesId`
    FOREIGN KEY (`cupcakeId`)
    REFERENCES `spex3`.`cupcakes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orderIdToOrdersId`
    FOREIGN KEY (`orderId`)
    REFERENCES `spex3`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;