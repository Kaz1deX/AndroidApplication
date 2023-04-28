package com.example.androidapplication.ui.viewmodels;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.androidapplication.data.databases.entity.QuestionEntity;
import com.example.androidapplication.data.repositories.QuestionRepository;
import com.example.androidapplication.data.models.QuestionModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class QuestionViewModel extends AndroidViewModel {
    private QuestionRepository mRepository;
    private final LiveData<List<QuestionModel>> mAllQuestions;
    public QuestionViewModel (Application application) {
        super(application);
        mRepository = new QuestionRepository(application);
        mAllQuestions = mRepository.getAllQuestions();
    }
    public LiveData<List<QuestionModel>> getAllQuestions() { return mAllQuestions; }
    public void insert(QuestionModel question) { mRepository
            .insert(new QuestionEntity(question.getName(), question.getComplexity())); }
}