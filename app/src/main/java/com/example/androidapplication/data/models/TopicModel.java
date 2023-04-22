package com.example.androidapplication.data.models;

public class TopicModel {
    private String topic;
    private int number_subtopics;

    public TopicModel() {
        this("No topic", 0);
    }

    public TopicModel(String topic, int number_subtopics) {
        this.topic = topic;
        this.number_subtopics = number_subtopics;
    }

    public String getTopic() {
        return topic;
    }

    public int getNumberSubtopics() {
        return number_subtopics;
    }
}