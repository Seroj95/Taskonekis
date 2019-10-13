package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView textView=findViewById(R.id.textView);
      SharedPreferences sharedPreferences=this.getSharedPreferences("Shared",Context.MODE_PRIVATE);

      SharedPreferences.Editor editor=sharedPreferences.edit();

    }
}
