package com.example.androidapplication.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Environment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androidapplication.R;
import com.example.androidapplication.databinding.FragmentHelloBinding;
import com.example.androidapplication.databinding.FragmentNameBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class NameFragment extends Fragment {
    FragmentNameBinding binding;

    public NameFragment(){
        super(R.layout.fragment_name);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNameBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // sharedPreferences
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("student", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        binding.editTextTextPersonName4.setText(sharedPreferences
                .getString("student", "No name"));

        binding.buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", binding.editTextTextPersonName4.getText().toString());

                String student_name = binding.editTextTextPersonName4.getText().toString();
                String file_name = "studentName.txt";

                // app-specific storage
                createFileAppSpecificStorage(file_name, student_name);

                // external storage
                createFileExternalStorage(file_name, student_name);

                editor.putString("student", binding.editTextTextPersonName4
                        .getText().toString());
                editor.apply();

                Navigation.findNavController(view).navigate(R.id.action_nameFragment_to_statisticFragment, bundle);
            }
        });

        binding.buttonName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nameFragment_to_recyclerViewFragment2);
            }
        });
    }

    void createFileAppSpecificStorage(String file_name, String student_name){
        Context context = getContext();
        File directory = context.getFilesDir();
        File file = new File(directory, file_name);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(student_name);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void createFileExternalStorage(String file_name, String student_name){
        Context context = getContext();
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            File file2 = new File(Environment.getExternalStorageDirectory(), file_name);
            try {
                FileWriter writer = new FileWriter(file2);
                writer.write(student_name);
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            ActivityCompat.requestPermissions(getActivity(), new String[]
                    {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }
}