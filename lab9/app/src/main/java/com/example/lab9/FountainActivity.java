package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tutorials.android.particles.ParticlesGenerator;
import com.tutorials.android.particles.ParticlesManager;
import com.tutorials.android.particles.ParticlesSource;
import com.tutorials.android.particles.Utils;
import com.tutorials.android.particles.particles.BitmapParticles;
import com.tutorials.android.particles.particles.Particles;
import java.util.Random;

public class FountainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fountain);

        ViewGroup main = findViewById(R.id.ParticlesOnTouchFount);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Bitmap allPossibleParticles = Utils.createCircleBitmap(Color.BLUE, 10);
                final ParticlesGenerator particlesGenerator = new ParticlesGenerator() {
                    @Override
                    public Particles generateParticles(Random random) {
                        final Bitmap bitmap = allPossibleParticles;
                        return new BitmapParticles(bitmap);
                    }
                };

                final int containerMiddleX = main.getWidth() / 2;
                final int containerMiddleY = main.getHeight() *3/4;
                final ParticlesSource particlesSource = new ParticlesSource(containerMiddleX, containerMiddleY);

                ParticlesManager particlesManager = new ParticlesManager(FountainActivity.this, particlesGenerator, particlesSource, main)
                        .setEmissionDuration(3000)
                        .setEmissionRate(100)
                        .setVelocityX(0)
                        .setVelocityY(-720)
                        .setAccelerationX(0, 100)
                        .setAccelerationY(400)
                        .setRotationalVelocity(180, 180)
                        .animate();
            }
        });

        Button bNext = findViewById(R.id.NextPage);
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FountainActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });
    }
}