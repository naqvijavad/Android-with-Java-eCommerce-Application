package com.example.finalproject_solemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderSuccess extends AppCompatActivity {

    TextView tvfname;
    Button contShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);
        String fname= getIntent().getStringExtra("fname");
        tvfname =findViewById(R.id.tvGreetings);
        tvfname.setText("Hey, "+fname+"!");


        contShopping=findViewById(R.id.btnContinue);

        contShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderSuccess.this,ProductActivity.class));
            }
        });

    }
}