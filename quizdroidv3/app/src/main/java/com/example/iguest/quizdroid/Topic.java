package com.example.iguest.quizdroid;

import java.util.ArrayList;

/**
 * Created by iguest on 2/20/15.
 */
public class Topic {
    private ArrayList<Quiz> list;
    private String title;
    private String shortDesc;
    private String longDesc;

    public Topic(){
        list = new ArrayList<Quiz>();
        title ="";
        shortDesc = "";
        longDesc = "";
    }

    public Topic(ArrayList<Quiz> a, String b, String c, String d){
        list = a;
        title = b;
        shortDesc = c;
        longDesc = d;
    }

    public ArrayList<Quiz> getList(){
        return list;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setList(ArrayList<Quiz> list) {
        this.list = list;
    }

    public void setShortDesc(String desc){
        shortDesc = desc;
    }

    public void setLongDesc(String desc){
        longDesc = desc;
    }

    public void addQuiz(Quiz question) {
        list.add(question);
    }
}
