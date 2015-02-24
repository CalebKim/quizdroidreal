package com.example.iguest.quizdroid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by iguest on 2/24/15.
 */
public class CreateRepo implements TopicRepository {

    private ArrayList<Topic> full_list;

    public CreateRepo() {
        full_list = new ArrayList<Topic>();
    }

    public void load(String file){
        BufferedReader in = null;
        try{
            String line;

            in = new BufferedReader(new FileReader("file.in"));
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
                    createTopic(quizList, line, shortDesc, longDesc);
                }
            }
            in.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addQuestion(Quiz quiz){

    }

    public void changeTitle(String title){

    }

    public void changeShortDesc(String shortDesc){

    }

    public void changeLongDesc(String longDesc){

    }

    public void createQuiz(String text, ArrayList<String> questions, int answer) {

    }

    public void createTopic(ArrayList<Quiz> list, String title, String shortDesc, String longDesc){
        full_list.add(new Topic(list, title, shortDesc, longDesc));
    }
}
