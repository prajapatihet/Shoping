package com.example.shoping;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class MyListAdapter extends ArrayAdapter<String> {

    private String[] nm;
    private Integer[] img;
    private String[] pri;
    private Activity context;

    public MyListAdapter(Activity context,String[] nm,Integer[] img,String[] pri){

        super(context,R.layout.mylist,nm);

        this.context = context;
        this.nm = nm;
        this.pri = pri;
        this.img = img;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist,null,true);
        TextView t1 = rowView.findViewById(R.id.bookname);
        ImageView i1 = rowView.findViewById(R.id.bookimg);
        TextView t2 = rowView.findViewById(R.id.listPrice);

        t1.setText(nm[position]);
        i1.setImageResource(img[position]);
        t2.setText(pri[position]);

        return rowView;

    }
}
