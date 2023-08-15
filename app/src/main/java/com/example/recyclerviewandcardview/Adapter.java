package com.example.recyclerviewandcardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewandcardview.databinding.ItemLayoutBinding;

import org.xmlpull.v1.XmlPullParser;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private List<String> names;
    private OnItemClick listener;

    public Adapter(List<String> names, OnItemClick listener) {
        this.names = names;
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
        String name = names.get(position);
        holder.bind(name, listener);
    }

    @Override
    public int getItemCount() {
        return this.names.size();
    }
}
