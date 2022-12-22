package com.example.shoping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Books extends AppCompatActivity {

    ListView listView;
    Integer[] img = {R.drawable.al,R.drawable.guli,R.drawable.wingsoffire,R.drawable.sh,R.drawable.ei,R.drawable.ga};
    String[] nm = {"The Alchemist","Gulliver's Travels","Wings of Fire","Adventures of Sherlock Holmes","Albert Einstein:The Genius Who Failed School","MK Gandhi:The Story of My Experiments with Truth"};
    String[] pri = {"$50","$20","$15","$10","$30","$25"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        listView = findViewById(R.id.list);

        MyListAdapter myListAdapter = new MyListAdapter(this,nm,img,pri);
        listView.setAdapter(myListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(Books.this, DetailedScreen.class);

                intent.putExtra("image",img[i]);
                intent.putExtra("name",nm[i]);
                intent.putExtra("price",pri[i]);

                startActivity(intent);

            }
        });
    }
}