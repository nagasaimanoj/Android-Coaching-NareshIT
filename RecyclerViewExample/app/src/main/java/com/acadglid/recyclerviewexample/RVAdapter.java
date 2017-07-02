package com.acadglid.recyclerviewexample;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    List<Person> persons;
    public  RVAdapter(List<Person> persons){
        this.persons = persons;
    }
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_layout, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int position) {

        personViewHolder.personName.setText(persons.get(position).name);
        personViewHolder.personAge.setText(persons.get(position).age);
        personViewHolder.personPhoto.setImageResource(persons.get(position).photoId);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(View itemView)
        {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName  = (TextView)itemView.findViewById(R.id.person_name);
            personAge   = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }
}
