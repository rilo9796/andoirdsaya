package rilonur.gunawa.multifuntionapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SendEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
    }
        public void sendemail(View view){
            EditText txtPenerima = (EditText) findViewById(R.id.penerima);
            EditText txtJudul = (EditText) findViewById(R.id.judul);
            EditText txtIsi = (EditText) findViewById(R.id.isipesan);

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

            emailIntent.setData(Uri.parse("mailto:"+txtPenerima.getText().toString()));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, "rilo9796@gmail.com");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, txtJudul.getText().toString());
            emailIntent.putExtra(Intent.EXTRA_TEXT, txtIsi.getText().toString());

            try{
                startActivity(Intent.createChooser(emailIntent, "Send Email...."));
                finish();
            }catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(SendEmail.this,
                        "There is no email client installed", Toast.LENGTH_SHORT).show();
            }

            startActivity(emailIntent);
        }
}
