package com.example.iguest.quizdroid;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Window;

/**
 * Created by iguest on 3/6/15.
 */
public class AppPreferences extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
