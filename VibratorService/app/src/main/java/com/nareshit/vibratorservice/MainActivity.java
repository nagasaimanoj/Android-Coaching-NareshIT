package com.nareshit.vibratorservice;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etTimeInSec;
    TextView tvVibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvVibrate = (TextView) findViewById(R.id.tvVibrate);
        etTimeInSec = (EditText) findViewById(R.id.etTimeinSec);
        tvVibrate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int timeInSec = Integer.parseInt(etTimeInSec.getText().toString());
        long mSec = timeInSec * 1000;
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(mSec);
        Toast.makeText(getApplicationContext(), "Vibrator Starts", Toast.LENGTH_SHORT).show();
    }
}