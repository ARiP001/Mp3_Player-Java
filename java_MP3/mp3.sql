-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2024 at 11:09 AM
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
(12, 'arif', 'Wind Riders', 'Asher Fulero', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Wind Riders - Asher Fulero.mp3'),
(13, 'arif', 'Tropic Fuse', 'French Fuse', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Tropic Fuse - French Fuse.mp3'),
(14, 'test', 'Epilogue', 'YOASOBI', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\YOASOBI - THE BOOK MP3\\01  Epilogue.mp3'),
(16, 'playlist_baru', 'Encore', 'YOASOBI', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Encore.mp3'),
(17, 'playlist_baru', 'Halzion', 'YOASOBI', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Halzion.mp3'),
(18, 'coba _fix', 'Encore', 'YOASOBI', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Encore.mp3'),
(19, 'coba _fix', 'Halzion', 'YOASOBI', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Halzion.mp3'),
(20, 'coba _fix', 'Tabun', 'YOASOBI', 'C:\\Users\\LWNOVO\\Documents\\NetBeansProjects\\java_MP3\\src\\assets\\Tabun.mp3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `playlist`
--
ALTER TABLE `playlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
