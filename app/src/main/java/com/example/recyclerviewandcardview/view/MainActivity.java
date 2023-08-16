package com.example.recyclerviewandcardview.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.recyclerviewandcardview.model.Movie;
import com.example.recyclerviewandcardview.utils.OnItemClick;
import com.example.recyclerviewandcardview.R;
import com.example.recyclerviewandcardview.adapter.Adapter;
import com.example.recyclerviewandcardview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<Movie> movies;
    private Adapter adapter;
    private RecyclerView.LayoutManager lManager = new GridLayoutManager(this, 2);

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
        movies = new ArrayList<Movie>();
        movies.add(new Movie("OPPENHEIMER", "https://es.web.img2.acsta.net/c_310_420/pictures/23/05/25/13/41/1835431.jpg"));
        movies.add(new Movie("JURASSIC WORLD: DOMINION", "https://es.web.img3.acsta.net/c_310_420/pictures/22/04/25/10/39/2475018.jpg"));
        movies.add(new Movie("TOP GUN: MAVERICK", "https://es.web.img3.acsta.net/c_310_420/pictures/22/03/29/15/57/1533124.jpg"));
        movies.add(new Movie("GRAN TURISMO", "https://es.web.img2.acsta.net/c_310_420/pictures/23/05/03/14/13/0249485.jpg"));
    }

    private void initAdapter() {
        adapter = new Adapter(movies, new OnItemClick() {
            @Override
            public void onItemclick(Movie movie, int position) {
                deleteItem(position);
            }
        });
    }

    private void initRecyclerView() {
        binding.recycler.setHasFixedSize(true);
        binding.recycler.setItemAnimator(new DefaultItemAnimator());
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(lManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.addItem) {
            addItem();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void addItem() {
        int position = 0;
        String newName = "name n° " + (movies.size() + 1);
        movies.add(position, new Movie("new movie", "https://st2.depositphotos.com/14768666/43366/v/450/depositphotos_433666052-stock-illustration-cinema-film-icon-simple-style.jpg"));
        adapter.notifyItemInserted(position);
        lManager.scrollToPosition(position);
    }

    private void deleteItem(int position) {
        movies.remove(position);
        adapter.notifyItemRemoved(position);
    }
}