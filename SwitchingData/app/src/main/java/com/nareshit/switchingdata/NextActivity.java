package com.nareshit.switchingdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NextActivity extends Activity implements View.OnClickListener {
    TextView tvUserName,tvAddress,tvPhone,tvBack;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_next);
        intializeViewControls();

        b = getIntent().getExtras();
        String userName = b.getString("userName");
        String address  = b.getString("address");
        String phone    = b.getString("phone");

        tvUserName.setText(userName);
        tvAddress.setText(address);
        tvPhone.setText(phone);
    }

    private void intializeViewControls() {

        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvBack = (TextView) findViewById(R.id.tvBack);

        tvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(NextActivity.this,MainActivity.class);
        startActivity(i);
    }
}