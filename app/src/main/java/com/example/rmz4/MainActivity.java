package com.example.rmz4;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    Button pulseButton;
    Button rotationButton;
    Button leftRightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.testView);
        pulseButton = findViewById(R.id.pulseButton);
        rotationButton = findViewById(R.id.rotationButton);
        leftRightButton = findViewById(R.id.leftRightButton);

        pulseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation pulse = AnimationUtils.loadAnimation(MainActivity.this, R.anim.pulse);
                frameLayout.startAnimation(pulse);
            }
        });

        rotationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation pulse = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotation);
                frameLayout.startAnimation(pulse);
            }
        });

        leftRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation pulse = AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_right);
                frameLayout.startAnimation(pulse);
            }
        });

    }
}
