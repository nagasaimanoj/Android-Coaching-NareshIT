package com.nareshit.databasedemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nareshit.databasedemo.R;
import com.nareshit.databasedemo.database.DBHandler;

public class UpdateActivity extends Activity implements View.OnClickListener {
    EditText etEmail, etPhone, etAddress;
    TextView tvShow, tvUpdate;
    SQLiteDatabase db = null;
    DBHandler dbHandler = null;
    LinearLayout llData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        llData = (LinearLayout) findViewById(R.id.llData);
        dbHandler = new DBHandler(getApplicationContext());
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddress = (EditText) findViewById(R.id.etAddress);

        tvShow = (TextView) findViewById(R.id.tvShow);
        tvUpdate = (TextView) findViewById(R.id.tvUpdate);

        tvShow.setOnClickListener(this);
        tvUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tvShow:

                llData.setVisibility(View.VISIBLE);
                String email = etEmail.getText().toString();
                getDataFromDB(email);

                break;
            case R.id.tvUpdate:

                String phone = etPhone.getText().toString();
                String emails = etEmail.getText().toString();
                String addresses = etAddress.getText().toString();

                long id = dbHandler.updateRec(emails, phone, addresses);

                if (id != -1) {
                    Intent i = new Intent(getApplicationContext(), DashBoardActivity.class);
                    startActivity(i);
                } else
                    Toast.makeText(getApplicationContext(), "Rec Not Updated", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void getDataFromDB(String email) {


        db = dbHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Student where email=?", new String[]{email});
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                String phone = cursor.getString(cursor.getColumnIndex("phone"));
                String address = cursor.getString(cursor.getColumnIndex("address"));
                etPhone.setText(phone);
                etAddress.setText(address);
            }
        }

    }
}
