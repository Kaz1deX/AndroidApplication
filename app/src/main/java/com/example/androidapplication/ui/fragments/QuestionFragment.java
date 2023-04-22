package com.example.androidapplication.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.androidapplication.R;
import com.example.androidapplication.databinding.FragmentQuestionBinding;

public class QuestionFragment extends Fragment {
    private FragmentQuestionBinding binding;
    public QuestionFragment() {
        super(R.layout.fragment_question);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuestionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonUpload.setOnClickListener(v -> {
            String questionName = binding.editTextNameQuestion.getText().toString();
            String questionComplexity = binding.editTextComplexity.getText().toString();
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(questionName) && !TextUtils.isEmpty(questionComplexity)) {
                binding.editTextNameQuestion.setError(null);
                bundle.putString("RESULT_OK_NAME", questionName);
                bundle.putString("RESULT_OK_COMPLEXITY", questionComplexity);
                Navigation.findNavController(view).navigate(R.id.action_questionFragment_to_nameFragment, bundle);
            }
            else if (TextUtils.isEmpty(questionName)) {
                binding.editTextNameQuestion.setError("Пустая строка");
            }
            else if (TextUtils.isEmpty(questionComplexity))
            {
                binding.editTextComplexity.setError("Пустая строка");
            }
            else
            {
                binding.editTextNameQuestion.setError("Пустая строка");
                binding.editTextComplexity.setError("Пустая строка");
            }
        });
    }
}