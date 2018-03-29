package it.lamaantiruggine.dofm_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String PASSWORD = "pastafizia";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText password = (EditText)findViewById(R.id.password);
        Button login_button = (Button)findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (checker(password.getText().toString(),PASSWORD)) {
                    Intent go_to_main_activity = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(go_to_main_activity);
                } else {
                    Toast.makeText(getApplicationContext(),"Password errata.", Toast.LENGTH_SHORT).show();
                    password.setText("");
                }
            }
        });
    }

    public boolean checker (String written, String password) {
        if (written.toLowerCase().equals(password.toLowerCase())) {
            return true;
        } else return false;
    }
}

