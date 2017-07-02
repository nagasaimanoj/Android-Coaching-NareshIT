package com.nareshit.guicomponents_parttwo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SampleActivity extends Activity implements View.OnClickListener {
    Spinner spVersionNames;
    TextView tvShow;
    String versionNames[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gui_part_two);

        spVersionNames = (Spinner) findViewById(R.id.spVersionNames);
        tvShow = (TextView) findViewById(R.id.tvShow);
        versionNames = getResources().getStringArray(R.array.version_names);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SampleActivity.this,android.R.layout.simple_spinner_item,versionNames);
        spVersionNames.setAdapter(adapter);
        tvShow.setOnClickListener(this);


    }

    @Override
    public void onClick(View view)
    {
        String versionName = spVersionNames.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(),"U Selected"+versionName,Toast.LENGTH_SHORT).show();
    }
}
