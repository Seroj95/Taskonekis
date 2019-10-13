package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AddNoteActivity extends AppCompatActivity {
private EditText editTextTitle;
private EditText editTextDescreption;
private Spinner spinnerDaysOfWek;
private RadioGroup radioGroupPriorety;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);


    }

    public void onClickSaveNote(View view) {
    }
}
