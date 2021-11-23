package com.example.kursquiz;

public final class Question {
    private final String question_text;
    private final String[] alternatives;
    private final int correct_answer;

    public Question( String question_text, String[]alternatives, int correct_answer){
        this.question_text = question_text;
        this.alternatives = alternatives;
        this.correct_answer = correct_answer;
    }

    public String getText(){
        return question_text;
    }

    public String[] getAlternatives() {
        return alternatives;
    }

    public int getAnswer(){
        return correct_answer;
    }

}




