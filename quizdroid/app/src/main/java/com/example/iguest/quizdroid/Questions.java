package com.example.iguest.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;


public class Questions extends ActionBarActivity {
    public String topic_field = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        // get data that was passed from first activity
        Intent launch = getIntent();
        String topic = launch.getStringExtra("topic");
        topic_field = topic;
        RadioButton q1 = (RadioButton) findViewById(R.id.q1);
        RadioButton q2 = (RadioButton) findViewById(R.id.q2);
        RadioButton q3 = (RadioButton) findViewById(R.id.q3);
        RadioButton q4 = (RadioButton) findViewById(R.id.q4);
        TextView top_question = (TextView) findViewById(R.id.textView);
        if (topic_field.equals("Physics")){
            top_question.setText("A photon collides with a stationary electron. If the photon scatters at an angle θ,\n" +
                    "show that the resulting wavelength, λ' is given in terms of the original wavelength, λ, by\n" +
                    "λ'= λ + (h/mc)(1-cos θ),\n" +
                    "where m is the mass of the electron. Note: The energy of a photon is E = hν = hc/λ.");
            q1.setText("λ' = λ + h/mc(1 - cos θ)");
            q2.setText("If θ ≈ 0 (that is, not much scattering), then λ'" +
                    " != λ, as expected.");
            q3.setText("Therefore, the photon bounces back with an essentially fixed E, independent of the initial E");
            q4.setText("Seriously...?");
        } else if (topic_field.equals("Math")){
            top_question.setText("Determine the best strategy for each player in the following two-player game. There\n" +
                    "are three piles, each of which contains some number of coins. Players alternate turns,\n" +
                    "each turn consisting of removing any (non-zero) number of coins from a single pile.\n" +
                    "The goal is to be the person to remove the last coin(s).");
            q1.setText("If the starting numbers of coins are random, then the player who goes first will\n" +
                    "most likely win,");
            q2.setText("Regardless of how many starting number of coins there are, the player who goes first will win");
            q3.setText("Winning positions are the\n" +
                    "ones that have an even number of 1’s in each column, when written in base 2.");
            q4.setText("What the ...........");
        } else {
            top_question.setText("Which Marvel Comic run is the best?");
            q1.setText("Ultimate Spiderman");
            q2.setText("Hawkeye");
            q3.setText("Inhumans");
            q4.setText("all of the above");
        }

        /*Intent nextActivity = new Intent(Questions.this, Answers.class);


        if (nextActivity.resolveActivity(getPackageManager()) != null) {
            startActivity(nextActivity); // opens a new activity
        }
        // code still runs asynchronously

        finish(); // kill this instance self (this activity)*/
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.q1:
                if (checked) {
                    // Pirates are the best
                    break;
                }
            case R.id.q2:
                if (checked) {
                    // Ninjas rule
                    break;
                }
            case R.id.q3:
                if (checked) {
                    // blah is the blah
                    break;
                }
            case R.id.q4:
                if (checked) {
                    // blah is the blah
                    break;
                }
        }
    }
}
