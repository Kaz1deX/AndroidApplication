package com.example.androidapplication.data.repositories;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.androidapplication.data.sources.AppSpecificStorageNameDataSource;
import com.example.androidapplication.data.sources.ExternalStorageNameDataSource;
import com.example.androidapplication.data.sources.SharedPreferencesStorageDataSource;

public class NameRepository {
    private AppSpecificStorageNameDataSource appSpecificStorageNameDataSource;
    private ExternalStorageNameDataSource externalStorageNameDataSource;
    private SharedPreferencesStorageDataSource sharedPreferencesStorageDataSource;
    public NameRepository(Context context) {
        appSpecificStorageNameDataSource = new AppSpecificStorageNameDataSource(context);
        externalStorageNameDataSource = new ExternalStorageNameDataSource(context);
        sharedPreferencesStorageDataSource = new SharedPreferencesStorageDataSource(context);
    }

    public void addNameAppSpecific(String user_name){
        appSpecificStorageNameDataSource.addNameAppSpecific(user_name);
    }

    public void addNameExternalStorage(String user_name){
        externalStorageNameDataSource.addNameExternalStorage(user_name);
    }

    public void addNameSharedPreferences(String user_name) {
        sharedPreferencesStorageDataSource.addNameSharedPreferences(user_name);
    }

    public String getUserName(String user_name) {
        return sharedPreferencesStorageDataSource.getUserName(user_name);
    }
}