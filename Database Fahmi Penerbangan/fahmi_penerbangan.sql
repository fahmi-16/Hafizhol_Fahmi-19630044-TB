-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2022 at 10:43 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fahmi_penerbangan`
--

-- --------------------------------------------------------

--
-- Table structure for table `keberangkatan`
--

CREATE TABLE `keberangkatan` (
  `id_keberangkatan` varchar(50) NOT NULL,
  `id_penerbangan` varchar(50) NOT NULL,
  `id_kelas` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `keberangkatan`
--

INSERT INTO `keberangkatan` (`id_keberangkatan`, `id_penerbangan`, `id_kelas`, `nama`, `alamat`, `telepon`) VALUES
('1/PE-1--B1', 'PE-1', '1/PE-1', 'Fahmi', 'Sungai Sipai Martapura', '08192361723'),
('2/PE-1--B2', 'PE-1', '2/PE-1', 'Alfai', 'Banjarmasin HKSN', '0891267382234'),
('2/PE-3--B1', 'PE-3', '2/PE-3', 'Ucup', 'Sekmupul', '0172839123');

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id_kelas` varchar(50) NOT NULL,
  `id_penerbangan` varchar(50) NOT NULL,
  `kelas` varchar(15) NOT NULL,
  `kursi` int(11) NOT NULL,
  `bagasi` double NOT NULL,
  `harga` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `id_penerbangan`, `kelas`, `kursi`, `bagasi`, `harga`) VALUES
('1/PE-1', 'PE-1', 'Firsh Class', 20, 80, 8000000),
('1/PE-2', 'PE-2', 'Executive', 6, 60, 3000000),
('1/PE-3', 'PE-3', 'Firsh Class', 20, 80, 7000000),
('1/PE-4', 'PE-4', 'Executive', 12, 30, 5000000),
('1/PE-5', 'PE-5', 'Executive', 12, 30, 5000000),
('1/PE-6', 'PE-6', 'FIrsh Class', 12, 50, 4000000),
('2/PE-1', 'PE-1', 'Executive', 50, 50, 6000000),
('2/PE-2', 'PE-2', 'Ekonomi', 150, 40, 1200000),
('2/PE-3', 'PE-3', 'Ekonomi', 900, 30, 3000000),
('2/PE-4', 'PE-4', 'Ekonomi', 280, 20, 1500000),
('2/PE-5', 'PE-5', 'Ekonomi', 300, 20, 1200000),
('2/PE-6', 'PE-6', 'Ekonomi', 600, 20, 3000000),
('3/PE-1', 'PE-1', 'Ekonomi', 700, 40, 3000000);

-- --------------------------------------------------------

--
-- Table structure for table `penerbangan`
--

CREATE TABLE `penerbangan` (
  `id_penerbangan` varchar(50) NOT NULL,
  `no_pesawat` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `jam` time NOT NULL,
  `asal` varchar(100) NOT NULL,
  `tujuan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penerbangan`
--

INSERT INTO `penerbangan` (`id_penerbangan`, `no_pesawat`, `tanggal`, `jam`, `asal`, `tujuan`) VALUES
('PE-1', 'HF-0002', '2022-01-13', '07:30:00', 'Banjarmasin', 'Jakatra'),
('PE-2', 'BT-1010001', '2022-01-15', '06:00:00', 'Surabaya', 'Jakarta'),
('PE-3', 'BT-1020001', '2022-01-16', '14:00:00', 'Bali', 'Banjarmasin'),
('PE-4', 'LI-1138002', '2022-01-24', '18:30:00', 'Banjarmasin', 'Bandung'),
('PE-5', 'HF-0002', '2022-01-06', '07:00:00', 'Banjarmasin', 'Bandung'),
('PE-6', 'GR-0912738', '2022-01-06', '13:00:00', 'Banjarmasin', 'Jakarta');

-- --------------------------------------------------------

--
-- Table structure for table `pesawat`
--

CREATE TABLE `pesawat` (
  `no_pesawat` varchar(50) NOT NULL,
  `nama_pesawat` varchar(50) NOT NULL,
  `maskapai` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pesawat`
--

INSERT INTO `pesawat` (`no_pesawat`, `nama_pesawat`, `maskapai`) VALUES
('BT-1010001', 'Airbus A-320', 'Batik Air'),
('BT-1020001', 'Airbus A-330', 'Batik Air'),
('GR-0912738', 'Boing 777-800', 'Garuda Indonesia'),
('HF-0001', 'Airbus A380-1000', 'Hafiz Airlines'),
('HF-0002', 'Boing 777-800', 'Hafiz Airlines'),
('LI-1138002', 'Boing 737-300', 'Lion Air'),
('LI-1238001', 'Airbus A-320', 'Lion Air');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_keberangkatan` varchar(50) NOT NULL,
  `harga` bigint(20) NOT NULL,
  `bayar` bigint(20) NOT NULL,
  `kembali` bigint(20) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_keberangkatan`, `harga`, `bayar`, `kembali`, `tanggal`) VALUES
('1/PE-1--B1', 8000000, 8000000, 0, '2022-01-04'),
('2/PE-1--B2', 6000000, 7000000, 1000000, '2022-01-04'),
('2/PE-3--B1', 3000000, 3500000, 500000, '2022-01-04');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `level` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user`, `password`, `level`) VALUES
('admin', 'admin', 'Admin'),
('fahmi', 'fahmi123', 'Admin'),
('kariawan', 'kariawan', 'Kariawan'),
('wahyu', 'wahyu123', 'Kariawan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `keberangkatan`
--
ALTER TABLE `keberangkatan`
  ADD PRIMARY KEY (`id_keberangkatan`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`);

--
-- Indexes for table `penerbangan`
--
ALTER TABLE `penerbangan`
  ADD PRIMARY KEY (`id_penerbangan`);

--
-- Indexes for table `pesawat`
--
ALTER TABLE `pesawat`
  ADD PRIMARY KEY (`no_pesawat`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_keberangkatan`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
