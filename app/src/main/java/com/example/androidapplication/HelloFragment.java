package com.example.androidapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.androidapplication.databinding.FragmentHelloBinding;

public class HelloFragment extends Fragment {
    FragmentHelloBinding binding;
    public HelloFragment(){
        super(R.layout.fragment_hello);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHelloBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonHelloFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("navigation", "Navigation text 1");
                Navigation.findNavController(view).navigate(R.id.action_helloFragment_to_listViewFragment, bundle);
            }
        });

        binding.buttonHelloFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("navigation", binding.editTextTextPersonName4.getText().toString());
                Navigation.findNavController(view).navigate(R.id.action_helloFragment_to_recyclerViewFragment, bundle);
            }
        });
    }
}