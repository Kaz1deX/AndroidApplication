package com.example.androidapplication.data.databases.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.androidapplication.data.models.TopicModel;

@Entity(tableName = "topic_table")
public class TopicEntity {
    @PrimaryKey(autoGenerate = true)
    private String name;
    private int number_subtopics;
    public TopicEntity(@NonNull String name, int number_subtopics) {
        this.name = name;
        this.number_subtopics = number_subtopics;
    }
    @NonNull
    public String getName() {
        return this.name;
    }
    public void setName(@NonNull String name) {
        this.name = name;
    }
    public int getNumberSubtopics() {
        return number_subtopics;
    }
    public void setNumberSubtopics(int number_subtopics) {
        this.number_subtopics = number_subtopics;
    }
    public TopicModel toTopic(){
        return new TopicModel(this.name, this.number_subtopics);
    }
}