package it.lamaantiruggine.dofm_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    // Da non modificare, la splash screen è presente in @drawable/splash_background.jpg

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = getSharedPreferences("UserInfo", 0);
        SharedPreferences.Editor editor = settings.edit();
        String nome_utente = settings.getString("NOME", "");

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        Boolean signed = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("signed", false);



        if (isFirstRun || !signed) {
            //show sign up activity
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).apply();

            startActivity(new Intent(SplashActivity.this, SignUpActivity.class));
            Toast.makeText(SplashActivity.this, "Benvenuto nel DOFM", Toast.LENGTH_LONG).show();

        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            Toast.makeText(SplashActivity.this, "Ciao " + nome_utente + "!", Toast.LENGTH_LONG).show();
            finish();
        }


    }
}
