-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : ven. 02 août 2024 à 13:13
-- Version du serveur : 10.7.3-MariaDB-log
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `theboutique`
--
CREATE DATABASE IF NOT EXISTS `theboutique` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `theboutique`;

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Parent` (`Parent`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`Id`, `nom`, `Parent`) VALUES
(1, 'Accessoires', NULL),
(2, 'Thés', NULL),
(3, 'Thé vert', 2),
(4, 'Thé blanc', 2);

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

DROP TABLE IF EXISTS `produits`;
CREATE TABLE IF NOT EXISTS `produits` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prix` double NOT NULL,
  `quantite` int(11) NOT NULL,
  `description` text NOT NULL,
  `categorie_id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `categorie_id` (`categorie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`Id`, `nom`, `prix`, `quantite`, `description`, `categorie_id`) VALUES
(1, 'Thé vert', 45.6, 410, 'Thé vert de l\'empereur', 3),
(2, 'Théière', 49.99, 6, 'Théière', 1),
(3, 'The Blanc', 10, 50, 'Thé Vert mais blanc', 4),
(4, 'The Blanc', 10, 50, 'Thé Vert mais blanc', 4);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `categories`
--
ALTER TABLE `categories`
  ADD CONSTRAINT `categories_ibfk_1` FOREIGN KEY (`Parent`) REFERENCES `categories` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `produits_ibfk_1` FOREIGN KEY (`categorie_id`) REFERENCES `categories` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
