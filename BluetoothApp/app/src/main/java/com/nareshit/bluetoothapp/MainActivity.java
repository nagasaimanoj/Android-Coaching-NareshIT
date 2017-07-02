package com.nareshit.bluetoothapp;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView tvTurnOn,tvDiscoverable,tvTurnOff;
    BluetoothAdapter bluetoothAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        tvTurnOn = (TextView) findViewById(R.id.tvTurnOn);
        tvDiscoverable = (TextView) findViewById(R.id.tvDisCoverable);
        tvTurnOff = (TextView) findViewById(R.id.tvTurnOff);

        tvTurnOn.setOnClickListener(this);
        tvDiscoverable.setOnClickListener(this);
        tvTurnOff.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.tvTurnOn:

                Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableIntent,111);

                break;
            case R.id.tvDisCoverable:

                Intent dicoverIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(dicoverIntent,112);
                break;
            case R.id.tvTurnOff:

                bluetoothAdapter.disable();
                break;

        }
    }
}
