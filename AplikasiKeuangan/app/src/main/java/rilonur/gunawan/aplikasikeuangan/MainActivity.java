package rilonur.gunawan.aplikasikeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String strShow = " ";
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    protected void onResume(){
        super.onResume();

        ListView listTransaksi = (ListView) findViewById(R.id.list_transaksi);
        TransaksiHelper dbHelper = new TransaksiHelper(this);
        final List<Transaksi> listTrans = dbHelper.getTransaksi();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listTrans);
        listTransaksi.setAdapter(adapter);

        int saldo = 0;
        for(int i = 0; i < listTrans.size(); i++){
            if(listTrans.get(i).jenis == 1){
                saldo += listTrans.get(i).jumlah;
            }else {
                saldo -= listTrans.get(i).jumlah;
            }
        }

        TextView txtSaldo = (TextView) findViewById(R.id.txt_saldo);
        txtSaldo.setText("Saldo Tersisa :"+Integer.toString(saldo));

        listTransaksi.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Transaksi transaksi = listTrans.get(position);
                Intent intent = new Intent(parent.getContext(),DetailActivity.class);
                intent.putExtra("transaksi.detail", transaksi);
                startActivity(intent);
            }
        });

        // txtShow = (TextView) findViewById(R.id.result);

      //  TransaksiHelper dbHelper = new TransaksiHelper(this);
       // List<Transaksi> listTrans = dbHelper.getTransaksi();

        //for (int i = 0; i < listTrans.size(); i++){
          //  Transaksi trans = listTrans.get(i);
            // strShow += "---------------------------------\n";
           // strShow += trans.nama=" ("+trans.getJenis()+") "+trans.jumlah
             //       +"\n"+trans.keterangan+"\n";
        //}
        // txtShow.setText(strShow);
    }

    public void addTransaksi(View view){
        Intent intent = new Intent(this, Form.class);
        startActivity(intent);
    }
}
