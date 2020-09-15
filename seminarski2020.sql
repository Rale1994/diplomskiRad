/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.5-10.1.28-MariaDB : Database - seminarski2020
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski2020` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `seminarski2020`;

/*Table structure for table `advokat` */

DROP TABLE IF EXISTS `advokat`;

CREATE TABLE `advokat` (
  `AdvokatID` int(20) NOT NULL AUTO_INCREMENT,
  `JMBG` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `Ime` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Prezime` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Ulica` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Broj` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `KontaktTelefon` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `KorisnickoIme` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Lozinka` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `PrebivalisteID` int(20) NOT NULL,
  `ArhivaID` int(20) DEFAULT NULL,
  PRIMARY KEY (`AdvokatID`),
  KEY `PrebivalisteID` (`PrebivalisteID`),
  KEY `ArhivaID` (`ArhivaID`),
  CONSTRAINT `advokat_ibfk_1` FOREIGN KEY (`PrebivalisteID`) REFERENCES `prebivaliste` (`PrebivalisteID`),
  CONSTRAINT `advokat_ibfk_2` FOREIGN KEY (`ArhivaID`) REFERENCES `arhiva` (`ArhivaID`)
) ENGINE=InnoDB AUTO_INCREMENT=1214 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `advokat` */

insert  into `advokat`(`AdvokatID`,`JMBG`,`Ime`,`Prezime`,`Ulica`,`Broj`,`KontaktTelefon`,`KorisnickoIme`,`Lozinka`,`PrebivalisteID`,`ArhivaID`) values (1212,'12121','Rados','Golubovic','asdasda','123123','12312312','rale','rale',123,NULL),(1213,'1458','Milena','Golubovic','Uciteljska','11','4547985191','milena','milena',123,NULL);

/*Table structure for table `arhiva` */

DROP TABLE IF EXISTS `arhiva`;

CREATE TABLE `arhiva` (
  `ArhivaID` int(20) NOT NULL AUTO_INCREMENT,
  `DatumDobijanjaSertifikata` datetime NOT NULL,
  `SertifikatID` int(20) NOT NULL,
  `AdvokatID` int(20) DEFAULT NULL,
  PRIMARY KEY (`ArhivaID`),
  KEY `SertifikatID` (`SertifikatID`),
  KEY `AdvokatID` (`AdvokatID`),
  CONSTRAINT `arhiva_ibfk_1` FOREIGN KEY (`SertifikatID`) REFERENCES `sertifikat` (`SertifikatID`),
  CONSTRAINT `arhiva_ibfk_2` FOREIGN KEY (`AdvokatID`) REFERENCES `advokat` (`AdvokatID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `arhiva` */

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `KlijentID` int(20) NOT NULL AUTO_INCREMENT,
  `JMBG` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `Ime` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Prezime` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Ulica` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Broj` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `KontaktTelefon` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `PrebivalisteID` int(20) NOT NULL,
  `AdvokatID` int(20) NOT NULL,
  PRIMARY KEY (`KlijentID`),
  KEY `AdvokatID` (`AdvokatID`),
  KEY `PrebivalisteID` (`PrebivalisteID`),
  CONSTRAINT `klijent_ibfk_1` FOREIGN KEY (`AdvokatID`) REFERENCES `advokat` (`AdvokatID`),
  CONSTRAINT `klijent_ibfk_2` FOREIGN KEY (`PrebivalisteID`) REFERENCES `prebivaliste` (`PrebivalisteID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `klijent` */

insert  into `klijent`(`KlijentID`,`JMBG`,`Ime`,`Prezime`,`Ulica`,`Broj`,`KontaktTelefon`,`PrebivalisteID`,`AdvokatID`) values (2,'9874561237894','Nikola','Nikolic','Vojvode Stepe','320','064789456',123,1212),(3,'4567891233216','Nikola','Miric','Bulevar Oslobodjenja','210','789456214',125,1213),(14,'1233214566547','qweqwe','qweqweqwe','asdasd','asdasd','asdasdasd',123,1212),(18,'1233214566547','asdasd','asdasd','asdasd','asdasda','123123123123',123,1212),(32,'7418529639632','Stefan','Mosurovci','Mihaila Bulgakova','140','123123123',123,1212),(36,'2009994793416','Rados ','Golubovic','Uciteljska','119','0692847350',123,1213);

/*Table structure for table `prebivaliste` */

DROP TABLE IF EXISTS `prebivaliste`;

CREATE TABLE `prebivaliste` (
  `PrebivalisteID` int(20) NOT NULL AUTO_INCREMENT,
  `PostanskiBroj` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Naziv` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`PrebivalisteID`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `prebivaliste` */

insert  into `prebivaliste`(`PrebivalisteID`,`PostanskiBroj`,`Naziv`) values (123,'11000','Beograd'),(124,'31330','Priboj'),(125,'21000','Novi Sad'),(126,'34000','Kragujevac'),(127,'18000','Nis');

/*Table structure for table `predmetsudjenja` */

DROP TABLE IF EXISTS `predmetsudjenja`;

CREATE TABLE `predmetsudjenja` (
  `PredmetSudjenjaID` int(20) NOT NULL AUTO_INCREMENT,
  `NazivPredmetaSudjenja` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`PredmetSudjenjaID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `predmetsudjenja` */

insert  into `predmetsudjenja`(`PredmetSudjenjaID`,`NazivPredmetaSudjenja`) values (1,'Tuzba'),(2,'Ostavniski postupak'),(3,'Razvod braka'),(4,'Naknada materijalne stete'),(5,'Naknada nemtarijalne stete'),(6,'Raskid ugovora');

/*Table structure for table `sertifikat` */

DROP TABLE IF EXISTS `sertifikat`;

CREATE TABLE `sertifikat` (
  `SertifikatID` int(20) NOT NULL AUTO_INCREMENT,
  `NazivSertifikata` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`SertifikatID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sertifikat` */

/*Table structure for table `sudjenje` */

DROP TABLE IF EXISTS `sudjenje`;

CREATE TABLE `sudjenje` (
  `SudjenjeID` int(20) NOT NULL AUTO_INCREMENT,
  `Datum` date NOT NULL,
  `DuzinaTrajanja` int(11) NOT NULL,
  `Napomena` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PredmetSudjenjaID` int(20) NOT NULL,
  `AdvokatID` int(20) NOT NULL,
  `KlijentID` int(20) NOT NULL,
  PRIMARY KEY (`SudjenjeID`),
  KEY `PredmetSudjenjaID` (`PredmetSudjenjaID`),
  KEY `AdvokatID` (`AdvokatID`),
  KEY `KlijentID` (`KlijentID`),
  CONSTRAINT `sudjenje_ibfk_1` FOREIGN KEY (`PredmetSudjenjaID`) REFERENCES `predmetsudjenja` (`PredmetSudjenjaID`),
  CONSTRAINT `sudjenje_ibfk_2` FOREIGN KEY (`AdvokatID`) REFERENCES `advokat` (`AdvokatID`),
  CONSTRAINT `sudjenje_ibfk_3` FOREIGN KEY (`KlijentID`) REFERENCES `klijent` (`KlijentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sudjenje` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
