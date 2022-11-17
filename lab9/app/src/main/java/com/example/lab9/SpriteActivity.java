package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class SpriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sprite);

        Button bNext = findViewById(R.id.NextPage);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SurfaceView smt = findViewById(R.id.Smt);
                //SurfaceView smt2 = findViewById(R.id.Smt2);
                smt.onFinishTemporaryDetach();
//                smt2.onFinishTemporaryDetach();
                Intent intent = new Intent(SpriteActivity.this, ParticlesActivity.class);
                startActivity(intent);
            }
        });
    }
}