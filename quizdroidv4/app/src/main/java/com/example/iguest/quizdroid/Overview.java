package com.example.iguest.quizdroid;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;


public class Overview extends ActionBarActivity {
    private int user_ans = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        Intent launch = getIntent();
        String topic = launch.getStringExtra("topic");

        if (savedInstanceState == null) { // if Application ever fired up before, is this the first time we're firing it up
            // r.id.container is where you want the fragment to be inserted
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.overview_page, new PlaceholderFragment(topic))
                    .commit();
        }
    }

    public static class PlaceholderFragment extends Fragment {
        private String topic_field = "";

        public PlaceholderFragment() {
            this("math");
        }

        public PlaceholderFragment(String topic) {
            topic_field = topic;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            // get View of Fragment from fragment_main.xml
            View rootView = inflater.inflate(R.layout.activity_overview, container, false);

            // get button @id/button4 from fragment_main.xml
            // set the text of the topic.
            TextView top_title = (TextView) rootView.findViewById(R.id.topic_title);
            top_title.setText(topic_field);
            //set description of topic.
            //grab repo
            ArrayList<Topic> topics = QuizApp.getInstance().getRepo();
            TextView overview_desc = (TextView) rootView.findViewById(R.id.overview_desc);
            if (topic_field.equals("Math")){
                overview_desc.setText(topics.get(0).getLongDesc());
            } else if (topic_field.equals("Physics")){
                overview_desc.setText(topics.get(1).getLongDesc());
            } else {
                overview_desc.setText(topics.get(2).getLongDesc());
            }
            Button b = (Button) rootView.findViewById(R.id.overview_next_button);

            // On button click Open 2nd activity
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.overview_page, new PlaceholderFragmentQ(topic_field))
                            .commit();
                }
            });
            return rootView;
        }
    }

    public static class PlaceholderFragmentQ extends Fragment {
        private String topic_field = "";
        private int user_ans = 0;

        public PlaceholderFragmentQ() {
            this("math");
        }

        public PlaceholderFragmentQ(String topic) {
            topic_field = topic;
        }
        ArrayList<Topic> topics = QuizApp.getInstance().getRepo();
        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            // get View of Fragment from fragment_main.xml
            View rootView = inflater.inflate(R.layout.activity_questions, container, false);

            RadioButton q1 = (RadioButton) rootView.findViewById(R.id.q1);
            RadioButton q2 = (RadioButton) rootView.findViewById(R.id.q2);
            RadioButton q3 = (RadioButton) rootView.findViewById(R.id.q3);
            RadioButton q4 = (RadioButton) rootView.findViewById(R.id.q4);
            TextView top_question = (TextView) rootView.findViewById(R.id.textView);
            if (topic_field.equals("Physics")){
                ArrayList<Quiz> questions = topics.get(1).getList();
                questions.get(0).getText();
                top_question.setText(questions.get(0).getText());
                ArrayList<String> listQ = questions.get(0).getQuestions();
                q1.setText(listQ.get(0));
                q2.setText(listQ.get(1));
                q3.setText(listQ.get(2));
                q4.setText(listQ.get(3));
            } else if (topic_field.equals("Math")){
                ArrayList<Quiz> questions = topics.get(0).getList();
                questions.get(0).getText();
                top_question.setText(questions.get(0).getText());
                ArrayList<String> listQ = questions.get(0).getQuestions();
                q1.setText(listQ.get(0));
                q2.setText(listQ.get(1));
                q3.setText(listQ.get(2));
                q4.setText(listQ.get(3));
            } else {
                ArrayList<Quiz> questions = topics.get(2).getList();
                top_question.setText(questions.get(0).getText());
                questions.get(0).getText();
                top_question.setText(questions.get(0).getText());
                ArrayList<String> listQ = questions.get(0).getQuestions();
                q1.setText(listQ.get(0));
                q2.setText(listQ.get(1));
                q3.setText(listQ.get(2));
                q4.setText(listQ.get(3));
            }

            Button b = (Button) rootView.findViewById(R.id.button);
            // On button click Open 2nd activity
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.overview_page, new PlaceholderFragmentA(topic_field, user_ans))
                            .commit();
                }
            });
            return rootView;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        //show button
        Button finish = (Button) findViewById(R.id.button);
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.q1:
                if (checked) {
                    setAnswer(1);
                    // Pirates are the best
                    break;
                }
            case R.id.q2:
                if (checked) {
                    setAnswer(2);
                    // Ninjas rule
                    break;
                }
            case R.id.q3:
                if (checked) {
                    setAnswer(3);
                    // blah is the blah
                    break;
                }
            case R.id.q4:
                if (checked) {
                    setAnswer(4);
                    // blah is the blah
                    break;
                }
        }
        finish.setVisibility(View.VISIBLE);
    }

    private void setAnswer(int i) {
        user_ans = i;
    }

    public static class PlaceholderFragmentA extends Fragment {
        private String topic_field = "";
        private int ans = -1;

        public PlaceholderFragmentA() {
            this("math", -1);
        }

        public PlaceholderFragmentA(String topic, int answer) {
            topic_field = topic;
            ans = answer;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            // get View of Fragment from fragment_main.xml
            View rootView = inflater.inflate(R.layout.activity_answers, container, false);

            //stuff
            TextView bool_ans = (TextView) rootView.findViewById(R.id.bool_ans);
            TextView user_ans = (TextView) rootView.findViewById(R.id.user_ans);
            TextView correct_ans = (TextView) rootView.findViewById(R.id.correct_ans);
            TextView total_num = (TextView) rootView.findViewById(R.id.total_num);
            ArrayList<Topic> topics = QuizApp.getInstance().getRepo();
            if (topic_field.equals("Math")){
                if (ans == 1) {
                    bool_ans.setText("Correct!");
                    user_ans.setText("You put: " + "'If the starting numbers of coins are random, then the player who goes first will most likely win,'");
                    correct_ans.setText("Correct Answer: " + "'If the starting numbers of coins are random, then the player who goes first will most likely win,'");
                    total_num.setText("1/1 correct.  You're basically Archimedes");
                } else if (ans == 2) {
                    bool_ans.setText("Wrong!");
                    user_ans.setText("You put: " + "'Winning positions are the\n" +
                            "ones that have an even number of 1’s in each column, when written in base 2.'");
                    correct_ans.setText("Correct Answer: " + "'If the starting numbers of coins are random, then the player who goes first will most likely win,'");
                    total_num.setText("0/1 correct. These are losing positions not winning positions");
                } else if (ans == 3){
                    bool_ans.setText("Wrong!");
                    user_ans.setText("You put: " + "'Regardless of how many starting number of coins there are, the player who goes first will win'");
                    correct_ans.setText("Correct Answer: " + "'If the starting numbers of coins are random, then the player who goes first will most likely win,'");
                    total_num.setText("0/1 correct.  Nice try, but obviously wrong.");
                } else {
                    bool_ans.setText("Wrong!");
                    user_ans.setText("You put: " + "'What the ...........'");
                    correct_ans.setText("Correct Answer: " + "'If the starting numbers of coins are random, then the player who goes first will most likely win,'");
                    total_num.setText("0/1 correct.  You're not even trying");
                }
            } else if (topic_field.equals("Physics")){
                if (ans == 1) {
                    bool_ans.setText("Wrong!");
                    user_ans.setText("You put: " + "'λ' = λ + h/mc(1 - cos θ)'");
                    correct_ans.setText("Correct Answer: " + "'Therefore, the photon bounces back with an essentially fixed E, independent of the initial E'");
                    total_num.setText("0/1 correct." + "You should try again");
                } else if (ans == 2) {
                    bool_ans.setText("Wrong!");
                    user_ans.setText("You put: " + "'If θ ≈ 0 (that is, not much scattering), then λ'!= λ, as expected.'");
                    correct_ans.setText("Correct Answer: " + "'Therefore, the photon bounces back with an essentially fixed E, independent of the initial E'");
                    total_num.setText("0/1 correct." + "You're WRONG");
                } else if (ans == 3){
                    bool_ans.setText("Correct!");
                    user_ans.setText("You put: " + "'Therefore, the photon bounces back with an essentially fixed E, independent of the initial E'");
                    correct_ans.setText("Correct Answer: " + "'Therefore, the photon bounces back with an essentially fixed E, independent of the initial E'");
                    total_num.setText("1/1 correct." + "You're basically Newton");
                } else {
                    bool_ans.setText("Wrong!");
                    user_ans.setText("You put: " + "'Seriously...?'");
                    correct_ans.setText("Correct Answer: " + "'Therefore, the photon bounces back with an essentially fixed E, independent of the initial E'");
                    total_num.setText("0/1 correct." + "You're disappointing");
                }
            } else {
                if (ans == 1) {
                    bool_ans.setText("Correct!");
                    user_ans.setText("You put: " + "'Ultimate Spiderman'");
                    correct_ans.setText("Correct Answer: " + "'Ultimate Spiderman'");
                    total_num.setText("1/1 correct. " + "You're basically Peter Parker");
                } else if (ans == 2) {
                    bool_ans.setText("Correct!");
                    user_ans.setText("You put: " + "'Hawkeye'");
                    correct_ans.setText("Correct Answer: " + "'Hawkeye'");
                    total_num.setText("1/1 correct." + "Bullseye");
                } else if (ans == 3){
                    bool_ans.setText("Correct!");
                    user_ans.setText("You put: " + "'Inhumans'");
                    correct_ans.setText("Correct Answer: " + "'Inhumans'");
                    total_num.setText("1/1 correct." + "You Mutant!");
                } else {
                    bool_ans.setText("Correct!");
                    user_ans.setText("You put: " + "'all of the above'");
                    correct_ans.setText("Correct Answer: " + "'all of the above'");
                    total_num.setText("1/1 correct." + "This is the true correct answer");
                }
            }

            return rootView;
        }
    }

}
