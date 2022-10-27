package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    Button next_btn1 = findViewById(R.id.next_btn1);
    Button prev_btn1 = findViewById(R.id.prev_btn1);
    TextView txt_view = findViewById(R.id.txt_view);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListenerOnButton();
    }
    public void setListenerOnButton() {
        next_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_view.setText("Stack depth is " + String.valueOf(++count));
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        prev_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count != 0) {
                    txt_view.setText("Stack depth is " + String.valueOf(--count));
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
