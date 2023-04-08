package com.example.androidapplication.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidapplication.data.datarepositories.QuestionRepository;
import com.example.androidapplication.data.datamodels.QuestionModel;

import java.util.List;

public class QuestionViewModel extends ViewModel {
    public LiveData<List<QuestionModel>> questions;
    public QuestionRepository questionRepository = new QuestionRepository();

    public QuestionViewModel() {
        questions = questionRepository.getData();
    }
}