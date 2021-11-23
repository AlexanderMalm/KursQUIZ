package com.example.kursquiz;

import android.content.Context;
import android.util.Log;


import java.io.BufferedReader;
import java.io.InputStream;

public class QHandler {
    //initierar en array med alla frågor
    private final Question[] questions = new QuestionLibrary().getQuestions();
    private int score = 0;
    private int currentuestion = 0;

    //Returnerar nästa fråga att besvara och inkrementerar räknaren för använda frågor
    public Question nextQuestion(){
        Question cq = questions[currentuestion];
        currentuestion++;
        return cq;
    }

    //Returnerar true om anvädaren valde rätt alternativ, annars false. Inkrementerar score
    public boolean checkAnswer(int answer ){
        if(answer == questions[currentuestion-1].getAnswer()) {
            score++;
            return true;
        } else {
            return false;
        }
    }
    //Returnera true om alla frågor besvarats
    public boolean game_ended(){
        return currentuestion == questions.length;
    }
    //Returnera score
    public int getScore(){
        return score;
    }

    public int length(){
        return questions.length;
    }
}