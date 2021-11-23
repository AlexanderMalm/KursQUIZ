package com.example.kursquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Till startsida");
        TextView t = findViewById(R.id.score);
        Intent i = getIntent();
        int game_score = i.getIntExtra("Score", 0);
        int n_questions = i.getIntExtra("n_questions", 0);

        String result_output = "Ditt resultat är " +String.valueOf(game_score)+"/"+n_questions;
        t.setText(result_output);


    }



}