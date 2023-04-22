package com.example.androidapplication.data.databases.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.androidapplication.data.models.QuestionModel;

@Entity(tableName = "question_table")
public class QuestionEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String complexity;

    public QuestionEntity(@NonNull String name, String complexity) {
        this.name = name;
        this.complexity = complexity;
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
    public String getComplexity() {
        return this.complexity;
    }
    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }
    public QuestionModel toQuestion() {
        return new QuestionModel(this.name, this.complexity);
    }
}