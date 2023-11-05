package com.example.finalproject_solemate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class register extends AppCompatActivity {

    private EditText user_name, email_adr, password, confirm_pwd;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("Registration");

        mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);


        Button register = findViewById(R.id.register_btn);
        Button login = findViewById(R.id.login_btn);
        user_name = findViewById(R.id.full_name);
        email_adr = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm_pwd = findViewById(R.id.confirm_password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this, Login.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_name = user_name.getText().toString().trim();
                String txt_email = email_adr.getText().toString().trim();
                String txt_pwd = password.getText().toString().trim();
                String txt_confirm_pwd =confirm_pwd.getText().toString().trim();

                // Check if any field is empty or contains only whitespace characters
                if (TextUtils.isEmpty(txt_name) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_pwd) || TextUtils.isEmpty(txt_confirm_pwd)) {
                    Toast.makeText(register.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(txt_name.replaceAll("\\s", "")) || TextUtils.isEmpty(txt_email.replaceAll("\\s", "")) || TextUtils.isEmpty(txt_pwd.replaceAll("\\s", "")) || TextUtils.isEmpty(txt_confirm_pwd.replaceAll("\\s", ""))) {
                    Toast.makeText(register.this, "Please enter valid input for all fields.", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(txt_email).matches()) {
                    Toast.makeText(register.this, "Please enter a valid email address.", Toast.LENGTH_SHORT).show();
                } else if (txt_pwd.length() < 8) {
                    Toast.makeText(register.this, "Password must be at least 8 characters long.", Toast.LENGTH_SHORT).show();
                } else if (!txt_pwd.equals(txt_confirm_pwd)) {
                    Toast.makeText(register.this, "Password and confirm password fields do not match.", Toast.LENGTH_SHORT).show();
                } else {
                    // Continue with registration process
                    registerUser(txt_name, txt_email, txt_pwd);
                }
            }
        });

    }

    private void registerUser(String name, String email, String pwd) {
        /* Get a reference to the Firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference usersRef = database.getReference("users");

        // Create a new user object with the given details
        HashMap<String, Object> newUser = new HashMap<>();
        newUser.put("name", name);
        newUser.put("email", email);
        newUser.put("password", pwd);

        // Save the new user object to the "users" node in the database
        String key = usersRef.push().getKey();
        usersRef.child(key).setValue(newUser)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Registration successful, show a toast message
                        Toast.makeText(register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Registration failed, show a toast message with the error
                        Toast.makeText(register.this, "Registration failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });*/
        mAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(register.this, new  OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(register.this,"Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(register.this,Login.class));
                    finish();
                }
                else{
                    Toast.makeText(register.this,"Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}