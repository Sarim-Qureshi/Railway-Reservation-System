-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 07, 2022 at 03:05 PM
-- Server version: 8.0.21
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `railwayrs`
--

-- --------------------------------------------------------

--
-- Table structure for table `meal`
--

DROP TABLE IF EXISTS `meal`;
CREATE TABLE IF NOT EXISTS `meal` (
  `Meal_id` int NOT NULL,
  `Meal_type` varchar(25) DEFAULT NULL,
  `Price` int DEFAULT NULL,
  PRIMARY KEY (`Meal_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `meal`
--

INSERT INTO `meal` (`Meal_id`, `Meal_type`, `Price`) VALUES
(423, 'Rajwada meal', 210),
(678, 'Vada Basket', 180),
(986, 'Paratha Basket', 200),
(467, 'idli and sambhar', 80),
(902, 'Dal Bhat', 80),
(453, 'Pasta', 170),
(527, 'Fried Rice', 110),
(892, 'manchorian', 120),
(906, 'Puri Bhaji', 90);

-- --------------------------------------------------------

--
-- Table structure for table `pnr`
--

DROP TABLE IF EXISTS `pnr`;
CREATE TABLE IF NOT EXISTS `pnr` (
  `trainno` varchar(20) NOT NULL,
  `pnrno` int NOT NULL,
  `traintime` varchar(10) DEFAULT NULL,
  `ticketprice` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  PRIMARY KEY (`trainno`,`pnrno`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `pnr`
--

INSERT INTO `pnr` (`trainno`, `pnrno`, `traintime`, `ticketprice`, `date`, `firstname`, `lastname`) VALUES
('01019/20', 6017, '03:00 PM', 2500, '2020-12-05', 'sr', 'nj'),
('01016/15', 5195, '03:00 PM', 2500, '2020-12-14', '', ''),
('01016/15', 9083, '03:00 PM', 2500, '2020-12-14', 'Arr', 'yutr'),
('01016/15', 9096, '03:00 PM', 2500, '2020-12-08', 'wirk', 'ty'),
('01016/15', 8150, '03:00 PM', 2500, '2020-12-20', 'Sarim', 'Qureshi'),
('01016/15', 6816, '03:00 PM', 2500, '2020-12-20', 'abc', 'xyz'),
('01016/15', 2886, '03:00 PM', 2500, '2020-12-05', 'Ichigo', 'Kurosaki'),
('01016/15', 6106, '03:00 PM', 2500, '2020-12-09', 'Armin', 'Meiwes');

-- --------------------------------------------------------

--
-- Table structure for table `rpnr`
--

DROP TABLE IF EXISTS `rpnr`;
CREATE TABLE IF NOT EXISTS `rpnr` (
  `trainno` int NOT NULL,
  `pnrno` int NOT NULL,
  `traindepttime` varchar(10) NOT NULL,
  `ticketprice` int NOT NULL,
  `date` date NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  PRIMARY KEY (`trainno`,`pnrno`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rpnr`
--

INSERT INTO `rpnr` (`trainno`, `pnrno`, `traindepttime`, `ticketprice`, `date`, `firstname`, `lastname`) VALUES
(11077, 1572, '17:20', 1500, '2020-12-06', 'c', 'd'),
(11077, 2977, '17:20', 1500, '2020-12-08', 'c', 'c'),
(11077, 3125, '17:20', 1500, '2020-12-08', '', 'c'),
(11077, 1086, '17:20', 1500, '2020-12-14', 'ne', 'wt'),
(11077, 2957, '17:20', 1500, '2020-12-14', 'yry', 'ne'),
(11077, 2052, '17:20', 1500, '2020-12-14', 'c', 'c'),
(11077, 3416, '17:20', 1500, '2020-12-11', 'r', 'y'),
(11077, 7531, '17:20', 1500, '2020-12-11', 'c', 'c'),
(11077, 7326, '17:20', 1500, '2020-12-22', 'abc2', 'xyz2'),
(11077, 6931, '17:20', 1500, '2020-12-06', 'c', 'c'),
(11077, 425, '17:20', 1500, '2020-12-06', '', ''),
(11077, 7686, '17:20', 1500, '2020-12-06', '', ''),
(11077, 665, '17:20', 1500, '2020-12-10', 'Poin', 'Tri');

-- --------------------------------------------------------

--
-- Table structure for table `rt11077`
--

DROP TABLE IF EXISTS `rt11077`;
CREATE TABLE IF NOT EXISTS `rt11077` (
  `depttime` varchar(10) DEFAULT NULL,
  `arrtime` varchar(10) DEFAULT NULL,
  `tickets` int DEFAULT NULL,
  `ticketprice` int DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rt11077`
--

INSERT INTO `rt11077` (`depttime`, `arrtime`, `tickets`, `ticketprice`, `date`) VALUES
('17:20', '10:10', 5, 1500, '2020-12-25'),
('17:20', '10:10', 5, 1500, '2020-12-24'),
('17:20', '10:10', 5, 1500, '2020-12-23'),
('17:20', '10:10', 4, 1500, '2020-12-22'),
('17:20', '10:10', 5, 1500, '2020-12-21'),
('17:20', '10:10', 5, 1500, '2020-12-17'),
('17:20', '10:10', 5, 1500, '2020-12-18'),
('17:20', '10:10', 5, 1500, '2020-12-19'),
('17:20', '10:10', 5, 1500, '2020-12-20');

-- --------------------------------------------------------

--
-- Table structure for table `rt12019`
--

DROP TABLE IF EXISTS `rt12019`;
CREATE TABLE IF NOT EXISTS `rt12019` (
  `depttime` varchar(10) DEFAULT NULL,
  `arrtime` varchar(10) DEFAULT NULL,
  `tickets` int DEFAULT NULL,
  `ticketprice` int DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rt12019`
--

INSERT INTO `rt12019` (`depttime`, `arrtime`, `tickets`, `ticketprice`, `date`) VALUES
('17:20', '10:10', 5, 1500, '2020-12-25'),
('17:20', '10:10', 5, 1500, '2020-12-24'),
('17:20', '10:10', 5, 1500, '2020-12-23'),
('17:20', '10:10', 5, 1500, '2020-12-22'),
('17:20', '10:10', 5, 1500, '2020-12-21'),
('17:20', '10:10', 5, 1500, '2020-12-17'),
('17:20', '10:10', 5, 1500, '2020-12-18'),
('17:20', '10:10', 5, 1500, '2020-12-19'),
('17:20', '10:10', 5, 1500, '2020-12-20');

-- --------------------------------------------------------

--
-- Table structure for table `spt0101615`
--

DROP TABLE IF EXISTS `spt0101615`;
CREATE TABLE IF NOT EXISTS `spt0101615` (
  `traintime` varchar(10) NOT NULL,
  `tickets` int DEFAULT NULL,
  `ticketprice` int DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`traintime`,`date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `spt0101615`
--

INSERT INTO `spt0101615` (`traintime`, `tickets`, `ticketprice`, `date`) VALUES
('03:00 PM', 5, 2500, '2020-12-25'),
('03:00 PM', 5, 2500, '2020-12-23'),
('03:00 PM', 5, 2500, '2020-12-24'),
('03:00 PM', 5, 2500, '2020-12-19'),
('03:00 PM', 5, 2500, '2020-12-22'),
('03:00 PM', 5, 2500, '2020-12-21'),
('03:00 PM', 3, 2500, '2020-12-20'),
('03:00 PM', 5, 2500, '2020-12-17'),
('03:00 PM', 5, 2500, '2020-12-18');

-- --------------------------------------------------------

--
-- Table structure for table `spt0101920`
--

DROP TABLE IF EXISTS `spt0101920`;
CREATE TABLE IF NOT EXISTS `spt0101920` (
  `traintime` varchar(10) NOT NULL,
  `tickets` int DEFAULT NULL,
  `ticketprice` int DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`traintime`,`date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `spt0101920`
--

INSERT INTO `spt0101920` (`traintime`, `tickets`, `ticketprice`, `date`) VALUES
('03:00 PM', 5, 2500, '2020-12-25'),
('03:00 PM', 5, 2500, '2020-12-23'),
('03:00 PM', 5, 2500, '2020-12-24'),
('03:00 PM', 5, 2500, '2020-12-19'),
('03:00 PM', 5, 2500, '2020-12-22'),
('03:00 PM', 5, 2500, '2020-12-21'),
('03:00 PM', 5, 2500, '2020-12-20'),
('03:00 PM', 5, 2500, '2020-12-17'),
('03:00 PM', 5, 2500, '2020-12-18');

-- --------------------------------------------------------

--
-- Table structure for table `traindet`
--

DROP TABLE IF EXISTS `traindet`;
CREATE TABLE IF NOT EXISTS `traindet` (
  `trainnum` varchar(20) NOT NULL,
  `trainname` varchar(50) NOT NULL,
  `trainsource` varchar(50) NOT NULL,
  `traindest` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `traindet`
--

INSERT INTO `traindet` (`trainnum`, `trainname`, `trainsource`, `traindest`) VALUES
('01016/15', 'Kushinagar Express', 'Gorakhpur', 'Lokmanyatilak (T)'),
('01019/20', 'Konarka Express', 'Mumbai CST', 'Bhubaneswar'),
('01061/62', 'Darbhanga Express', 'Lokmanyatilak (T)', 'Darbhanga'),
('01071/72', 'Kamayani Express', 'Lokmanyatilak (T)', 'Varanasi'),
('01093/94', 'Mahanagri Express', 'Mumbai CST', 'Varanasi'),
('01139/40', 'Mumbai CST Gadag Express', 'Mumbai CST', 'Gadag'),
('01301/02', 'Udyan Express', 'Mumbai CST', 'KSR Bengaluru'),
('02156/55', 'Bhopal Express', 'Hazrat Nizamuddin', 'Habibganj'),
('02230/29', 'Lucknow Mail', 'New Delhi', 'Lucknow Jn'),
('02296/95', 'Sanghmitra Express', 'Danapur', 'KSR Bengaluru'),
('02377/78', 'Padatik Express', 'Sealdah', 'New Alipurduar'),
('02392/91', 'Shramjevi Express', 'New Delhi', 'Rajgir'),
('02394/93', 'Sampoorn Kranti Express', 'New Delhi', 'Rajendra Nagar'),
('02418/17', 'Prayagraj Express', 'New Delhi', 'Prayagraj'),
('02420/19', 'Gomti Express', 'New Delhi', 'Lucknow'),
('02407/08', 'Karambhumi Express', 'Amritsar', 'New Jalpaiguri'),
('02357/58', 'Amritsar Kolkata Express', 'Amritsar', 'Kolkata'),
('02452/51', 'Shram Shakti Express', 'New Delhi', 'Kanpur'),
('02463/64', 'Samprak KrantiJodhpur', 'Jodhpur', 'Jaipur'),
('02477/78', 'Jaipur Jodhpur Express', 'Jaipur', 'Jodhpur'),
('02479/80', 'Suryanagri Express', 'Bandra (T)', 'Jodhpur'),
('02533/34', 'Pushpak Express', 'Lucknow', 'Mumbai CST'),
('02555/56', 'Gorakhdham Express', 'Hisar', 'Gorakhpur'),
('02560/59', 'Shivganga Express', 'New Delhi', 'Manduadih'),
('02618/17', 'Mangla Express', 'Hazrat Nizamuddin', 'Ernakulam'),
('04009/10', 'Champaran Satyagrah Express', 'Anand Vihar', 'Bapudham Motihari'),
('02629/30', 'Karnataka Samprak Kranti Express', 'New Delhi', 'Yesvantpur'),
('02701/02', 'Husain Sagar Express', 'Mumbai CST', 'Hyderabad'),
('02703/04', 'Falaknuma Express', 'Howrah', 'Secunderabad'),
('02715/16', 'Sachkhand Express', 'H. S. Nanded', 'Amritsar'),
('02724/23', 'Telangana Express', 'New Delhi', 'Hyderabad'),
('02792/91', 'Danapur Secunderabad Express', 'Danapur', 'Secunderabad'),
('02801/02', 'Purushottam Express', 'Puri', 'New Delhi'),
('02810/09', 'HWH-Mumbai Mail', 'Howrah', 'Mumbai CST'),
('02833/34', 'Ahmedabad Howrah Express', 'Ahmedabad', 'Howrah'),
('02904/03', 'Golden Temple Mail', 'Amritsar', 'Mumbai CST'),
('02916/15', 'Ashram Express', 'Delhi', 'Ahmedabad'),
('02926/25', 'Paschim Express', 'Amritsar', 'Bandra'),
('02933/34', 'Karnavati Express', 'Mumbai CST', 'Ahmedabad'),
('02963/64', 'Mewar Express', 'Hazrat Nizamuddin', 'Udaipur City'),
('08183/84', 'Tatanagar Danapur Express', 'Tatanagar', 'Danapur'),
('05484/83', 'Mahananda Express', 'Delhi', 'Alipurduar'),
('06345/46', 'Netrvati Express', 'Mumbai (LTT)', 'Thiruvananthapuram Central'),
('02806/06', 'AP Express', 'Vishakapatnam', 'New Delhi'),
('02182/81', 'Nizamuddin Jabalpur Express', 'Hazrat Nizamuddin', 'Jabalpur'),
('02418/17', 'Mahamana Express', 'New Delhi', 'Varanasi'),
('02955/56', 'Mumbai Central Jaipur Express', 'Mumbai Central', 'Jaipur'),
('07201/02', 'Golconda Express', 'Guntur', 'Secunderabad'),
('02793/94', 'Rayalseema Express', 'Tirupati', 'Nizamabad'),
('09165/66', 'Sabarmati Express', 'Ahmedabad', 'Darbhanga');

-- --------------------------------------------------------

--
-- Table structure for table `train_list`
--

DROP TABLE IF EXISTS `train_list`;
CREATE TABLE IF NOT EXISTS `train_list` (
  `Train_no` int NOT NULL,
  `Train_name` varchar(53) DEFAULT NULL,
  `Train_type` varchar(12) DEFAULT NULL,
  `Dept_time` varchar(13) DEFAULT NULL,
  `Arri_time` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Train_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `train_list`
--

INSERT INTO `train_list` (`Train_no`, `Train_name`, `Train_type`, `Dept_time`, `Arri_time`) VALUES
(11077, 'PUNE - JAMMU TAWI JHELUM EXPRESS', 'MAIL EXPRESS', '17:20', '10:10'),
(12019, 'HOWRAH - RANCHI SHATABDI EXPRESS', 'SHATABDI', '06:05', '13:15'),
(12038, 'LUDHIANA - NEW DELHI SHATABDI EXPRESS', 'SHATABDI', '16:40', '22:10'),
(12048, 'FIROZPUR - NEW DELHI SHATABDI EXPRESS', 'SHATABDI', '04:00', '21:10'),
(12049, 'AGRA CANTT - DELHI H NIZAMUDDIN GATIMAAN EXPRESS', 'SHATABDI', '17:50', '19:30'),
(12050, 'DELHI H NIZAMUDDIN - AGRA CANTT GATIMAAN EXPRESS', 'SHATABDI', '08:10', '09:50'),
(12138, 'FIROZPUR CANTT - MUMBAI CST PUNJAB MAIL SF EXP', 'SUPERFAST', '21:40', '07:35'),
(12267, 'MUMBAI CENTRAL - AHMEDABAD AC DURONTO EXP', 'DURONTO', '23:25', '05:55'),
(12268, 'AHMEDABAD - MUMBAI CENT AC DURONTO EXP', 'DURONTO', '23:40', '06:00'),
(12295, 'BANGALORE CITY - DANAPUR SANGHAMITRA SF EXP', 'SUPERFAST', '09:00', '09:20'),
(12307, 'HOWRAH - JODHPUR SF EXPRESS', 'SUPERFAST', '23:30', '08:30'),
(12424, 'NEW DELHI - DIBRUGARH TOWN RAJDHANI EXPRESS', 'RAJDHANI', '13:55', '07:00'),
(12426, 'JAMMU TAWI - NEW DELHI RAJDHANI EXPRESS', 'RAJDHANI', '19:40', '05:05'),
(12430, 'NEW DELHI - LUCKNOW AC SF EXPRESS', 'RAJDHANI', '20:50', '06:40'),
(12437, 'SECUNDERABAD - HAZRAT NIZAMUDDIN RAJDHANI EXPRESS', 'RAJDHANI', '12:45', '10:25'),
(12506, 'DELHI ANAND VIHAR - GUWAHATI NORTH EAST EXPRESS', 'SUPERFAST', '06:45', '16:50'),
(12801, 'PURI - NEW DELHI PURUSHOTTAM SF EXPRESS', 'SUPERFAST', '21:45', '04:50'),
(12802, 'NEW DELHI - PURI PURUSHOTTAM SF EXPRESS', 'SUPERFAST', '22:15', '05:25'),
(12833, 'AHMEDABAD - HOWRAH SF EXPRESS', 'SUPERFAST', '00:15', '13:30'),
(12859, 'MUMBAI CST - HOWRAH GITANJALI SF EXPRESS', 'SUPERFAST', '06:00', '12:30'),
(12864, 'YESVANTPUR - HOWRAH SF EXPRESS', 'SUPERFAST', '19:35', '06:25'),
(12951, 'MUMBAI CENTRAL - NEW DELHI RAJDHANI EXPRESS', 'RAJDHANI', '16:35', '08:35'),
(12953, 'MUMBAI CENT - HAZRAT NIZAMUDDIN AUGUST KRANTI RAJ EXP', 'RAJDHANI', '17:40', '10:55'),
(22201, 'KOLKATA SEALDAH - PURI DURONTO EXPRESS', 'DURONTO', '20:00', '04:00'),
(22204, 'SECUNDERABAD - VISAKHAPATNAM AC DURONTO EXPRESS', 'DURONTO', '20:15', '06:35'),
(22206, 'MADURAI - CHENNAI CENTRAL AC DURONTO EXPRESS', 'DURONTO', '22:40', '07:20');

-- --------------------------------------------------------

--
-- Table structure for table `udata`
--

DROP TABLE IF EXISTS `udata`;
CREATE TABLE IF NOT EXISTS `udata` (
  `username` varchar(20) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `udata`
--

INSERT INTO `udata` (`username`, `firstname`, `lastname`, `password`) VALUES
('admin', '', '', 'admin'),
('abc', 'abc', 'xyz', '123'),
('i', 'Ichigo', 'Kurosaki', 'i'),
('d', 'c', 'c', 'd'),
('sarim', 'Sarim', 'Qureshi', '1234');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
