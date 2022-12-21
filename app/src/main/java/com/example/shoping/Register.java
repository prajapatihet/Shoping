package com.example.shoping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    LinearLayout login;
    Button buReg;
    TextView uname,email,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        login = findViewById(R.id.login);
        buReg = findViewById(R.id.btn_signUp);
        uname = findViewById(R.id.etUserName);
        email = findViewById(R.id.etEmail);
        pwd = findViewById(R.id.etPassword);
        getSupportActionBar().hide();

        buReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (uname.getText().toString().isEmpty()){
                    Toast.makeText(Register.this,"Write your Username name",Toast.LENGTH_LONG).show();
                }else if (email.getText().toString().isEmpty()){
                    Toast.makeText(Register.this,"Write your Email-ID name",Toast.LENGTH_LONG).show();
                }else if (pwd.getText().toString().isEmpty()){
                    Toast.makeText(Register.this,"Write your Password name",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Register.this,"Registered successfully",Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,LogIn.class);
                startActivity(intent);

            }
        });
    }
}
