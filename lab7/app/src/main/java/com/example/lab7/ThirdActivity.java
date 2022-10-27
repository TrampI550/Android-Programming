package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import kotlin.jvm.internal.Ref;

public class ThirdActivity extends AppCompatActivity {
    String time;
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
        idTimer = findViewById(R.id.idTimer);
        start_btn = findViewById(R.id.start_btn);
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
    }
}