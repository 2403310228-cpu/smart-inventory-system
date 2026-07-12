package com.mycompany.aplikasiminimarket.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static Connection koneksi;

    public static Connection getConnection() {

        if (koneksi == null) {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                koneksi = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sautronaldo_uas_pab",
                "root",
                ""
            );

                System.out.println("Koneksi Database Berhasil");

            } catch (ClassNotFoundException | SQLException e) {

                System.out.println(e.getMessage());

            }

        }

        return koneksi;

    }

}