package com.example.androidapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class HelloFragment extends Fragment {
    FragmentManager fragmentManager;
    public HelloFragment(){
        super(R.layout.fragment_hello);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button_hello_fragment = (Button) view.findViewById(R.id.button_hello_fragment);
        button_hello_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}