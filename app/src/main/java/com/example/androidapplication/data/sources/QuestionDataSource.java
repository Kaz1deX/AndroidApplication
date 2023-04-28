package com.example.androidapplication.data.sources;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidapplication.data.models.QuestionModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDataSource {

    private File app_specific_storage_file;

    public QuestionDataSource(Application application) {
        File app_specific_directory = application.getFilesDir();
        app_specific_storage_file = new File(app_specific_directory, "names.txt");
    }

    public static LiveData<List<QuestionModel>> createList() {
        MutableLiveData<List<QuestionModel>> list = new MutableLiveData<>();
        ArrayList<QuestionModel> questions = new ArrayList<>();
        for (int i = 0; i < 800; i++) {
            QuestionModel temp = new QuestionModel("Вопрос " + (i+1), "Легко");
            questions.add(temp);
        }
        list.setValue(questions);
        return list;
    }

    public void addQuestion(String question_name){
        try {
            FileWriter writer = new FileWriter(app_specific_storage_file);
            writer.write(question_name);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}