package com.example.recyclerviewandcardview.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewandcardview.R;

public class LoadUrlImage {

    public static void loadUrl(String url, ImageView imageView) {
        Glide
                .with(imageView.getContext())
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.baseline_local_movie)
                .into(imageView);
    }
}
