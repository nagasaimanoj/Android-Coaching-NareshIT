package com.nareshit.studentmarksdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
 * Created by Manikanta on 7/25/2016.
 */
public class ResultActivity extends Activity implements View.OnClickListener {
    TextView tvGrade, tvAverage;
    int m1, m2, m3, total;
    float avg;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_result_layout);

        tvAverage = (TextView) findViewById(R.id.tvAverage);
        tvGrade = (TextView) findViewById(R.id.tvGrade);

        b = getIntent().getExtras();
        m1 = b.getInt("m1");
        m2 = b.getInt("m2");
        m3 = b.getInt("m3");
        total = b.getInt("total");
        avg = total / 3;
        tvAverage.setText("" + avg);
        tvGrade.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();

        if (m1 >= 35 && m2 >= 35 && m3 >= 35) {

            if (avg >= 75) {
                i.putExtra("Result", "DISTINCTION");
            } else if (avg >= 60) {
                i.putExtra("Result", "FIRST CLASS");
            } else if (avg >= 50) {
                i.putExtra("Result", "SECOND CLASS");
            } else if (avg >= 40) {
                i.putExtra("Result", "THIRD CLASS");
            } else {
                i.putExtra("Result", "Pass");
            }
        } else {
            i.putExtra("Result", "Govindha Govindha");
        }
        setResult(2, i);
        finish();
    }
}
