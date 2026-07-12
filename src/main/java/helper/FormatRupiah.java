package helper;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatRupiah {

   public static String formatRupiah(double nilai) {

    Locale indonesia = new Locale("id", "ID");

    NumberFormat rupiah = NumberFormat.getCurrencyInstance(indonesia);

    String hasil = rupiah.format(nilai);

    hasil = hasil.replace("Rp", "Rp. ");
    hasil = hasil.replace(",00", "");

    return hasil;

    }

}