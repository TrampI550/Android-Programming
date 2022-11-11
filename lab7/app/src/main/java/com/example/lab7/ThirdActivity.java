package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ThirdActivity extends AppCompatActivity {
    String time;
    String time_tosend;
    Timer timer;
    Button start_btn;
    private boolean bolly = true;
    int second = 0;
    int minute = 0;
    int hour = 0;
    TextView idTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayList str = new ArrayList<String>();
        ListAdapter customAdapter = new ListAdapter(this, R.layout.list_items, str, 1);
        listView.setAdapter(customAdapter);

        idTimer = findViewById(R.id.idTimer);
        start_btn = findViewById(R.id.start_btn);
        Button add_time = findViewById(R.id.add_time);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time = "";
                if (bolly) {
                    timer = new Timer();
                    timer.schedule((TimerTask) (new TimerTask() {
                        public void run() {
                            runOnUiThread((Runnable) (new Runnable() {
                                public final void run() {
                                    time += (hour < 10) ? "0" + String.valueOf(hour) + ":" : String.valueOf(hour) + ":";
                                    time += (minute < 10) ? "0" + String.valueOf(minute) + ":" : String.valueOf(minute) + ":";
                                    time += (second < 10) ? "0" + String.valueOf(second) : String.valueOf(second);
                                    time_tosend = time;
                                    second++;
                                    hour = (hour + (minute + second / 60) / 60) % 24;
                                    minute = (minute + second / 60) % 60;
                                    second %= 60;
                                    idTimer.setText(time);
                                    time = "";
                                }
                            }));
                        }
                    }), 0L, 1000L);
                    bolly = false;
                } else {
                    timer.cancel();
                    hour = minute = second = 0;
                    bolly = true;
                }
            }
        });
        add_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str.add(time_tosend);
                customAdapter.notifyDataSetChanged();
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
            item.setText(Integer.toString(position+1) + " " + source.get(position));
            return v;
        }
    }
}