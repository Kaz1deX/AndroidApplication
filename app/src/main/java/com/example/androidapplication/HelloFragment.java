package com.example.androidapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.androidapplication.databinding.FragmentHelloBinding;

public class HelloFragment extends Fragment {
    FragmentManager fragmentManager;
    FragmentHelloBinding binding;
    MainActivity mainActivity;

    public HelloFragment(){
        super(R.layout.fragment_hello);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getParentFragmentManager();

        fragmentManager.setFragmentResultListener("change to HubFragment", this, (requestKey, result) -> {
            String results = result.getString("resultText");
            binding.enterName.setText(results + "?");
        });
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

        binding.buttonHelloFragment.setOnClickListener(view1 -> {
            Bundle result = new Bundle();
            result.putString("resultText", binding.editTextTextPersonName4.getText().toString());
            fragmentManager.setFragmentResult("change to RepositoryFragment", result);
            mainActivity.changeFragment(view1);
        });
    }
}