CREATE DATABASE  IF NOT EXISTS `Ecole` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `Ecole`;
-- MySQL dump 10.14  Distrib 5.5.55-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: Ecole
-- ------------------------------------------------------
-- Server version	5.5.55-MariaDB-1~trusty

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Absence`
--

DROP TABLE IF EXISTS `Absence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Absence` (
  `idAbsence` int(11) NOT NULL AUTO_INCREMENT,
  `idProf` int(11) NOT NULL,
  `idEleve` int(11) NOT NULL,
  `date` date NOT NULL,
  `matiere` int(11) NOT NULL,
  `vue` int(1) DEFAULT '0',
  PRIMARY KEY (`idAbsence`),
  KEY `fk_Absence_Prof` (`idProf`),
  KEY `fk_Absence_Eleve` (`idEleve`),
  KEY `fk_Absence_Matiere` (`matiere`),
  CONSTRAINT `fk_Absence_Eleve` FOREIGN KEY (`idEleve`) REFERENCES `Eleve` (`idEleve`),
  CONSTRAINT `fk_Absence_Matiere` FOREIGN KEY (`matiere`) REFERENCES `Matiere` (`idMatiere`),
  CONSTRAINT `fk_Absence_Prof` FOREIGN KEY (`idProf`) REFERENCES `Utilisateur` (`idUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Absence`
--

LOCK TABLES `Absence` WRITE;
/*!40000 ALTER TABLE `Absence` DISABLE KEYS */;
INSERT INTO `Absence` VALUES (1,7,4,'2017-01-01',1,1),(2,7,4,'2016-12-21',2,1),(3,7,4,'2016-12-06',1,1),(4,7,4,'2017-01-03',1,1),(5,7,4,'2017-01-09',1,1),(6,7,4,'2017-02-09',1,1),(7,7,4,'2017-02-01',2,1),(8,7,4,'2017-02-02',3,1),(9,7,4,'2017-02-10',2,1);
/*!40000 ALTER TABLE `Absence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cahier`
--

DROP TABLE IF EXISTS `Cahier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cahier` (
  `idCahier` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `professeur` int(11) NOT NULL,
  `groupe` int(11) NOT NULL,
  `description` text NOT NULL,
  `exercices` text,
  PRIMARY KEY (`idCahier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cahier`
--

LOCK TABLES `Cahier` WRITE;
/*!40000 ALTER TABLE `Cahier` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cahier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Classe`
--

DROP TABLE IF EXISTS `Classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Classe` (
  `idClasse` int(11) NOT NULL AUTO_INCREMENT,
  `eleve` int(11) NOT NULL,
  `groupe` int(11) NOT NULL,
  `annee_scolaire` varchar(10) NOT NULL,
  PRIMARY KEY (`idClasse`),
  KEY `fk_Classe_Eleve` (`eleve`),
  KEY `fk_Classe_Groupe` (`groupe`),
  CONSTRAINT `fk_Classe_Eleve` FOREIGN KEY (`eleve`) REFERENCES `Eleve` (`idEleve`),
  CONSTRAINT `fk_Classe_Groupe` FOREIGN KEY (`groupe`) REFERENCES `Groupe` (`idGroupe`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Classe`
--

LOCK TABLES `Classe` WRITE;
/*!40000 ALTER TABLE `Classe` DISABLE KEYS */;
INSERT INTO `Classe` VALUES (1,4,1,'2016/2017'),(2,5,1,'2016/2017'),(3,6,1,'2016/2017'),(4,7,1,'2017/2017'),(5,8,1,'2017/2017');
/*!40000 ALTER TABLE `Classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contact`
--

DROP TABLE IF EXISTS `Contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contact` (
  `idContact` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `sujet` varchar(70) DEFAULT NULL,
  `texte` text NOT NULL,
  `date` date NOT NULL,
  `vue` int(1) DEFAULT '0',
  PRIMARY KEY (`idContact`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contact`
--

LOCK TABLES `Contact` WRITE;
/*!40000 ALTER TABLE `Contact` DISABLE KEYS */;
INSERT INTO `Contact` VALUES (1,'sihem@gmail.com','hgbiojbk','kjjbikjnknll mjnljbnkmnbjouiphuobipjihoubj','2017-01-07',0),(2,'youssef.abidi.32@gmail.com','A complaint ','we are people who complains about every thing , so we\'d like to write you a message to complain about not finding something to complain about , So Fuck you man. Good bye :) ','2017-01-27',1),(3,'sammir@gmaail.com','sujet de contact','Ce contact sera traite ensuite par l\'admin Ce contact sera traite ensuite par l\'admin Ce contact sera traite ensuite par l\'admin Ce contact sera traite ensuite par l\'admin Ce contact sera traite ensuite par l\'admin Ce contact sera traite ensuite par l\'admin Ce contact sera traite ensuite par l\'admin ','2017-02-11',1),(4,'youssef.abidi.32@gmail.com','Contact de la part des parent','mffsb ekgd ggdp gk flkfk fkfk fkl fgkf ','2017-02-11',0);
/*!40000 ALTER TABLE `Contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Eleve`
--

DROP TABLE IF EXISTS `Eleve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Eleve` (
  `idEleve` int(11) NOT NULL AUTO_INCREMENT,
  `code_eleve` varchar(45) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `date_naissance` date NOT NULL,
  `lieu_naissance` varchar(45) DEFAULT NULL,
  `date_inscrit` date DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `adresse` varchar(50) DEFAULT NULL,
  `num_assurance` varchar(45) NOT NULL,
  `parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEleve`),
  UNIQUE KEY `code_eleve_UNIQUE` (`code_eleve`),
  UNIQUE KEY `num_assurance_UNIQUE` (`num_assurance`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_Eleve_1_idx` (`parent`),
  CONSTRAINT `fk_Eleve_1` FOREIGN KEY (`parent`) REFERENCES `Utilisateur` (`idUtilisateur`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Eleve`
--

LOCK TABLES `Eleve` WRITE;
/*!40000 ALTER TABLE `Eleve` DISABLE KEYS */;
INSERT INTO `Eleve` VALUES (4,'JiJI123','abidi','azzen','2010-02-16','Jendouba','2016-12-30','azzen@gmail.com','Jenduba ferdaws','HJ455',14),(5,'HFYDB','Ben Salem','Aladin','2017-01-01','Tunis','2017-01-01','ala@gmail.com','Tunis araiana','HFG55',13),(6,'M45P','Boltane','Elyes','2010-04-01','Tunis','2017-01-01','elyes@gmail.com','Tunis Gamart','JFOBL',14),(7,'D1245','Bellili','Ahmed','2017-02-11','Tunis ','2017-02-11','ahmed@gmail.com','Tunis Ariana sojvbfjobdf','H1245',17),(8,'SD54','knflkb','mflfmbk f','2017-02-11','sflkbdjb deob erj','2017-02-11','dmkvnfk@gmail.com','dmlb fmbl fkl','GH54',14);
/*!40000 ALTER TABLE `Eleve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Groupe`
--

DROP TABLE IF EXISTS `Groupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Groupe` (
  `idGroupe` int(11) NOT NULL AUTO_INCREMENT,
  `niveau` int(11) NOT NULL,
  `nom` varchar(10) NOT NULL,
  PRIMARY KEY (`idGroupe`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Groupe`
--

LOCK TABLES `Groupe` WRITE;
/*!40000 ALTER TABLE `Groupe` DISABLE KEYS */;
INSERT INTO `Groupe` VALUES (1,2,'A'),(2,2,'B'),(3,1,'A'),(4,1,'B'),(5,3,'B'),(6,3,'A'),(7,4,'A'),(8,4,'B'),(9,5,'B'),(10,5,'A'),(11,6,'A'),(12,6,'B');
/*!40000 ALTER TABLE `Groupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Matiere`
--

DROP TABLE IF EXISTS `Matiere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Matiere` (
  `idMatiere` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  PRIMARY KEY (`idMatiere`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Matiere`
--

LOCK TABLES `Matiere` WRITE;
/*!40000 ALTER TABLE `Matiere` DISABLE KEYS */;
INSERT INTO `Matiere` VALUES (1,'INFO'),(2,'GEOGRAPHIE'),(3,'MATHEMATIQUE'),(4,'FRANCAIS');
/*!40000 ALTER TABLE `Matiere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Note`
--

DROP TABLE IF EXISTS `Note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Note` (
  `idNote` int(11) NOT NULL AUTO_INCREMENT,
  `idEleve` int(11) NOT NULL,
  `idClasse` int(11) NOT NULL,
  `idMatiere` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  `valeur` float NOT NULL,
  PRIMARY KEY (`idNote`),
  KEY `idEleve` (`idEleve`),
  KEY `idMatiere` (`idMatiere`),
  KEY `idClasse` (`idClasse`),
  CONSTRAINT `Note_ibfk_1` FOREIGN KEY (`idEleve`) REFERENCES `Eleve` (`idEleve`),
  CONSTRAINT `Note_ibfk_2` FOREIGN KEY (`idMatiere`) REFERENCES `Matiere` (`idMatiere`),
  CONSTRAINT `Note_ibfk_3` FOREIGN KEY (`idClasse`) REFERENCES `Classe` (`idClasse`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Note`
--

LOCK TABLES `Note` WRITE;
/*!40000 ALTER TABLE `Note` DISABLE KEYS */;
INSERT INTO `Note` VALUES (4,4,1,1,'Devoir Surveillé',12.5),(5,5,2,1,'Devoir Surveillé',11),(6,6,3,1,'Devoir Surveillé',20),(7,4,1,1,'Examen',20),(8,5,2,1,'Examen',20),(9,6,3,1,'Examen',20),(10,4,1,3,'Examen',18),(11,5,2,3,'Examen',5),(12,6,3,3,'Examen',10);
/*!40000 ALTER TABLE `Note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Remarque`
--

DROP TABLE IF EXISTS `Remarque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Remarque` (
  `idRemarque` int(11) NOT NULL AUTO_INCREMENT,
  `idProf` int(11) NOT NULL,
  `idEleve` int(11) NOT NULL,
  `date` date NOT NULL,
  `sujet` varchar(70) DEFAULT NULL,
  `texte` text NOT NULL,
  `vue_admin` int(1) DEFAULT '0',
  `vue_parent` int(1) DEFAULT '0',
  PRIMARY KEY (`idRemarque`),
  KEY `fk_Remarque_Prof` (`idProf`),
  KEY `fk_Remarque_Eleve` (`idEleve`),
  CONSTRAINT `fk_Remarque_Eleve` FOREIGN KEY (`idEleve`) REFERENCES `Eleve` (`idEleve`),
  CONSTRAINT `fk_Remarque_Prof` FOREIGN KEY (`idProf`) REFERENCES `Utilisateur` (`idUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Remarque`
--

LOCK TABLES `Remarque` WRITE;
/*!40000 ALTER TABLE `Remarque` DISABLE KEYS */;
INSERT INTO `Remarque` VALUES (1,7,4,'2017-01-01','Bl bla','Si nous souhaitons ajouter la possibilité de commencer une partie à partir\r\nd’une position donnée à la place de la position initiale standard, nous sommes\r\namenés à utiliser la nouvelle notation du point d’entrée (« entry point »). Le\r\ncercle blanc nommé « Position » sur la figure 6-3 permet de démarrer directement une partie dans l’état « NoirsJouent » si on le désire, alors que le sous-\r\nétat initial par défaut est « BlancsJouent », comme indiqué par la flèche positionnée au-dessus de ce sous-état. Les événements « pat » et « répétition »\r\nsont factorisés, alors que « abandon » et « mat » mènent à des états de sortie\r\ndifférents suivant l’état source. La notation du point de sortie (« exit point »)\r\nconsiste en une croix à l’intérieur d’un cercle blanc. Elle est également nouvelle et propre à UML 2.',1,1),(2,7,4,'2017-01-26','jbofjbvoj bfob ojfs','BelÃ©n Cruz Zapata received her Engineer\'s degree in Computer Science from the\r\nUniversity of Murcia in Spain, specializing in software technologies and intelligent\r\nand knowledge technologies. She earned an M.Sc in Computer Science and is\r\nnow working in her Ph.D on the Software Engineering Research Group from the\r\nUniversity of Murcia.\r\nBelÃ©n is based in Spain, although in the field of her Ph.D she is now collaborating with\r\nthe UniversitÃ© Mohammed V-Soussi, in Rabat, as beneficiary of an Erasmus Mundus\r\nprogram. Her research is focused on the mobile world and cloud computing.\r\nShe has a special interest in the development of mobile applications and new\r\ntechnologies. In the past few years, she has worked as a mobile developer for\r\nseveral platforms such as Android, iOS , and the Web.',1,0),(3,7,4,'2017-01-26','gggngdnmknbmold lodnb, oppg o,gf','sbubbjgnvpsbn rjngokorznjnkb,rpkznj krznb k, kon,bn k, nj,ore,k,',1,0),(4,7,4,'2017-02-11','sujet de la remarque','zpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g gzpkn pd npidg gd gdipk g g',1,1);
/*!40000 ALTER TABLE `Remarque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Seance`
--

DROP TABLE IF EXISTS `Seance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Seance` (
  `idSeance` int(11) NOT NULL AUTO_INCREMENT,
  `classe` int(11) NOT NULL,
  `professeur` int(11) NOT NULL,
  `matiere` int(11) NOT NULL,
  `jour` varchar(10) DEFAULT NULL,
  `debut` time NOT NULL,
  `fin` time NOT NULL,
  PRIMARY KEY (`idSeance`),
  KEY `fk_Seance_Professeur` (`professeur`),
  KEY `fk_Seance_Matiere` (`matiere`),
  CONSTRAINT `fk_Seance_Matiere` FOREIGN KEY (`matiere`) REFERENCES `Matiere` (`idMatiere`),
  CONSTRAINT `fk_Seance_Professeur` FOREIGN KEY (`professeur`) REFERENCES `Utilisateur` (`idUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Seance`
--

LOCK TABLES `Seance` WRITE;
/*!40000 ALTER TABLE `Seance` DISABLE KEYS */;
INSERT INTO `Seance` VALUES (1,1,16,3,'Lundi','08:00:00','09:30:00'),(2,1,16,3,'Mardi','09:45:00','11:15:00'),(8,1,7,4,'Lundi','08:00:00','09:30:00'),(9,1,2,3,'Mardi','08:00:00','09:30:00'),(10,1,16,1,'Lundi','09:45:00','11:15:00');
/*!40000 ALTER TABLE `Seance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Utilisateur`
--

DROP TABLE IF EXISTS `Utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Utilisateur` (
  `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `cin` varchar(8) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `adresse` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `tel` varchar(8) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `identifiant_uniq` varchar(20) DEFAULT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`idUtilisateur`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `cin_UNIQUE` (`cin`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Utilisateur`
--

LOCK TABLES `Utilisateur` WRITE;
/*!40000 ALTER TABLE `Utilisateur` DISABLE KEYS */;
INSERT INTO `Utilisateur` VALUES (1,'45962170','youssef','abidi',NULL,'youssef@gmail.com',NULL,'youssef','27ju1993',NULL,'Admin'),(2,'14253697','Sami','Abidi','technopole lghazala dbnd','sami.abidi@gmail.com','11445521','sami','abidi,abidi','100000001','Professeur'),(6,'12457845','yassine','grejmi','nnf  oignso oinb k','grejmi@gmail.com','55555522','yassine','yassine','1245786',''),(7,'07961620','samir','elwafi','jendouba malja kahla','sammir@gmaail.com','53512147','samir','samirsamir','004455887700','Professeur'),(8,'07854368','Abidi','Riadh','Jenndouba','riadh@gmail.com','27061993','riadh','riadhriadh',NULL,'Parent'),(11,'07854369','Abidi','Riadh','Jenndouba','riadh@gmail.com','27061993','riadhr','dfdfdfdf',NULL,'Parent'),(13,'07854367','Abidi','Riadh','mida Nabeul','riadh@gmail.com','27061993','riadhrd','dfdfdfdf',NULL,'Parent'),(14,'00011145','Abidi','Sihem','jendouba','youssef.abidi.32@gmail.com','25413600','sihemQ','sihemsihem',NULL,'Parent'),(15,'12447756','Mesbah','slahhahahah','jbdjb fjjfjfjf fjfjfjjf','slah@gmail.com','22000001','slahhh','slahhhh','44554485','Professeur'),(16,'00112211','abidi','belgacem','jendoubkbvpopn zk','belgassem@gmail.com','55110022','belgacem','belgacem','f5212','Professeur'),(17,'12451245','Bellili','Nasser','lsnvol ldj odj do bdjf ','nasser@gmail.com','54884477','hyisjvbs','27ju1993',NULL,'Parent'),(18,'01211144','Wechtati','Tawfik','sofjb    dofin od odj gj gf','tawfik@gmail.com','51000000','tawfik','tawfik','124570000','Professeur');
/*!40000 ALTER TABLE `Utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-17 13:15:15
