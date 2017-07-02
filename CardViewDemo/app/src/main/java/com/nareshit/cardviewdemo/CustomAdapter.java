package com.nareshit.cardviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Manikanta on 8/29/2016.
 */
public class CustomAdapter extends BaseAdapter
{

    Context ctx;
    ArrayList<Category> categoryArrayList;

    public CustomAdapter(Context context, ArrayList<Category> categoryArrayList) {

        this.ctx = context;
        this.categoryArrayList = categoryArrayList;
    }

    @Override
    public int getCount() {
        return categoryArrayList.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {

        Category category = categoryArrayList.get(i);
        view = LayoutInflater.from(ctx).inflate(R.layout.custom_row,null);

        ImageView ivCategoryImage = (ImageView) view.findViewById(R.id.ivCateogoryImage);
        TextView tvCategoryName = (TextView) view.findViewById(R.id.tvCategoryName);
        TextView tvCategoryAddress = (TextView) view.findViewById(R.id.tvCategoryAddress);
        TextView tvCategoryPhone = (TextView) view.findViewById(R.id.tvCategoryPhone);

        tvCategoryAddress.setText(category.getCategoryAddress());
        tvCategoryName.setText(category.getCategoryName());
        tvCategoryPhone.setText(category.getCategoryPhone());
        ivCategoryImage.setBackgroundResource(category.getCategoryImage());

        return view;
    }
}
