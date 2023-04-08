package com.example.androidapplication.data;

public class Question {
    private String question;
    private int number;

    public Question() {
        this("No question", 0);
    }

    public Question(String question, int number) {
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