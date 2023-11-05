package com.example.finalproject_solemate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Checkout extends AppCompatActivity {

    EditText etFirstName,etLastName,etEmail,etPhone;
    EditText etAddress,etCardNumber,etExpMonth,etExpYear,etCvv;

    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        setTitle("Checkout");

        etFirstName =  findViewById(R.id.first_name_edit_text);
        etLastName =  findViewById(R.id.last_name_edit_text);
        etEmail =  findViewById(R.id.email_edit_text);
        etPhone =  findViewById(R.id.phone_edit_text);
        etAddress =  findViewById(R.id.address_edit_text);
        etCardNumber =  findViewById(R.id.card_number_edit_text);
        etExpMonth =  findViewById(R.id.expiry_month_edit_text);
        etExpYear =  findViewById(R.id.expiry_year_edit_text);
        etCvv =  findViewById(R.id.cvv_edit_text);
        checkout = findViewById(R.id.checkout_button);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isError = false;

                // Validate first name
                if (TextUtils.isEmpty(etFirstName.getText().toString())) {
                    isError = true;
                }

                // Validate last name
                if (TextUtils.isEmpty(etLastName.getText().toString())) {
                    isError = true;
                }

                // Validate email
                if (TextUtils.isEmpty(etEmail.getText().toString())) {
                    isError = true;
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {
                    isError = true;
                }

                // Validate phone number
                if (TextUtils.isEmpty(etPhone.getText().toString())) {
                    isError = true;
                }

                // Validate address
                if (TextUtils.isEmpty(etAddress.getText().toString())) {
                    isError = true;
                }

                // Validate card number
                if (TextUtils.isEmpty(etCardNumber.getText().toString())) {
                    isError = true;
                }

                // Validate expiry date
                String expiryMonth = etExpMonth.getText().toString();
                String expiryYear = etExpYear.getText().toString();
                if (TextUtils.isEmpty(expiryMonth) || TextUtils.isEmpty(expiryYear)) {
                    isError = true;
                } else if (expiryMonth.length() != 2 || expiryYear.length() != 4) {
                    isError = true;
                }

                // Validate CVV
                if (TextUtils.isEmpty(etCvv.getText().toString())) {
                    isError = true;
                }

                if (!isError) {
                    // Perform checkout
                    CartData.getInstance().clear();
                    Intent intent = new Intent(Checkout.this,OrderSuccess.class);
                    intent.putExtra("fname",etFirstName.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(Checkout.this,"Please Enter all details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}