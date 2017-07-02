package com.nareshit.textinputlayoutdesignapp;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvLogin;
    TextInputLayout tilUserName,tilPassword,tilAddress;
    EditText etUserName,etPassword,etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLogin = (TextView) findViewById(R.id.tvLogin);
        etAddress = (EditText) findViewById(R.id.etAddress);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);

        tilUserName = (TextInputLayout) findViewById(R.id.tilUserName);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        tilAddress = (TextInputLayout) findViewById(R.id.tilAddress);

        tvLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (etUserName.getText().toString().trim().isEmpty())
        {
            tilUserName.setError("Please enter UserName");
        }
        if (etPassword.getText().toString().trim().isEmpty())
        {
            tilPassword.setError("please enter Password");
        }
    }
}
