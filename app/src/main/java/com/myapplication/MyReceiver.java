package com.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {

            // TODO: This method is called when the BroadcastReceiver is receiving
            // an Intent broadcast.
            // throw new UnsupportedOperationException("Not yet implemented");
            Log.v("CHECK", "cassa");
            Intent service1 = new Intent(context, MyAlarmService.class);
            context.startService(service1);
        }



}