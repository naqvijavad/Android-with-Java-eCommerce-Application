package com.example.finalproject_solemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.dynamic.IFragmentWrapper;

import java.util.ArrayList;

public class detail extends AppCompatActivity {

    TextView brand,name,price,totalprice,description;

    ImageView productImage;

    EditText quantity;

    Button buy,addqty,subqty;


    int productId;
    String productBrand ;
    String productName, productDescription ;
    double productPrice = 0;
    int productImageId ;
    int qty = 1;
    double price2 = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Product Info");


        name = findViewById(R.id.detail_name_text_view);
        brand = findViewById(R.id.detail_brand_text_view);
        price = findViewById(R.id.detail_price_text_view);
        description = findViewById(R.id.tvproductDescr);
        productImage = findViewById(R.id.detail_image_view);
        quantity = findViewById(R.id.etQuantity);
        buy = findViewById(R.id.buy_button);
        addqty = findViewById(R.id.addQty);
        subqty = findViewById(R.id.subQty);



       Products   products = (Products) getIntent().getSerializableExtra("products");

       ArrayList<Products> newP = new ArrayList<>();
       newP.add(products);




       //changing qty to add
        addqty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = Integer.parseInt(quantity.getText().toString());
                qty++;
                quantity.setText(Integer.toString(qty));
                 price2 = qty * productPrice;


            }
        });

        //changing qty to subtract
        subqty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qty = Integer.parseInt(quantity.getText().toString());
                if(qty>=2){
                    qty--;
                    price2 = qty * productPrice;
                    quantity.setText(Integer.toString(qty));

                }
            }
        });

        for (Products abc : newP
             ) {
             productBrand = abc.getBrand();
             productName = abc.getName();
             productPrice = abc.getPrice();
             productImageId = abc.getImageId();
             productDescription = abc.getDescription();
        }

        //setting values to tv
        name.setText(productName);
        brand.setText(productBrand);
        price.setText("$"+Double.toString(productPrice));
        description.setText(productDescription);
        productImage.setImageResource(productImageId);






        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to add data to cart
                CartData.getInstance().addItem(products);

               // Toast.makeText(detail.this, products.getQuantity(), Toast.LENGTH_SHORT).show();

                price2 = qty * productPrice;
                products.setQuantity(qty);
                products.setTotalPrice(price2);


                startActivity(new Intent(detail.this,Cart.class));

                finish();
            }
        });





    }
}