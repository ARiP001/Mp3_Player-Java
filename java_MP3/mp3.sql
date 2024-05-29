-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2024 at 07:24 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mp3`
--

-- --------------------------------------------------------

--
-- Table structure for table `music`
--

CREATE TABLE `music` (
  `id` int(11) NOT NULL,
  `judul` varchar(25) NOT NULL,
  `genre` varchar(25) NOT NULL,
  `artis` varchar(25) NOT NULL,
  `link` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `music`
--

INSERT INTO `music` (`id`, `judul`, `genre`, `artis`, `link`) VALUES
(1, 'letsgo', 'anisong', 'abraar', 'https');

-- --------------------------------------------------------

--
-- Table structure for table `playlist`
--

CREATE TABLE `playlist` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `judul` varchar(255) NOT NULL,
  `artis` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `playlist`
--

INSERT INTO `playlist` (`id`, `nama`, `judul`, `artis`, `link`) VALUES
(3, 'arif', '', '', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Tropic Fuse - French Fuse.mp3'),
(4, 'arif', '', '', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Wind Riders - Asher Fulero.mp3'),
(5, 'coba', '', '', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Wind Riders - Asher Fulero.mp3'),
(6, 'coba', '', '', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Wind Riders - Asher Fulero.mp3'),
(7, 'coba', '', '', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Tropic Fuse - French Fuse.mp3'),
(8, 'arif', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Tropic Fuse - French Fuse.mp3', 'Tropic Fuse', 'French Fuse'),
(9, 'arif', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Wind Riders - Asher Fulero.mp3', 'Wind Riders', 'Asher Fulero');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `music`
--
ALTER TABLE `music`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `music`
--
ALTER TABLE `music`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `playlist`
--
ALTER TABLE `playlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
