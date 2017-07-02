package com.nareshit.dialogdesigning;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView tvAlertDialog, tvInputDialog, tvDatePicker, tvTimePicker, tvProgressDialog;
    Calendar calendar;
    int year, month, date, hour, min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = Calendar.getInstance();

        tvAlertDialog = (TextView) findViewById(R.id.tvAlertDialog);
        tvInputDialog = (TextView) findViewById(R.id.tvInputDialog);
        tvDatePicker = (TextView) findViewById(R.id.tvDatePicker);
        tvTimePicker = (TextView) findViewById(R.id.tvTimePicker);
        tvProgressDialog = (TextView) findViewById(R.id.tvProgressDialog);

        tvProgressDialog.setOnClickListener(this);
        tvAlertDialog.setOnClickListener(this);
        tvTimePicker.setOnClickListener(this);
        tvInputDialog.setOnClickListener(this);
        tvDatePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder adb;
        switch (view.getId()) {
            case R.id.tvAlertDialog:

                adb = new AlertDialog.Builder(MainActivity.this);
                adb.setIcon(R.mipmap.ic_launcher);
                adb.setTitle("This is My AlertDialog Box");
                adb.setMessage("Do you want to Continue or Not");

                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent contactItnet = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
                        startActivity(contactItnet);
                    }
                });

                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                adb.show();
                break;


            case R.id.tvInputDialog:

                adb = new AlertDialog.Builder(MainActivity.this);
                adb.setIcon(R.mipmap.ic_launcher);
                adb.setTitle("This is My InputDialog Box");
                final EditText etInput = new EditText(MainActivity.this);
                etInput.setHint("Please Enter UserName");
                adb.setView(etInput);
                adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String userName = etInput.getText().toString();
                        Toast.makeText(getApplicationContext(), "UserName ::" + userName, Toast.LENGTH_SHORT).show();
                    }
                });

                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                adb.show();
                break;

            case R.id.tvDatePicker:
                DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int years, int months, int dates) {
                        year = years;
                        month = months + 1;
                        date = dates;

                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(year);
                        stringBuilder.append("-");
                        stringBuilder.append(month);
                        stringBuilder.append("-");
                        stringBuilder.append(date);

                        Toast.makeText(getApplicationContext(), stringBuilder.toString(), Toast.LENGTH_SHORT).show();


                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
                dpd.show();
                break;
            case R.id.tvTimePicker:
                TimePickerDialog tpd = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hours, int mins) {
                        hour = hours;
                        min = mins;
                        Toast.makeText(getApplicationContext(), "Hours" + hour + ":" + "Minutes" + min, Toast.LENGTH_SHORT).show();
                    }
                }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), false);
                tpd.show();
                break;
            case R.id.tvProgressDialog:

                final ProgressDialog pd = new ProgressDialog(MainActivity.this);
                pd.setMessage("Please wait your results is Proccesing....");
                pd.setCancelable(false);

                new Thread() {

                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(2000);
                            if (pd.isShowing())
                                pd.dismiss();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

                pd.show();
                break;
        }
    }
}
