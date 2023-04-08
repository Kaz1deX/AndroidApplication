package com.example.androidapplication.data.datasources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidapplication.data.datamodels.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionDataSource {
    public static LiveData<List<QuestionModel>> createList() {
        MutableLiveData<List<QuestionModel>> list = new MutableLiveData<>();
        ArrayList<QuestionModel> questions = new ArrayList<>();
        for (int i = 0; i < 800; i++) {
            QuestionModel temp = new QuestionModel("Вопрос " + (i+1), i+1);
            questions.add(temp);
        }
        list.setValue(questions);
        return list;
    }
}