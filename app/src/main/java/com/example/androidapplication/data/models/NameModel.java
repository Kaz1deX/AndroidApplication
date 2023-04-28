package com.example.androidapplication.data.models;

public class NameModel {
    private String name;

    public NameModel() {
        this("No name");
    }

    public NameModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}