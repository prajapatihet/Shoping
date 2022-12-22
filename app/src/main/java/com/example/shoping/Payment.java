package com.example.shoping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    Button btn;
    EditText name,number,cvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btn = findViewById(R.id.pay);
        name = findViewById(R.id.cardName);
        number = findViewById(R.id.accountNumber);
        cvv = findViewById(R.id.cvvNum);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty() || number.getText().toString().isEmpty() || cvv.getText().toString().isEmpty()){
                    Toast.makeText(Payment.this, "Enter details", Toast.LENGTH_SHORT).show();
                } else if(name.getText().toString().equals("Het") && number.getText().toString().equals("123456789125") && cvv.getText().toString().equals("255")) {
                    startActivity(new Intent(Payment.this,Processing.class));
                    finish();
                } else {
                    Toast.makeText(Payment.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}