package com.example.androidapplication.ui.viewmodels;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;

import com.example.androidapplication.data.repositories.NameRepository;

public class NameViewModel extends AndroidViewModel {
    private NameRepository mRepository;
    public NameViewModel (Application application) {
        super(application);
        mRepository = new NameRepository(application);
    }
    public void addNameAppSpecific(String user_name){
        mRepository.addNameAppSpecific(user_name);
    }

    public void addNameExternalStorage(String user_name){
        mRepository.addNameExternalStorage(user_name);
    }

    public void addNameSharedPreferences(String user_name) {
        mRepository.addNameSharedPreferences(user_name);
    }

    public String getUserName(String user_name) {
        return mRepository.getUserName(user_name);
    }
}