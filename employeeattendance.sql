-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 28, 2016 at 12:06 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `employeeattendance`
--

-- --------------------------------------------------------

--
-- Table structure for table `archivesmembers`
--

CREATE TABLE IF NOT EXISTS `archivesmembers` (
  `EmpId` varchar(10) NOT NULL,
  `FName` varchar(20) NOT NULL,
  `SName` varchar(20) NOT NULL,
  `LName` varchar(20) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `PhoneNo` varchar(15) NOT NULL,
  `DOB` date NOT NULL,
  PRIMARY KEY (`EmpId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `archivesmembers`
--

INSERT INTO `archivesmembers` (`EmpId`, `FName`, `SName`, `LName`, `Email`, `PhoneNo`, `DOB`) VALUES
('asdfgh', 'sedrtyu', 'swedrfgyhj', 'ertyu', 'sedrtyuj', 'ertyhuj', '2016-09-12'),
('erftgh', 'ertyhuj', 'ertgyjk', 'rftgyjk', 'rfgtyujk', 'fgtyjkl', '2016-09-12'),
('kim', 'kim', 'kim', 'kim', 'kim', '1234567', '2016-09-13');

-- --------------------------------------------------------

--
-- Table structure for table `checkin`
--

CREATE TABLE IF NOT EXISTS `checkin` (
  `EmpId` varchar(10) NOT NULL DEFAULT '',
  `checkinDate` date NOT NULL DEFAULT '0000-00-00',
  `checkinTime` time DEFAULT NULL,
  PRIMARY KEY (`EmpId`,`checkinDate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `checkin`
--

INSERT INTO `checkin` (`EmpId`, `checkinDate`, `checkinTime`) VALUES
('dan', '2016-09-27', '19:45:25'),
('dan', '2016-09-28', '09:04:37'),
('wer', '2016-09-27', '11:30:12'),
('wer', '2016-09-28', '08:34:09');

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

CREATE TABLE IF NOT EXISTS `checkout` (
  `EmpId` varchar(10) NOT NULL DEFAULT '',
  `checkOutDate` date NOT NULL DEFAULT '0000-00-00',
  `checkOutTime` time DEFAULT NULL,
  PRIMARY KEY (`EmpId`,`checkOutDate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `checkout`
--

INSERT INTO `checkout` (`EmpId`, `checkOutDate`, `checkOutTime`) VALUES
('dan', '2016-09-27', '19:45:29'),
('dan', '2016-09-28', '09:04:40'),
('wer', '2016-09-27', '11:29:05'),
('wer', '2016-09-28', '08:34:15');

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `EmpId` varchar(10) NOT NULL,
  `FName` varchar(20) NOT NULL,
  `SName` varchar(20) DEFAULT NULL,
  `LName` varchar(20) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `PhoneNo` varchar(15) NOT NULL,
  `DOB` date NOT NULL,
  PRIMARY KEY (`EmpId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`EmpId`, `FName`, `SName`, `LName`, `Email`, `PhoneNo`, `DOB`) VALUES
('bob', 'bob', 'bob', 'bob', 'bob', 'bob', '2016-02-08'),
('dan', 'dan', 'dan', 'dan', 'dan', 'dan', '2016-03-09'),
('man', 'man', 'man', 'man', 'man', 'man', '2016-00-06'),
('wer', 'erty', 'rtyui', 'rtyui', 'tyuiop[', 'dfghj', '0000-00-00');

--
-- Triggers `members`
--
DROP TRIGGER IF EXISTS `archivemember`;
DELIMITER //
CREATE TRIGGER `archivemember` AFTER DELETE ON `members`
 FOR EACH ROW insert into archivesmembers values(old.EmpId,old.Fname,old.Sname,old.Lname,old.Email,old.phoneNo,old.DOB)
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `EmpId` varchar(10) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`EmpId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`EmpId`, `password`) VALUES
('bob', 'member'),
('dan', 'member'),
('man', 'member'),
('wer', 'kim');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `checkin`
--
ALTER TABLE `checkin`
  ADD CONSTRAINT `checkin_ibfk_1` FOREIGN KEY (`EmpId`) REFERENCES `members` (`EmpId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `checkout`
--
ALTER TABLE `checkout`
  ADD CONSTRAINT `checkout_ibfk_1` FOREIGN KEY (`EmpId`) REFERENCES `members` (`EmpId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`EmpId`) REFERENCES `members` (`EmpId`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
