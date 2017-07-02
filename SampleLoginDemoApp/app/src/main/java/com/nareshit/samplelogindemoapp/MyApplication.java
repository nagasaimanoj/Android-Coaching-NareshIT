package com.nareshit.samplelogindemoapp;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Manikanta on 8/26/2016.
 */
public class MyApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();

        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.nareshit.samplelogindemoapp",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }


    }
}
