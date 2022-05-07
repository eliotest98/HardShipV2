-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hardship
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hardship
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hardship` DEFAULT CHARACTER SET utf8 ;
USE `hardship` ;

-- -----------------------------------------------------
-- Table `hardship`.`album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`album` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Genere` VARCHAR(30) CHARACTER SET 'utf8' NOT NULL,
  `Titolo` VARCHAR(30) NOT NULL,
  `Copertina` VARCHAR(256) NOT NULL,
  `numero_brani` INT(10) NOT NULL,
  `data` VARCHAR(11) NOT NULL,
  `Embed` TEXT NULL DEFAULT NULL,
  `Dettagli` VARCHAR(256) NOT NULL,
  `username_admin` VARCHAR(15) NOT NULL,
  `ID_etichetta` INT(10) NOT NULL,
  `ID_artista` INT(10) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Titolo` (`Titolo` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`amministratore`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`amministratore` (
  `Username` VARCHAR(15) NOT NULL,
  `Password` VARCHAR(30) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

INSERT INTO amministratore VALUES("root" , "root");
-- -----------------------------------------------------
-- Table `hardship`.`articolo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`articolo` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Quantità` INT(10) NOT NULL,
  `Prezzo` DECIMAL(4,2) NOT NULL,
  `ID_album` INT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`artista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`artista` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Nazionalità` (`Nome` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`brano`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`brano` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Titolo` VARCHAR(256) NOT NULL,
  `Anno` VARCHAR(11) NOT NULL,
  `Durata` VARCHAR(6) NOT NULL,
  `ID_album` INT(10) NULL DEFAULT NULL,
  `ID_artista` INT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`cd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`cd` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Prezzo` DECIMAL(4,2) NOT NULL,
  `numero_Copie` INT(10) NOT NULL,
  `ID_Album` INT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`cliente` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(25) NOT NULL,
  `Cognome` VARCHAR(30) NOT NULL,
  `DataNascita` VARCHAR(11) NOT NULL,
  `Username` VARCHAR(15) NOT NULL,
  `Password` VARCHAR(30) NOT NULL,
  `CodiceFiscale` CHAR(16) NOT NULL,
  `Email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`digitale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`digitale` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Prezzo` DECIMAL(4,2) NOT NULL,
  `numero_Copie` INT(10) NOT NULL,
  `ID_album` INT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`etichetta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`etichetta` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(25) NOT NULL,
  `Feed` INT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`fattura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`fattura` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `InfoP` VARCHAR(64) NOT NULL,
  `Indirizzo` TEXT NOT NULL,
  `DataAcquisto` VARCHAR(11) NOT NULL,
  `ID_cliente` INT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`feedback` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Titolo` VARCHAR(25) NOT NULL,
  `Testo` VARCHAR(1024) NOT NULL,
  `Data` VARCHAR(11) NOT NULL,
  `ID_Album` INT(10) NOT NULL,
  `ID_Cliente` INT(10) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`formazione`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`formazione` (
  `ID_Fattura` INT(10) NOT NULL,
  `ID_Articolo` INT(10) NOT NULL,
  PRIMARY KEY (`ID_Fattura`, `ID_Articolo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`news` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Contenuto` TEXT NOT NULL,
  `Data` VARCHAR(11) NOT NULL,
  `Autore` VARCHAR(25) NOT NULL,
  `Titolo` VARCHAR(50) NOT NULL,
  `Copertina` TEXT NOT NULL,
  `Categoria` VARCHAR(15) NOT NULL,
  `Username_admin` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`ricezione`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`ricezione` (
  `ID_richiesta` INT(10) NOT NULL,
  `username_admin` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`ID_richiesta`, `username_admin`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `hardship`.`richiesta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`richiesta` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `nome_album` VARCHAR(30) NOT NULL,
  `artista` VARCHAR(25) NOT NULL,
  `ID_Cliente` INT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 219
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`sottoscrizione`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`sottoscrizione` (
  `ID_Etichetta` INT(10) NOT NULL,
  `ID_Artista` INT(10) NOT NULL,
  PRIMARY KEY (`ID_Etichetta`, `ID_Artista`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`vinile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`vinile` (
  `ID` INT(10) NOT NULL AUTO_INCREMENT,
  `Prezzo` DECIMAL(4,2) NOT NULL,
  `numero_Copie` INT(10) NOT NULL,
  `ID_Album` INT(10) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `hardship`.`visualizzazione`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hardship`.`visualizzazione` (
  `ID_Cliente` INT(10) NOT NULL,
  `ID_News` INT(10) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
