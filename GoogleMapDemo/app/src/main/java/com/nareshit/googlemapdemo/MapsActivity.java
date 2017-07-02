package com.nareshit.googlemapdemo;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements LocationListener {
    LocationManager locationManager;
    GoogleMap googleMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        googleMap = supportMapFragment.getMap();
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(provider);
        if (location != null) {
            onLocationChanged(location);
        }
        locationManager.requestLocationUpdates(provider, 20, 2, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        //Getting lat and Lng
        double lat = location.getLatitude();
        double lng = location.getLongitude();
        Log.i("LatLng ::", "" + lat + lng);
        Toast.makeText(getApplicationContext(), "Lat" + lat + "Lng" + lng, Toast.LENGTH_SHORT).show();
        //Converting Latitude and Longitude in to LatLng position
        LatLng latLng = new LatLng(lat, lng);
        //Creating the Marker
        MarkerOptions markerOptions = new MarkerOptions();
        //Creating the Marker position
        markerOptions.position(latLng);
        //Adding the marker to google map
        googleMap.addMarker(markerOptions);
        //Camera Position
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12));
        convertLatLngintoAddress(lat, lng);
    }

    private void convertLatLngintoAddress(double lat, double lng) {
        Geocoder geocoder = new Geocoder(MapsActivity.this);
        try {
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 5);
            String cName = addresses.get(0).getCountryName();
            String add = addresses.get(0).getAddressLine(3);
            String adminArea = addresses.get(0).getAdminArea();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CountryName" + cName);
            stringBuilder.append("\n");
            stringBuilder.append("Address" + add);
            stringBuilder.append("\n");
            stringBuilder.append("AdminArea" + adminArea);
            String address = stringBuilder.toString();
            Toast.makeText(getApplicationContext(), address, Toast.LENGTH_SHORT).show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}