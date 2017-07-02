package com.nareshit.intents_explicit_intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Manikanta on 7/22/2016.
 */
public class NextActivity extends Activity implements View.OnClickListener {
    TextView tvBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        tvBack = (TextView) findViewById(R.id.tvBack);
        tvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(NextActivity.this,MainActivity.class);
        startActivity(i);

    }
}
