package com.nareshit.alarmapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText etTimeInSec;
    TextView tvSetAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTimeInSec = (EditText) findViewById(R.id.etTimeinSec);
        tvSetAlarm = (TextView) findViewById(R.id.tvSetAlarm);

        tvSetAlarm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int timeInSec = Integer.parseInt(etTimeInSec.getText().toString());
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent i = new Intent(MainActivity.this, AlarmReciver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 10, i, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + timeInSec, pendingIntent);

    }
}