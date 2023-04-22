package com.example.androidapplication.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.androidapplication.data.sources.QuestionDataSource;
import com.example.androidapplication.data.models.QuestionModel;

import java.util.List;

public class QuestionRepository {
    private LiveData<List<QuestionModel>> questions;

    public QuestionRepository() {
        questions = QuestionDataSource.createList();
    }

    public LiveData<List<QuestionModel>> getData() {
        return questions;
    }
}