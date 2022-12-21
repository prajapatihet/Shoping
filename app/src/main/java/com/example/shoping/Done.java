package com.example.shoping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

public class Done extends AppCompatActivity {

    private static final int SPLASH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_done);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Done.this, Books.class);
            startActivity(intent);
            finish();
        },SPLASH);
        Toast.makeText(Done.this,"Successfully done",Toast.LENGTH_LONG).show();
    }
}