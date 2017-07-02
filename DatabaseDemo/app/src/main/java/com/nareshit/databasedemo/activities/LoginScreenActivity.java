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

public class LoginScreenActivity extends Activity implements View.OnClickListener {
    EditText etEmail, etPassword;
    TextView tvLogin, tvCancel, tvNewUser;

    DBHandler dbHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHandler = new DBHandler(getApplicationContext());
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvCancel = (TextView) findViewById(R.id.tvCancel);
        tvNewUser = (TextView) findViewById(R.id.tvNewUser);

        tvLogin.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
        tvNewUser.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tvLogin:

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                boolean val = dbHandler.loginCrediantials(email, password);
                if (val) {
                    Intent i = new Intent(getApplicationContext(), DashBoardActivity.class);
                    startActivity(i);
                } else
                    Toast.makeText(getApplicationContext(), "Email/password is Failed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvCancel:

                etPassword.getText().clear();
                etEmail.getText().clear();

                break;
            case R.id.tvNewUser:

                Intent i = new Intent(getApplicationContext(), NewUserActivity.class);
                startActivity(i);

                break;


        }
    }
}
