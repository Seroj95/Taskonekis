package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {
    private ArrayList<Notes> notes;

    public NotesAdapter(ArrayList<Notes> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view=LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);

        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
Notes note=notes.get(position);
holder.textViewTitle.setText(note.getTitle());
holder.textViewDescreption.setText(note.getDescreption());
holder.textViewDayOfWek.setText(note.getDayOfWek());
int coloeId = 0;
int priorety=note.getPriorety();
switch (priorety){
    case 1:
        coloeId=holder.itemView.getResources().getColor(android.R.color.holo_blue_bright);
        break;
    case 2:
        coloeId=holder.itemView.getResources().getColor(android.R.color.holo_orange_dark);
        break;
    case 3:
        coloeId=holder.itemView.getResources().getColor(android.R.color.holo_red_light);
        break;
    default:
       break;
}
holder.textViewTitle.setBackgroundColor(coloeId);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{
private TextView  textViewTitle;
private TextView  textViewDescreption;
private TextView  textViewDayOfWek;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.editTextViewTitle);
            textViewDescreption=itemView.findViewById(R.id.textViewDescreption);
            textViewDayOfWek=itemView.findViewById(R.id.textViewDayOfWeek);


        }
    }
}
