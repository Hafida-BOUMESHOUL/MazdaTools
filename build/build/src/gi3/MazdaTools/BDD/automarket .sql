-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 27 mai 2021 à 22:45
-- Version du serveur :  10.4.19-MariaDB
-- Version de PHP : 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `automarket`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `name`, `phone`, `email`, `gender`) VALUES
(1, 'kaouthar', '666', 'kkkkk', ''),
(2, 'imane', '8888', 'iamne', 'Femme'),
(3, 'kaouthar', '666', 'kessou', 'Femme'),
(4, 'fatima', '77', 'fatima', 'Femme'),
(5, 'houda', '456', 'houda', 'Femme'),
(6, 'hafida', '123', 'hafida', 'Femme'),
(7, 'meryyam', '777', 'meryam', 'Femme'),
(8, 'kkk', '555', 'kkk', 'Femme'),
(9, 'GG', '33', 'GG', 'Homme'),
(10, 'fatima', '566677', 'fatima', 'Femme'),
(11, 'GG', '22', 'GG', 'Homme'),
(12, 'TT', '88', 'TT', 'Homme'),
(13, 'NN', '666', 'MM', 'Femme'),
(14, 'HOHO', '444', 'HOHO', 'Homme'),
(15, 'HIHI', '555', 'HIHI', 'Homme'),
(16, 'HIHI', 'HIHI', 'HIHI', 'Homme'),
(17, 'HIHI', 'HIHI', 'HIHI', 'Homme'),
(18, 'HUHU', 'HUHU', 'HUHU', 'Homme'),
(19, 'ZUZU', 'ZUZU', 'ZUZU', 'Homme'),
(20, 'RIRI', 'RIRI', 'RIRI', 'Femme'),
(21, 'RURU', 'RURU', 'RURU', 'Homme'),
(22, 'eiei', 'eiei', 'eiei', 'Homme'),
(23, 'rtrt ', 'rtrt', 'rtrt ', 'Femme'),
(24, 'AA', 'AA', 'AA', 'Femme'),
(25, 'kjfhqkjgqfh', '08276245625', 'QKHDDJQKDdh', 'Homme');

-- --------------------------------------------------------

--
-- Structure de la table `manager`
--

CREATE TABLE `manager` (
  `idManager` int(11) NOT NULL,
  `Login` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `manager`
--

INSERT INTO `manager` (`idManager`, `Login`, `password`) VALUES
(1, '2021001', 'root');

-- --------------------------------------------------------

--
-- Structure de la table `order`
--

CREATE TABLE `order` (
  `idOrder` int(11) NOT NULL,
  `Date` varchar(100) NOT NULL,
  `Adress` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `idClient` int(11) NOT NULL,
  `idManager` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `order`
--

INSERT INTO `order` (`idOrder`, `Date`, `Adress`, `status`, `idClient`, `idManager`) VALUES
(2, '2021/05/26 13:06:04', 'HIHI', 'En cours', 17, 1),
(3, '2021/05/26 13:13:18', 'HUHU', 'En cours', 18, 1),
(4, '2021/05/26 13:14:58', 'ZUZU', 'En cours', 19, 1),
(5, '2021/05/26 13:27:12', 'RIRI', 'En cours', 20, 1),
(6, '2021/05/26 13:29:56', 'RURU', 'En cours', 21, 1),
(7, '2021/05/26 13:37:07', 'eiei', 'En cours', 22, 1),
(8, '2021/05/26 13:37:59', 'rere', 'En cours', 23, 1),
(9, '2021/05/26 13:39:55', 'AA', 'Annulee', 24, 1),
(10, '2021/05/26 14:35:14', 'jerada', 'En cours', 25, 1);

-- --------------------------------------------------------

--
-- Structure de la table `order_line`
--

CREATE TABLE `order_line` (
  `idOrder` int(11) NOT NULL,
  `idProduct` int(11) NOT NULL,
  `soldPrice` float NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `order_line`
--

INSERT INTO `order_line` (`idOrder`, `idProduct`, `soldPrice`, `quantity`) VALUES
(10, 3, 0, 10);

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `idProduct` int(11) NOT NULL,
  `label` varchar(255) NOT NULL,
  `unit_price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`idProduct`, `label`, `unit_price`) VALUES
(1, 'Pneu 4 saisons Landsail SEASDRAG 195/65 R15 91V', 38.68),
(2, 'BLUE PRINT Disque de frein ', 24.18),
(3, 'AMiO HOLD-04 Support pour télépne portable ', 4.78),
(4, 'KEGEL Housse de Siège ', 16.08),
(5, 'ARGO Enjoliveur ', 15.18),
(6, 'LEOPLAST Enjoliveur', 15.28),
(7, 'GASTROL GTX, A3/B4 Huile moteur ', 29.18),
(8, 'PIERBURG  Débimètre de masse d\'air ', 120.48),
(9, 'RENSI Tapis de sol ', 21.08),
(10, 'ALCA Couvre-volant ', 4.78),
(11, 'CARPASSION Bâche de voiture ', 28.48),
(12, 'MAMMOOTH Housse de roues ', 7.38),
(13, 'SHELL Chiffon automobile anti-buée ', 3.38),
(14, 'MODULA Barre de toit ', 101.38),
(15, 'PIONEER TS-G1010F Haut-parleurs', 27.28),
(16, 'JVC Haut-parleurs', 27.38),
(17, 'OGNIOCHRON Extincteur de feu', 13.28),
(18, 'CARCOMMERCE Câble d recharge allume-cigare', 10.08),
(19, 'SHELL Spirax S4, G Huile pour de boîte de vitesse', 11.38),
(20, 'VEMO Pâte grippant, climatisation ', 40.58);

-- --------------------------------------------------------

--
-- Structure de la table `ventes`
--

CREATE TABLE `ventes` (
  `Id` int(5) NOT NULL,
  `annee` int(4) NOT NULL,
  `gain` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ventes`
--

INSERT INTO `ventes` (`Id`, `annee`, `gain`) VALUES
(1, 2017, 1700),
(2, 2018, 2000),
(3, 2019, 700),
(4, 2020, 1800);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`idManager`);

--
-- Index pour la table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`idOrder`),
  ADD KEY `idClient` (`idClient`),
  ADD KEY `idManager` (`idManager`);

--
-- Index pour la table `order_line`
--
ALTER TABLE `order_line`
  ADD KEY `idOrder` (`idOrder`),
  ADD KEY `idProduct` (`idProduct`);

--
-- Index pour la table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`idProduct`);

--
-- Index pour la table `ventes`
--
ALTER TABLE `ventes`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `manager`
--
ALTER TABLE `manager`
  MODIFY `idManager` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `order`
--
ALTER TABLE `order`
  MODIFY `idOrder` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `product`
--
ALTER TABLE `product`
  MODIFY `idProduct` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `order_ibfk_2` FOREIGN KEY (`idManager`) REFERENCES `manager` (`idManager`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `order_line`
--
ALTER TABLE `order_line`
  ADD CONSTRAINT `order_line_ibfk_1` FOREIGN KEY (`idOrder`) REFERENCES `order` (`idOrder`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `order_line_ibfk_2` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
