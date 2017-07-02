package com.nareshit.fragmentdemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nareshit.fragmentdemo.R;

/**
 * Created by Manikanta on 8/23/2016.
 */
public class DetailsFragment extends android.support.v4.app.Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.details_fragment,null);
        return view;
    }
}
