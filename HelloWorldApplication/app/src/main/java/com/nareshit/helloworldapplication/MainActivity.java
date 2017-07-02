package com.nareshit.helloworldapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity implements View.OnClickListener {
    //Declaration of View Components
    Button btnShow;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //To Create Empty Window
        setContentView(R.layout.activity_main);
        // Load Ur XML

        btnShow = (Button) findViewById(R.id.btnShow);
        tvName = (TextView) findViewById(R.id.tvName);
        btnShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = tvName.getText().toString();
        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
    }
}