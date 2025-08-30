package com.example.vezbe2verzija2;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vezbe2verzija2.ui.login.LoginActivity;

public class LoginScreen extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen2);
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.CAMERA},
                100
        );

        Button loginButton = findViewById(R.id.loginbutton);
        Log.d("nullcheck", "loginButton = " + loginButton);

        Button registerbutton = findViewById(R.id.registerbtn);

        TextView usernameEditText = findViewById(R.id.usernameEditText);
        TextView passwordEditText = findViewById(R.id.passwordEditText);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLICK", "KLIKNUTO LOGIN DUGME!");
                Intent intent = new Intent(LoginScreen.this, HomeScreen.class);
                intent.putExtra("email", usernameEditText.getText().toString());
                intent.putExtra("password", passwordEditText.getText().toString());
                startActivity(intent);
            }
        });

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this, RegisterScreen.class);
                startActivity(intent);
            }
        });

        // Keep insets listener only for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
