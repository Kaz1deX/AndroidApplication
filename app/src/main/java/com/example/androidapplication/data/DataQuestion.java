package com.example.androidapplication.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidapplication.data.Question;

import java.util.ArrayList;
import java.util.List;

public class DataQuestion {
    public static LiveData<List<Question>> createList() {
        MutableLiveData<List<Question>> list = new MutableLiveData<>();
        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i < 800; i++) {
            Question temp = new Question("Вопрос " + (i+1), i+1);
            questions.add(temp);
        }
        list.setValue(questions);
        return list;
    }
}