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
        //hardcoded list
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
        //physics
        String topic1 = "Physics";
        String shortDesc1 = "Physics, so cool. 1 question.";
        String longDesc1 = "With every action there is an equal and opposite reaction. Newton stood on the 'shoulders of giants' to produce illuminating work that contributed to our ability to comprehend where we are in the universe.  Our pale blue dot is simply a speck in the ocean of galaxies.  Physics allowed us to look out and see what is beyond our atmosphere.  Physics is a field that earns its place in time and on our universally successful quiz app. 1 question";
        Quiz quest1 = new Quiz();
        quest1.setText("A photon collides with a stationary electron. If the photon scatters at an angle θ, show that the resulting wavelength, λ' is given in terms of the original wavelength, λ, by λ'= λ + (h/mc)(1-cos θ), where m is the mass of the electron. Note: The energy of a photon is E = hν = hc/λ.");
        ArrayList<String> questions1 = new ArrayList<String>();
        questions1.add("λ' = λ + h/mc(1 - cos θ)");
        questions1.add("If θ ≈ 0 (that is, not much scattering), then λ'!= λ, as expected.");
        questions1.add("therefore, the photon bounces back with an essentially fixed E, independent of the initial E");
        questions1.add("Seriously...?");
        quest1.setQuestions(questions1);
        quest1.setAnswer(3);
        ArrayList<Quiz> quizList1 = new ArrayList<Quiz>();
        quizList1.add(quest1);
        createTopic(quizList1, topic1, shortDesc1, longDesc1);
        //marvel
        String topic2 = "Marvel Super Heroes";
        String shortDesc2 = "Marvel, not DC. 1 question";
        String longDesc2 = " Founded in 1939. Responsible for Spiderman. 1 question";
        Quiz quest2 = new Quiz();
        quest2.setText("Which Marvel Comic run is the best?");
        ArrayList<String> questions2 = new ArrayList<String>();
        questions2.add("Ultimate Spiderman");
        questions2.add("Hawkeye");
        questions2.add("Inhumans");
        questions2.add("All of the above");
        quest2.setQuestions(questions2);
        quest2.setAnswer(4);
        ArrayList<Quiz> quizList2 = new ArrayList<Quiz>();
        quizList2.add(quest2);
        createTopic(quizList2, topic2, shortDesc2, longDesc2);
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

    public void addQuestion(Topic topic, Quiz quiz){
        topic.addQuiz(quiz);
    }

    public void changeTitle(Topic topic, String title){
        topic.setTitle(title);
    }

    public void changeShortDesc(Topic topic, String shortDesc){
        topic.setShortDesc(shortDesc);
    }

    public void changeLongDesc(Topic topic, String longDesc){
        topic.setLongDesc(longDesc);
    }

    public Quiz createQuiz(String text, ArrayList<String> questions, int answer) {
        Quiz quiz = new Quiz();
        return quiz;
    }

    public void createTopic(ArrayList<Quiz> list, String title, String shortDesc, String longDesc){
        fullList.add(new Topic(list, title, shortDesc, longDesc));
    }

}
