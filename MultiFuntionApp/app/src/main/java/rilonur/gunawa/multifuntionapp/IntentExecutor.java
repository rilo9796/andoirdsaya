package rilonur.gunawa.multifuntionapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentExecutor extends AppCompatActivity {

    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_executor);

        Button btn = (Button) findViewById(R.id.btn_execute);
        Intent intent = getIntent();
        operator = intent.getStringExtra(MainActivity.OHYA);
//        Log.d("executor", "oprator");
        if (operator.equals("browse")){
            btn.setText("Buka Browser");
        } else if(operator.equals("phone")){
            btn.setText("Hubungi No Telepon");
        }else if(operator.equals("map")){
            btn.setText("Buka Map");
        }
    }
    public void execute(View view){
        Intent exeintent = null;
        EditText txtExec = (EditText) findViewById(R.id.text_exec);
        String exec = txtExec.getText().toString();

        if (operator.equals("browse")){
            Uri webpage = Uri.parse("http://"+exec);
            exeintent = new Intent(Intent.ACTION_VIEW,webpage);
        } else if (operator.equals("phone")) {
            Uri number = Uri.parse("tel:"+exec);
            exeintent = new Intent(Intent.ACTION_DIAL,number);
        } else if (operator.equals("map")) {
            Uri gmmIntentUri = Uri.parse("geo:"+exec);
            exeintent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
        }
        startActivity(exeintent);
    }
}
