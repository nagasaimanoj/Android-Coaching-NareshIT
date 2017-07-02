package com.nareshit.databasedemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.nareshit.databasedemo.R;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread() {

            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                    Intent i = new Intent(getApplicationContext(), LoginScreenActivity.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
