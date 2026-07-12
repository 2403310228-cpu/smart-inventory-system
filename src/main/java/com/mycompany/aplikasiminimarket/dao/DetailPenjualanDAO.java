package com.mycompany.aplikasiminimarket.dao;

import com.mycompany.aplikasiminimarket.config.Koneksi;
import com.mycompany.aplikasiminimarket.model.DetailPenjualan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class DetailPenjualanDAO {

    private final Connection conn;

    public DetailPenjualanDAO() {
        conn = Koneksi.getConnection();
    }

    //===========================
    // SIMPAN DETAIL
    //===========================

    public boolean simpan(DetailPenjualan detail) {

        String sql =
                "INSERT INTO detail_penjualan"
                + "(no_transaksi,kode_barang,harga,jumlah,subtotal)"
                + " VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, detail.getNoTransaksi());
            ps.setString(2, detail.getKodeBarang());
            ps.setDouble(3, detail.getHarga());
            ps.setInt(4, detail.getJumlah());
            ps.setDouble(5, detail.getSubtotal());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;

    }

    //===========================
    // HAPUS DETAIL
    //===========================

    public boolean hapus(int idDetail) {

        try {

            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM detail_penjualan "
                    + "WHERE id_detail=?");

            ps.setInt(1, idDetail);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return false;

    }

    //===========================
    // AMBIL DETAIL BERDASARKAN
    // NOMOR TRANSAKSI
    //===========================

    public List<DetailPenjualan> getByTransaksi(String noTransaksi) {

        List<DetailPenjualan> list = new ArrayList<>();

        String sql =
                "SELECT * FROM detail_penjualan "
                + "WHERE no_transaksi=?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, noTransaksi);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                DetailPenjualan d =
                        new DetailPenjualan();

                d.setIdDetail(rs.getInt("id_detail"));
                d.setNoTransaksi(rs.getString("no_transaksi"));
                d.setKodeBarang(rs.getString("kode_barang"));
                d.setHarga(rs.getDouble("harga"));
                d.setJumlah(rs.getInt("jumlah"));
                d.setSubtotal(rs.getDouble("subtotal"));

                list.add(d);

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return list;

    }

}