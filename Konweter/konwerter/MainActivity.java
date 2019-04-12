package com.example.mich.konwerter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonMasa, buttonSignal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonMasa = (Button) findViewById(R.id.button1);
        buttonMasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KonwerterMasa.class);
                startActivity(intent);
            }
        });

        buttonSignal = (Button) findViewById(R.id.button2);
        buttonSignal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KonwerterSignal.class);
                startActivity(intent);
            }
        });

    }
}
