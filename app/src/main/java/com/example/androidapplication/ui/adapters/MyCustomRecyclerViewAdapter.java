package com.example.androidapplication.ui.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidapplication.R;
import com.example.androidapplication.data.models.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class MyCustomRecyclerViewAdapter extends RecyclerView.Adapter<MyCustomRecyclerViewAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private List<QuestionModel> questions;
    private Context context;

    public MyCustomRecyclerViewAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.questions = new ArrayList<>();
        this.context = context;
    }

    @Override
    public MyCustomRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.question_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCustomRecyclerViewAdapter.ViewHolder holder, int position) {
        QuestionModel question = questions.get(position);
        holder.question_text.setText(question.getName());
        holder.car_image.setImageResource(R.drawable.car);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("question", question.getName());
                Navigation.findNavController(view).navigate(R.id.action_recyclerViewFragment2_to_itemInfoFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView question_text;
        ImageView car_image;

        public ViewHolder(View view){
            super(view);
            question_text = view.findViewById(R.id.question_text);
            car_image = view.findViewById(R.id.car_image);
        }
    }

    public void updateQuestions(List<QuestionModel> questions) {
        this.questions.clear();
        this.questions = questions;
        notifyDataSetChanged();
    }
}