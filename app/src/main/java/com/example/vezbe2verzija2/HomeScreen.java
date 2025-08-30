package com.example.vezbe2verzija2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vezbe2verzija2.databinding.ActivityHomeScreenBinding;

import org.w3c.dom.Text;

public class HomeScreen extends BaseActivity {

    public ActivityHomeScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityHomeScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("TEST");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView emailtext = findViewById(R.id.emailtext);
        TextView pswtext = findViewById(R.id.pswtext);

        //Toolbar toolbar = binding.tulbar;
        //setSupportActionBar(toolbar);

        emailtext.setText(getIntent().getStringExtra("email"));
        pswtext.setText(getIntent().getStringExtra("password"));

        Button productsbtn = binding.productsbutton;
        productsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, Products.class);
                startActivity(intent);
            }
        });
    }
}