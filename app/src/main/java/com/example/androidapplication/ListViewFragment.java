package com.example.androidapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidapplication.databinding.FragmentListViewBinding;

import java.util.ArrayList;
import java.util.List;

public class ListViewFragment extends Fragment {
    FragmentListViewBinding binding;

    public ListViewFragment(){
        super(R.layout.fragment_list_view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> questions_array = new ArrayList<String>();
        for (int i = 0; i < 800; i++){
            questions_array.add("Вопрос " + (i+1));
        }

        MyCustomListViewAdapter listViewAdapter = new MyCustomListViewAdapter(getActivity(), R.layout.question_item, questions_array);
        binding.listView.setAdapter(listViewAdapter);
    }
}