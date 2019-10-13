package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerViewNotes;
public static final ArrayList<Notes> notes=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewNotes=findViewById(R.id.recyclerViewNotes);
notes.add(new Notes("ha","as","sfsfsf",2));
notes.add(new Notes("ha","as","sfsfsf",1));
notes.add(new Notes("ha","as","sfsfsf",3));
notes.add(new Notes("ha","as","sfsfsf",2));
notes.add(new Notes("ha","as","sfsfsf",1));
NotesAdapter notesAdapter=new NotesAdapter(notes);
recyclerViewNotes.setLayoutManager(new GridLayoutManager(this,3));
recyclerViewNotes.setAdapter(notesAdapter);
    }

    public void onClickAddNode(View view) {
    }
}
