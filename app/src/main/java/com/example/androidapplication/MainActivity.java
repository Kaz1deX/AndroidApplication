package com.example.androidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyButton";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(R.string.enter_name);

        TextView editTextTextPersonName2 = (TextView) findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName2.setHint("Имя");

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("Далее");

        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.greenhowl);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MyButton", "Кнопка была нажата программно");
            }
        };
        button2.setOnClickListener(listener);

        // Использование ViewBinding
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView2.setText(R.string.enter_name);
        binding.editTextTextPersonName2.setHint("Имя");
        binding.button2.setText("Далее");
        binding.imageView2.setImageResource(R.drawable.greenhowl);

        binding.button2.setOnClickListener(listener);
    }

    public void clickMyButton(View view){
        Log.i("MyButton", "Кнопка была нажата декларативно");
    }
}