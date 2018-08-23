-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2016 at 05:54 AM
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
('kim', '2016-10-25', '11:39:31'),
('kim', '2016-11-07', '09:10:55'),
('kim', '2016-11-16', '14:34:32'),
('kim', '2016-11-22', '20:30:21');

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
('kim', '2016-10-25', '11:39:35'),
('kim', '2016-11-07', '09:10:58'),
('kim', '2016-11-16', '14:34:36'),
('kim', '2016-11-22', '20:30:29');

-- --------------------------------------------------------

--
-- Table structure for table `leaverequest`
--

CREATE TABLE IF NOT EXISTS `leaverequest` (
  `EmpId` varchar(10) NOT NULL,
  `Start` date NOT NULL,
  `End` date NOT NULL,
  `Reason` text NOT NULL,
  PRIMARY KEY (`EmpId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `leavestatus`
--

CREATE TABLE IF NOT EXISTS `leavestatus` (
  `EmpId` varchar(10) NOT NULL,
  `Status` varchar(10) NOT NULL,
  PRIMARY KEY (`EmpId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
('dan', 'dan', 'dan', 'dan', 'dan@gmail.com', '0704829933', '2016-11-05'),
('kim', 'kim', 'kim', 'kim', 'kim', '12345678', '2016-10-12'),
('man', 'man', 'man', 'man', 'manDFGHJK', 'sdfghjk', '2016-11-02');

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
('dan', 'member'),
('kim', 'kim'),
('man', 'member');

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
