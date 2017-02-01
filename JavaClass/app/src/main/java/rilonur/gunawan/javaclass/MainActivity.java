package rilonur.gunawan.javaclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String showString;
    public TextView showText;
    public Barang [] arrBarang = new Barang[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText = (TextView) findViewById(R.id.show_text);

        showString = "Manipulasi Class Java Android";
        addSeparator();

        initBarang();
//        showString += arrBarang[3].toString();
//        addSeparator();
//        showString += arrBarang[4].toString();


        Transaksi trans1 = new Transaksi();
        trans1.addBarang(arrBarang[3]);
        trans1.addBarang(arrBarang[7]);
        trans1.addBarang(arrBarang[1]);
        showString += trans1.printTransaksi();
        showString += "\n"+trans1.maxBarang();

        showText.setText(showString);

    }

    public void addSeparator(){
        showString +="\n--------------------------------------------\n";
    }

    public void initBarang(){
        arrBarang[0] = new Barang("Laptop", 1 ,7000000);
        arrBarang[1] = new Barang("Printer", Barang.ELEKTRONIK ,2500000);
        arrBarang[2] = new Barang("Monitor", Barang.ELEKTRONIK ,1500000);
        arrBarang[3] = new Barang("Scanner", Barang.ELEKTRONIK ,2700000);
        arrBarang[4] = new Barang("Meja", Barang.NON_ELEKTRONIK ,300000);
        arrBarang[5] = new Barang("Kursi", Barang.NON_ELEKTRONIK ,400000);
        arrBarang[6] = new Barang("Lemari", Barang.ELEKTRONIK ,4000000);
        arrBarang[7] = new Barang("Handpone", Barang.ELEKTRONIK ,2300000);
        arrBarang[8] = new Barang("SoftCase", Barang.NON_ELEKTRONIK ,50000);
        arrBarang[9] = new Barang("Mouse", Barang.ELEKTRONIK ,70000);
    }
}
