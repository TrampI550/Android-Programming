package com.example.lab6;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lab6.R;

import java.util.ArrayList;

public class SquaresList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squares);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList str = new ArrayList<String>();
        str.add("Element");
        str.add("Element");
        ListAdapter customAdapter = new ListAdapter(this, R.layout.list_items, str, 1);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                str.remove(position);
                customAdapter.notifyDataSetChanged();
            }
        });

        Button bAddItem = findViewById(R.id.AddItem);
        bAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str.add("Element");
                customAdapter.notifyDataSetChanged();
            }
        });

        Button bNext = findViewById(R.id.NextPage);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SquaresList.this, ExchangeRate.class);
                startActivity(intent);
            }
        });
    }

    private static class ListAdapter extends ArrayAdapter {

        private int resourceLayout;
        private Context mContext;
        private ArrayList<String> source;
        private int counter;

        public ListAdapter(Context context, int resource, ArrayList<String> str, int _counter) {
            super(context, resource, str);
            this.resourceLayout = resource;
            this.mContext = context;
            this.source = str;
            this.counter = _counter;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;

            if (v == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(mContext);
                v = vi.inflate(resourceLayout, null);
            }

            LinearLayout row = v.findViewById(R.id.Rectangle);
            row.setBackgroundColor(Color.WHITE);
            TextView item = v.findViewById(R.id.Item);
            item.setText(source.get(position) + " " + Integer.toString(position+1));
            return v;
        }
    }
}
