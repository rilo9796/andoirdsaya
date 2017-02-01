package rilonur.gunawan.javaclass;

import java.util.ArrayList;

/**
 * Created by D2J-00 on 31/01/2017.
 */
public class Transaksi {

    private ArrayList<Barang> listBarang = new ArrayList<>();

    public void addBarang(Barang barang) {
        this.listBarang.add(barang);
    }

    public int totalTransaksi() {
        int hasil = 0;
        for (int i = 0; i < listBarang.size(); i++) {
            hasil += listBarang.get(i).getHarga();
        }

        return hasil;
    }

    public String printTransaksi() {
        String text = "Barang yang dibeli pada transaksi ini adalah: \n";
        text += "\n-----------------------------------------------\n";
        for (int i = 0; i < listBarang.size(); i++) {
            text += listBarang.get(i).toString();
        }
        text += "---------------------------------------------\n";
        text += "  Total Pembelian: " + totalTransaksi() + "\n";
        text += "  Rata- Rata Pembelian: " + averageTransaksi() + "\n";
        return text;
    }

    public double averageTransaksi() {
        double hasil = 0;
        for (int i = 0; i < listBarang.size(); i++) {
            hasil += listBarang.get(i).getHarga();
        }

        hasil = hasil / listBarang.size();
        return hasil;
    }

    public String maxBarang() {
        Barang max;

        max = listBarang.get(0);
        for (int i = 0; i < listBarang.size(); i++) {
            if (listBarang.get(i).getHarga() > max.getHarga()) {

                max = listBarang.get(i);
                 }

            }
            String namaBarang = max.getNama();
            int hargaBarang = max.getHarga();
            String text = "Barang termahal pada transaksi adalah " + namaBarang +" dengan harga "+hargaBarang;
            return text;
        }


}
