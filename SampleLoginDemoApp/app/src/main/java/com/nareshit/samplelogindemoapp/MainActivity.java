package com.nareshit.samplelogindemoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    Profile profile;
    TextView tvProfileName ;
    CallbackManager callbackManager;
    LoginButton loginButton;
    ImageView ivProfilePic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();
        ivProfilePic = (ImageView) findViewById(R.id.ivProfilePic);

        tvProfileName = (TextView) findViewById(R.id.tvProfileName);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();
                profile = Profile.getCurrentProfile();

                if (profile!=null)
                {
                    String name = profile.getName();

                    Picasso.with(MainActivity.this)
                            .load("https://graph.facebook.com/" + profile.getId() + "/picture?type=large")
                            .resize(50, 50)
                            .centerCrop()
                            .into(ivProfilePic);

                    tvProfileName.setText(name);


                }


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        if (profile!=null)
        {
            tvProfileName.setText(profile.getName());
        }


    }
}
