package com.example.androidapplication.data.databases.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.androidapplication.data.databases.entity.QuestionEntity;

import java.util.List;

@Dao
public interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(QuestionEntity book);
    @Query("DELETE FROM question_table")
    void deleteAll();
    @Query("SELECT * FROM question_table ORDER BY name")
    LiveData<List<QuestionEntity>> getAllQuestions();
}