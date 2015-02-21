package com.example.iguest.quizdroid;

import android.app.Application;
import android.util.Log;

/**
 * Created by iguest on 2/20/15.
 */
public class QuizApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("quizdroid", "this ish be working");
    }

}
