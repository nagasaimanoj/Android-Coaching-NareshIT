package com.nareshit.databasedemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nareshit.databasedemo.R;
import com.nareshit.databasedemo.database.DBHandler;

public class NewUserActivity extends Activity implements View.OnClickListener {
    EditText etEMail, etPassword, etPhone, etAddress;
    TextView tvRegister, tvCancel;
    DBHandler dbHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);

        dbHandler = new DBHandler(getApplicationContext());
        etAddress = (EditText) findViewById(R.id.etAddress);
        etEMail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPhone = (EditText) findViewById(R.id.etPhone);

        tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvCancel = (TextView) findViewById(R.id.tvCancel);


        tvRegister.setOnClickListener(this);
        tvCancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tvRegister:

                String email = etEMail.getText().toString();
                String password = etPassword.getText().toString();
                String address = etAddress.getText().toString();
                String phone = etPhone.getText().toString();


                long id = dbHandler.insertStudentRec(email, password, address, phone);
                if (id != -1) {
                    Intent i = new Intent(getApplicationContext(), LoginScreenActivity.class);
                    startActivity(i);
                } else
                    Toast.makeText(getApplicationContext(), "EMail already exsists", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvCancel:


                break;

        }
    }
}