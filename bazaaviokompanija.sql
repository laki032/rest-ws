-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 28, 2015 at 10:42 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bazaaviokompanija`
--
CREATE DATABASE IF NOT EXISTS `bazaaviokompanija` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bazaaviokompanija`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastLogin` date DEFAULT NULL,
  `ulogovan` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`, `lastLogin`, `ulogovan`) VALUES
('admin', 'admin', NULL, NULL),
('Lazar', '1234', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `aviomehanicar`
--

CREATE TABLE IF NOT EXISTS `aviomehanicar` (
  `JMBG` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `tipMehanicara` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`JMBG`),
  KEY `JMBG` (`JMBG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `aviomehanicar`
--

INSERT INTO `aviomehanicar` (`JMBG`, `tipMehanicara`) VALUES
('0708010123455', 'Glavni majstor'),
('1809010123412', 'Pomocni majstor'),
('2211992782867', 'Ucenik'),
('2234555121200', 'Glavni majstor'),
('2234555121212', 'Glavni majstor'),
('2234555121223', 'Glavni majstor'),
('2234555121233', 'Pomocni majstor'),
('2234555121234', 'Pomocni majstor'),
('2234555121254', 'Pomocni majstor'),
('2234555121255', 'Ucenik'),
('2234555121261', 'Ucenik');

-- --------------------------------------------------------

--
-- Table structure for table `avion`
--

CREATE TABLE IF NOT EXISTS `avion` (
  `avionID` bigint(9) NOT NULL,
  `oznaka` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `godProizvodnje` bigint(4) DEFAULT NULL,
  `brojPutnika` bigint(5) DEFAULT NULL,
  `nosivost` bigint(5) DEFAULT NULL,
  `tipID` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`avionID`),
  KEY `tipID` (`tipID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `avion`
--

INSERT INTO `avion` (`avionID`, `oznaka`, `godProizvodnje`, `brojPutnika`, `nosivost`, `tipID`) VALUES
(1, 'Airbus A320', 1990, 11, 11, 1),
(2, 'Antonov An-124', 1992, 12, 12, 2),
(3, 'RC-135', 1993, 33, 3333, 3),
(4, 'F-22 Raptor', 1944, 141, 411, 4),
(5, 'BAE F-35 Lightning III', 1995, 151, 11, 5),
(6, 'Boeing 737', 1996, 6, 66, 1),
(7, 'L-1011 TriStar', 1997, 7, 11, 1),
(8, 'RC-1350', 1988, 88, 8, 3),
(9, 'Sukhoi GC20', 1999, 19, 11, 5);

-- --------------------------------------------------------

--
-- Table structure for table `licenca`
--

CREATE TABLE IF NOT EXISTS `licenca` (
  `JMBG` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `tipID` bigint(11) NOT NULL,
  `datumDobijanja` date DEFAULT NULL,
  PRIMARY KEY (`JMBG`,`tipID`),
  KEY `JMBG` (`JMBG`),
  KEY `tipID` (`tipID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `licenca`
--

INSERT INTO `licenca` (`JMBG`, `tipID`, `datumDobijanja`) VALUES
('0708010123455', 1, '2015-06-27'),
('0708010123455', 2, '2015-06-05'),
('0708010123455', 3, '2015-06-14'),
('0708010123455', 4, '2015-06-23'),
('1809010123412', 1, '2015-06-04'),
('1809010123412', 2, '2015-06-16'),
('1809010123412', 4, '2015-06-14'),
('1809010123412', 5, '2015-06-28'),
('2211992782867', 1, '2015-06-19'),
('2211992782867', 2, '2015-06-01'),
('2211992782867', 4, '2015-06-02'),
('2211992782867', 5, '2015-06-22'),
('2234555121200', 1, '2015-06-25'),
('2234555121200', 2, '2015-06-17'),
('2234555121200', 3, '2015-06-13'),
('2234555121200', 4, '2015-06-19'),
('2234555121212', 2, '2015-06-17'),
('2234555121212', 3, '2015-06-15'),
('2234555121212', 4, '2015-06-14'),
('2234555121223', 1, '2015-06-21'),
('2234555121223', 2, '2015-06-19'),
('2234555121223', 3, '2015-06-13'),
('2234555121223', 4, '2015-06-15'),
('2234555121233', 1, '2015-06-16'),
('2234555121233', 5, '2015-06-16'),
('2234555121234', 1, '2015-06-17'),
('2234555121234', 3, '2015-06-25'),
('2234555121234', 4, '2015-06-06'),
('2234555121234', 5, '2015-06-02'),
('2234555121254', 2, '2015-06-01'),
('2234555121254', 3, '2015-05-23'),
('2234555121254', 4, '2015-03-22'),
('2234555121255', 3, '2015-03-05'),
('2234555121255', 4, '2015-03-15'),
('2234555121255', 5, '2015-03-14'),
('2234555121261', 1, '2015-05-13'),
('2234555121261', 2, '2015-05-23'),
('2234555121261', 3, '2015-05-12');

-- --------------------------------------------------------

--
-- Table structure for table `pilot`
--

CREATE TABLE IF NOT EXISTS `pilot` (
  `JMBG` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `ocenaStanja` tinyint(1) DEFAULT NULL,
  `datumPregleda` date DEFAULT NULL,
  PRIMARY KEY (`JMBG`),
  KEY `JMBG` (`JMBG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `pilot`
--

INSERT INTO `pilot` (`JMBG`, `ocenaStanja`, `datumPregleda`) VALUES
('2200000782867', 0, '2015-06-13'),
('2211000782867', 1, '2015-06-07'),
('2234555121262', 1, '2015-06-23'),
('2234555121263', 1, '2015-06-03'),
('2234555121264', 1, '2015-04-15'),
('2234555121265', 1, '2015-01-13'),
('2234555121266', 1, '2015-03-10'),
('2234555121267', 0, '2015-06-13'),
('2234555121268', 0, '2015-06-11'),
('2234555121269', 0, '2015-07-17');

-- --------------------------------------------------------

--
-- Table structure for table `tipaviona`
--

CREATE TABLE IF NOT EXISTS `tipaviona` (
  `tipID` bigint(11) NOT NULL,
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`tipID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tipaviona`
--

INSERT INTO `tipaviona` (`tipID`, `naziv`) VALUES
(1, 'Putnicki'),
(2, 'Teretni'),
(3, 'Izvidjacki'),
(4, 'Ucenicki'),
(5, 'Borbeni');

-- --------------------------------------------------------

--
-- Table structure for table `uloga`
--

CREATE TABLE IF NOT EXISTS `uloga` (
  `JMBG` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `avionID` bigint(11) NOT NULL,
  `nazivUloge` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datum` date DEFAULT NULL,
  PRIMARY KEY (`JMBG`,`avionID`),
  KEY `JMBG` (`JMBG`),
  KEY `avionID` (`avionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `uloga`
--

INSERT INTO `uloga` (`JMBG`, `avionID`, `nazivUloge`, `datum`) VALUES
('2200000782867', 2, 'Instruktor', '2015-06-09'),
('2200000782867', 3, 'Instruktor', '2015-06-01'),
('2200000782867', 4, 'Glavni pilot', '2015-06-12'),
('2200000782867', 5, 'Ko pilot', '2015-06-13'),
('2211000782867', 1, 'Kapetan', '2015-06-06'),
('2211000782867', 3, 'Kapetan', '2015-06-26'),
('2211000782867', 4, 'Kapetan', '2015-06-13'),
('2211000782867', 5, 'Instruktor', '2015-06-05'),
('2234555121262', 1, 'Instruktor', '2015-06-06'),
('2234555121262', 2, 'Ko pilot', '2015-06-14'),
('2234555121262', 3, 'Instruktor', '2015-06-13'),
('2234555121263', 2, 'Ko pilot', '2015-06-23'),
('2234555121263', 3, 'Ucenik', '2015-06-14'),
('2234555121263', 4, 'Kapetan', '2015-06-04'),
('2234555121264', 2, 'Ko pilot', '2015-06-30'),
('2234555121264', 4, 'Kapetan', '2015-06-10'),
('2234555121264', 5, 'Kapetan', '2015-06-05'),
('2234555121265', 1, 'Kapetan', '2015-06-02'),
('2234555121265', 4, 'Kapetan', '2015-06-28'),
('2234555121265', 5, 'Instruktor', '2015-06-29'),
('2234555121266', 1, 'Kapetan', '2015-06-19'),
('2234555121266', 2, 'Kapetan', '2015-06-09'),
('2234555121266', 5, 'Kapetan', '2015-06-17'),
('2234555121267', 2, 'Kapetan', '2015-06-17'),
('2234555121267', 3, 'Kapetan', '2015-06-29'),
('2234555121267', 4, 'Kapetan', '2015-06-21'),
('2234555121268', 1, 'Instruktor', '2015-06-27'),
('2234555121268', 5, 'Ucenik', '2015-06-15'),
('2234555121269', 1, 'Ucenik', '2015-06-06'),
('2234555121269', 2, 'Ucenik', '2015-06-04'),
('2234555121269', 3, 'Instruktor', '2015-05-13'),
('2234555121269', 4, 'Instruktor', '2015-05-21'),
('2234555121269', 5, 'Ucenik', '2015-05-22');

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE IF NOT EXISTS `zaposleni` (
  `JMBG` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `imePrezime` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `godinaRodjenja` bigint(4) DEFAULT NULL,
  PRIMARY KEY (`JMBG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`JMBG`, `imePrezime`, `godinaRodjenja`) VALUES
('0708010123455', 'Stevan Stojanovic', 2010),
('1809010123412', 'Dusko Radinovic', 2010),
('2200000782867', 'Slobodan Marovic', 1992),
('2211000782867', 'Vladimir Jugovic', 1982),
('2211992782867', 'Refik Sabanadzovic', 1992),
('2234555121200', 'Ljubisa Milojevic', 1979),
('2234555121212', 'Darko Pancev', 1966),
('2234555121223', 'Dragisa Binic', 1976),
('2234555121233', 'Vlada Stosic', 1967),
('2234555121234', 'Goran Vasilijevic', 1971),
('2234555121254', 'Ivica Momcilovic', 1970),
('2234555121255', 'Zeljko Kaludjerovic', 1970),
('2234555121261', 'Ilija Najdoski', 1971),
('2234555121262', 'Robert Prosinecki', 1972),
('2234555121263', 'Dejan Savicevic', 1960),
('2234555121264', 'Sinisa Mihajlovic', 1965),
('2234555121265', 'Miodrag Belodedic', 1970),
('2234555121266', 'Milic Jovanovic', 1968),
('2234555121267', 'Goran Juric', 1969),
('2234555121268', 'Rade Tosic', 1975),
('2234555121269', 'Vladan Lukic', 1978);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `aviomehanicar`
--
ALTER TABLE `aviomehanicar`
  ADD CONSTRAINT `aviomehanicar_ibfk_1` FOREIGN KEY (`JMBG`) REFERENCES `zaposleni` (`JMBG`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `avion`
--
ALTER TABLE `avion`
  ADD CONSTRAINT `Avion_ibfk_1` FOREIGN KEY (`tipID`) REFERENCES `tipaviona` (`tipID`) ON UPDATE CASCADE;

--
-- Constraints for table `licenca`
--
ALTER TABLE `licenca`
  ADD CONSTRAINT `Licenca_ibfk_2` FOREIGN KEY (`tipID`) REFERENCES `tipaviona` (`tipID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `licenca_ibfk_1` FOREIGN KEY (`JMBG`) REFERENCES `aviomehanicar` (`JMBG`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `licenca_ibfk_2` FOREIGN KEY (`tipID`) REFERENCES `tipaviona` (`tipID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pilot`
--
ALTER TABLE `pilot`
  ADD CONSTRAINT `pilot_ibfk_1` FOREIGN KEY (`JMBG`) REFERENCES `zaposleni` (`JMBG`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `uloga`
--
ALTER TABLE `uloga`
  ADD CONSTRAINT `Uloga_ibfk_2` FOREIGN KEY (`avionID`) REFERENCES `avion` (`avionID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `uloga_ibfk_1` FOREIGN KEY (`JMBG`) REFERENCES `pilot` (`JMBG`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `uloga_ibfk_2` FOREIGN KEY (`avionID`) REFERENCES `avion` (`avionID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
