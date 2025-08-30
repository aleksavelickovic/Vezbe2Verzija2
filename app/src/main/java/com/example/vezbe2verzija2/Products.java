package com.example.vezbe2verzija2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vezbe2verzija2.data.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Products extends BaseActivity {

    private boolean isFiltered = false;
    private List<Product> allProducts = new ArrayList<>();
    private List<Product> displayedProducts = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_products);
        setTitle("Proizvodi");

        ListView productsListView = findViewById(R.id.productsListView);

        // popuni originalnu listu
        fillArraylist(allProducts);
        displayedProducts.addAll(allProducts);

        // adapter koji prikazuje ime proizvoda iz displayedProducts
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                getProductNames(displayedProducts)
        );
        productsListView.setAdapter(adapter);

        productsListView.setOnItemClickListener((parent, view, position, id) -> {
            Product proizvod = displayedProducts.get(position);
            Intent intent = new Intent(Products.this, ProductDetails.class);
            intent.putExtra("name", proizvod.getName());
            intent.putExtra("desc", proizvod.getDescription());
            intent.putExtra("price", String.valueOf(proizvod.getPrice()));
            startActivity(intent);
        });

        Button prikazitelefone = findViewById(R.id.telefonibtn);
        prikazitelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayedProducts.clear();
                if (!isFiltered) {
                    // filtriraj samo telefone
                    for (Product p : allProducts) {
                        if (p.getName().equalsIgnoreCase("Telefon")) {
                            displayedProducts.add(p);
                        }
                    }
                } else {
                    // prikaži sve proizvode
                    displayedProducts.addAll(allProducts);
                }
                adapter.clear();
                adapter.addAll(getProductNames(displayedProducts));
                adapter.notifyDataSetChanged();
                isFiltered = !isFiltered;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private List<String> getProductNames(List<Product> products) {
        List<String> names = new ArrayList<>();
        for (Product p : products) {
            names.add(p.getName());
        }
        return names;
    }

    private void fillArraylist(List<Product> products) {
        products.add(new Product("Laptop", "Pametan laptop", 1345));
        products.add(new Product("Telefon", "Brzi telefon", 672));
        products.add(new Product("Tablet", "Gaming tablet", 1482));
        products.add(new Product("Monitor", "Profesionalni monitor", 910));
        products.add(new Product("Headphones", "Bežični headphones", 245));
        products.add(new Product("Printer", "Profesionalni printer", 1120));
        products.add(new Product("Laptop", "Gaming laptop", 1578));
        products.add(new Product("Tablet", "Pametan tablet", 731));
        products.add(new Product("Telefon", "Bežični telefon", 399));
        products.add(new Product("Monitor", "Brzi monitor", 1302));
        products.add(new Product("Headphones", "Gaming headphones", 478));
        products.add(new Product("Printer", "Brzi printer", 1367));
        products.add(new Product("Laptop", "Bežični laptop", 598));
        products.add(new Product("Tablet", "Profesionalni tablet", 1215));
        products.add(new Product("Telefon", "Gaming telefon", 890));
        products.add(new Product("Monitor", "Pametan monitor", 1043));
        products.add(new Product("Headphones", "Brzi headphones", 325));
        products.add(new Product("Printer", "Bežični printer", 757));
        products.add(new Product("Laptop", "Profesionalni laptop", 1420));
        products.add(new Product("Tablet", "Bežični tablet", 682));
        products.add(new Product("Telefon", "Profesionalni telefon", 1125));
        products.add(new Product("Monitor", "Gaming monitor", 1490));
        products.add(new Product("Headphones", "Pametan headphones", 560));
        products.add(new Product("Printer", "Gaming printer", 1310));
        products.add(new Product("Laptop", "Brzi laptop", 1175));
    }
}
