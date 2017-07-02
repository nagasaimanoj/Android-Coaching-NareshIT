package com.nareshit.servicelifecycledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btnPlay;
    boolean isPlaying = false;
    String str = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent songIntent = new Intent(MainActivity.this, MyService.class);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        str = "Play";
        btnPlay.setText(str);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    stopService(songIntent);
                    str = "Play";
                    btnPlay.setText(str);
                    isPlaying = false;
                } else {
                    startService(songIntent);
                    str = "Stop";
                    btnPlay.setText(str);
                    isPlaying = true;
                }
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        final Intent songIntent = new Intent(MainActivity.this, MyService.class);
        stopService(songIntent);
    }

}