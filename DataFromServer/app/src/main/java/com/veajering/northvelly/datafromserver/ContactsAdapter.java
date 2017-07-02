package com.veajering.northvelly.datafromserver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by manikanta reddy on 4/20/2016.
 */
public class ContactsAdapter extends BaseAdapter
{
    Context mContext;
    ArrayList<Contact> contactArrayList;
    public ContactsAdapter(Context context, ArrayList<Contact> contactList) {

        this.mContext = context;
        this.contactArrayList = contactList;
    }

    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        Contact contact = contactArrayList.get(i);
        view = LayoutInflater.from(mContext).inflate(R.layout.list_row,null);

        TextView tvName = (TextView) view.findViewById(R.id.tvName);
        TextView tvAddress = (TextView) view.findViewById(R.id.tvAddress);
        TextView tvEmail = (TextView) view.findViewById(R.id.tvEmail);

        tvName.setText(contact.getId());
        tvEmail.setText(contact.getEmail());
        tvAddress.setText(contact.getAddress());
        return view;
    }
}
