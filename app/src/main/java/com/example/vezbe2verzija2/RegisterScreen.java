package com.example.vezbe2verzija2;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vezbe2verzija2.databinding.ActivityRegisterScreenBinding;

public class RegisterScreen extends AppCompatActivity {

    public ActivityRegisterScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityRegisterScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Button potvrdibtn = findViewById(R.id.potvrdibutton);
        Button potvrdibtn = binding.potvrdibutton;
        //EditText emailtext = findViewById(R.id.editTextTextEmailAddress);
        EditText emailtext = binding.editTextTextEmailAddress;
        //EditText pswtext = findViewById(R.id.editTextTextPassword);
        EditText pswtext = binding.editTextTextPassword;

        potvrdibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterScreen.this, HomeScreen.class);
                intent.putExtra("email", emailtext.getText().toString());
                intent.putExtra("password", pswtext.getText().toString());
                startActivity(intent);
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}