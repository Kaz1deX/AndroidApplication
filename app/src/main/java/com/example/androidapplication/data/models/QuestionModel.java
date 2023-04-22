package com.example.androidapplication.data.models;

public class QuestionModel {
    private String name;
    private String complexity;

    public QuestionModel() {
        this("No question", "No complexity");
    }

    public QuestionModel(String name, String complexity) {
        this.name = name;
        this.complexity = complexity;
    }

    public String getName() {
        return name;
    }

    public String getComplexity() {
        return complexity;
    }
}