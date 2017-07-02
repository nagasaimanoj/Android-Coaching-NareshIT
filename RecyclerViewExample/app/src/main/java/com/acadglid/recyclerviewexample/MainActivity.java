package com.acadglid.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Person> persons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeData();
        recyclerView = (RecyclerView) findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(persons);
        recyclerView.setAdapter(adapter);


    }


    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old",R.mipmap.ic_launcher));
        persons.add(new Person("Lavery Maiss","25 years old",R.mipmap.ic_launcher));
        persons.add(new Person("ManiKanta",   "28 years old",R.mipmap.ic_launcher));
        persons.add(new Person("Sami",        "26 years old",R.mipmap.ic_launcher));
        persons.add(new Person("Suresh Kumar","40 years old",R.mipmap.ic_launcher));
        persons.add(new Person("SaiKumar",    "25 years old",R.mipmap.ic_launcher));
    }
}
