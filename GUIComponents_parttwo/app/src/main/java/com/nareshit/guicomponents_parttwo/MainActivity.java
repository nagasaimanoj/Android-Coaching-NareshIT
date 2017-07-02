package com.nareshit.guicomponents_parttwo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    RadioButton rbMale,rbFemale,rbOthers;
    CheckBox cbAndroid,cbIOS,cbWindows;
    TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbAndroid = (CheckBox) findViewById(R.id.cbAndroid);
        cbIOS = (CheckBox) findViewById(R.id.cbIos);
        cbWindows = (CheckBox) findViewById(R.id.cbWindows);


        rbMale = (RadioButton) findViewById(R.id.rbMale);
        rbFemale = (RadioButton) findViewById(R.id.rbFeMale);
        rbOthers = (RadioButton) findViewById(R.id.rbOthers);

        tvShow = (TextView) findViewById(R.id.tvShow);

        tvShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {

        if (rbMale.isChecked())
        {
            Toast.makeText(getApplicationContext(),"U Selected"+rbMale.getText().toString(),Toast.LENGTH_SHORT).show();
        }
        else if (rbFemale.isChecked())
        {
            Toast.makeText(getApplicationContext(),"U Selected"+rbFemale.getText().toString(),Toast.LENGTH_SHORT).show();
        }
        else if (rbOthers.isChecked())
        {
            Toast.makeText(getApplicationContext(),"U Selected"+rbOthers.getText().toString(),Toast.LENGTH_SHORT).show();
        }





        /*if (cbAndroid.isChecked())
        {
            Toast.makeText(getApplicationContext(),cbAndroid.getText().toString(),Toast.LENGTH_SHORT).show();
        }
        if (cbIOS.isChecked())
        {
            Toast.makeText(getApplicationContext(),cbIOS.getText().toString(),Toast.LENGTH_SHORT).show();
        }
        if (cbWindows.isChecked())
        {
            Toast.makeText(getApplicationContext(),cbWindows.getText().toString(),Toast.LENGTH_SHORT).show();
        }

*/


    }
}
