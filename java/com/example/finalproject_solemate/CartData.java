package com.example.finalproject_solemate;

import java.util.ArrayList;

public class CartData {

    private static CartData instance;
    private ArrayList<Products> productsArrayList;
    double total;

    //constructor
    CartData(){
        productsArrayList = new ArrayList<>();
    }

    public static CartData getInstance() {
        if (instance == null) {
            instance = new CartData();
        }
        return instance;
    }

    public void addItem(Products product) {
        productsArrayList.add(product);
    }

    public void removeItem(Products product) {
        productsArrayList.remove(product);
    }

    public ArrayList<Products> getproductsArrayList() {
        return productsArrayList;
    }

    public double totalPrice(){
        total = 0;
        for (Products p: productsArrayList
             ) {

            total+=p.getTotalPrice();


        }
        return total;
    }

    public int getItemCount() {
        return productsArrayList.size();
    }

    public void clear() {
        productsArrayList.clear();
    }
}
