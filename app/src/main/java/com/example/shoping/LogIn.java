package com.example.shoping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    LinearLayout btnReg;
    Button btnlog;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        getSupportActionBar().hide();

        btnReg = findViewById(R.id.register);
        btnlog = findViewById(R.id.btnSignIn);
        username = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, Register.class);
                startActivity(intent);
                finish();
            }
        });
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().isEmpty() && password.getText().toString().isEmpty()){
                    Toast.makeText(LogIn.this,"Enter Username and Password",Toast.LENGTH_LONG).show();
                }else if (username.getText().toString().equals("Het") && password.getText().toString().equals("het1234")){
                    Intent intent = new Intent(LogIn.this, Books.class);
                    startActivity(intent);

                    finish();
                }else{
                    Toast.makeText(LogIn.this,"Invalid Username and Password",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}