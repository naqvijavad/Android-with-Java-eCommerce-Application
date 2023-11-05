package com.example.finalproject_solemate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class ProductActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Products> products;

    Button tocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        setTitle("Products");
        recyclerView = findViewById(R.id.rvProducts);

        products = new ArrayList<>();

        tocart = (Button) findViewById(R.id.btnProductoCart);

        tocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductActivity.this,Cart.class));
            }
        });


        Products products1 = new Products();
        products1.setId(1);
        products1.setQuantity(1);
        products1.setBrand("Nike");
        products1.setName("Jordan 1");
        products1.setDescription("The Nike Jordan 1 is a classic basketball shoe that features a high-top design, Air cushioning, and the iconic Jumpman logo. It's a favorite among sneaker enthusiasts and athletes alike.");
        products1.setPrice(350);
        products1.setImageId(R.drawable.jordan1);

        Products products2 = new Products();
        products2.setQuantity(1);
        products2.setId(2);
        products2.setBrand("Nike");
        products2.setName("Jordan 2");
        products2.setDescription("The Nike Jordan 2 is a luxury basketball shoe that features a sleek design inspired by Italian sports cars, with premium materials and full-length Air cushioning for comfort.");
        products2.setPrice(400);
        products2.setImageId(R.drawable.jordan2);

        Products products3 = new Products();
        products3.setQuantity(1);
        products3.setId(3);
        products3.setBrand("Nike");
        products3.setName("Jordan3");
        products3.setDescription("The Nike Jordan 3 is a legendary basketball shoe designed by Tinker Hatfield that introduced the iconic elephant print and visible Air cushioning, and was worn by Michael Jordan during his 1988 NBA Slam Dunk Contest victory.");
        products3.setPrice(450);
        products3.setImageId(R.drawable.jordan3);

        Products products4 = new Products();
        products4.setQuantity(1);
        products4.setId(4);
        products4.setBrand("Nike");
        products4.setName("Jordan 4");
        products4.setDescription("The Nike Jordan 4 is a classic basketball shoe that features a unique wings design on the side and a visible Air cushioning unit. It was worn by Michael Jordan during the 1989 NBA playoffs.");
        products4.setPrice(500);
        products4.setImageId(R.drawable.jordan4);

        Products products5 = new Products();
        products5.setQuantity(1);
        products5.setId(5);
        products5.setBrand("Nike");
        products5.setName("Jordan 5");
        products5.setDescription("The Nike Jordan 5 is a popular basketball shoe that features a distinctive shark teeth design on the midsole and a reflective tongue inspired by World War II fighter planes. It was worn by Michael Jordan during the 1990-1991 NBA season.");
        products5.setPrice(550);
        products5.setImageId(R.drawable.jordan5);

        Products products6 = new Products();
        products6.setQuantity(1);
        products6.setId(6);
        products6.setBrand("Nike");
        products6.setName("Zoom X");
        products6.setDescription("Nike Zoom X is a responsive foam cushioning technology designed for running shoes, providing high energy return and lightweight comfort. It's used in Nike's fastest and most efficient running shoes, like the Nike ZoomX Vaporfly Next%");
        products6.setPrice(600);
        products6.setImageId(R.drawable.nikezoom);

        Products products7 = new Products();
        products7.setQuantity(1);
        products7.setId(7);
        products7.setBrand("Nike");
        products7.setName("Zoom Pegasus");
        products7.setDescription("The Nike Zoom Pegasus is a popular running shoe that features Zoom Air cushioning for a responsive and comfortable ride, and a breathable mesh upper for ventilation.");
        products7.setPrice(650);
        products7.setImageId(R.drawable.nikezoom2);

        Products products8 = new Products();
        products8.setQuantity(1);
        products8.setId(8);
        products8.setBrand("Nike");
        products8.setName("Air Mag");
        products8.setDescription("The Nike Air Mag is a futuristic high-top sneaker inspired by the iconic self-lacing shoes worn by Marty McFly in the movie Back to the Future II. It features LED lights and a rechargeable battery, and was released in limited quantities in 2011.");
        products8.setPrice(700);
        products8.setImageId(R.drawable.nikeautolace);

        products.add(products1);
        products.add(products2);
        products.add(products3);
        products.add(products4);
        products.add(products5);
        products.add(products6);
        products.add(products7);
        products.add(products8);


        ProductAdapter productAdapter = new ProductAdapter(this,products);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productAdapter);





    }
}