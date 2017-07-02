package com.nareshit.googlemapdemo;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapViewActivity extends FragmentActivity implements View.OnClickListener {
    GoogleMap googleMap;
    EditText etAddress;
    TextView tvFind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_view);


        SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        googleMap = supportMapFragment.getMap();

        etAddress = (EditText) findViewById(R.id.etAddress);
        tvFind = (TextView) findViewById(R.id.tvFind);

        tvFind.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String address  = etAddress.getText().toString();
        convertAddressintoLatLng(address);
    }

    private void convertAddressintoLatLng(String address) {

        Geocoder geocoder = new Geocoder(MapViewActivity.this);
        try {
            List<Address> addresses = geocoder.getFromLocationName(address,5);

            double lat= addresses.get(0).getLatitude();
            double lng = addresses.get(0).getLongitude();

            LatLng latLng = new LatLng(lat,lng);
            MarkerOptions markerOptions = new MarkerOptions();
            googleMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.map_icon)));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,12));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
