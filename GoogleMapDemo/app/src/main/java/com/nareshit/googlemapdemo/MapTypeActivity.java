package com.nareshit.googlemapdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by Manikanta on 8/22/2016.
 */
public class MapTypeActivity extends FragmentActivity implements View.OnClickListener {
    GoogleMap googleMap;
    TextView tvHybrid,tvSatilite,tvTeerain;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_type);

        SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        googleMap = supportMapFragment.getMap();

        tvHybrid = (TextView) findViewById(R.id.tvHybrid);
        tvTeerain = (TextView) findViewById(R.id.tvTerrain);
        tvSatilite = (TextView) findViewById(R.id.tvSatilite);

        tvHybrid.setOnClickListener(this);
        tvSatilite.setOnClickListener(this);
        tvTeerain.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.tvHybrid:

                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.tvSatilite:
                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.tvTerrain:
                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;

        }
    }
}
