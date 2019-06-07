-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 07 juin 2019 à 21:20
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `id` int(11) NOT NULL,
  `annee` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `anneescolaire`
--

INSERT INTO `anneescolaire` (`id`, `annee`) VALUES
(1, 2017),
(2, 2018),
(3, 2016),
(4, 2018),
(5, 2019);

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trimestre` int(11) NOT NULL,
  `inscription` int(11) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `trimestre` (`trimestre`),
  KEY `inscription` (`inscription`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bulletin`
--

INSERT INTO `bulletin` (`id`, `trimestre`, `inscription`, `appreciation`) VALUES
(1, 1, 2016, 'Tres bien'),
(2, 2, 2016, 'Bon eleve assidu'),
(3, 3, 2016, 'Bien mais peu faire quelques efforts'),
(4, 4, 2018, 'Eleve non serieux, que du bavardage malgre des bonnes notes dans certaines matieres'),
(5, 5, 2018, 'Toujours autant de bavardages, faire attention pour le dernier trimestre'),
(6, 6, 2018, 'Tres juste'),
(7, 7, 2019, 'Bien');

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `niveau` int(11) NOT NULL,
  `anneescolaire` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `niveau` (`niveau`),
  KEY `anneescolaire` (`anneescolaire`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `nom`, `niveau`, `anneescolaire`) VALUES
(1, 'CP', 1, 2016),
(2, 'CP', 1, 2017),
(3, 'CM2', 5, 2018),
(4, 'CM2', 5, 2017),
(5, 'CE1', 2, 2016),
(6, 'CE2', 3, 2019),
(7, 'CE2', 3, 2018),
(8, 'CM1', 4, 2016),
(9, 'CM1', 4, 2018),
(10, 'CM1', 4, 2019),
(11, 'CE2', 3, 2017),
(12, 'CM2', 5, 2019),
(13, 'CE1', 2, 2019),
(14, 'CE2', 3, 2019);

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bulletin` int(11) NOT NULL,
  `enseignement` int(11) NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `bulletin` (`bulletin`),
  KEY `enseignement` (`enseignement`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `detailbulletin`
--

INSERT INTO `detailbulletin` (`id`, `bulletin`, `enseignement`, `appreciation`) VALUES
(1, 1, 1, 'Bonne moyenne'),
(2, 1, 2, 'Excellent'),
(3, 2, 2, 'Tres correct a poursuivre !'),
(4, 2, 4, 'Bien, eleve serieux'),
(5, 3, 3, 'Dernier controle a retravailler mais bon travail dans l\'ensemble'),
(6, 3, 6, 'You have to practice more in english, for example you can watch some movies in english'),
(7, 4, 2, 'Resultats bons mais vous n\'etes pas assez serieux, attention aux bavardages !'),
(8, 4, 3, 'Oblige de le deplacer a chaque cours car perturbe trop la classe'),
(9, 5, 5, 'Bon eleve'),
(10, 5, 1, 'Bons resultats malgre une dissipation'),
(11, 6, 2, 'Resultats pas bons, ne pas hesiter a poser des questions '),
(12, 6, 4, 'Les sciences ne sont pas fait pour vous !'),
(13, 7, 3, 'Ensemble correct'),
(14, 7, 1, 'Bien'),
(15, 1, 6, 'Very good'),
(16, 2, 3, 'Ok'),
(17, 3, 1, 'A continuer dans cette lancee'),
(18, 4, 5, 'Bien'),
(19, 5, 4, 'ok'),
(20, 6, 1, 'Excellent');

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `discipline`
--

INSERT INTO `discipline` (`id`, `nom`) VALUES
(1, 'Maths'),
(2, 'Francais'),
(3, 'Histoire/Geographie'),
(4, 'Sciences'),
(5, 'Sport'),
(6, 'Anglais');

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classe` int(11) NOT NULL,
  `discipline` int(11) NOT NULL,
  `personne` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classe` (`classe`),
  KEY `discipline` (`discipline`),
  KEY `personne` (`personne`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignement`
--

INSERT INTO `enseignement` (`id`, `classe`, `discipline`, `personne`) VALUES
(1, 1, 1, 1),
(2, 2, 2, 2),
(3, 3, 3, 3),
(4, 4, 4, 4),
(5, 5, 5, 5),
(6, 6, 6, 6),
(7, 7, 7, 7),
(8, 8, 1, 8),
(9, 9, 4, 9),
(10, 10, 2, 10);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detailBulletin` int(11) NOT NULL,
  `note` double NOT NULL,
  `appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `detailBulletin` (`detailBulletin`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`id`, `detailBulletin`, `note`, `appreciation`) VALUES
(1, 1, 14.5, 'Bien'),
(2, 2, 17, 'Tres bien'),
(3, 3, 13.2, 'Bien'),
(4, 4, 12.7, 'Assez bien'),
(5, 5, 11.1, 'Assez bien'),
(6, 6, 9, 'Moyen'),
(7, 7, 13, 'Bien'),
(8, 8, 10.5, 'Moyen'),
(9, 9, 15, 'Bien'),
(10, 10, 14.8, 'Bien'),
(11, 11, 4.5, 'A revoir !!'),
(12, 12, 2, 'A revoir !! Tres mauvais'),
(13, 13, 13.2, 'Correct'),
(14, 14, 15.2, 'Bien'),
(15, 15, 16.7, 'Tres bien'),
(16, 16, 12.6, 'Assez bien'),
(17, 17, 14, 'Bien'),
(18, 18, 15.5, 'Bien'),
(19, 19, 12.9, 'Assez bien'),
(20, 20, 19, 'Excellent');

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classe` int(11) NOT NULL,
  `personne` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classe` (`classe`),
  KEY `personne` (`personne`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`id`, `classe`, `personne`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11),
(12, 12, 12),
(13, 13, 13),
(14, 14, 14);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`id`, `nom`) VALUES
(1, 'CP'),
(2, 'CE1'),
(3, 'CE2'),
(4, 'CM1'),
(5, 'CM2');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `type`) VALUES
(1, 'Dupont', 'Francois', 1),
(2, 'Chassigneu', 'Frederic', 1),
(3, 'Delage', 'Julie', 1),
(4, 'Raguet', 'Christine', 2),
(5, 'Mont', 'Penelope', 2),
(6, 'Deplus', 'Pierre', 2),
(7, 'Mazier', 'Paul', 2),
(8, 'Grand', 'Oliver', 2),
(9, 'Poiri', 'Elisabeth', 2),
(10, 'Tavernier', 'Lucas', 2),
(11, 'Cohen', 'Alexandra', 1),
(12, 'Lambert', 'Alexia', 1),
(13, 'Duchemin', 'Victor', 1),
(14, 'Abboud', 'Mathieu', 1),
(15, 'Franc', 'Mathilde', 1),
(16, 'Boudissa', 'Faycal', 1),
(17, 'Pougaut', 'Emma', 1),
(18, 'Machecourt', 'Raphael', 1),
(19, 'Cario', 'Charlotte', 1),
(20, 'Deffontaine', 'Tristan', 1);

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `id` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `debut` int(11) NOT NULL,
  `fin` int(11) NOT NULL,
  `anneescolaire` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `anneescolaire` (`anneescolaire`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`id`, `numero`, `debut`, `fin`, `anneescolaire`) VALUES
(1, 1, 1, 4, 2016),
(2, 2, 1, 4, 2016),
(3, 3, 1, 4, 2016),
(4, 4, 1, 4, 2018),
(5, 5, 1, 4, 2018),
(6, 6, 1, 4, 2018),
(7, 7, 1, 4, 2019);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
