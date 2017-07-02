package com.nareshit.debugfiedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etAge;
    TextView tvVote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAge = (EditText) findViewById(R.id.etAge);
        tvVote = (TextView) findViewById(R.id.tvVote);

        tvVote.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int age = Integer.parseInt(etAge.getText().toString());

        if (age>=18)
        {
            Toast.makeText(getApplicationContext(),"ELegible for Vote",Toast.LENGTH_SHORT).show();
        }
        else

            Toast.makeText(getApplicationContext(),"Not ELegible for Vote",Toast.LENGTH_SHORT).show();
    }
}
