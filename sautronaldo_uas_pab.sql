-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 12 Jul 2026 pada 14.57
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sautronaldo_uas_pab`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kode_barang` varchar(10) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `harga_beli` double DEFAULT NULL,
  `harga_jual` double DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `kode_supplier` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kode_barang`, `nama_barang`, `kategori`, `harga_beli`, `harga_jual`, `stok`, `kode_supplier`) VALUES
('BR002', 'IndomieGoreng', 'Makanan', 2500, 3000, 100, 'SP001'),
('BR003', 'Mie Sedap Goreng', 'Makanan', 3000, 3500, 100, 'SP003'),
('BR004', 'Spried', 'Minuman', 4700, 5000, 99, 'SP001'),
('BR005', 'KacangGaruda', 'Snack', 2000, 3000, 100, 'SP001'),
('BR101', 'Indomie Goreng', 'Makanan', 2500, 3500, 120, 'SP001'),
('BR102', 'Indomie Soto', 'Makanan', 2500, 3500, 110, 'SP001'),
('BR103', 'Indomie Ayam Bawang', 'Makanan', 2500, 3500, 100, 'SP001'),
('BR104', 'Mie Sedaap Goreng', 'Makanan', 2600, 3600, 95, 'SP001'),
('BR105', 'Mie Sedaap Kari', 'Makanan', 2600, 3600, 90, 'SP001'),
('BR106', 'Supermi Ayam', 'Makanan', 2400, 3400, 100, 'SP001'),
('BR107', 'Sarimi Isi 2', 'Makanan', 3200, 4500, 80, 'SP001'),
('BR108', 'Pop Mie Ayam', 'Makanan', 4800, 6000, 60, 'SP001'),
('BR109', 'Pop Mie Soto', 'Makanan', 4800, 6000, 70, 'SP001'),
('BR110', 'Aqua 600ml', 'Minuman', 2500, 4000, 200, 'SP002'),
('BR111', 'Le Minerale 600ml', 'Minuman', 2300, 3500, 180, 'SP002'),
('BR112', 'Ades 600ml', 'Minuman', 2200, 3500, 170, 'SP002'),
('BR113', 'Teh Botol Sosro', 'Minuman', 3500, 5000, 150, 'SP002'),
('BR114', 'Pucuk Harum', 'Minuman', 3000, 4500, 130, 'SP002'),
('BR115', 'Ultra Milk Coklat', 'Minuman', 5000, 7000, 90, 'SP002'),
('BR116', 'Ultra Milk Putih', 'Minuman', 5000, 7000, 90, 'SP002'),
('BR117', 'Floridina Orange', 'Minuman', 3200, 4500, 80, 'SP002'),
('BR118', 'Good Day Cappuccino', 'Minuman', 2800, 4000, 100, 'SP002'),
('BR119', 'ABC Susu', 'Minuman', 1800, 3000, 140, 'SP002'),
('BR120', 'Energen Coklat', 'Minuman', 2200, 3500, 130, 'SP002'),
('BR121', 'Rinso 800gr', 'Kebutuhan Rumah', 18000, 22000, 50, 'SP003'),
('BR122', 'Daia 800gr', 'Kebutuhan Rumah', 17000, 21000, 40, 'SP003'),
('BR123', 'So Klin Liquid', 'Kebutuhan Rumah', 15000, 19000, 45, 'SP003'),
('BR124', 'Molto Pewangi', 'Kebutuhan Rumah', 7000, 9000, 60, 'SP003'),
('BR125', 'Sunlight Lemon', 'Kebutuhan Rumah', 9000, 12000, 50, 'SP003'),
('BR126', 'Mama Lemon', 'Kebutuhan Rumah', 8500, 11000, 40, 'SP003'),
('BR127', 'Baygon Spray', 'Kebutuhan Rumah', 22000, 27000, 30, 'SP003'),
('BR128', 'Hit Aerosol', 'Kebutuhan Rumah', 24000, 29000, 25, 'SP003'),
('BR129', 'Wipol Karbol', 'Kebutuhan Rumah', 14000, 18000, 35, 'SP003'),
('BR130', 'Vixal Pembersih', 'Kebutuhan Rumah', 12000, 15000, 30, 'SP003'),
('BR131', 'Pepsodent 190gr', 'Perawatan', 9000, 12000, 60, 'SP001'),
('BR132', 'Close Up Red', 'Perawatan', 9500, 12500, 50, 'SP001'),
('BR133', 'Lifebuoy Sabun', 'Perawatan', 4000, 6000, 90, 'SP001'),
('BR134', 'Lux Soft Touch', 'Perawatan', 4200, 6200, 80, 'SP001'),
('BR135', 'Sunsilk Shampoo', 'Perawatan', 17000, 21000, 45, 'SP001'),
('BR136', 'Pantene Shampoo', 'Perawatan', 18000, 23000, 40, 'SP001'),
('BR137', 'Head & Shoulders', 'Perawatan', 25000, 30000, 35, 'SP001'),
('BR138', 'Rexona Roll On', 'Perawatan', 16000, 20000, 40, 'SP001'),
('BR139', 'Nivea Men', 'Perawatan', 22000, 27000, 30, 'SP001'),
('BR140', 'Biore Facial Foam', 'Perawatan', 18000, 23000, 35, 'SP001'),
('BR141', 'Roma Kelapa', 'Snack', 7000, 9000, 80, 'SP002'),
('BR142', 'Oreo Vanilla', 'Snack', 8000, 10000, 90, 'SP002'),
('BR143', 'Tango Wafer', 'Snack', 7500, 9500, 100, 'SP002'),
('BR144', 'Qtela Singkong', 'Snack', 9000, 12000, 60, 'SP002'),
('BR145', 'Chitato Sapi Panggang', 'Snack', 9500, 13000, 55, 'SP002'),
('BR146', 'Lays Rumput Laut', 'Snack', 10000, 14000, 50, 'SP002'),
('BR147', 'Piattos Keju', 'Snack', 8500, 11000, 65, 'SP002'),
('BR148', 'SilverQueen 65gr', 'Snack', 12000, 15000, 45, 'SP002'),
('BR149', 'Beng Beng', 'Snack', 2500, 3500, 120, 'SP002'),
('BR150', 'Kinder Joy', 'Snack', 18000, 22000, 30, 'SP002');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_penjualan`
--

CREATE TABLE `detail_penjualan` (
  `id_detail` int(11) NOT NULL,
  `no_transaksi` varchar(15) DEFAULT NULL,
  `kode_barang` varchar(10) DEFAULT NULL,
  `harga` double DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `detail_penjualan`
--

INSERT INTO `detail_penjualan` (`id_detail`, `no_transaksi`, `kode_barang`, `harga`, `jumlah`, `subtotal`) VALUES
(1, 'TRX0001', 'BR101', 3500, 2, 7000),
(2, 'TRX0001', 'BR110', 4000, 3, 12000),
(3, 'TRX0002', 'BR102', 3500, 5, 17500),
(4, 'TRX0002', 'BR141', 9000, 2, 18000),
(5, 'TRX0003', 'BR103', 3500, 4, 14000),
(6, 'TRX0003', 'BR111', 3500, 6, 21000),
(7, 'TRX0004', 'BR104', 3600, 3, 10800),
(8, 'TRX0004', 'BR142', 10000, 2, 20000),
(9, 'TRX0005', 'BR105', 3600, 5, 18000),
(10, 'TRX0005', 'BR143', 9500, 2, 19000),
(11, 'TRX0006', 'BR106', 3400, 6, 20400),
(12, 'TRX0006', 'BR112', 3500, 5, 17500),
(13, 'TRX0007', 'BR107', 4500, 3, 13500),
(14, 'TRX0007', 'BR144', 12000, 1, 12000),
(15, 'TRX0008', 'BR108', 6000, 4, 24000),
(16, 'TRX0008', 'BR145', 13000, 2, 26000),
(17, 'TRX0009', 'BR109', 6000, 2, 12000),
(18, 'TRX0009', 'BR146', 14000, 1, 14000),
(19, 'TRX0010', 'BR110', 4000, 5, 20000),
(20, 'TRX0010', 'BR147', 11000, 2, 22000),
(21, 'TRX0011', 'BR111', 3500, 8, 28000),
(22, 'TRX0011', 'BR148', 15000, 1, 15000),
(23, 'TRX0012', 'BR112', 3500, 4, 14000),
(24, 'TRX0012', 'BR149', 3500, 10, 35000),
(25, 'TRX0013', 'BR113', 5000, 5, 25000),
(26, 'TRX0013', 'BR150', 22000, 1, 22000),
(27, 'TRX0014', 'BR114', 4500, 4, 18000),
(28, 'TRX0014', 'BR121', 22000, 1, 22000),
(29, 'TRX0015', 'BR115', 7000, 3, 21000),
(30, 'TRX0015', 'BR122', 21000, 1, 21000),
(31, 'TRX0016', 'BR116', 7000, 2, 14000),
(32, 'TRX0016', 'BR123', 19000, 2, 38000),
(33, 'TRX0017', 'BR117', 4500, 6, 27000),
(34, 'TRX0017', 'BR124', 9000, 2, 18000),
(35, 'TRX0018', 'BR118', 4000, 7, 28000),
(36, 'TRX0018', 'BR125', 12000, 2, 24000),
(37, 'TRX0019', 'BR119', 3000, 8, 24000),
(38, 'TRX0019', 'BR126', 11000, 2, 22000),
(39, 'TRX0020', 'BR120', 3500, 10, 35000),
(40, 'TRX0020', 'BR127', 27000, 1, 27000),
(41, 'TRX0021', 'BR128', 29000, 1, 29000),
(42, 'TRX0022', 'BR129', 18000, 2, 36000),
(43, 'TRX0023', 'BR130', 15000, 2, 30000),
(44, 'TRX0024', 'BR131', 12000, 3, 36000),
(45, 'TRX0025', 'BR132', 12500, 2, 25000),
(46, 'TRX0026', 'BR133', 6000, 5, 30000),
(47, 'TRX0027', 'BR134', 6200, 4, 24800),
(48, 'TRX0028', 'BR135', 21000, 2, 42000),
(49, 'TRX0029', 'BR136', 23000, 2, 46000),
(50, 'TRX0030', 'BR137', 30000, 1, 30000),
(51, 'TRX051', 'BR146', 14000, 10, 140000),
(52, 'TRX051', 'BR144', 12000, 11, 132000),
(53, 'TRX051', 'BR146', 14000, 10, 140000),
(54, 'TRX051', 'BR144', 12000, 11, 132000),
(55, 'TRX051', 'BR146', 14000, 10, 140000),
(56, 'TRX051', 'BR144', 12000, 11, 132000),
(57, 'TRX051', 'BR146', 14000, 10, 140000),
(58, 'TRX051', 'BR144', 12000, 11, 132000),
(59, 'TRX052', 'BR002', 3000, 11, 33000),
(60, 'TRX052', 'BR005', 3000, 11, 33000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `no_transaksi` varchar(15) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `kasir` varchar(100) DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`no_transaksi`, `tanggal`, `kasir`, `total`) VALUES
('TRX0001', '2026-07-01', 'Admin', 125000),
('TRX0002', '2026-07-01', 'Admin', 98000),
('TRX0003', '2026-07-01', 'Kasir', 76000),
('TRX0004', '2026-07-02', 'Admin', 154000),
('TRX0005', '2026-07-02', 'Kasir', 89000),
('TRX0006', '2026-07-02', 'Admin', 210000),
('TRX0007', '2026-07-03', 'Kasir', 67000),
('TRX0008', '2026-07-03', 'Admin', 134000),
('TRX0009', '2026-07-03', 'Kasir', 99000),
('TRX0010', '2026-07-04', 'Admin', 182000),
('TRX0011', '2026-07-04', 'Kasir', 112000),
('TRX0012', '2026-07-04', 'Admin', 97000),
('TRX0013', '2026-07-05', 'Kasir', 143000),
('TRX0014', '2026-07-05', 'Admin', 198000),
('TRX0015', '2026-07-05', 'Kasir', 88000),
('TRX0016', '2026-07-06', 'Admin', 124000),
('TRX0017', '2026-07-06', 'Kasir', 76000),
('TRX0018', '2026-07-06', 'Admin', 165000),
('TRX0019', '2026-07-07', 'Kasir', 93000),
('TRX0020', '2026-07-07', 'Admin', 145000),
('TRX0021', '2026-07-07', 'Kasir', 103000),
('TRX0022', '2026-07-08', 'Admin', 128000),
('TRX0023', '2026-07-08', 'Kasir', 94000),
('TRX0024', '2026-07-08', 'Admin', 176000),
('TRX0025', '2026-07-09', 'Kasir', 119000),
('TRX0026', '2026-07-09', 'Admin', 202000),
('TRX0027', '2026-07-09', 'Kasir', 87000),
('TRX0028', '2026-07-10', 'Admin', 136000),
('TRX0029', '2026-07-10', 'Kasir', 158000),
('TRX0030', '2026-07-10', 'Admin', 92000),
('TRX0031', '2026-07-11', 'Kasir', 110000),
('TRX0032', '2026-07-11', 'Admin', 167000),
('TRX0033', '2026-07-11', 'Kasir', 99000),
('TRX0034', '2026-07-12', 'Admin', 184000),
('TRX0035', '2026-07-12', 'Kasir', 72000),
('TRX0036', '2026-07-12', 'Admin', 143000),
('TRX0037', '2026-07-13', 'Kasir', 96000),
('TRX0038', '2026-07-13', 'Admin', 173000),
('TRX0039', '2026-07-13', 'Kasir', 89000),
('TRX0040', '2026-07-14', 'Admin', 194000),
('TRX0041', '2026-07-14', 'Kasir', 115000),
('TRX0042', '2026-07-14', 'Admin', 126000),
('TRX0043', '2026-07-15', 'Kasir', 98000),
('TRX0044', '2026-07-15', 'Admin', 208000),
('TRX0045', '2026-07-15', 'Kasir', 132000),
('TRX0046', '2026-07-16', 'Admin', 149000),
('TRX0047', '2026-07-16', 'Kasir', 91000),
('TRX0048', '2026-07-16', 'Admin', 177000),
('TRX0049', '2026-07-17', 'Kasir', 105000),
('TRX0050', '2026-07-17', 'Admin', 189000),
('TRX051', '2026-07-10', 'XxxxxX', 272000),
('TRX052', '2026-07-10', 'Pagi', 66000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `kode_supplier` varchar(10) DEFAULT NULL,
  `nama_supplier` varchar(100) NOT NULL,
  `alamat` text DEFAULT NULL,
  `telepon` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`kode_supplier`, `nama_supplier`, `alamat`, `telepon`, `email`) VALUES
('SP001', 'PT Maju Jaya', 'Jakarta', '081234567890', 'maju@gmail.com'),
('SP002', 'CV Sumber Rejeki', 'Bandung', '082222222222', 'rejeki@gmail.com'),
('SP003', 'PT Nusantara', 'Surabaya', '083333333333', 'nusantara@gmail.com'),
('SP004', 'PT Sinar Makmur', 'Jakarta', '081234560004', 'sp004@gmail.com'),
('SP005', 'CV Berkah Jaya', 'Bandung', '081234560005', 'sp005@gmail.com'),
('SP006', 'PT Nusantara Abadi', 'Surabaya', '081234560006', 'sp006@gmail.com'),
('SP007', 'CV Maju Bersama', 'Semarang', '081234560007', 'sp007@gmail.com'),
('SP008', 'PT Sejahtera Sentosa', 'Yogyakarta', '081234560008', 'sp008@gmail.com'),
('SP009', 'CV Mitra Usaha', 'Medan', '081234560009', 'sp009@gmail.com'),
('SP010', 'PT Indo Makmur', 'Makassar', '081234560010', 'sp010@gmail.com'),
('SP011', 'CV Prima Niaga', 'Palembang', '081234560011', 'sp011@gmail.com'),
('SP012', 'PT Cahaya Baru', 'Pontianak', '081234560012', 'sp012@gmail.com'),
('SP013', 'CV Sumber Rejeki Baru', 'Malang', '081234560013', 'sp013@gmail.com'),
('SP014', 'PT Anugerah Abadi', 'Solo', '081234560014', 'sp014@gmail.com'),
('SP015', 'CV Mega Jaya', 'Bekasi', '081234560015', 'sp015@gmail.com'),
('SP016', 'PT Bintang Timur', 'Depok', '081234560016', 'sp016@gmail.com'),
('SP017', 'CV Sentosa Mandiri', 'Bogor', '081234560017', 'sp017@gmail.com'),
('SP018', 'PT Karya Nusantara', 'Tangerang', '081234560018', 'sp018@gmail.com'),
('SP019', 'CV Makmur Sentosa', 'Cirebon', '081234560019', 'sp019@gmail.com'),
('SP020', 'PT Pangan Jaya', 'Tasikmalaya', '081234560020', 'sp020@gmail.com'),
('SP021', 'CV Aneka Usaha', 'Purwokerto', '081234560021', 'sp021@gmail.com'),
('SP022', 'PT Prima Abadi', 'Pekanbaru', '081234560022', 'sp022@gmail.com'),
('SP023', 'CV Gemilang', 'Jambi', '081234560023', 'sp023@gmail.com'),
('SP024', 'PT Mutiara Niaga', 'Padang', '081234560024', 'sp024@gmail.com'),
('SP025', 'CV Harapan Baru', 'Lampung', '081234560025', 'sp025@gmail.com'),
('SP026', 'PT Sukses Selalu', 'Banjarmasin', '081234560026', 'sp026@gmail.com'),
('SP027', 'CV Andalas', 'Balikpapan', '081234560027', 'sp027@gmail.com'),
('SP028', 'PT Borneo Makmur', 'Samarinda', '081234560028', 'sp028@gmail.com'),
('SP029', 'CV Cipta Karya', 'Manado', '081234560029', 'sp029@gmail.com'),
('SP030', 'PT Global Jaya', 'Kendari', '081234560030', 'sp030@gmail.com'),
('SP031', 'CV Indo Sejahtera', 'Mataram', '081234560031', 'sp031@gmail.com'),
('SP032', 'PT Sinar Nusantara', 'Kupang', '081234560032', 'sp032@gmail.com'),
('SP033', 'CV Bumi Sentosa', 'Jayapura', '081234560033', 'sp033@gmail.com'),
('SP034', 'PT Kencana Abadi', 'Batam', '081234560034', 'sp034@gmail.com'),
('SP035', 'CV Lestari Jaya', 'Banda Aceh', '081234560035', 'sp035@gmail.com'),
('SP036', 'PT Maju Terus', 'Serang', '081234560036', 'sp036@gmail.com'),
('SP037', 'CV Indo Raya', 'Cilegon', '081234560037', 'sp037@gmail.com'),
('SP038', 'PT Sumber Makmur', 'Sukabumi', '081234560038', 'sp038@gmail.com'),
('SP039', 'CV Prima Sentosa', 'Garut', '081234560039', 'sp039@gmail.com'),
('SP040', 'PT Karya Mandiri', 'Kediri', '081234560040', 'sp040@gmail.com'),
('SP041', 'CV Bintang Jaya', 'Madiun', '081234560041', 'sp041@gmail.com'),
('SP042', 'PT Surya Abadi', 'Blitar', '081234560042', 'sp042@gmail.com'),
('SP043', 'CV Mitra Mandiri', 'Probolinggo', '081234560043', 'sp043@gmail.com'),
('SP044', 'PT Agung Sejahtera', 'Pasuruan', '081234560044', 'sp044@gmail.com'),
('SP045', 'CV Maju Makmur', 'Sidoarjo', '081234560045', 'sp045@gmail.com'),
('SP046', 'PT Tirta Jaya', 'Gresik', '081234560046', 'sp046@gmail.com'),
('SP047', 'CV Delta Niaga', 'Banyuwangi', '081234560047', 'sp047@gmail.com'),
('SP048', 'PT Samudera Abadi', 'Cimahi', '081234560048', 'sp048@gmail.com'),
('SP049', 'CV Nusantara Mandiri', 'Salatiga', '081234560049', 'sp049@gmail.com'),
('SP050', 'PT Inti Pangan', 'Magelang', '081234560050', 'sp050@gmail.com'),
('SP051', 'CV Berkat Sentosa', 'Tegal', '081234560051', 'sp051@gmail.com'),
('SP052', 'PT Graha Niaga', 'Pati', '081234560052', 'sp052@gmail.com'),
('SP053', 'CV Karya Bersama', 'Jepara', '081234560053', 'sp053@gmail.com');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `level` enum('ADMIN','KASIR') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama`, `level`) VALUES
(1, 'admin', 'admin123', 'Administrator', 'ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`),
  ADD KEY `fk_supplier` (`kode_supplier`);

--
-- Indeks untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD PRIMARY KEY (`id_detail`),
  ADD KEY `fk_penjualan` (`no_transaksi`),
  ADD KEY `fk_barang` (`kode_barang`);

--
-- Indeks untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`no_transaksi`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD UNIQUE KEY `kode_supplier` (`kode_supplier`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  MODIFY `id_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `fk_supplier` FOREIGN KEY (`kode_supplier`) REFERENCES `supplier` (`kode_supplier`);

--
-- Ketidakleluasaan untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD CONSTRAINT `fk_barang` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_penjualan` FOREIGN KEY (`no_transaksi`) REFERENCES `penjualan` (`no_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
