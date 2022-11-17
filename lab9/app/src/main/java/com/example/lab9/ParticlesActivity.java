package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tutorials.android.particles.ParticlesGenerator;
import com.tutorials.android.particles.ParticlesManager;
import com.tutorials.android.particles.ParticlesSource;
import com.tutorials.android.particles.Utils;
import com.tutorials.android.particles.particles.BitmapParticles;
import com.tutorials.android.particles.particles.Particles;

import java.util.ArrayList;
import java.util.Random;

public class ParticlesActivity extends AppCompatActivity {
    private int Potoki = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particles);

        final ParticlesSource[] particlesSource = {null};
        float length = (float) Math.sqrt(180*180 + 180*180);
        final ParticlesGenerator[] particlesGenerator = {null};

        ViewGroup main = findViewById(R.id.ParticlesOnTouch);
//        ArrayList<Thread> threadPool = new ArrayList();
//        for (int j = 0; j < 10; j++)
//            threadPool.add(new Thread(() -> {
//                for (int i = 0; i < 360; i++) {
//                    new ParticlesManager(ParticlesActivity.this, particlesGenerator[0], particlesSource[0], main)
//                            .setNumInitialCount(1)
//                            .setVelocityX((float) (length * Math.cos(i)))
//                            .setVelocityY((float) (length * Math.sin(i)))
//                            .animate();
//                }
//            }));

        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                Potoki++;
                int x = (int)event.getX();
                int y = (int)event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        final Bitmap allPossibleParticles = Utils.createCircleBitmap(Color.WHITE, 25);
                        particlesGenerator[0] = new ParticlesGenerator() {
                            @Override
                            public Particles generateParticles(Random random) {
                                final Bitmap bitmap = allPossibleParticles;
                                return new BitmapParticles(bitmap);
                            }
                        };
                        final int containerMiddleX = x;
                        final int containerMiddleY = y;
                        particlesSource[0] = new ParticlesSource(containerMiddleX, containerMiddleY);
                        for (int i = 0; i < 360; i++) {
                            new ParticlesManager(ParticlesActivity.this, particlesGenerator[0], particlesSource[0], main)
                                    .setNumInitialCount(1)
                                    .setVelocityX((float) (length * Math.cos(i)))
                                    .setVelocityY((float) (length * Math.sin(i)))
                                    .animate();
                        }
                    }
                    default:{}
                }
                return false;
            }
        });

        Button bNext = findViewById(R.id.NextPage);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParticlesActivity.this, FountainActivity.class);
                startActivity(intent);
            }
        });
    }

}
