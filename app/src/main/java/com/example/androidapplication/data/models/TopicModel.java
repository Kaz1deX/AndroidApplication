package com.example.androidapplication.data.models;

public class TopicModel {
    private String name;
    private int number_subtopics;

    public TopicModel() {
        this("No topic", 0);
    }

    public TopicModel(String name, int number_subtopics) {
        this.name = name;
        this.number_subtopics = number_subtopics;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberSubtopics() {
        return this.number_subtopics;
    }
}