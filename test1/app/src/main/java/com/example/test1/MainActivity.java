package com.example.test1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    double result = 0;
    String muden = "";
    private Button tap_btn;
    private TextView counter;
    private TextView muda;
    private MediaPlayer mediaplayer;
    private EditText number1, number2, number3;
    private Button button1, button2, button3, button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = findViewById(R.id.counter);
        muda = findViewById(R.id.muda);
        tap_btn = findViewById(R.id.tap_btn);
        mediaplayer = MediaPlayer.create(this, R.raw.muda_sound);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);


        tap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (muden.length() >= 76*5) {
                    muden = "";
                }
                muden = muden + "muda ";
                muda.setText(muden);
                counter.setText(String.valueOf(++count));
                mediaplayer.start();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result = Double.parseDouble(number1.getText().toString()) + Double.parseDouble(number2.getText().toString());
                    number3.setText(String.valueOf(result));
                }
                catch (Exception e){
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result = Double.parseDouble(number1.getText().toString()) - Double.parseDouble(number2.getText().toString());
                    number3.setText(String.valueOf(result));
                }
                catch (Exception e){
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (Double.parseDouble(number2.getText().toString()) != 0) {
                        result = Double.parseDouble(number1.getText().toString()) / Double.parseDouble(number2.getText().toString());
                        number3.setText(String.valueOf(result));
                    }
                    else {
                        mediaplayer.start();
                    }
                }
                catch (Exception e) {
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    result = Double.parseDouble(number1.getText().toString()) * Double.parseDouble(number2.getText().toString());
                    number3.setText(String.valueOf(result));
                }
                catch (Exception e){
                }
            }
        });
    }
}