package com.example.android.exerciseapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivePreferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_preference);

        TextView prefMessage = (TextView) findViewById(R.id.tv_receivedPref);

        SharedPreferences sharedPreferences = getSharedPreferences(ResultFragment.PREF_NAME, MODE_PRIVATE);

        String message = sharedPreferences.getString(ResultFragment.PREF_ARG, null);

        prefMessage.setText(message);

    }
}
