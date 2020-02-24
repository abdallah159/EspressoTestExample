package com.abdallah.esseprsoteasting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Abdallah on 24/02/2020.
 */
public class MainActivity extends AppCompatActivity {
    TextView statusTV;
    EditText emailET, passwordET;
    Button loginBTN;
    ProgressBar loadingPB;

    String email = "user@code95.info";
    String password = "123456";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBTN = findViewById(R.id.loginBTN);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passwordET);
        loadingPB = findViewById(R.id.loadingPB);
        statusTV = findViewById(R.id.statusTV);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingPB.setVisibility(View.VISIBLE);
                if (emailET.getText() == null || passwordET.getText() == null) {
                    Toast.makeText(MainActivity.this, getString(R.string.enter_valid_data), Toast.LENGTH_SHORT).show();
                    statusTV.setVisibility(View.GONE);
                    loadingPB.setVisibility(View.GONE);
                } else {
                    checkLoginCredentials();
                }
            }
        });
    }

    public void checkLoginCredentials() {
        if (emailET.getText().toString().equals(email) && passwordET.getText().toString().equals(password)) {
            statusTV.setText(getString(R.string.correct));
            statusTV.setBackground(ContextCompat.getDrawable(this, R.drawable.correct_round));
            statusTV.setVisibility(View.VISIBLE);
        } else {
            statusTV.setText(getString(R.string.error));
            statusTV.setBackground(ContextCompat.getDrawable(this, R.drawable.error_round));
            statusTV.setVisibility(View.VISIBLE);
        }
        loadingPB.setVisibility(View.GONE);
    }
}
