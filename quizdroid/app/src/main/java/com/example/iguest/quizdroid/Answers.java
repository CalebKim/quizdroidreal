package com.example.iguest.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Answers extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        Intent launch = getIntent();
        String topic = launch.getStringExtra("topic");
        int ans = launch.getIntExtra("ans", -1);
        TextView bool_ans = (TextView) findViewById(R.id.bool_ans);
        TextView user_ans = (TextView) findViewById(R.id.user_ans);
        TextView correct_ans = (TextView) findViewById(R.id.correct_ans);
        TextView total_num = (TextView) findViewById(R.id.total_num);
        if (topic.equals("Math")){
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
        } else if (topic.equals("Physics")){
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
        Button b = (Button) findViewById(R.id.button2);

        // On button click Open 2nd activity
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Answers.this, MainActivity.class);

                if (nextActivity.resolveActivity(getPackageManager()) != null) {
                    startActivity(nextActivity);
                }

                finish(); // suicide
            }
        });
    }




}