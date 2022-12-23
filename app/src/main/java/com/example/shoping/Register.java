package com.example.shoping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    LinearLayout login;
    Button buReg;
    TextView uname,email,pwd;
    FirebaseDatabase database;
    private FirebaseAuth auth;
    ProgressDialog progressDialog;

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

        auth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(Register.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We are creating your account....");

        buReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (uname.getText().toString().isEmpty()){
                    uname.setError("Enter your Username");
                    return;
                }
                if (email.getText().toString().isEmpty()){
                    email.setError("Enter your Email");
                    return;
                }
                if (pwd.getText().toString().isEmpty()){
                    pwd.setError("Enter your Password");
                    return;
                }
                progressDialog.show();
                auth.createUserWithEmailAndPassword(email.getText().toString(),pwd.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.dismiss();
                                if (task.isSuccessful()){
                                    Users user = new Users(uname.getText().toString(),email.getText().toString(),pwd.getText().toString());

                                    String id = task.getResult().getUser().getUid();
                                    database.getReference().child("Users").child(id).setValue(user);
                                    Toast.makeText(Register.this, "User create Successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Register.this,LogIn.class));
                                }else{
                                    Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
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
