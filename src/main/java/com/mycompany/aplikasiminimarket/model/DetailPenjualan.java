package com.mycompany.aplikasiminimarket.model;

public class DetailPenjualan {

    private int idDetail;
    private String noTransaksi;
    private String kodeBarang;
    private double harga;
    private int jumlah;
    private double subtotal;

    public DetailPenjualan() {
    }

    public DetailPenjualan(int idDetail, String noTransaksi,
            String kodeBarang, double harga,
            int jumlah, double subtotal) {

        this.idDetail = idDetail;
        this.noTransaksi = noTransaksi;
        this.kodeBarang = kodeBarang;
        this.harga = harga;
        this.jumlah = jumlah;
        this.subtotal = subtotal;

    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}