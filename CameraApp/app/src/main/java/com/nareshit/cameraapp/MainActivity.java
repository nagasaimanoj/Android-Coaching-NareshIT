package com.nareshit.cameraapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    ImageView ivProfilepic;
    TextView tvCaputredPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivProfilepic = (ImageView) findViewById(R.id.ivProfilePic);
        tvCaputredPhoto = (TextView) findViewById(R.id.tvCapturedPhoto);

        tvCaputredPhoto.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,2);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==2)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ivProfilepic.setImageBitmap(photo);
        }
    }
}
