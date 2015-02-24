package com.example.iguest.quizdroid;

import android.app.Application;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by iguest on 2/20/15.
 */
public class QuizApp extends Application implements TopicRepository{

    private static QuizApp instance;

    public ArrayList<Topic> fullList;

    public static void initInstance()
    {
        if (instance == null)
        {
            // Create the instance
            instance = new QuizApp();
        }
    }

    public static QuizApp getInstance()
    {
        // Return the instance
        return instance;
    }

    public QuizApp()
    {
        fullList = new ArrayList<Topic>();
        String topic = "Math";
        String shortDesc = "Math. You know like 1+1. 1 question";
        String longDesc = "Math. The only pure field of study in our society.  Archimedes, Gauss, Euler, Erdos. These fathers of mathematics produced the foundation to our understanding of the universe. Truly a topic worthy of such a prestigious quiz app. 1 question";
        Quiz quest = new Quiz();
        quest.setText("Determine the best strategy for each player in the following two-player game. There are three piles, each of which contains some number of coins. Players alternate turns, each turn consisting of removing any (non-zero) number of coins from a single pile. The goal is to be the person to remove the last coin(s).");
        ArrayList<String> questions = new ArrayList<String>();
        questions.add("If the starting numbers of coins are random, then the player who goes first will most likely win.");
        questions.add("Winning positions are the ones that have an even number of 1’s in each column, when written in base 2.");
        questions.add("Regardless of how many starting number of coins there are, the player who goes first will win");
        questions.add("What the ...........");
        quest.setQuestions(questions);
        quest.setAnswer(1);
        ArrayList<Quiz> quizList = new ArrayList<Quiz>();
        quizList.add(quest);
        createTopic(quizList, topic, shortDesc, longDesc);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("quizdroid", "this be working");
        initInstance();
    }

    /* code for file load, decided to use a hardcoded list for the time being.
    public void load(String file){
        BufferedReader in = null;
        try{
            String line;

            in = new BufferedReader(new FileReader(file));
            while ((line = in.readLine()) != null){
                if(line.startsWith("[t]")){
                    String topic = line;
                    String shortDesc = in.readLine();
                    String longDesc = in.readLine();
                    Quiz quest = new Quiz();
                    quest.setText(in.readLine());
                    ArrayList<String> questions = new ArrayList<String>();
                    questions.add(in.readLine());
                    questions.add(in.readLine());
                    questions.add(in.readLine());
                    questions.add(in.readLine());
                    quest.setQuestions(questions);
                    quest.setAnswer(Integer.parseInt(in.readLine()));
                    ArrayList<Quiz> quizList = new ArrayList<Quiz>();
                    quizList.add(quest);
                    createTopic(quizList, topic, shortDesc, longDesc);
                }
            }
            in.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }*/

    public ArrayList<Topic> getRepo(){
        return fullList;
    }

    public void addQuestion(Quiz quiz){

    }

    public void changeTitle(String title){

    }

    public void changeShortDesc(String shortDesc){

    }

    public void changeLongDesc(String longDesc){

    }

    public Quiz createQuiz(String text, ArrayList<String> questions, int answer) {

    }

    public void createTopic(ArrayList<Quiz> list, String title, String shortDesc, String longDesc){
        fullList.add(new Topic(list, title, shortDesc, longDesc));
    }

}
