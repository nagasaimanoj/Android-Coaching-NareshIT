package com.nareshit.telephonymanagerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView tvInfo,tvInfos;
    TelephonyManager telephonyManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.tvInfo);
        tvInfos = (TextView) findViewById(R.id.tvInfos);

        telephonyManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        tvInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {

        String IMEINUM = telephonyManager.getDeviceId();
        String simNo   = telephonyManager.getSimSerialNumber();
        String simOperatorName = telephonyManager.getSimOperatorName();
        String countryISO = telephonyManager.getSimCountryIso();
        String voiceNumber = telephonyManager.getVoiceMailNumber();

        StringBuilder sb = new StringBuilder();
        sb.append("IMEINum ::"+IMEINUM);
        sb.append("\n");
        sb.append("SimNo   ::"+simNo);
        sb.append("\n");
        sb.append("SimName ::"+simOperatorName);
        sb.append("\n");
        sb.append("CISO    ::"+countryISO);
        sb.append("\n");
        sb.append("VNumber ::"+voiceNumber);
        sb.append("\n");

        String info = sb.toString();
        tvInfos.setText(info);



    }
}
