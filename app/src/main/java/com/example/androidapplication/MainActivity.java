package com.example.androidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("Введите свое имя");

        TextView editTextTextPersonName2 = (TextView) findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName2.setHint("Имя");

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("Далее");

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.greenhowl);
    }
}