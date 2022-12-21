package com.example.shoping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Books extends AppCompatActivity {

    ListView listView;
    Integer[] img = {R.drawable.alchemist,R.drawable.guli,R.drawable.wingsoffire,R.drawable.sh,R.drawable.ei,R.drawable.ga};
    String[] nm = {"The Alchemist","Gulliver's Travels","Wings of Fire","Adventures of Sherlock Holmes","Albert Einstein:The Genius Who Failed School","MK Gandhi:The Story of My Experiments with Truth"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        listView = findViewById(R.id.list);

        MyListAdapter myListAdapter = new MyListAdapter(this,nm,img);
        listView.setAdapter(myListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(Books.this, DetailedScreen.class);

                intent.putExtra("image",img[i]);
                intent.putExtra("name",nm[i]);

                startActivity(intent);

            }
        });
    }
}