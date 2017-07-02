package com.nareshit.studentmarksdata;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText etMarksOne, etMarksTwo, etMarksThree;
    TextView tvGrade, tvTotal, tvSubmit;
    int m1, m2, m3, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeViewControls();
    }

    private void intializeViewControls() {

        etMarksOne = (EditText) findViewById(R.id.etMarksOne);
        etMarksTwo = (EditText) findViewById(R.id.etMarksTwo);
        etMarksThree = (EditText) findViewById(R.id.etMarksThree);
        tvSubmit = (TextView) findViewById(R.id.tvSubmit);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
        tvGrade = (TextView) findViewById(R.id.tvGrade);
        tvSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        m1 = Integer.parseInt(etMarksOne.getText().toString());
        m2 = Integer.parseInt(etMarksTwo.getText().toString());
        m3 = Integer.parseInt(etMarksThree.getText().toString());
        total = m1 + m2 + m3;
        tvTotal.setText("" + total);


        new Thread() {

            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                    Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                    i.putExtra("m1", m1);
                    i.putExtra("m2", m2);
                    i.putExtra("m3", m3);
                    i.putExtra("total", total);
                    startActivityForResult(i, 1001);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001 && resultCode == 2) {
            Bundle b = data.getExtras();
            String result = b.getString("Result");

            if (result.equals("Govindha Govindha")) {
                tvGrade.setVisibility(View.VISIBLE);
                tvGrade.setText("" + result);
                tvGrade.setBackgroundColor(Color.RED);

            } else {

                tvGrade.setVisibility(View.VISIBLE);
                tvGrade.setText("" + result);
                tvGrade.setBackgroundColor(Color.GREEN);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}