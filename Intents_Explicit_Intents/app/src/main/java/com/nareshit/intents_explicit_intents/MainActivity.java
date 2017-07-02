package com.nareshit.intents_explicit_intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView tvNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNext = (TextView) findViewById(R.id.tvNext);
        tvNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(MainActivity.this,NextActivity.class);
        startActivity(i);
    }
}
