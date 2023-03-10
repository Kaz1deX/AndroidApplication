package com.example.androidapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyCustomListViewAdapter extends ArrayAdapter<String> {
    private LayoutInflater inflater;
    private int layout;
    private List<String> questions;

    public MyCustomListViewAdapter(Context context, int resource, List<String> questions) {
        super(context, resource, questions);
        this.questions = questions;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        TextView question_text = view.findViewById(R.id.question_text);
        question_text.setText(questions.get(position));

        ImageView car_image = view.findViewById(R.id.car_image);
        car_image.setImageResource(R.drawable.car);

        return view;
    }
}