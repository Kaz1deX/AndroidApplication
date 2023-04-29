package com.example.androidapplication.data.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.androidapplication.data.databases.dao.TopicDao;
import com.example.androidapplication.data.databases.entity.TopicEntity;
import com.example.androidapplication.data.databases.roomDatabase.TopicRoomDatabase;
import com.example.androidapplication.data.models.TopicModel;

import java.util.List;
import java.util.stream.Collectors;

public class TopicRepository {
    private final TopicDao mTopicDao;
    private final LiveData<List<TopicModel>> mAllTopics;
    private final Context context;
    private TopicRoomDatabase roomDatabase;
    public TopicRepository(Application applicationContext) {
        context = applicationContext;
        roomDatabase = TopicRoomDatabase.getDatabase(context);
        mTopicDao = TopicRoomDatabase.getDatabase(context).topicDao();
        mAllTopics = Transformations.map(mTopicDao.getAllTopics(), entities -> entities.stream()
                .map(TopicEntity::toTopic).collect(Collectors.toList()));
    }
    public LiveData<List<TopicModel>> getAllTopics() {
        return mAllTopics;
    }
    public void insert(TopicEntity topic) {
        TopicRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTopicDao.insert(topic);
        });
    }
}