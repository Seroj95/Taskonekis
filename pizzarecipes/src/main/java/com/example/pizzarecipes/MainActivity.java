package com.example.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView.Adapter adapter;
RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<PizzaRecipeItem>pizzaRecipeAdapters=new ArrayList<>();
        pizzaRecipeAdapters.add(new PizzaRecipeItem(R.drawable.pizza1,Util.TITLE_1,Util.DESCREPTION_1_,Util.RECEPT_1));
        pizzaRecipeAdapters.add(new PizzaRecipeItem(R.drawable.pizza2,Util.TITLE_2,Util.DESCREPTION_2_,Util.RECEPT_2));
        pizzaRecipeAdapters.add(new PizzaRecipeItem(R.drawable.pizza3,Util.TITLE_3,Util.DESCREPTION_3_,Util.RECEPT_3));
        recyclerView=findViewById(R.id.recyclerview);
recyclerView.setHasFixedSize(true);
adapter=new PizzaRecipeAdapter(pizzaRecipeAdapters,this);
layoutManager=new LinearLayoutManager(this);
recyclerView.setAdapter(adapter);
recyclerView.setLayoutManager(layoutManager);

    }
}
