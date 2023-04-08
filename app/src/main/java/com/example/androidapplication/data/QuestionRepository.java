package com.example.androidapplication.data;

import androidx.lifecycle.LiveData;

import com.example.androidapplication.data.DataQuestion;
import com.example.androidapplication.data.Question;

import java.util.List;

public class QuestionRepository {
    private LiveData<List<Question>> questions;

    public QuestionRepository() {
        questions = DataQuestion.createList();
    }

    public LiveData<List<Question>> getData() {
        return questions;
    }
}