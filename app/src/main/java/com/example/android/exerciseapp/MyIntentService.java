package com.example.android.exerciseapp;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.android.exerciseapp.action.FOO";
    private static final String ACTION_BAZ = "com.example.android.exerciseapp.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.android.exerciseapp.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.android.exerciseapp.extra.PARAM2";

    public static final String INTENT_IN_PARAM = "intent_in_param";
    public static final String INTENT_OUT_PARAM = "intent_out_param";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(INTENT_OUT_PARAM, param1);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String message = intent.getStringExtra(INTENT_IN_PARAM);

            String outputMessage = message + SystemClock.currentThreadTimeMillis();

            Intent intent1 = new Intent();

            intent1.setAction(MainActivity.MyReceiver.ACTION_RESP);

            intent1.putExtra(INTENT_OUT_PARAM, outputMessage);

            sendBroadcast(intent1);

        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
