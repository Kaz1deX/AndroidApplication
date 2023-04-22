package com.example.androidapplication.ui.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.androidapplication.data.databases.entity.TopicEntity;
import com.example.androidapplication.data.models.TopicModel;
import com.example.androidapplication.data.repositories.TopicRepository;

import java.util.List;

public class TopicViewModel extends AndroidViewModel {
    private TopicRepository mRepository;

    private final LiveData<List<TopicModel>> mAllTopics;

    public TopicViewModel (Application application) {
        super(application);
        mRepository = new TopicRepository(application);
        mAllTopics = mRepository.getAllTopics();
    }

    public LiveData<List<TopicModel>> getAllTopics() { return mAllTopics; }

    public void insert(TopicModel topic) { mRepository
            .insert(new TopicEntity(topic.getName(), topic.getNumberSubtopics())); }
}