package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private RecyclerView.Adapter adapter;
private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<ReciclerViewItem>reciclerViewItems=new ArrayList<>();
        reciclerViewItems.add(new ReciclerViewItem(R.drawable.ic_android_black_24dp,"poxos","poxosyan"));
        reciclerViewItems.add(new ReciclerViewItem(R.drawable.ic_android_black_24dp,"poxos","poxosyan"));
        reciclerViewItems.add(new ReciclerViewItem(R.drawable.ic_android_black_24dp,"poxos","poxosyan"));
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new ReciclerViewAdapter(reciclerViewItems);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
