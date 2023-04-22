package com.example.androidapplication.data.databases.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.androidapplication.data.databases.entity.TopicEntity;

import java.util.List;

@Dao
public interface TopicDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(TopicEntity topic);
    @Query("DELETE FROM topic_table")
    void deleteAll();
    @Query("SELECT * FROM topic_table ORDER BY name")
    LiveData<List<TopicEntity>> getAllTopics();
}