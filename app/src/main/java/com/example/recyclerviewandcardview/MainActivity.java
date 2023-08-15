package com.example.recyclerviewandcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewandcardview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<String> names;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initRecyclerview();
    }

    private void initRecyclerview() {
        initNames();
        initAdapter();
        initRecyclerView();
    }

    private void initNames() {
        names = new ArrayList<>();
        names.add("Ana");
        names.add("Barbara");
        names.add("Carlos");
        names.add("Daniel");
        names.add("Enmanuel");
        names.add("Fabiana");
    }

    private void initAdapter() {
        adapter = new Adapter(names, new OnItemClick() {
            @Override
            public void onItemclick(String name, int position) {
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView() {
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new GridLayoutManager(this, 3));
    }

}