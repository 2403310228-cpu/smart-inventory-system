package com.mycompany.aplikasiminimarket.dao;

import com.mycompany.aplikasiminimarket.config.Koneksi;
import com.mycompany.aplikasiminimarket.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {

    private Connection conn;

    public UserDAO() {
        conn = Koneksi.getConnection();
    }

    // =========================
    // LOGIN
    // =========================
    public User login(String username, String password) {

        User user = null;

        String sql = "SELECT * FROM user WHERE username=? AND password=?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new User();

                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNama(rs.getString("nama"));
                user.setLevel(rs.getString("level"));

            }

        } catch (SQLException e) {
            System.out.println("Login Error : " + e.getMessage());
        }

        return user;

    }

    // =========================
    // SIMPAN USER
    // =========================
    public boolean simpan(User user) {

        String sql = "INSERT INTO user(username,password,nama,level) VALUES(?,?,?,?)";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNama());
            ps.setString(4, user.getLevel());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Simpan Error : " + e.getMessage());

        }

        return false;

    }

    // =========================
    // UPDATE USER
    // =========================
    public boolean update(User user) {

        String sql = "UPDATE user SET "
                + "username=?,"
                + "password=?,"
                + "nama=?,"
                + "level=? "
                + "WHERE id_user=?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNama());
            ps.setString(4, user.getLevel());
            ps.setInt(5, user.getIdUser());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Update Error : " + e.getMessage());

        }

        return false;

    }

    // =========================
    // HAPUS USER
    // =========================
    public boolean hapus(int idUser) {

        String sql = "DELETE FROM user WHERE id_user=?";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idUser);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println("Hapus Error : " + e.getMessage());

        }

        return false;

    }

    // =========================
    // TAMPIL SEMUA USER
    // =========================
    public ArrayList<User> getAllUser() {

        ArrayList<User> list = new ArrayList<>();

        String sql = "SELECT * FROM user ORDER BY nama ASC";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User user = new User();

                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNama(rs.getString("nama"));
                user.setLevel(rs.getString("level"));

                list.add(user);

            }

        } catch (SQLException e) {

            System.out.println("Tampil Error : " + e.getMessage());

        }

        return list;

    }

    // =========================
    // CARI USER
    // =========================
    public ArrayList<User> cariUser(String keyword) {

        ArrayList<User> list = new ArrayList<>();

        String sql = "SELECT * FROM user "
                + "WHERE username LIKE ? "
                + "OR nama LIKE ? "
                + "OR level LIKE ? "
                + "ORDER BY nama ASC";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User user = new User();

                user.setIdUser(rs.getInt("id_user"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNama(rs.getString("nama"));
                user.setLevel(rs.getString("level"));

                list.add(user);

            }

        } catch (SQLException e) {

            System.out.println("Cari Error : " + e.getMessage());

        }

        return list;

    }

}