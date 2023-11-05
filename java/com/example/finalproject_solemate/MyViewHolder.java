package com.example.finalproject_solemate;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView productImage,cartProductImage;
    TextView name,brand,price,cartName,cartTotalPrice,quantity;
    Button remove;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        //products detail
        productImage = itemView.findViewById(R.id.RvImageView);
        name= itemView.findViewById(R.id.RvTvPName);
        brand = itemView.findViewById(R.id.RvTvBrand);
        price = itemView.findViewById(R.id.RvTvPrice);

        //cart
        cartName = itemView.findViewById(R.id.tvCartName);
        cartTotalPrice = itemView.findViewById(R.id.tvCartTPrice);
        quantity = itemView.findViewById(R.id.tvCartQuantity);
        remove =  itemView.findViewById(R.id.btnCartDelt);
        cartProductImage = itemView.findViewById(R.id.cartProductImage);
    }
}
