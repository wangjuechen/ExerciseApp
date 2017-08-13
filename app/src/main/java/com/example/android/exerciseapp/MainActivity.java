package com.example.android.exerciseapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements InputFragment.OnFragmentInteractionListener,
ShareActionProvider.OnShareTargetSelectedListener{

    private InputFragment inputFragment;
    private ResultFragment resultFragment;
    private ShareActionProvider mShareActionProvider = null;

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
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.share_action_menu, menu);

        MenuItem item = menu.findItem(R.id.menu_share_action);

        mShareActionProvider  = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        mShareActionProvider.setOnShareTargetSelectedListener(this);

        return (super.onCreateOptionsMenu(menu));
    }

    private void setShareIntent(Intent shareIntent) {
        if(mShareActionProvider != null){
            mShareActionProvider.setShareIntent(shareIntent);
        }
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

    @Override
    public boolean onShareTargetSelected(ShareActionProvider source, Intent intent) {
        return false;
    }
}
