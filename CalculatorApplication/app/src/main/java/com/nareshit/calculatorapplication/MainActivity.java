package com.nareshit.calculatorapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Declaration
    EditText etFirstNumber, etSecondNumber;
    TextView tvResult;
    Button btnAdd, btnSub, btnMul, btnDiv, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeViewControls();
    }

    private void intializeViewControls() {

        etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String firstNumber = etFirstNumber.getText().toString();
        String secondNumber = etSecondNumber.getText().toString();

        int fNum = Integer.parseInt(firstNumber);
        int sNum = Integer.parseInt(secondNumber);
        int result = 0;


        switch (v.getId()) {

            case R.id.btnAdd:
                result = fNum + sNum;
                tvResult.setText("" + result);
                break;

            case R.id.btnSub:
                result = fNum - sNum;
                tvResult.setText("" + result);
                break;

            case R.id.btnMul:
                result = fNum * sNum;
                tvResult.setText("" + result);
                break;

            case R.id.btnDiv:
                float fNumber = Float.parseFloat(firstNumber);
                float sNumber = Float.parseFloat(secondNumber);
                float res = 0.0f;
                res = fNumber / sNumber;
                tvResult.setText("" + res);
                break;

            case R.id.btnClear:
                etFirstNumber.getText().clear();
                etSecondNumber.getText().clear();
                tvResult.setText("");
                break;
        }

    }
}