package com.example.recyclerviewandcardview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewandcardview.databinding.ItemLayoutBinding;

public class ViewHolder extends RecyclerView.ViewHolder {

    ItemLayoutBinding binding;

    public ViewHolder(@NonNull ItemLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String name, OnItemClick listener) {

        binding.tvName.setText(name);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemclick(name, getAdapterPosition());
            }
        });
    }
}
