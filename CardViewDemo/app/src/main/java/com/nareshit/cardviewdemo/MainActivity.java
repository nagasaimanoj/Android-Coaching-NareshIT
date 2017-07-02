package com.nareshit.cardviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity
{
    ListView lvItems;
    ArrayList<Category> categoryArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryArrayList = new ArrayList<Category>();
        lvItems = (ListView) findViewById(R.id.lvItems);
        saveData();
        CustomAdapter adapter = new CustomAdapter(MainActivity.this,categoryArrayList);
        lvItems.setAdapter(adapter);
    }
    private void saveData()
    {
        Category category = new Category();
        category.setCategoryImage(R.drawable.aaa);
        category.setCategoryName("AAAA");
        category.setCategoryAddress("HYDERBAD");
        category.setCategoryPhone("1234567890");
        categoryArrayList.add(category);

        category = new Category();
        category.setCategoryImage(R.drawable.aaa);
        category.setCategoryName("AAAA");
        category.setCategoryAddress("HYDERBAD");
        category.setCategoryPhone("1234567890");
        categoryArrayList.add(category);

        category = new Category();
        category.setCategoryImage(R.drawable.bbb);
        category.setCategoryName("BBBB");
        category.setCategoryAddress("HYDERBAD");
        category.setCategoryPhone("1234567890");
        categoryArrayList.add(category);

        category = new Category();
        category.setCategoryImage(R.drawable.ccc);
        category.setCategoryName("CCCC");
        category.setCategoryAddress("HYDERBAD");
        category.setCategoryPhone("1234567890");
        categoryArrayList.add(category);

        category = new Category();
        category.setCategoryImage(R.drawable.ddd);
        category.setCategoryName("DDDD");
        category.setCategoryAddress("HYDERBAD");
        category.setCategoryPhone("1234567890");
        categoryArrayList.add(category);

        category = new Category();
        category.setCategoryImage(R.drawable.eee);
        category.setCategoryName("EEEE");
        category.setCategoryAddress("HYDERBAD");
        category.setCategoryPhone("1234567890");
        categoryArrayList.add(category);

        category = new Category();
        category.setCategoryImage(R.drawable.fff);
        category.setCategoryName("FFFF");
        category.setCategoryAddress("HYDERBAD");
        category.setCategoryPhone("1234567890");
        categoryArrayList.add(category);

        category = new Category();
        category.setCategoryImage(R.drawable.ggg);
        category.setCategoryName("GGGG");
        category.setCategoryAddress("HYDERBAD");
        category.setCategoryPhone("1234567890");
        categoryArrayList.add(category);

        category = new Category();
        category.setCategoryImage(R.drawable.hhh);
        category.setCategoryName("HHHH");
        category.setCategoryAddress("HYDERBAD");
        category.setCategoryPhone("1234567890");
        categoryArrayList.add(category);

        category = new Category();
        category.setCategoryImage(R.drawable.iii);
        category.setCategoryName("IIII");
        category.setCategoryAddress("HYDERBAD");
        category.setCategoryPhone("1234567890");
        categoryArrayList.add(category);
    }
}
