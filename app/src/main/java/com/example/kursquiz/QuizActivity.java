package com.example.kursquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class QuizActivity extends AppCompatActivity {

    private TextView question_textView;
    private int currentAnswer;
    private Button answer_one, answer_two, answer_three, answer_four;

    private final QHandler qh = new QHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setViews();
        nextQuestion();

        //Ger möjlighet att genom actionbar avsluta och återgå till startsida
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Till startsida");
    }

    private void setViews(){
        question_textView = findViewById(R.id.thetext);
        answer_one = findViewById(R.id.button_alt_one);
        answer_two = findViewById(R.id.button_alt_two);
        answer_three = findViewById(R.id.button_alt_three);
        answer_four = findViewById(R.id.button_alt_four);

    }
    //Sorterar en questions attribut och visar dem för anvädaren i korrekt buttonviews oh textview
    private void nextQuestion(){
        Question currentQuestion = qh.nextQuestion();

        question_textView.setText(currentQuestion.getText());
        answer_one.setText(currentQuestion.getAlternatives()[0]);
        answer_two.setText(currentQuestion.getAlternatives()[1]);
        answer_three.setText(currentQuestion.getAlternatives()[2]);
        answer_four.setText(currentQuestion.getAlternatives()[3]);
    }

    //Hämtar nästa fråga, har alla besvarats skapas nytt intent där resultatet skickas med och redovisas
    private void next_question(View v) {
        if(!qh.game_ended()){
            nextQuestion();

        }else {
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("Score", qh.getScore());
            i.putExtra("n_questions", qh.length());
            startActivity(i);
        }
    }

/*
    //Funktioner för spara användarens svarsalternativ
    public void alt_1(View v){
        currentAnswer = 1;
    }

    public void alt_2(View v){
        currentAnswer = 2;
    }

    public void alt_3(View v)
    { currentAnswer = 3;  }

    public void alt_4(View v){
        currentAnswer = 4;
    }
*/
    @SuppressLint("NonConstantResourceId")
    public void pressed(View v){

        switch(v.getId()){
            case R.id.button_alt_one:
                currentAnswer = 1;
                break;
            case R.id.button_alt_two:
                currentAnswer = 2;
                break;
            case R.id.button_alt_three:
                currentAnswer = 3;
                break;
            case R.id.button_alt_four:
                currentAnswer = 4;
                break;
        }
    }

    //Testar det angivna svaret och berättar för användaren
    public void submit(View v){
        if(qh.checkAnswer(currentAnswer)){
            Toast.makeText(getApplicationContext(),"Rätt",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Fel du suger",Toast.LENGTH_SHORT).show();
        }

        currentAnswer =0;
        next_question(question_textView);
    }
}

