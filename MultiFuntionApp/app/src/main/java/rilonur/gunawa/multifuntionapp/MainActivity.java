package rilonur.gunawa.multifuntionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String OHYA = "rilonur.gunawa.multifuntionapp.Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMessage(View view){
        // contoh penggunaan explicit intent
        Intent intent = new Intent(this, ShowMessage.class);
        TextView txtMessage = (TextView) findViewById(R.id.txt_message);
        intent.putExtra(OHYA, txtMessage.getText().toString());
        startActivity(intent);
    }
    public void openBrowser(View view){
        // membuka activity yang akan mengeksekusi implicit intent
        Intent intent = new Intent(this, IntentExecutor.class);
        intent.putExtra(OHYA, "browse");
        startActivity(intent);
    }
    public void openPhone(View view){
        // membuka activity yang akan mengeksekusi implicit intent
        Intent intent = new Intent(this, IntentExecutor.class);
        intent.putExtra(OHYA, "phone");
        startActivity(intent);
    }
    public void openMap(View view){
        // membuka activity yang akan mengeksekusi implicit intent
        Intent intent = new Intent(this, IntentExecutor.class);
        intent.putExtra(OHYA, "map");
        startActivity(intent);
    }
}
