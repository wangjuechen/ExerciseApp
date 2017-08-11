package com.example.android.exerciseapp;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentInteractionListener {

    private InputFragment inputFragment;
    private ResultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = new InputFragment();

        resultFragment = new ResultFragment();

        if (savedInstanceState != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, inputFragment)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_content_container, resultFragment)
                .commit();

    }

    @Override
    public void onFragmentInteraction(String text) {
       String sendingMessage = text + SystemClock.currentThreadTimeMillis();

        resultFragment = new ResultFragment();

        Bundle bundle = new Bundle();

        bundle.putString(resultFragment.ARG_BUNDLE,sendingMessage);

        resultFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_content_container, resultFragment)
                .commit();
    }
}
