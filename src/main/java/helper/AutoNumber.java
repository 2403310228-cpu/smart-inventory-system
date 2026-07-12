package helper;

import com.mycompany.aplikasiminimarket.config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AutoNumber {

    private final Connection conn;

    public AutoNumber() {
        conn = Koneksi.getConnection();
    }

    public String generateKode(String tabel, String kolom, String prefix) {

        String kode = prefix + "001";

        try {

            String sql = "SELECT " + kolom +
                         " FROM " + tabel +
                         " ORDER BY " + kolom + " DESC LIMIT 1";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String lastKode = rs.getString(kolom);

                String angka = lastKode.substring(prefix.length());

                int nomor = Integer.parseInt(angka);

                nomor++;

                kode = prefix + String.format("%03d", nomor);

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return kode;

    }

}