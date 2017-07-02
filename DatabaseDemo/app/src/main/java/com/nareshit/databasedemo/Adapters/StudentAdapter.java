package com.nareshit.databasedemo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nareshit.databasedemo.R;
import com.nareshit.databasedemo.utils.Student;

import java.util.ArrayList;

/**
 * Created by Manikanta on 8/16/2016.
 */
public class StudentAdapter extends BaseAdapter
{

    Context mContext;
    ArrayList<Student> studentArrayList;

    public StudentAdapter(Context context, ArrayList<Student> studentArrayList) {

        this.mContext = context;
        this.studentArrayList = studentArrayList;
    }

    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int pos) {
        return pos;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Student student = studentArrayList.get(i);
        view = LayoutInflater.from(mContext).inflate(R.layout.activity_users_row,null);
        TextView tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        TextView tvAddress = (TextView) view.findViewById(R.id.tvAddress);
        TextView tvPhone = (TextView) view.findViewById(R.id.tvPhone);

        tvAddress.setText(student.getAddress());
        tvEmail.setText(student.getEmail());
        tvPhone.setText(student.getPhone());
        return view;
    }
}
