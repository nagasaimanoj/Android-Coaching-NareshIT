package com.nareshit.databasedemo.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nareshit.databasedemo.Adapters.StudentAdapter;
import com.nareshit.databasedemo.R;
import com.nareshit.databasedemo.database.DBHandler;
import com.nareshit.databasedemo.utils.Student;

import java.util.ArrayList;

public class UsersActivity extends Activity {

    ArrayList<Student> studentArrayList;
    SQLiteDatabase db = null;
    DBHandler dbHandler = null;
    ListView lvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        lvUsers = (ListView) findViewById(R.id.lvUsers);
        studentArrayList = new ArrayList<Student>();
        dbHandler = new DBHandler(getApplicationContext());
        getDataFromDB();
        StudentAdapter adapter = new StudentAdapter(UsersActivity.this, studentArrayList);
        lvUsers.setAdapter(adapter);

        lvUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String email = studentArrayList.get(i).getEmail();
                AlertDialog.Builder adb = new AlertDialog.Builder(UsersActivity.this);
                adb.setIcon(R.mipmap.ic_launcher);
                adb.setTitle("Delete Rec");
                adb.setMessage("Do you want to Delete this" + email + "Record");
                adb.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        long id = dbHandler.deleteRec(email);

                        if (id != -1) {
                            Intent i1 = new Intent(getApplicationContext(), DashBoardActivity.class);
                            startActivity(i1);
                        }
                    }
                });
                adb.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });
                adb.show();

            }
        });
    }

    private void getDataFromDB() {

        db = dbHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Student", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Student student = new Student();
                    student.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                    student.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
                    student.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                    studentArrayList.add(student);

                } while (cursor.moveToNext());
            }
        }
    }
}
