package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    private int count = 0;
    private boolean bolly = true;
    private boolean flag_plus = false;
    ImageView RED;
    ImageView GREEN;
    ImageView YELLOW;
    Button next_btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ImageView human = findViewById(R.id.human);
        next_btn1 = findViewById(R.id.next_btn2);
        RED = findViewById(R.id.imageView);
        YELLOW = findViewById(R.id.imageView3);
        GREEN = findViewById(R.id.imageView2);
        ImageView[] arr = {RED, YELLOW, GREEN};
        int[] arr2 = {R.drawable.red_sircle, R.drawable.yell_sircle, R.drawable.gre_sircle};
        Thread potok = new Thread(()->{
            while (true) {
                if (count == 2) {
                    System.out.print(String.valueOf(bolly) + "\n");
                    if (bolly) {
                        registerForContextMenu(human);
                        Animation anim = AnimationUtils.loadAnimation(this, R.anim.svetophor);
                        human.startAnimation(anim);
                    } else {
                        registerForContextMenu(human);
                        Animation anim = AnimationUtils.loadAnimation(this, R.anim.svet_left);
                        human.startAnimation(anim);
                    }
                    flag_plus = false;
                } else if (count == 0) flag_plus = true;
                arr[count].setImageResource(arr2[count]);
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count == 2) {
                    for(int i = 0; i < 4; i++) {
                        arr[count].setImageResource(R.drawable.black_sircle);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        arr[count].setImageResource(arr2[count]);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count == 2) {
                    if (bolly) {
                        human.setRotationY(180);
                        bolly = false;
                    }
                    else {
                        human.setRotationY(0);
                        bolly = true;
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                arr[count].setImageResource(R.drawable.black_sircle);
                if (flag_plus)
                    count++;
                else count--;
            }
        });
        potok.start();
        next_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}