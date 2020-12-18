-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 18-Dez-2020 às 15:03
-- Versão do servidor: 10.4.14-MariaDB
-- versão do PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `locadora`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefone` varchar(50) DEFAULT NULL,
  `data_nasc` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nome`, `cpf`, `endereco`, `email`, `telefone`, `data_nasc`) VALUES
(4, 'Izabela', '045336630-9', 'Rua Borges de Medeiros', 'iza_bk@hotmail.com', '(55)999781654', '02/03/2002');

-- --------------------------------------------------------

--
-- Estrutura da tabela `filme`
--

CREATE TABLE `filme` (
  `idFilme` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `tempo` int(11) DEFAULT NULL,
  `imagem3d` tinyint(4) DEFAULT NULL,
  `dublado` tinyint(4) DEFAULT NULL,
  `sinopse` varchar(500) DEFAULT NULL,
  `classificacao` varchar(40) DEFAULT NULL,
  `status_filme` tinyint(4) DEFAULT NULL,
  `categoria` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `filme`
--

INSERT INTO `filme` (`idFilme`, `titulo`, `tempo`, `imagem3d`, `dublado`, `sinopse`, `classificacao`, `status_filme`, `categoria`) VALUES
(3, 'Se eu ficar', 107, 0, 0, 'A jovem musicista Mia tem uma brilhante carreira pela frente, o que lhe gera dúvida entre dedicar-se integralmente à carreira, na famosa escola Julliard, ou a Adam, seu amor. Porém, a vida lhe traz uma surpresa. Mia sofre um grave acidente de carro, perde a família e fica à beira da morte. Em coma, ela reflete sobre o passado e o futuro que pode ter, caso sobreviva.', '10 anos', 0, 'Romance/Drama');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `nome` (`nome`);

--
-- Índices para tabela `filme`
--
ALTER TABLE `filme`
  ADD PRIMARY KEY (`idFilme`),
  ADD UNIQUE KEY `titulo` (`titulo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `filme`
--
ALTER TABLE `filme`
  MODIFY `idFilme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
