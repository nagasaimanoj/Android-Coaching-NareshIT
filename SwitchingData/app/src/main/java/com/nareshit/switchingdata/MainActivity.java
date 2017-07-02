package com.nareshit.switchingdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText etUserName, etAddress, etPhoneNumber;
    TextView tvSubmit, tvCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intializeViewControls();
    }

    private void intializeViewControls() {

        etUserName = (EditText) findViewById(R.id.etUserName);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
        tvSubmit = (TextView) findViewById(R.id.tvSubmit);
        tvCancel = (TextView) findViewById(R.id.tvCancel);

        tvSubmit.setOnClickListener(this);
        tvCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String userName = etUserName.getText().toString();
        String address = etAddress.getText().toString();
        String phone = etPhoneNumber.getText().toString();

        Intent mainAct = new Intent(MainActivity.this, NextActivity.class);
        mainAct.putExtra("userName", userName);
        mainAct.putExtra("address", address);
        mainAct.putExtra("phone", phone);
        startActivity(mainAct);
    }
}