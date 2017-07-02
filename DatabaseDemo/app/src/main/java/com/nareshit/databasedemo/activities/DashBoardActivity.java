package com.nareshit.databasedemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nareshit.databasedemo.R;

public class DashBoardActivity extends Activity implements View.OnClickListener {
    TextView tvRetrieve, tvUpdate, tvLUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tvRetrieve = (TextView) findViewById(R.id.tvReterive);
        tvRetrieve.setOnClickListener(this);

        tvUpdate = (TextView) findViewById(R.id.tvUpdate);
        tvUpdate.setOnClickListener(this);

        tvLUsers = (TextView) findViewById(R.id.tvLUsers);
        tvLUsers.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.tvReterive:
                Intent retAct = new Intent(getApplicationContext(), ReteriveActivity.class);
                startActivity(retAct);
                break;

            case R.id.tvUpdate:
                Intent updAct = new Intent(getApplicationContext(), UpdateActivity.class);
                startActivity(updAct);
                break;

            case R.id.tvLUsers:
                Intent userActivity = new Intent(getApplicationContext(), UsersActivity.class);
                startActivity(userActivity);
                break;
        }
    }
}