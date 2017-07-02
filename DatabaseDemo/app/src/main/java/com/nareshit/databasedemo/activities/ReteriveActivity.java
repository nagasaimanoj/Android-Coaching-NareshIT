package com.nareshit.databasedemo.activities;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nareshit.databasedemo.R;
import com.nareshit.databasedemo.database.DBHandler;

public class ReteriveActivity extends Activity implements View.OnClickListener {
    EditText etEMail;
    TextView tvShow;
    DBHandler dbHandler = null;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reterive);

        dbHandler = new DBHandler(getApplicationContext());
        etEMail = (EditText) findViewById(R.id.etEmail);
        tvShow = (TextView) findViewById(R.id.tvShow);

        tvShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String email = etEMail.getText().toString();
        getDataFromDB(email);
    }

    private void getDataFromDB(String email) {
        db = dbHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Student where email=?", new String[]{email});
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String password = cursor.getString(cursor.getColumnIndex("password"));
                String phone = cursor.getString(cursor.getColumnIndex("phone"));
                String address = cursor.getString(cursor.getColumnIndex("address"));
                Toast.makeText(getApplicationContext(), "Password ::" + password + "\n Phone ::" + phone + "\n Address ::" + address, Toast.LENGTH_SHORT).show();
            }
        }

    }
}
