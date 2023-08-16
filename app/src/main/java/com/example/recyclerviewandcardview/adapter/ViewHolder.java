package com.example.recyclerviewandcardview.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewandcardview.utils.LoadUrlImage;
import com.example.recyclerviewandcardview.model.Movie;
import com.example.recyclerviewandcardview.utils.OnItemClick;
import com.example.recyclerviewandcardview.databinding.ItemLayoutBinding;

public class ViewHolder extends RecyclerView.ViewHolder {

    ItemLayoutBinding binding;

    public ViewHolder(@NonNull ItemLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Movie movie, OnItemClick listener) {

        binding.tvName.setText(movie.getName());
        LoadUrlImage.loadUrl(movie.getPhoto(), binding.ivPhoto);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(getAdapterPosition());
                listener.onItemclick(movie, getAdapterPosition());
            }
        });
    }
}
