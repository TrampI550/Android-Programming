package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button next_btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView);
        next_btn1 = findViewById(R.id.next_btn1);
        TouchListener();
    }
    @SuppressLint("ClickableViewAccessibility")
    public void TouchListener() {
        next_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        txt.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({"ResourceType"})
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tap_dawn(v);
                    txt.setTextColor(Color.parseColor(getString(R.color.blue_1)));
                } else if (event.getAction() == MotionEvent.ACTION_UP){
                    tap_up(v);
                    txt.setTextColor(Color.parseColor(getString(R.color.blue_2)));
                }
                return false;
            }
        });
    }
    public void tap_dawn(View view) {
        registerForContextMenu(txt);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rot_dawn);
        txt.startAnimation(anim);
    }
    public void tap_up(View view) {
        registerForContextMenu(txt);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rot_up);
        txt.startAnimation(anim);
    }
    public void tapList(View view) {
    }
}