-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Май 04 2020 г., 06:39
-- Версия сервера: 5.7.24
-- Версия PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `db1`
--
CREATE DATABASE IF NOT EXISTS `db1` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `db1`;

-- --------------------------------------------------------

--
-- Структура таблицы `shops`
--

DROP TABLE IF EXISTS `shops`;
CREATE TABLE IF NOT EXISTS `shops` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET cp1251 COLLATE cp1251_bulgarian_ci NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `shops`
--

INSERT INTO `shops` (`id`, `name`, `address`, `phone`) VALUES
(1, 'Артур', '​Нурсултана Назарбаева проспект, 41', '+7 (7182) 54‒66‒06'),
(2, 'Квазар', '​Естая, 81', '+7 (7182) 32‒02‒05'),
(3, 'Манакбай', '​Машхур Жусупа﻿, 15', '+7 (7182) 55‒49‒86'),
(4, 'Керуен', 'Камзина, 171', ''),
(5, 'Goodwin', 'Нурсултана Назарбаева проспект, 50/1', ''),
(6, 'ГУЛЛИВЕР', 'Розы Люксембург, 113', ''),
(7, 'Атриум', 'Академика Сатпаева, 245/1', ''),
(8, 'Orange', 'Нурсултана Назарбаева проспект, 283/1', ''),
(9, 'Барыс', 'Торайгырова, 56', '+7 (7182) 55‒16‒79'),
(10, 'Отау', '​Торайгырова, 113', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
