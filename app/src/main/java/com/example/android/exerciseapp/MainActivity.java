package com.example.android.exerciseapp;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlankFragment myFragment = new BlankFragment();

        if(savedInstanceState != null){
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, myFragment)
                .commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
