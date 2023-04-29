package com.example.androidapplication.data.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.androidapplication.data.databases.dao.QuestionDao;
import com.example.androidapplication.data.databases.entity.QuestionEntity;
import com.example.androidapplication.data.databases.roomDatabase.QuestionRoomDatabase;
import com.example.androidapplication.data.models.QuestionModel;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionRepository {
    private final QuestionDao mQuestionDao;
    private final LiveData<List<QuestionModel>> mAllQuestions;
    private final Context context;
    private QuestionRoomDatabase roomDatabase;
    public QuestionRepository(Application applicationContext) {
        context = applicationContext;
        roomDatabase = QuestionRoomDatabase.getDatabase(context);
        mQuestionDao = QuestionRoomDatabase.getDatabase(context).questionDao();
        mAllQuestions = Transformations.map(mQuestionDao.getAllQuestions(), entities -> entities.stream()
                .map(QuestionEntity::toQuestion).collect(Collectors.toList()));
    }
    public LiveData<List<QuestionModel>> getAllQuestions() {
        return mAllQuestions;
    }
    public void insert(QuestionEntity question) {
        QuestionRoomDatabase.databaseWriteExecutor.execute(() -> {
            mQuestionDao.insert(question);
        });
    }
}