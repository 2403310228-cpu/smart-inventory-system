package com.mycompany.aplikasiminimarket.dao;

import com.mycompany.aplikasiminimarket.config.Koneksi;
import com.mycompany.aplikasiminimarket.model.Supplier;
import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {

    private final Connection conn;

    public SupplierDAO() {
        conn = Koneksi.getConnection();
    }

    // ==========================
    // GENERATE KODE SUPPLIER
    // ==========================
    public String generateKodeSupplier() {

        String kode = "SP001";

        String sql = "SELECT kode_supplier FROM supplier ORDER BY kode_supplier DESC LIMIT 1";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int nomor = Integer.parseInt(rs.getString("kode_supplier").substring(2));
                nomor++;

                kode = String.format("SP%03d", nomor);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return kode;

    }

    // ==========================
    // SIMPAN
    // ==========================
    public boolean simpan(Supplier supplier) {

        String sql = "INSERT INTO supplier(kode_supplier,nama_supplier,alamat,telepon,email) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, supplier.getKodeSupplier());
            ps.setString(2, supplier.getNamaSupplier());
            ps.setString(3, supplier.getAlamat());
            ps.setString(4, supplier.getTelepon());
            ps.setString(5, supplier.getEmail());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;

    }

    // ==========================
    // UPDATE
    // ==========================
    public boolean ubah(Supplier supplier) {

        String sql = "UPDATE supplier SET nama_supplier=?,alamat=?,telepon=?,email=? WHERE kode_supplier=?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, supplier.getNamaSupplier());
            ps.setString(2, supplier.getAlamat());
            ps.setString(3, supplier.getTelepon());
            ps.setString(4, supplier.getEmail());
            ps.setString(5, supplier.getKodeSupplier());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;

    }

    // ==========================
    // HAPUS
    // ==========================
    public boolean hapus(String kodeSupplier) {

        String sql = "DELETE FROM supplier WHERE kode_supplier=?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kodeSupplier);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
        System.out.println("Supplier masih digunakan oleh data barang.");
            } else 
            System.out.println(e.getMessage());

        }

        return false;

    }

    // ==========================
    // CARI
    // ==========================
    public Supplier cari(String kodeSupplier) {

        String sql = "SELECT * FROM supplier WHERE kode_supplier=?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, kodeSupplier);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Supplier s = new Supplier();

                s.setKodeSupplier(rs.getString("kode_supplier"));
                s.setNamaSupplier(rs.getString("nama_supplier"));
                s.setAlamat(rs.getString("alamat"));
                s.setTelepon(rs.getString("telepon"));
                s.setEmail(rs.getString("email"));

                return s;

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return null;

    }

    // ==========================
    // TAMPIL SEMUA
    // ==========================
    public List<Supplier> getSemuaSupplier() {

        List<Supplier> list = new ArrayList<>();

        String sql = "SELECT * FROM supplier ORDER BY kode_supplier";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Supplier s = new Supplier();

                s.setKodeSupplier(rs.getString("kode_supplier"));
                s.setNamaSupplier(rs.getString("nama_supplier"));
                s.setAlamat(rs.getString("alamat"));
                s.setTelepon(rs.getString("telepon"));
                s.setEmail(rs.getString("email"));

                list.add(s);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return list;

    }

    // ==========================
    // TOTAL SUPPLIER
    // ==========================
    public int getTotalSupplier() {

        int total = 0;

        String sql = "SELECT COUNT(*) AS total FROM supplier";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                total = rs.getInt("total");

            }

        } catch (SQLException e) {

            System.out.println("Total Supplier Error : " + e.getMessage());

        }

        return total;

    }
    public List<Supplier> cariSupplier(String keyword) {

    List<Supplier> list = new ArrayList<>();

    String sql = "SELECT * FROM supplier "
               + "WHERE kode_supplier LIKE ? "
               + "OR nama_supplier LIKE ? "
               + "OR alamat LIKE ? "
               + "OR telepon LIKE ? "
               + "OR email LIKE ?";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);

        String cari = "%" + keyword + "%";

        ps.setString(1, cari);
        ps.setString(2, cari);
        ps.setString(3, cari);
        ps.setString(4, cari);
        ps.setString(5, cari);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Supplier s = new Supplier();

            s.setKodeSupplier(rs.getString("kode_supplier"));
            s.setNamaSupplier(rs.getString("nama_supplier"));
            s.setAlamat(rs.getString("alamat"));
            s.setTelepon(rs.getString("telepon"));
            s.setEmail(rs.getString("email"));

            list.add(s);

        }

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return list;

    }
    public DefaultCategoryDataset getDatasetSupplier() {

    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    String sql = "SELECT nama, COUNT(*) AS jumlah "
               + "FROM supplier "
               + "GROUP BY nama";

    try {

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            dataset.addValue(
                    rs.getInt("jumlah"),
                    "Supplier",
                    rs.getString("nama")
            );

        }

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }

    return dataset;

}
}