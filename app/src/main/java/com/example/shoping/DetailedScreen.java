package com.example.shoping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedScreen extends AppCompatActivity {

    ImageView ima;
    TextView text,prices;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_screen);

        ima = findViewById(R.id.image);
        text = findViewById(R.id.text);
        but = findViewById(R.id.buy);
        prices = findViewById(R.id.price);

        Intent i = this.getIntent();

        if (i != null){
            String name = i.getStringExtra("name");
            String price = i.getStringExtra("price");
            int image = i.getIntExtra("image",R.drawable.no);

            ima.setImageResource(image);
            text.setText(name);
            prices.setText(price);

            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(DetailedScreen.this,Carting.class);
                    startActivity(intent);
                }
            });
        }

    }
}