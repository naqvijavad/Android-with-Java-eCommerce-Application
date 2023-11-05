package com.example.finalproject_solemate;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<MyViewHolder> {



    Context context;
    ArrayList<Products> productsArrayList;

    public ProductAdapter(Context context, ArrayList<Products> productsArrayList) {
        this.context = context;
        this.productsArrayList = productsArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
       return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      Products products =  productsArrayList.get(position);



        holder.brand.setText(products.getBrand());
        holder.name.setText(products.getName());
        holder.price.setText("$"+(int) products.getPrice());
        holder.productImage.setImageResource(products.getImageId());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, detail.class);

                intent.putExtra("products",products);




                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return productsArrayList.size();
    }
}
