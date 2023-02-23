package com.example.androidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView4 = (TextView) findViewById(R.id.textView4);

        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("name").toString();
        textView4.setText("Добро пожаловать, " + name);

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setText("Назад");
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("back", name);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        };
        button5.setOnClickListener(listener);
    }
}