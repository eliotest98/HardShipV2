-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Giu 29, 2022 alle 15:47
-- Versione del server: 10.4.24-MariaDB
-- Versione PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hardship`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `album`
--

CREATE TABLE `album` (
  `ID` int(10) NOT NULL,
  `Genere` varchar(30) CHARACTER SET utf8 NOT NULL,
  `Titolo` varchar(30) NOT NULL,
  `Copertina` varchar(256) NOT NULL,
  `numero_brani` int(10) NOT NULL,
  `data` varchar(11) NOT NULL,
  `Embed` text DEFAULT NULL,
  `Dettagli` varchar(256) NOT NULL,
  `username_admin` varchar(15) NOT NULL,
  `ID_etichetta` int(10) NOT NULL,
  `ID_artista` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `album`
--

INSERT INTO `album` (`ID`, `Genere`, `Titolo`, `Copertina`, `numero_brani`, `data`, `Embed`, `Dettagli`, `username_admin`, `ID_etichetta`, `ID_artista`) VALUES
(1, 'Pop', 'Ciccios', 'Black', 15, '15-02-2021', 'Bho', 'Bho', 'root', 1, 1),
(3, 'Pop', 'Ciccias', 'Black', 15, '15-02-2021', 'Bho', 'Bho', 'root', 0, 1),
(4, 'Pop', 'Cacca', 'Black', 15, '15-02-2021', 'Bho', 'Bho', 'root', 0, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `amministratore`
--

CREATE TABLE `amministratore` (
  `Username` varchar(15) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `amministratore`
--

INSERT INTO `amministratore` (`Username`, `Password`) VALUES
('root', 'root');

-- --------------------------------------------------------

--
-- Struttura della tabella `articolo`
--

CREATE TABLE `articolo` (
  `ID` int(10) NOT NULL,
  `Quantità` int(10) NOT NULL,
  `Prezzo` decimal(4,2) NOT NULL,
  `ID_album` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `articolo`
--

INSERT INTO `articolo` (`ID`, `Quantità`, `Prezzo`, `ID_album`) VALUES
(1, 10, '10.00', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `artista`
--

CREATE TABLE `artista` (
  `ID` int(10) NOT NULL,
  `Nome` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `artista`
--

INSERT INTO `artista` (`ID`, `Nome`) VALUES
(1, 'Artista');

-- --------------------------------------------------------

--
-- Struttura della tabella `brano`
--

CREATE TABLE `brano` (
  `ID` int(10) NOT NULL,
  `Titolo` varchar(256) NOT NULL,
  `Anno` varchar(11) NOT NULL,
  `Durata` varchar(6) NOT NULL,
  `ID_album` int(10) DEFAULT NULL,
  `ID_artista` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `brano`
--

INSERT INTO `brano` (`ID`, `Titolo`, `Anno`, `Durata`, `ID_album`, `ID_artista`) VALUES
(4, 'Bobbo', '2022', '2:39', 1, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `cd`
--

CREATE TABLE `cd` (
  `ID` int(10) NOT NULL,
  `Prezzo` decimal(4,2) NOT NULL,
  `numero_Copie` int(10) NOT NULL,
  `ID_Album` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `cd`
--

INSERT INTO `cd` (`ID`, `Prezzo`, `numero_Copie`, `ID_Album`) VALUES
(1, '10.00', 100, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `ID` int(10) NOT NULL,
  `Nome` varchar(25) NOT NULL,
  `Cognome` varchar(30) NOT NULL,
  `DataNascita` varchar(11) NOT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `CodiceFiscale` char(16) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `codice_fiscale` varchar(16) NOT NULL,
  `data_nascita` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`ID`, `Nome`, `Cognome`, `DataNascita`, `Username`, `Password`, `CodiceFiscale`, `Email`, `codice_fiscale`, `data_nascita`) VALUES
(1, 'Elio', 'Testa', '09/04/1998', 'eliotesta98', 'eliotesta98', 'TSTLEI98D09I805P', 'elio@gmail.com', 'TSTLEI98D09I805P', '09/04/1998');

-- --------------------------------------------------------

--
-- Struttura della tabella `digitale`
--

CREATE TABLE `digitale` (
  `ID` int(10) NOT NULL,
  `Prezzo` decimal(4,2) NOT NULL,
  `numero_Copie` int(10) NOT NULL,
  `ID_album` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `digitale`
--

INSERT INTO `digitale` (`ID`, `Prezzo`, `numero_Copie`, `ID_album`) VALUES
(1, '10.00', 100, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `etichetta`
--

CREATE TABLE `etichetta` (
  `ID` int(10) NOT NULL,
  `Nome` varchar(25) NOT NULL,
  `Feed` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `etichetta`
--

INSERT INTO `etichetta` (`ID`, `Nome`, `Feed`) VALUES
(1, 'Bho', 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `fattura`
--

CREATE TABLE `fattura` (
  `ID` int(10) NOT NULL,
  `InfoP` varchar(64) NOT NULL,
  `Indirizzo` text NOT NULL,
  `DataAcquisto` varchar(11) NOT NULL,
  `ID_cliente` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `fattura`
--

INSERT INTO `fattura` (`ID`, `InfoP`, `Indirizzo`, `DataAcquisto`, `ID_cliente`) VALUES
(1, 'Bho', 'Via Circumvallazione', '26/06/2022', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `feedback`
--

CREATE TABLE `feedback` (
  `ID` int(10) NOT NULL,
  `Titolo` varchar(25) NOT NULL,
  `Testo` varchar(1024) NOT NULL,
  `Data` varchar(11) NOT NULL,
  `ID_Album` int(10) NOT NULL,
  `ID_Cliente` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `feedback`
--

INSERT INTO `feedback` (`ID`, `Titolo`, `Testo`, `Data`, `ID_Album`, `ID_Cliente`) VALUES
(1, 'Bho', 'BlaBla', '29/06/2022', 1, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `formazione`
--

CREATE TABLE `formazione` (
  `ID_Fattura` int(10) NOT NULL,
  `ID_Articolo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `formazione`
--

INSERT INTO `formazione` (`ID_Fattura`, `ID_Articolo`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Struttura della tabella `news`
--

CREATE TABLE `news` (
  `ID` int(10) NOT NULL,
  `Contenuto` text NOT NULL,
  `Data` varchar(11) NOT NULL,
  `Autore` varchar(25) NOT NULL,
  `Titolo` varchar(50) NOT NULL,
  `Copertina` text NOT NULL,
  `Categoria` varchar(15) NOT NULL,
  `Username_admin` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `news`
--

INSERT INTO `news` (`ID`, `Contenuto`, `Data`, `Autore`, `Titolo`, `Copertina`, `Categoria`, `Username_admin`) VALUES
(1, 'Bho', '12-06-2022', 'Tizio', 'Black', 'Black', 'Pop', 'root'),
(8, 'Bho', '12-06-2022', 'Tizio', 'Black', 'Black', 'Pop', 'root'),
(12, 'contenutoTest', '15-01-2022', 'autoreTest', 'titoloTest', 'copertinaTest', 'categoriaTest', 'pippoRossiTest'),
(14, 'Contenuto per news nuova', '14-01-2022', 'autoreTest2', 'NewsCiccio', 'copertinaTest', 'categoriaTest', 'MarioRossi'),
(15, 'Contenuto per news vecchia', '13-01-2022', 'autoreTest2', 'NewsLuca', 'copertinaTest', 'categoriaTest', 'FrancoRossi');

-- --------------------------------------------------------

--
-- Struttura della tabella `ricezione`
--

CREATE TABLE `ricezione` (
  `ID_richiesta` int(10) NOT NULL,
  `username_admin` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `ricezione`
--

INSERT INTO `ricezione` (`ID_richiesta`, `username_admin`) VALUES
(1, 'root');

-- --------------------------------------------------------

--
-- Struttura della tabella `richiesta`
--

CREATE TABLE `richiesta` (
  `ID` int(10) NOT NULL,
  `nome_album` varchar(30) NOT NULL,
  `artista` varchar(25) NOT NULL,
  `ID_Cliente` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `richiesta`
--

INSERT INTO `richiesta` (`ID`, `nome_album`, `artista`, `ID_Cliente`) VALUES
(1, 'Ciccios', 'Artista', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `sottoscrizione`
--

CREATE TABLE `sottoscrizione` (
  `ID_Etichetta` int(10) NOT NULL,
  `ID_Artista` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `sottoscrizione`
--

INSERT INTO `sottoscrizione` (`ID_Etichetta`, `ID_Artista`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `vinile`
--

CREATE TABLE `vinile` (
  `ID` int(10) NOT NULL,
  `Prezzo` decimal(4,2) NOT NULL,
  `numero_Copie` int(10) NOT NULL,
  `ID_Album` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `vinile`
--

INSERT INTO `vinile` (`ID`, `Prezzo`, `numero_Copie`, `ID_Album`) VALUES
(1, '10.00', 100, 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `visualizzazione`
--

CREATE TABLE `visualizzazione` (
  `ID_Cliente` int(10) NOT NULL,
  `ID_News` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `visualizzazione`
--

INSERT INTO `visualizzazione` (`ID_Cliente`, `ID_News`) VALUES
(1, 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Titolo` (`Titolo`);

--
-- Indici per le tabelle `articolo`
--
ALTER TABLE `articolo`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Nazionalità` (`Nome`);

--
-- Indici per le tabelle `brano`
--
ALTER TABLE `brano`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `cd`
--
ALTER TABLE `cd`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `digitale`
--
ALTER TABLE `digitale`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `etichetta`
--
ALTER TABLE `etichetta`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `fattura`
--
ALTER TABLE `fattura`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `formazione`
--
ALTER TABLE `formazione`
  ADD PRIMARY KEY (`ID_Fattura`,`ID_Articolo`);

--
-- Indici per le tabelle `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `ricezione`
--
ALTER TABLE `ricezione`
  ADD PRIMARY KEY (`ID_richiesta`,`username_admin`);

--
-- Indici per le tabelle `richiesta`
--
ALTER TABLE `richiesta`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `sottoscrizione`
--
ALTER TABLE `sottoscrizione`
  ADD PRIMARY KEY (`ID_Etichetta`,`ID_Artista`);

--
-- Indici per le tabelle `vinile`
--
ALTER TABLE `vinile`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `album`
--
ALTER TABLE `album`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `articolo`
--
ALTER TABLE `articolo`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT per la tabella `artista`
--
ALTER TABLE `artista`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT per la tabella `brano`
--
ALTER TABLE `brano`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `cd`
--
ALTER TABLE `cd`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `digitale`
--
ALTER TABLE `digitale`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `etichetta`
--
ALTER TABLE `etichetta`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT per la tabella `fattura`
--
ALTER TABLE `fattura`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT per la tabella `feedback`
--
ALTER TABLE `feedback`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT per la tabella `news`
--
ALTER TABLE `news`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT per la tabella `richiesta`
--
ALTER TABLE `richiesta`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=219;

--
-- AUTO_INCREMENT per la tabella `vinile`
--
ALTER TABLE `vinile`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
