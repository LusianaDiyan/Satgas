package com.example.satgas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton watering, moisturing, datSen, gatecon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        watering = findViewById(R.id.watering);
        watering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, waterMonitoring.class);
                startActivity(intent);
            }
        });

        moisturing = findViewById(R.id.moisturing);
        moisturing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, soilMonitoring.class);
                startActivity(intent);
            }
        });

        datSen = findViewById(R.id.datesen);
        datSen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });

        gatecon = findViewById(R.id.gatecon);
        gatecon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, controlView.class);
                startActivity(intent);
            }
        });
    }
}
