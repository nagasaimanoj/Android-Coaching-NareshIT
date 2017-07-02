package com.nareshit.smsmanagerapp;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText etMobileNumber,etMessage;
    TextView tvSend;
    SmsManager smsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smsManager = SmsManager.getDefault();
        etMessage = (EditText) findViewById(R.id.etMessage);
        etMobileNumber = (EditText) findViewById(R.id.etMobileNumber);
        tvSend  = (TextView) findViewById(R.id.tvSend);
        tvSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String mobileNumber = etMobileNumber.getText().toString();
        String message = etMessage.getText().toString();

        try
        {

            smsManager.sendTextMessage(mobileNumber,null,message,null,null);
            Toast.makeText(getApplicationContext(),"SMS Sent",Toast.LENGTH_SHORT).show();

        }
        catch (Exception e)
        {

            Toast.makeText(getApplicationContext(),"SMS Failed",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}
