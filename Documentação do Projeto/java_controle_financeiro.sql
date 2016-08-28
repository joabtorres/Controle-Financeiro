-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 28-Ago-2016 às 13:36
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `java_controle_financeiro`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `fin_despesas`
--

CREATE TABLE IF NOT EXISTS `fin_despesas` (
  `n_cod` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `n_codusuario` int(11) NOT NULL,
  `c_produto` varchar(20) NOT NULL,
  `d_cadastro` date NOT NULL,
  `n_valor` double NOT NULL,
  PRIMARY KEY (`n_cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `fin_despesas`
--

INSERT INTO `fin_despesas` (`n_cod`, `n_codusuario`, `c_produto`, `d_cadastro`, `n_valor`) VALUES
(3, 1, 'Parcela do Notebook', '2016-07-28', 686);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fin_investimentos`
--

CREATE TABLE IF NOT EXISTS `fin_investimentos` (
  `n_cod` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `n_codusuario` int(11) NOT NULL,
  `c_produto` varchar(20) NOT NULL,
  `d_cadastro` date NOT NULL,
  `n_valor` double NOT NULL,
  PRIMARY KEY (`n_cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `fin_investimentos`
--

INSERT INTO `fin_investimentos` (`n_cod`, `n_codusuario`, `c_produto`, `d_cadastro`, `n_valor`) VALUES
(4, 1, 'Apostila', '2016-07-28', 100);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fin_lucros`
--

CREATE TABLE IF NOT EXISTS `fin_lucros` (
  `n_cod` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `n_codusuario` int(11) NOT NULL,
  `c_produto` varchar(20) NOT NULL,
  `d_cadastro` date NOT NULL,
  `n_valor` double NOT NULL,
  PRIMARY KEY (`n_cod`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Extraindo dados da tabela `fin_lucros`
--

INSERT INTO `fin_lucros` (`n_cod`, `n_codusuario`, `c_produto`, `d_cadastro`, `n_valor`) VALUES
(8, 1, 'Cliente Kananda', '2016-07-28', 200),
(9, 1, 'Estágio PRODEPA', '2016-07-28', 950.38);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fin_usuarios`
--

CREATE TABLE IF NOT EXISTS `fin_usuarios` (
  `n_codusuario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `c_nomeusuario` varchar(40) NOT NULL,
  `c_usuario` varchar(15) NOT NULL,
  `c_senhausuario` varchar(32) NOT NULL,
  `d_cadastrousuario` date NOT NULL,
  `b_permissaousuario` tinyint(1) NOT NULL,
  PRIMARY KEY (`n_codusuario`),
  UNIQUE KEY `c_usuario` (`c_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Extraindo dados da tabela `fin_usuarios`
--

INSERT INTO `fin_usuarios` (`n_codusuario`, `c_nomeusuario`, `c_usuario`, `c_senhausuario`, `d_cadastrousuario`, `b_permissaousuario`) VALUES
(1, 'Adminstrador Master', 'admin', '123', '2016-07-26', 0),
(17, 'JOAB TORRES ALENCAR', 'joabtorres', '96560262', '2016-07-28', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
