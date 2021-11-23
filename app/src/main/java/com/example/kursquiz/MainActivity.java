package com.example.kursquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Kopplad till knapp för att skapa nytt intent och starta quiz
    public void startGame(View v){
        Intent i = new Intent(this, QuizActivity.class);
        startActivity(i);
    }
}