package com.nareshit.activitylifecycleapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(getApplicationContext(), "Hi i am From OnCreate()...", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast toast = Toast.makeText(getApplicationContext(), "Hi i am From OnStart()...", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast toast = Toast.makeText(getApplicationContext(), "Hi i am From OnResume()...", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast toast = Toast.makeText(getApplicationContext(), "Hi i am From OnPause()...", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast toast = Toast.makeText(getApplicationContext(), "Hi i am From OnStop()...", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast toast = Toast.makeText(getApplicationContext(), "Hi i am From OnDestroy()...", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast toast = Toast.makeText(getApplicationContext(), "Hi i am From OnRestart()...", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
}
