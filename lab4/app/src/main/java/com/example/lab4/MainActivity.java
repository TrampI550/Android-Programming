package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        touchListener();
        //dateConsoler();
    }
    public void touchListener() {
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button next_btn1 = findViewById(R.id.next_btn1);
        TextView txt = findViewById(R.id.textView);
        Button counter= findViewById(R.id.btn3);
        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    txt.setText("Clicked");
                    btn1.setBackground(getDrawable(R.drawable.sec_fig));
                } else if (event.getAction() == MotionEvent.ACTION_UP){
                    txt.setText("Unclicked");
                    btn1.setBackground(getDrawable(R.drawable.ourfig));
                } else if (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS){
                    Toast.makeText(getApplicationContext(),
                            "Relax, kid",
                            Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            boolean boolinka = true;
            @Override
            public void onClick(View view) {
                if (boolinka) {
                    btn2.setBackground(getDrawable(R.drawable.sec_fig));
                    boolinka = false;
                }
                else {
                    btn2.setBackground(getDrawable(R.drawable.ourfig));
                    boolinka = true;
                }
            }
        });
        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setText(String.valueOf(++count));
            }
        });
        next_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}