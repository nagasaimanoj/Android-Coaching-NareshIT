package com.nareshit.implicitintentapp;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    TextView tvContact, tvBrowse, tvSearch, tvCall, tvCamera, tvMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intializeViewControls();
    }

    private void intializeViewControls() {

        tvContact = (TextView) findViewById(R.id.tvContact);
        tvContact.setOnClickListener(this);

        tvBrowse = (TextView) findViewById(R.id.tvBrowse);
        tvBrowse.setOnClickListener(this);

        tvSearch = (TextView) findViewById(R.id.tvSearch);
        tvSearch.setOnClickListener(this);

        tvCall = (TextView) findViewById(R.id.tvCall);
        tvCall.setOnClickListener(this);

        tvCamera = (TextView) findViewById(R.id.tvCamera);
        tvCamera.setOnClickListener(this);

        tvMap = (TextView) findViewById(R.id.tvMap);
        tvMap.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.tvContact:

                Intent contactIntent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
                startActivity(contactIntent);
                break;
            case R.id.tvBrowse:

                Intent browseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.axisbank.com"));
                startActivity(browseIntent);
                break;
            case R.id.tvSearch:

                Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                searchIntent.putExtra(SearchManager.QUERY, "Android Material");
                startActivity(searchIntent);
                break;
            case R.id.tvCall:

                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+919959297904"));
                startActivity(callIntent);
                break;

            case R.id.tvCamera:

                Intent cameraIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(cameraIntent, 2);

                break;

            case R.id.tvMap:

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Tirupati"));
                startActivity(mapIntent);


                break;


        }
    }
}
