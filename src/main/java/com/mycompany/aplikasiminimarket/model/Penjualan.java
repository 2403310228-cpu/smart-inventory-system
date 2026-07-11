package com.mycompany.aplikasiminimarket.model;

import java.util.Date;

public class Penjualan {

    private String noTransaksi;
    private Date tanggal;
    private String kasir;
    private double total;

    public Penjualan() {
    }

    public Penjualan(String noTransaksi, Date tanggal, String kasir, double total) {
        this.noTransaksi = noTransaksi;
        this.tanggal = tanggal;
        this.kasir = kasir;
        this.total = total;
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKasir() {
        return kasir;
    }

    public void setKasir(String kasir) {
        this.kasir = kasir;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}