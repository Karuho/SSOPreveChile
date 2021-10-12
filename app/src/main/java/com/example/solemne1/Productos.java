package com.example.solemne1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Productos extends AppCompatActivity {

    private Button btnReturn, btnDeleteProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        // Referencias
        btnReturn = findViewById(R.id.btnReturn);
        btnDeleteProduct = findViewById(R.id.btnDeleteProduct);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),UserMenu.class);
                startActivity(intent);
            }
        });

        /*btnDeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),UserMenu.class);
                startActivity(intent);
            }
        });*/
    }
}