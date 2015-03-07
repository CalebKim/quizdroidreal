package com.example.iguest.quizdroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by iguest on 3/6/15.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive (Context context, Intent intent) {
        String url = intent.getStringExtra("url");
        Toast.makeText(context, "this is the url: " + url, Toast.LENGTH_SHORT).show();
    }
}
