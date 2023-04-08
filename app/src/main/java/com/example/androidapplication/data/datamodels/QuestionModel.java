package com.example.androidapplication.data.datamodels;

public class QuestionModel {
    private String question;
    private int number;

    public QuestionModel() {
        this("No question", 0);
    }

    public QuestionModel(String question, int number) {
        this.question = question;
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public int getNumber() {
        return number;
    }
}