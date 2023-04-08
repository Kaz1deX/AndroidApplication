package com.example.androidapplication.data.datamodels;

public class TopicModel {
    private String topic;
    private int number;

    public TopicModel() {
        this("No topic", 0);
    }

    public TopicModel(String topic, int number) {
        this.topic = topic;
        this.number = number;
    }

    public String getTopic() {
        return topic;
    }

    public int getNumber() {
        return number;
    }
}