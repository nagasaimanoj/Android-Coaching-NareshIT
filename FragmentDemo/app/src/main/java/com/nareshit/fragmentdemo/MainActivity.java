package com.nareshit.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nareshit.fragmentdemo.fragments.DetailsFragment;
import com.nareshit.fragmentdemo.fragments.GamesFragment;
import com.nareshit.fragmentdemo.fragments.MoviesFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvMovies,tvGames,tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMovies = (TextView) findViewById(R.id.tvMovies);
        tvGames = (TextView) findViewById(R.id.tvGames);
        tvDetails = (TextView) findViewById(R.id.tvDetails);

        tvDetails.setOnClickListener(this);
        tvMovies.setOnClickListener(this);
        tvGames.setOnClickListener(this);


        Fragment fragment = new MoviesFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContainer,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View view)
    {
        Fragment fragment = null;
        switch (view.getId())
        {
            case R.id.tvMovies:
                fragment = new MoviesFragment();
                break;
            case R.id.tvGames:
                fragment = new GamesFragment();
                break;
            case R.id.tvDetails:
                fragment = new DetailsFragment();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flContainer,fragment);
        fragmentTransaction.commit();
    }
}
