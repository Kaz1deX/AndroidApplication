package com.example.androidapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Fragment hello_fragment, confirm_fragment;
    FragmentManager fragmentManager;
    EditText test_name_text;
    TextView result_text;
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK){
                Intent intent = result.getData();
                String name = intent.getStringExtra("name");
                result_text.setText(name);
            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test_name_text = (EditText) findViewById(R.id.test_name_text);
        result_text = (TextView) findViewById((R.id.result_text));

//        hello_fragment = new HelloFragment();
//        confirm_fragment = new ConfirmFragment();
//
//        if (savedInstanceState == null){
//            fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().setReorderingAllowed(true)
//                    .add(R.id.fragment_container_view, HelloFragment
//                            .class, null).commit();
//        }
    }

    public void clickMyButton(View view){
        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra("name", test_name_text.getText().toString());
//        startActivity(intent);




        mStartForResult.launch(intent);
    }


//    public void changeFragment(View view) {
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        switch (view.getId()) {
//            case R.id.button_back:
//                if (hello_fragment.isVisible())
//                    return;
//                fragmentTransaction.replace(R.id.fragment_container_view, hello_fragment);
//                break;
//            case R.id.button_hello_fragment:
//                if (confirm_fragment.isVisible())
//                    return;
//                fragmentTransaction.replace(R.id.fragment_container_view, confirm_fragment);
//                break;
//        }
//
//        fragmentTransaction.commit();
//    }
}