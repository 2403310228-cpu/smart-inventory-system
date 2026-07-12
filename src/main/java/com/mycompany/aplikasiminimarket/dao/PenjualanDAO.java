package com.mycompany.aplikasiminimarket.dao;
import org.jfree.data.category.DefaultCategoryDataset;
import com.mycompany.aplikasiminimarket.config.Koneksi;
import com.mycompany.aplikasiminimarket.model.Penjualan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PenjualanDAO {

    private final Connection conn;

    public PenjualanDAO() {
        conn = Koneksi.getConnection();
    }

    // ======================================
    // GENERATE NOMOR TRANSAKSI
    // ======================================
    public String generateNoTransaksi() {

        String kode = "TRX001";

        String sql = "SELECT no_transaksi FROM penjualan "
                   + "ORDER BY no_transaksi DESC LIMIT 1";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String last = rs.getString("no_transaksi");

                int nomor = Integer.parseInt(last.substring(3));

                nomor++;

                kode = String.format("TRX%03d", nomor);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return kode;

    }

    // ======================================
    // SIMPAN PENJUALAN
    // ======================================
    public boolean simpan(Penjualan penjualan) {

        String sql = "INSERT INTO penjualan"
                + "(no_transaksi,tanggal,kasir,total)"
                + " VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, penjualan.getNoTransaksi());

            ps.setDate(2,
                    new java.sql.Date(
                            penjualan.getTanggal().getTime()));

            ps.setString(3, penjualan.getKasir());

            ps.setDouble(4, penjualan.getTotal());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;

    }

    // ======================================
    // HAPUS PENJUALAN
    // ======================================
    public boolean hapus(String noTransaksi) {

        String sql = "DELETE FROM penjualan WHERE no_transaksi=?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, noTransaksi);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;

    }

    // ======================================
    // TOTAL PENJUALAN
    // ======================================
    public double getTotalPenjualan() {

        double total = 0;

        String sql = "SELECT SUM(total) AS total FROM penjualan";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                total = rs.getDouble("total");

            }

        } catch (SQLException e) {

            System.out.println("Total Penjualan Error : " + e.getMessage());

        }

        return total;

    }
    public DefaultCategoryDataset getDatasetPenjualan() {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    String sql = "SELECT MONTH(tanggal) AS bulan, SUM(total) AS total "
               + "FROM penjualan "
               + "GROUP BY MONTH(tanggal) "
               + "ORDER BY MONTH(tanggal)";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            String namaBulan = "";

            switch (rs.getInt("bulan")) {

                case 1: namaBulan = "Jan"; break;
                case 2: namaBulan = "Feb"; break;
                case 3: namaBulan = "Mar"; break;
                case 4: namaBulan = "Apr"; break;
                case 5: namaBulan = "Mei"; break;
                case 6: namaBulan = "Jun"; break;
                case 7: namaBulan = "Jul"; break;
                case 8: namaBulan = "Agu"; break;
                case 9: namaBulan = "Sep"; break;
                case 10: namaBulan = "Okt"; break;
                case 11: namaBulan = "Nov"; break;
                case 12: namaBulan = "Des"; break;

            }

            dataset.addValue(
                    rs.getDouble("total"),
                    "Penjualan",
                    namaBulan
            );

        }

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }

    return dataset;

}
    public int getJumlahTransaksi() {

    int total = 0;

    String sql = "SELECT COUNT(*) AS total FROM penjualan";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            total = rs.getInt("total");

        }

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }

    return total;

}
}