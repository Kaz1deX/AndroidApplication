package com.example.androidapplication.data;

public class Topic {
    private String topic;
    private int number;

    public Topic() {
        this("No topic", 0);
    }

    public Topic(String topic, int number) {
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