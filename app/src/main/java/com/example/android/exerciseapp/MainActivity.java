package com.example.android.exerciseapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mInputText = (TextView) findViewById(R.id.input_tv);

        String InputMessage = mInputText.getText().toString();

        MyIntentService.startActionFoo(this, InputMessage);

        IntentFilter intentFilter = new IntentFilter(MyReceiver.ACTION_RESP);

        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);

        myReceiver = new MyReceiver();

        registerReceiver(myReceiver, intentFilter);


    }
    

    public class MyReceiver extends BroadcastReceiver {
        public static final String ACTION_RESP =
                "com.mamlambo.intent.action.MESSAGE_PROCESSED";
        @Override
        public void onReceive(Context context, Intent intent) {

            TextView resultView = (TextView) findViewById(R.id.output_tv);
            String resultMessage = intent.getStringExtra(MyIntentService.INTENT_OUT_PARAM);
            resultView.setText(resultMessage);
            // TODO: This method is called when the BroadcastReceiver is receiving
            // an Intent broadcast.
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
}
