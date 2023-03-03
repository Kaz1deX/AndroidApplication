package com.example.androidapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment hello_fragment, confirm_fragment;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello_fragment = new HelloFragment();
        confirm_fragment = new ConfirmFragment();

        if (savedInstanceState == null){
            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setReorderingAllowed(true).add(R.id.fragment_container_view, HelloFragment.class, null).commit();
        }
    }

    public void changeFragment(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.button_back:
                if (hello_fragment.isVisible())
                    return;
                fragmentTransaction.replace(R.id.fragment_container_view, hello_fragment);
                break;
            case R.id.button_hello_fragment:
                if (confirm_fragment.isVisible())
                    return;
                fragmentTransaction.replace(R.id.fragment_container_view, confirm_fragment);
                break;
        }

        fragmentTransaction.commit();
    }
}