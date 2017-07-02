package com.nareshit.snackbarappdemo;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvSubmit;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        tvSubmit = (TextView) findViewById(R.id.tvSubmit);
        tvSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Snackbar.make(coordinatorLayout,"Please Enter the Fields",Snackbar.LENGTH_SHORT).show();
    }
}
