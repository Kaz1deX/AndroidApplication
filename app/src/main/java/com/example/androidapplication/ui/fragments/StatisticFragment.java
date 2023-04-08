package com.example.androidapplication.ui.fragments;

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
import com.example.androidapplication.databinding.FragmentStatisticBinding;

public class StatisticFragment extends Fragment {
    FragmentStatisticBinding binding;

    public StatisticFragment(){
        super(R.layout.fragment_name);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentStatisticBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String arguments = getArguments().getString("name");
        binding.statistic.setText(arguments + ", ваша статистика решённых вопросов:");
    }
}