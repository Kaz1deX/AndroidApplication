package com.example.androidapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyCustomRecyclerViewAdapter extends RecyclerView.Adapter<MyCustomRecyclerViewAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private List<String> themes;
    private Context context;

    public MyCustomRecyclerViewAdapter(Context context, List<String> themes) {
        this.inflater = LayoutInflater.from(context);
        this.themes = themes;
        this.context = context;
    }

    @Override
    public MyCustomRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.question_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCustomRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.question_text.setText(themes.get(position));
        holder.car_image.setImageResource(R.drawable.greenhowl);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, themes.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                Log.i("RecyclerView", themes.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return themes.size();
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
}