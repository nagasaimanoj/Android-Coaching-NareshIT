package com.nareshit.alarmapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Time is Up....Please AwakeUp", Toast.LENGTH_SHORT).show();

    }
}