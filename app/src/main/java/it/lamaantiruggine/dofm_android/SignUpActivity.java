package it.lamaantiruggine.dofm_android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button verify_button = (Button) findViewById(R.id.button);
        final EditText password = (EditText) findViewById(R.id.editText);
        final EditText nome = (EditText) findViewById(R.id.editText2);

        final SharedPreferences settings = getSharedPreferences("UserInfo", 0);
        final SharedPreferences.Editor editor = settings.edit();

        verify_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (password.getText().toString()) {
                    case "pastafizia":
                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                        // Lo segna loggato in modo tale che la prossima volta non debba riloggarsi
                        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("signed", true).apply();
                        editor.putString("NOME",nome.getText().toString()).apply();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Password errata.", Toast.LENGTH_LONG).show();
                        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("signed", false).apply();
                }
            }
        });
    }
}
