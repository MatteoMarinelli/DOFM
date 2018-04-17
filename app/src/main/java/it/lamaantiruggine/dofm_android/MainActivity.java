package it.lamaantiruggine.dofm_android;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aggiorna_button = (Button) findViewById(R.id.aggiorna_button);
        Button whatsapp_group_button = (Button) findViewById(R.id.whatsapp_group_button);
        Button whatsapp_matteo_button = (Button) findViewById(R.id.whatsapp_matteo_button);
        Button sito_button = (Button) findViewById(R.id.site_button);

        aggiorna_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Ti si aprirà una pagina nella quale potrai scaricare la nuova versione", Toast.LENGTH_LONG).show();
                Uri uri = Uri.parse("https://dofm.altervista.org/applicazione/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        whatsapp_group_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://chat.whatsapp.com/BnDTEfFrnshGnYxUDNiskC"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        sito_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.dofm.altervista.org"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        whatsapp_matteo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Scrivimi se ci sei e in che uscita", Toast.LENGTH_LONG).show();
                Uri uri = Uri.parse("https://api.whatsapp.com/send?phone=393392543470"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
