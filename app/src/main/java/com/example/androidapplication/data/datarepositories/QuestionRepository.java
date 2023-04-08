package com.example.androidapplication.data.datarepositories;

import androidx.lifecycle.LiveData;

import com.example.androidapplication.data.datasources.QuestionDataSource;
import com.example.androidapplication.data.datamodels.QuestionModel;

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