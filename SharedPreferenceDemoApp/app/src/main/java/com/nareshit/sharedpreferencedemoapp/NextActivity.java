package com.nareshit.sharedpreferencedemoapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends Activity implements View.OnClickListener {
    EditText etPhone, etEMail, etDes;
    TextView tvSubmit;
    SharedPreferences sf;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        sf = getSharedPreferences("prefName", MODE_APPEND);
        editor = sf.edit();
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEMail = (EditText) findViewById(R.id.etEMail);
        etDes = (EditText) findViewById(R.id.etDes);
        tvSubmit = (TextView) findViewById(R.id.tvSubmit);

        tvSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String email = etEMail.getText().toString();
        String phone = etPhone.getText().toString();
        String des = etDes.getText().toString();

        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("des", des);
        editor.commit();

        Intent i = new Intent(getApplicationContext(), ResultActivity.class);
        startActivity(i);
    }
}
