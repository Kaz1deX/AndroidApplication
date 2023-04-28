package com.example.androidapplication.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Environment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androidapplication.R;
import com.example.androidapplication.data.models.QuestionModel;
import com.example.androidapplication.data.repositories.QuestionRepository;
import com.example.androidapplication.data.sources.QuestionDataSource;
import com.example.androidapplication.databinding.FragmentHelloBinding;
import com.example.androidapplication.databinding.FragmentNameBinding;
import com.example.androidapplication.ui.viewmodels.NameViewModel;
import com.example.androidapplication.ui.viewmodels.QuestionViewModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class NameFragment extends Fragment {
    FragmentNameBinding binding;
    private QuestionViewModel questionViewModel;
    private NameViewModel nameViewModel;

    public NameFragment(){
        super(R.layout.fragment_name);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        nameViewModel = new ViewModelProvider(this).get(NameViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNameBinding.inflate(inflater, container, false);

        Bundle args = getArguments();
        if (args != null && args.containsKey("RESULT_OK_NAME") && args.containsKey("RESULT_OK_COMPLEXITY")) {
            QuestionModel question = new QuestionModel(args.getString("RESULT_OK_NAME"), args.getString("RESULT_OK_COMPLEXITY"));
            questionViewModel.insert(question);
        }

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.editTextTextPersonName4.setText(nameViewModel.getUserName("user_name"));

        binding.buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", binding.editTextTextPersonName4.getText().toString());

                String user_name = binding.editTextTextPersonName4.getText().toString();

                // app-specific storage
                nameViewModel.addNameAppSpecific(user_name);

                // external storage
                nameViewModel.addNameExternalStorage(user_name);

                // sharedPreferences
                nameViewModel.addNameSharedPreferences(user_name);

                Navigation.findNavController(view).navigate(R.id.action_nameFragment_to_questionFragment, bundle);
            }
        });

        binding.buttonName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nameFragment_to_recyclerViewFragment2);
            }
        });
    }
}