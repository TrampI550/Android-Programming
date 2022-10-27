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
                if (count%3 == 2) {
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
                }
                arr[count%3].setImageResource(arr2[count%3]);
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count%3 == 2) {
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
                arr[count%3].setImageResource(R.drawable.black_sircle);
                count++;
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