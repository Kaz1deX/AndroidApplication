package com.example.androidapplication.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidapplication.data.QuestionRepository;
import com.example.androidapplication.data.Question;

import java.util.List;

public class QuestionViewModel extends ViewModel {
    public LiveData<List<Question>> questions;

    public QuestionViewModel() {
        QuestionRepository questionRepository = new QuestionRepository();
        questions = questionRepository.getData();
    }
}