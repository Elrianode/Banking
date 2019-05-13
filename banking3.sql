-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2019 at 04:18 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banking3`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idcard` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remember_token` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `address`, `idcard`, `phone`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'Nguyễn Văn A', 'Hà Nội', '1234567890', '0987654321', NULL, '2019-04-06 17:00:00', NULL),
(2, 'Phạm Văn B', 'Sài gòn', '21243546575', '039339495', NULL, '2019-04-07 11:00:12', '2019-04-07 11:00:12'),
(3, 'Trương Quang Thái', '123456 ha noi', '123456789', '0916320407', NULL, '2019-04-02 17:00:00', '2019-04-11 17:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `interestrate`
--

CREATE TABLE `interestrate` (
  `id` int(11) NOT NULL,
  `m0` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `m1` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `m3` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `m6` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `m9` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `m12` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `m18` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `m24` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `m36` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `remember_token` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` varchar(123) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `interestrate`
--

INSERT INTO `interestrate` (`id`, `m0`, `m1`, `m3`, `m6`, `m9`, `m12`, `m18`, `m24`, `m36`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, '100.0', '0.8', '0.1', '7.6', '7.8', '8', '8.1', '8.1', '8.1', NULL, 'Thu May 09 19:21:02 ICT 2019', NULL),
(2, '1', '2', '3', '4', '5', '6', '7', '8', '9', NULL, '2019-05-22 00:00:00', NULL),
(3, '1', '2', '3', '4', '5', '6', '7', '8', '9', NULL, '2019-05-30 00:00:00', NULL),
(4, '1.0', '2.0', '3.0', '4.0', '5.0', '6.0', '7.0', '8.0', '7.0', NULL, NULL, NULL),
(5, '1.0', '2.0', '3.0', '4.0', '5.0', '6.0', '7.0', '8.0', '0.0', NULL, 'Thu May 09 10:38:54 ICT 2019', NULL),
(6, '1.0', '2.0', '3.0', '4.0', '5.0', '6.0', '7.0', '8.0', '9.0', NULL, '2019-05-05 00:00:00', NULL),
(7, '1.0', '2.0', '3.0', '4.0', '5.0', '6.0', '7.0', '8.0', '9.0', NULL, '2019-05-05 00:00:00', NULL),
(8, '1.0', '2.0', '3.0', '4.0', '5.0', '6.0', '7.0', '8.0', '9.0', NULL, 'Thu May 09 10:38:59 ICT 2019', NULL),
(9, '1.0', '2.0', '3.0', '4.0', '5.0', '6.0', '7.0', '8.0', '9.0', NULL, 'Thu May 09 10:38:59 ICT 2019', NULL),
(10, '1.0', '2.0', '3.0', '4.0', '5.0', '6.0', '7.0', '8.0', '9.0', NULL, 'Thu May 09 10:38:59 ICT 2019', NULL),
(11, '1.0', '2.0', '3.0', '4.0', '5.0', '6.0', '7.0', '8.0', '9.0', NULL, '2019-05-09 00:00:00.0', NULL),
(12, '1.0', '2.0', '3.0', '4.0', '5.0', '6.0', '7.0', '8.0', '9.0', NULL, '2019-05-09 00:00:00.0', NULL),
(13, '1.0', '2.0', '3.0', '4.0', '5.0', '6.0', '7.0', '8.0', '9.0', NULL, '2019-05-09 00:00:00.0', NULL),
(14, '1.0', '2.0', '3.0', '4.0', '5.0', '60.0', '7.0', '8.0', '9.0', NULL, 'Thu May 09 11:25:40 ICT 2019', NULL),
(15, '1.0', '2.0', '3.0', '4.0', '5.0', '3.0', '7.0', '8.0', '9.0', NULL, 'Thu May 09 11:26:18 ICT 2019', NULL),
(16, '1.0', '2.0', '3.0', '4.0', '5.0', '3.0', '2.0', '8.0', '9.0', NULL, 'Thu May 09 11:26:33 ICT 2019', NULL),
(17, '1.0', '2.0', '3.0', '4.0', '5.0', '3.0', '2.0', '8.0', '4.0', NULL, 'Thu May 09 11:28:13 ICT 2019', NULL),
(18, '1.0', '2.0', '3.0', '4.0', '2.0', '3.0', '2.0', '8.0', '4.0', NULL, 'Thu May 09 11:28:34 ICT 2019', NULL),
(19, '1.0', '2.0', '3.0', '4.0', '2.0', '3.0', '2.0', '8.0', '4.0', NULL, 'Thu May 09 19:21:01 ICT 2019', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `loanaccount`
--

CREATE TABLE `loanaccount` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_customer` int(11) NOT NULL,
  `id_loanrate` int(11) NOT NULL,
  `loan` double(8,2) NOT NULL,
  `kind` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `loanaccount`
--

INSERT INTO `loanaccount` (`id`, `id_customer`, `id_loanrate`, `loan`, `kind`, `created_at`, `updated_at`) VALUES
(1, 2, 1, 10000.00, 'abcxzy', '2019-05-04 17:00:00', '2019-05-04 17:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `loanrate`
--

CREATE TABLE `loanrate` (
  `id` int(10) NOT NULL,
  `12month` double DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `6month` double DEFAULT NULL,
  `36month` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `loanrate`
--

INSERT INTO `loanrate` (`id`, `12month`, `created_at`, `updated_at`, `6month`, `36month`) VALUES
(1, 8.4, '2019-05-05 05:00:00', '2019-05-04 17:00:00', 1.2, 3.4);

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_customer_table', 1),
(2, '2014_10_12_000000_create_interestrate_table', 2),
(5, '2014_10_12_000000_create_loanrate_table', 3),
(6, '2014_10_12_000000_create_loanaccount_table', 4);

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `savingaccount`
--

CREATE TABLE `savingaccount` (
  `id` int(11) NOT NULL,
  `id_rate` int(11) NOT NULL,
  `number` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `cash` double DEFAULT NULL,
  `term` int(11) DEFAULT NULL,
  `idcustomer` int(11) DEFAULT NULL,
  `kind` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `iswithdrawned` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `quyen` int(11) NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `quyen`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'bien pham', 'bienpn@mageplaza.com', '$2y$10$CEdbdsSMU9Nv.6yjdRMEtOhR0kdIiOBWtNR2Bup9upjueOPbcsM9m', 1, 'dO3cuQPDo5vYUtTURHhA4OUFcS3TGtehVfhcQhsMgF8MvKVmKjd33XMCXRRJ', '2019-04-06 17:00:00', NULL),
(2, 'thaimeo', 'thaimeo0210@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 1, NULL, '2019-04-02 17:00:00', '2019-04-11 17:00:00'),
(3, 'admin', 'admin', 'admin', 1, NULL, NULL, NULL),
(4, 'admin', 'admin', 'admin', 1, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idcard_UNIQUE` (`idcard`),
  ADD UNIQUE KEY `phone_UNIQUE` (`phone`);

--
-- Indexes for table `interestrate`
--
ALTER TABLE `interestrate`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loanaccount`
--
ALTER TABLE `loanaccount`
  ADD PRIMARY KEY (`id`),
  ADD KEY `loanaccount_id_customer_foreign` (`id_customer`),
  ADD KEY `loanaccount_id_loanrate_foreign` (`id_loanrate`);

--
-- Indexes for table `loanrate`
--
ALTER TABLE `loanrate`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `savingaccount`
--
ALTER TABLE `savingaccount`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer saving account_idx` (`idcustomer`),
  ADD KEY `id_rate` (`id_rate`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `interestrate`
--
ALTER TABLE `interestrate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `loanaccount`
--
ALTER TABLE `loanaccount`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `loanrate`
--
ALTER TABLE `loanrate`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `savingaccount`
--
ALTER TABLE `savingaccount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `loanaccount`
--
ALTER TABLE `loanaccount`
  ADD CONSTRAINT `loanaccount_id_customer_foreign` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `loanaccount_id_loanrate_foreign` FOREIGN KEY (`id_loanrate`) REFERENCES `loanrate` (`id`);

--
-- Constraints for table `savingaccount`
--
ALTER TABLE `savingaccount`
  ADD CONSTRAINT `customer saving account` FOREIGN KEY (`idcustomer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `savingaccount_ibfk_1` FOREIGN KEY (`id_rate`) REFERENCES `interestrate` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
