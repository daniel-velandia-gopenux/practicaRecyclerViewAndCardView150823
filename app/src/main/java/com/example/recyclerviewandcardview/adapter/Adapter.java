package com.example.recyclerviewandcardview.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewandcardview.model.Movie;
import com.example.recyclerviewandcardview.utils.OnItemClick;
import com.example.recyclerviewandcardview.databinding.ItemLayoutBinding;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Movie> movies;
    private OnItemClick listener;

    public Adapter(List<Movie> movies, OnItemClick listener) {
        this.movies = movies;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding binding = ItemLayoutBinding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.bind(movie, listener);
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }
}
