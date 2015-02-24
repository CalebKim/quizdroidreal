package com.example.iguest.quizdroid;

import java.util.ArrayList;

/**
 * Created by iguest on 2/20/15.
 */
public interface TopicRepository {


    void addQuestion(Quiz quiz);

    void changeTitle(String title);

    void changeShortDesc(String shortDesc);

    void changeLongDesc(String longDesc);

    Quiz createQuiz(String text, ArrayList<String> questions, int answer);

    void createTopic(ArrayList<Quiz> list, String title, String shortDesc, String longDesc);

}

//create retrieve update delete