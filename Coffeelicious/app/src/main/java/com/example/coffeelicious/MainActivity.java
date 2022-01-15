package com.example.coffeelicious;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // here we are creating an arraylist

        modelList = new ArrayList<>();
        modelList.add(new Model("Green Tea", getString(R.string.greentea), R.drawable.greentea ));
        modelList.add(new Model("Latte", getString(R.string.latte), R.drawable.late));
        modelList.add(new Model("Orange Smoothie", getString(R.string.orangesmoothie), R.drawable.orange));
        modelList.add(new Model("Orange Vanilla", getString(R.string.orangevanilla), R.drawable.orangevanilla));
        modelList.add(new Model("Cappucino", getString(R.string.cappcuni), R.drawable.cappcunio));
        modelList.add(new Model("Thai Tea", getString(R.string.thaitea), R.drawable.thaitea));
        modelList.add(new Model("Tea", getString(R.string.tea), R.drawable.tea));
        modelList.add(new Model("Bubble Tea", getString(R.string.bubbletea), R.drawable.milk));
        modelList.add(new Model("Matcha", getString(R.string.match), R.drawable.match));

        // here we are setting the recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));

        // here we are sending the list to the adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}