package com.nareshit.sharedpreferencedemoapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class ResultActivity extends Activity {
    SharedPreferences sp;
    EditText etFirstName, etAddress, etAge, etPhone, etEMail, etDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_result);

        sp = getSharedPreferences("prefName", MODE_APPEND);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etAge = (EditText) findViewById(R.id.etAge);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEMail = (EditText) findViewById(R.id.etEMail);
        etDes = (EditText) findViewById(R.id.etDes);

        String fName = sp.getString("fName", null);
        String address = sp.getString("address", null);
        String age = sp.getString("age", null);
        String phone = sp.getString("phone", null);
        String email = sp.getString("email", null);
        String des = sp.getString("des", null);

        etFirstName.setText(fName);
        etAddress.setText(address);
        etAge.setText(age);
        etEMail.setText(email);
        etPhone.setText(phone);
        etDes.setText(des);
    }
}