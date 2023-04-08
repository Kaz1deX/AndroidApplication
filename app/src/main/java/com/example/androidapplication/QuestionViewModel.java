package com.example.androidapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidapplication.model.Question;

import java.util.List;

public class QuestionViewModel extends ViewModel {
    public LiveData<List<Question>> questions;

    public QuestionViewModel() {
        QuestionRepository questionRepository = new QuestionRepository();
        questions = questionRepository.getData();
    }
}