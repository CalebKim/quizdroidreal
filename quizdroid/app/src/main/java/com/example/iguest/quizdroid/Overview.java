package com.example.iguest.quizdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;


public class Overview extends ActionBarActivity {
    public String topic_field = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        // Get the Intent that opened this activity
        // get data that was passed from first activity
        Intent launch = getIntent();
        String topic = launch.getStringExtra("topic");
        topic_field = topic;
        // set the text of the topic.
        TextView top_title = (TextView) findViewById(R.id.topic_title);
        top_title.setText(topic);
        //set description of topic.
        TextView overview_desc = (TextView) findViewById(R.id.overview_desc);
        if (topic.equals("Math")){
            overview_desc.setText("Math. The only pure field of study in our society.  Archimedes, Gauss, Euler, Erdos.  " +
                    "These fathers of mathematics produced the foundation to our understanding of the universe. " +
                    "Truly a topic worthy of such a prestigious quiz app. 1 question");
        } else if (topic.equals("Physics")){
            overview_desc.setText("With every action there is an equal and opposite reaction.  " +
                    "Newton stood on the 'shoulders of giants' to produce illuminating work that contributed to our ability" +
                    "to comprehend where we are in the universe." +
                    "  Our pale blue dot is simply a speck in the ocean of galaxies.  Physics allowed us to look out and " +
                    "see what is beyond our atmosphere.  Physics is a field that earns its place in time and on our universally" +
                    " successful quiz app. 1 question");
        } else {
            overview_desc.setText("Founded in 1939. Responsible for Spiderman. 1 question" );
        }


        Button b = (Button) findViewById(R.id.overview_next_button);

        // On button click Open 2nd activity
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(Overview.this, Questions.class);

                // add data to be passed to next activity
                nextActivity.putExtra("topic", topic_field);


                if (nextActivity.resolveActivity(getPackageManager()) != null) {
                    startActivity(nextActivity);
                }

                finish(); // suicide
            }
        });
    }
}
