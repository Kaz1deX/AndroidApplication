package com.example.androidapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.androidapplication.databinding.FragmentConfirmBinding;

public class ConfirmFragment extends Fragment {
    FragmentManager fragmentManager;
    FragmentConfirmBinding binding;
    MainActivity mainActivity;
    public ConfirmFragment(){
        super(R.layout.fragment_confirm);
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

        fragmentManager.setFragmentResultListener("change ConfirmFragment", this, (requestKey, result) -> {
            String results = result.getString("resultText");
            binding.textNameInformation.setText("Ваше имя: " + results);
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentConfirmBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonBack.setOnClickListener(view1 -> {
            Bundle result = new Bundle();
            result.putString("resultText", binding.textNameInformation.getText().toString());
            fragmentManager.setFragmentResult("change HelloFragment", result);
            mainActivity.changeFragment(view1);
        });
    }
}