package com.example.pizzarecipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaRecipeAdapter extends RecyclerView.Adapter<PizzaRecipeAdapter.PizzaRecipeViewHolder> {
    ArrayList<PizzaRecipeItem>pizzaRecipeItems;
Context context;
    public PizzaRecipeAdapter(ArrayList<PizzaRecipeItem> pizzaRecipeItems,Context context) {
        this.context=context;
        this.pizzaRecipeItems = pizzaRecipeItems;
    }

    @NonNull
    @Override
    public PizzaRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_recipe_item, parent, false);
       PizzaRecipeViewHolder pizzaRecipeViewHolder =new PizzaRecipeViewHolder(view);
        return pizzaRecipeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaRecipeViewHolder holder, int position) {
PizzaRecipeItem pizzaRecipeItem=pizzaRecipeItems.get(position);
holder.pizzaImageView.setImageResource(pizzaRecipeItem.getImageResource());
holder.title.setText(pizzaRecipeItem.getTitle());
holder.descreption.setText(pizzaRecipeItem.getDecreption());
    }

    @Override
    public int getItemCount() {
        return pizzaRecipeItems.size();
    }

      class PizzaRecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ImageView pizzaImageView;
          public TextView title;
          public TextView descreption;

        public PizzaRecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            pizzaImageView=itemView.findViewById(R.id.pizzaImageView);
            title=itemView.findViewById(R.id.titleTextView);
            descreption=itemView.findViewById(R.id.descreptionTextView);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            PizzaRecipeItem pizzaRecipeItem=pizzaRecipeItems.get(position);
            Intent intent =new Intent(context,RecipeActivity.class);
            intent.putExtra("image",pizzaRecipeItem.getImageResource());
            intent.putExtra("title",pizzaRecipeItem.getTitle());
            intent.putExtra("rec",pizzaRecipeItem.getReception());

            context.startActivity(intent);
        }
    }
}
