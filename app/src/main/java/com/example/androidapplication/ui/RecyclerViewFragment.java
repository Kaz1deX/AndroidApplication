package com.example.androidapplication.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidapplication.MyCustomRecyclerViewAdapter;
import com.example.androidapplication.R;
import com.example.androidapplication.databinding.FragmentRecyclerViewBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewFragment extends Fragment {
    FragmentRecyclerViewBinding binding;

    public RecyclerViewFragment(){
        super(R.layout.fragment_recycler_view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> themes_array = new ArrayList<String>();
        for (int i = 0; i < 200; i++){
            themes_array.add("Вопрос " + (i+1));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setLayoutManager(layoutManager);

        MyCustomRecyclerViewAdapter recyclerViewAdapter = new MyCustomRecyclerViewAdapter(getActivity(), themes_array);
        binding.recyclerView.setAdapter(recyclerViewAdapter);

        String arguments = getArguments().getString("navigation");
        binding.navigationText.setText(arguments);
    }
}