package com.mycompany.aplikasiminimarket.dao;

import com.mycompany.aplikasiminimarket.config.Koneksi;
import com.mycompany.aplikasiminimarket.model.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarangDAO {
    private final Connection conn;

    public BarangDAO() {
        conn = Koneksi.getConnection();
    }

  public String generateKodeBarang() {

    String kode = "BR001";

    try {

        String sql = "SELECT kode_barang FROM barang ORDER BY kode_barang DESC LIMIT 1";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            int nomor = Integer.parseInt(
                    rs.getString("kode_barang").substring(2));

            nomor++;

            kode = String.format("BR%03d", nomor);

        }

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return kode;

}
    public boolean simpan(Barang barang) {
        String sql = "INSERT INTO barang(kode_barang,nama_barang,kategori,kode_supplier,harga_beli,harga_jual,stok) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, barang.getKodeBarang());
            ps.setString(2, barang.getNamaBarang());
            ps.setString(3, barang.getKategori());
            ps.setString(4, barang.getKodeSupplier());
            ps.setDouble(5, barang.getHargaBeli());
            ps.setDouble(6, barang.getHargaJual());
            ps.setInt(7, barang.getStok());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean ubah(Barang barang) {
        String sql = "UPDATE barang SET nama_barang=?,kategori=?,kode_supplier=?,harga_beli=?,harga_jual=?,stok=? WHERE kode_barang=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, barang.getNamaBarang());
            ps.setString(2, barang.getKategori());
            ps.setString(3, barang.getKodeSupplier());
            ps.setDouble(4, barang.getHargaBeli());
            ps.setDouble(5, barang.getHargaJual());
            ps.setInt(6, barang.getStok());
            ps.setString(7, barang.getKodeBarang());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

            public boolean hapus(String kodeBarang) {

            String sql = "DELETE FROM barang WHERE kode_barang=?";

            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, kodeBarang);

                return ps.executeUpdate() > 0;

            } catch (SQLException e) {
                System.out.println(e.getMessage());

            return false;
            }
}
public List<Barang> cariBarang(String keyword) {

    List<Barang> list = new ArrayList<>();

    String sql = "SELECT * FROM barang WHERE "
            + "kode_barang LIKE ? OR "
            + "nama_barang LIKE ?";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Barang b = new Barang();

            b.setKodeBarang(rs.getString("kode_barang"));
            b.setNamaBarang(rs.getString("nama_barang"));
            b.setKategori(rs.getString("kategori"));
            b.setHargaBeli(rs.getDouble("harga_beli"));
            b.setHargaJual(rs.getDouble("harga_jual"));
            b.setStok(rs.getInt("stok"));
            b.setKodeSupplier(rs.getString("kode_supplier"));

            list.add(b);

        }

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return list;
}
    public int getTotalBarang() {

    int total = 0;

    String sql = "SELECT COUNT(*) AS total FROM barang";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            total = rs.getInt("total");
        }

    } catch (SQLException e) {

        System.out.println("Total Barang Error : " + e.getMessage());

    }

    return total;
    
}
    public Barang getBarangByKode(String kode) {

    Barang barang = null;

    String sql = "SELECT * FROM barang WHERE kode_barang=?";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, kode);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            barang = new Barang();

            barang.setKodeBarang(rs.getString("kode_barang"));
            barang.setNamaBarang(rs.getString("nama_barang"));
            barang.setKategori(rs.getString("kategori"));
            barang.setHargaBeli(rs.getDouble("harga_beli"));
            barang.setHargaJual(rs.getDouble("harga_jual"));
            barang.setStok(rs.getInt("stok"));
            barang.setKodeSupplier(rs.getString("kode_supplier"));

        }

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return barang;
}
    public DefaultCategoryDataset getDatasetBarang() {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    String sql = "SELECT kategori, COUNT(*) AS jumlah FROM barang GROUP BY kategori";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            dataset.addValue(
                    rs.getInt("jumlah"),
                    "Barang",
                    rs.getString("kategori")
            );

        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    return dataset;
}
    public ArrayList<Barang> getSemuaBarang() {

    ArrayList<Barang> list = new ArrayList<>();

    String sql = "SELECT * FROM barang ORDER BY kode_barang";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Barang b = new Barang();

            b.setKodeBarang(rs.getString("kode_barang"));
            b.setNamaBarang(rs.getString("nama_barang"));
            b.setHargaJual(rs.getDouble("harga_jual"));
            b.setStok(rs.getInt("stok"));

            list.add(b);

        }

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }

    return list;
}

}
