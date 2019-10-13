package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReciclerViewAdapter extends RecyclerView.Adapter <ReciclerViewAdapter.ReciclerViewViewHolder>{
    private ArrayList<ReciclerViewItem>arrayList;
    public static class ReciclerViewViewHolder  extends RecyclerView.ViewHolder{
public ImageView imageView;
public TextView textView1;
public TextView textView2;
        public ReciclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageViewId);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);

        }
    }


    public ReciclerViewAdapter(ArrayList<ReciclerViewItem> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ReciclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recicler_card_view, parent, false);
        ReciclerViewViewHolder reciclerViewViewHolder=new ReciclerViewViewHolder(view);
        return reciclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReciclerViewViewHolder holder, int position) {
ReciclerViewItem reciclerViewItem=arrayList.get(position);
holder.imageView.setImageResource(reciclerViewItem.getImageViewRecourse());
holder.textView1.setText(reciclerViewItem.getText1());
holder.textView2.setText(reciclerViewItem.getText2());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
