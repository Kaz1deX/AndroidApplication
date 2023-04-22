package com.example.androidapplication.data.databases.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.androidapplication.data.models.TopicModel;

@Entity(tableName = "topic_table")
public class TopicEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    public int getNumberSubtopics() {
        return this.numberSubtopics;
    }

    private int numberSubtopics;


    private String name;
    public TopicEntity(@NonNull String name, int numberSubtopics) {
        this.name = name;
        this.numberSubtopics = numberSubtopics;
    }
    @NonNull
    public String getName() {
        return this.name;
    }
    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }
    public void setId(@NonNull int id) {
        this.id = id;
    }

    public TopicModel toTopic(){
        return new TopicModel(this.name, this.numberSubtopics);
    }
}