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
    TextView get_name_text;
    public static final String KEY_NAME = "NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        get_name_text = (TextView) findViewById(R.id.get_name_text);

//        Bundle arguments = getIntent().getExtras();
//        String name = arguments.get("name").toString();
//        get_name_text.setText(name);

        Intent intent = new Intent();
        intent.putExtra("name", get_name_text.getText().toString());
        setResult(RESULT_OK, intent);
        finish();




















//        TextView textView4 = (TextView) findViewById(R.id.textView4);
//
//        Bundle arguments = getIntent().getExtras();
//        String name = arguments.get("name").toString();
//        textView4.setText("Добро пожаловать, " + name);
//
//        TextView textView5 = (TextView) findViewById(R.id.textView5);
//        textView5.setText("Хотите поменять имя?");
//
//        Button button5 = (Button) findViewById(R.id.button5);
//        button5.setText("Назад");
//        View.OnClickListener listener = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.putExtra("back", name);
//                setResult(Activity.RESULT_OK, intent);
//                finish();
//            }
//        };
//        button5.setOnClickListener(listener);
    }
}