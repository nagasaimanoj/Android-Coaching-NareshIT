package com.nareshit.sharedpreferencedemoapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {


    //To Share
    SharedPreferences sharedPreferences;
    //Save
    SharedPreferences.Editor editor;


    EditText etFirstName, etAge, etAddress;
    TextView tvNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("prefName", MODE_APPEND);
        editor = sharedPreferences.edit();


        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etAge = (EditText) findViewById(R.id.etAge);
        tvNext = (TextView) findViewById(R.id.tvNext);


        tvNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String fName = etFirstName.getText().toString();
        String age = etAge.getText().toString();
        String address = etAddress.getText().toString();

        editor.putString("fName", fName);
        editor.putString("age", age);
        editor.putString("address", address);
        editor.commit();

        Intent i = new Intent(getApplicationContext(), NextActivity.class);
        startActivity(i);
    }
}