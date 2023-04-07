package com.example.androidapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidapplication.R;
import com.example.androidapplication.databinding.FragmentHelloBinding;
import com.example.androidapplication.databinding.FragmentNameBinding;

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

        binding.buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", binding.editTextTextPersonName4.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_nameFragment_to_statisticFragment, bundle);
            }
        });

        binding.buttonName2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", binding.editTextTextPersonName4.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_nameFragment_to_recyclerViewFragment2, bundle);
            }
        });
    }
}