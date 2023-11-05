package com.example.finalproject_solemate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerView;
    double total = 0;
    ArrayList<Products> products;
    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.rvCart);
        checkout = (Button) findViewById(R.id.button3);

        CartAdapter cartAdapter = new CartAdapter(CartData.getInstance().getproductsArrayList(), this,checkout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartAdapter);

        recreate();

       /* for (Products p : CartData.getInstance().getproductsArrayList()
             ) {
            total += p.getTotalPrice();

        }*/


        total = CartData.getInstance().totalPrice();



        checkout.setText("Checkout $" +total);


        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(CartData.getInstance().getItemCount()==0){
                    Toast.makeText(Cart.this, "Please add product to your cart", Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivity(new Intent(Cart.this,Checkout.class));

                }
            }
        });
    }
}