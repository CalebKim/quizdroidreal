package com.example.iguest.quizdroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends ActionBarActivity {
    ListView listView;
    protected QuizApp app;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button setting = (Button) findViewById(R.id.setting);
        stop();
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String url = SP.getString("username", "NA");
        Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        alarmIntent.putExtra("url", url);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);
        annoy();
        setting.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent nextActivity = new Intent(MainActivity.this, AppPreferences.class);
                startActivity(nextActivity);
                //intent starts
                stop();
            }
        });

        //initSingletons();
        app = (QuizApp)getApplication();

        ArrayList<Topic> fullList = new ArrayList<Topic>();
        Log.v("quizdroid", "blah3");
        BufferedReader in = null;

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        ArrayList<Topic> topics = QuizApp.getInstance().getRepo();
        String[] values = new String[topics.size()];

        int i = 0;
        for (Topic v: topics){
            values[i] = v.getTitle();
            i++;
        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);
                if (itemValue.equals("Math")){
                    Intent nextActivity = new Intent(MainActivity.this, Overview.class);
                    // add data to be passed to next activity
                    nextActivity.putExtra("topic", "Math");


                    if (nextActivity.resolveActivity(getPackageManager()) != null) {
                        startActivity(nextActivity);
                    }


                     // suicide

                } else if (itemValue.equals("Physics")) {
                    Intent nextActivity = new Intent(MainActivity.this, Overview.class);
                    // add data to be passed to next activity
                    nextActivity.putExtra("topic", "Physics");


                    if (nextActivity.resolveActivity(getPackageManager()) != null) {
                        startActivity(nextActivity);
                    }

                     // suicide

                } else {
                    Intent nextActivity = new Intent(MainActivity.this, Overview.class);

                    // add data to be passed to next activity
                    nextActivity.putExtra("topic", "Marvel Super Heroes");


                    if (nextActivity.resolveActivity(getPackageManager()) != null) {
                        startActivity(nextActivity);
                    }

                     // suicide

                }

            }

        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String url = SP.getString("username", "NA");
        Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        alarmIntent.putExtra("url", url);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);
        annoy();
    }

    protected void initSingletons()
    {
        // Initialize the instance of MySingleton
        QuizApp.initInstance();
    }

    public void annoy(){
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String url = SP.getString("username", "NA");
        int time = Integer.parseInt(SP.getString("time", "1")); //input time
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
                1000*60*time, pendingIntent);
        Toast.makeText(this, "this is the url: " + url, Toast.LENGTH_SHORT).show();
    }


    public void stop() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
    }

}
