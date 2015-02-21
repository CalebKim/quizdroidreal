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
            TextView overview_desc = (TextView) rootView.findViewById(R.id.overview_desc);
            if (topic_field.equals("Math")){
                overview_desc.setText("Math. The only pure field of study in our society.  Archimedes, Gauss, Euler, Erdos.  " +
                        "These fathers of mathematics produced the foundation to our understanding of the universe. " +
                        "Truly a topic worthy of such a prestigious quiz app. 1 question");
            } else if (topic_field.equals("Physics")){
                overview_desc.setText("With every action there is an equal and opposite reaction.  " +
                        "Newton stood on the 'shoulders of giants' to produce illuminating work that contributed to our ability" +
                        "to comprehend where we are in the universe." +
                        "  Our pale blue dot is simply a speck in the ocean of galaxies.  Physics allowed us to look out and " +
                        "see what is beyond our atmosphere.  Physics is a field that earns its place in time and on our universally" +
                        " successful quiz app. 1 question");
            } else {
                overview_desc.setText("Founded in 1939. Responsible for Spiderman. 1 question" );
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
                top_question.setText("A photon collides with a stationary electron. If the photon scatters at an angle θ,\n" +
                        "show that the resulting wavelength, λ' is given in terms of the original wavelength, λ, by\n" +
                        "λ'= λ + (h/mc)(1-cos θ),\n" +
                        "where m is the mass of the electron. Note: The energy of a photon is E = hν = hc/λ.");
                q1.setText("λ' = λ + h/mc(1 - cos θ)");
                q2.setText("If θ ≈ 0 (that is, not much scattering), then λ'!= λ, as expected.");
                q3.setText("Therefore, the photon bounces back with an essentially fixed E, independent of the initial E");
                q4.setText("Seriously...?");
            } else if (topic_field.equals("Math")){
                top_question.setText("Determine the best strategy for each player in the following two-player game. There\n" +
                        "are three piles, each of which contains some number of coins. Players alternate turns,\n" +
                        "each turn consisting of removing any (non-zero) number of coins from a single pile.\n" +
                        "The goal is to be the person to remove the last coin(s).");
                q1.setText("If the starting numbers of coins are random, then the player who goes first will\n" +
                        "most likely win,");
                q2.setText("Winning positions are the\n" +
                        "ones that have an even number of 1’s in each column, when written in base 2.");
                q3.setText("Regardless of how many starting number of coins there are, the player who goes first will win");
                q4.setText("What the ...........");
            } else {
                top_question.setText("Which Marvel Comic run is the best?");
                q1.setText("Ultimate Spiderman");
                q2.setText("Hawkeye");
                q3.setText("Inhumans");
                q4.setText("all of the above");
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
