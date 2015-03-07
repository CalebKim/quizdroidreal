package com.example.iguest.quizdroid;

import java.util.ArrayList;

/**
 * Created by iguest on 2/20/15.
 */
public class Quiz {
    private String text;
    private ArrayList<String> questions;
    private int answer;

    public Quiz () {
        text="";
        questions = new ArrayList<String>();
        answer=-1;
    }

    public String getText () {
        return text;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public int getAnswer() {
        return answer;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
    }

    public void setAnswer(int answer){
        this.answer = answer;
    }




}
