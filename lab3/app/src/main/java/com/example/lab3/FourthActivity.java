package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        setListenerOnButton();
        staringAni();
    }
    public void staringAni() {
        ImageView moven = findViewById(R.id.moven);
        registerForContextMenu(moven);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rect_anim);
        moven.startAnimation(anim);
    }
    public void setListenerOnButton() {
        Button next_btn7 = findViewById(R.id.next_btn7);
        Button next_btn8 = findViewById(R.id.next_btn8);
        Button btn_ani = findViewById(R.id.btn_ani);
        next_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
                startActivity(intent);
            }
        });
        btn_ani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                staringAni();
            }
        });
        next_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}