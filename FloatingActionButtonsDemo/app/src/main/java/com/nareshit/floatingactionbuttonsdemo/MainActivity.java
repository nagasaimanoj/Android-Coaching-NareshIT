package com.nareshit.floatingactionbuttonsdemo;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabSubmit = (FloatingActionButton) findViewById(R.id.fabSubmit);


        fabSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent contact = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
                startActivity(contact);
            }
        });
    }
}
