package com.example.finalproject_solemate;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Products> productsArrayList;
    private Context context;
    Button btn;

    public CartAdapter(ArrayList<Products> productsArrayList, Context context, Button btn) {
        this.productsArrayList = productsArrayList;
        this.context = context;
        this.btn = btn;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cartlayout,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Products products = productsArrayList.get(position);
        holder.cartTotalPrice.setText("Total Price : $" + Double.toString(products.getTotalPrice()));
        holder.cartName.setText(products.getName());
        holder.quantity.setText("QTY : "+Integer.toString(products.getQuantity()));
        holder.cartProductImage.setImageResource(products.getImageId());
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productsArrayList.remove(products);
                CartData.getInstance().totalPrice();

                notifyDataSetChanged();
                btn.setText("Checkout $"+CartData.getInstance().totalPrice());



            }
        });

    }



   /* private void refreshActivity() {
       *//* if (context instanceof Cart ) {
            Cart activity = (Cart) context;

            activity.recreate();

        }*//*

        if (context instanceof Cart ) {
            Cart activity = (Cart) context;

            Intent intent = new Intent(context, Cart.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
            activity.finish();

        }

        ;
    }
    private void deleteActivity() {
        if (context instanceof Cart ) {
            Cart activity = (Cart) context;

            activity.finish();

        }
    }*/

    @Override
    public int getItemCount() {
        return productsArrayList.size();
    }
}
