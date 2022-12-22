package com.example.shoping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ElectronicActivity extends AppCompatActivity {
    ListView listView2;
    Integer[] img2 = {R.drawable.realme,R.drawable.mi,R.drawable.lenovo,R.drawable.asus,R.drawable.hp,R.drawable.mac,R.drawable.sum};
    String[] nm2 = {"RealmeBook","MiBook","Lenovo Laptop","Asus Laptop","HP laptop","MacBook","SamsungBook"};
    String[] pri2 = {"$50","$20","$15","$10","$30","$25","$70"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic);

        listView2 = findViewById(R.id.list2);

        MyListAdapter myListAdapter = new MyListAdapter(this,nm2,img2,pri2);
        listView2.setAdapter(myListAdapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(ElectronicActivity.this, DetailedScreen.class);

                intent.putExtra("image",img2[i]);
                intent.putExtra("name",nm2[i]);
                intent.putExtra("price",pri2[i]);

                startActivity(intent);

            }
        });
    }
}