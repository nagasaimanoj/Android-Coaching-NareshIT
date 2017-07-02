package com.nareshit.guicomponents_parttwo;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends Activity {

    String names[] = {"Mani", "Sai", "Ramu", "Sita", "Naresh", "Koushik"};
    String status[] = {"Sleepy", "Nice", "Smile", "Thanks", "Eating", "Running"};
    String dates[] = {"05/08/2016", "05/08/2016", "05/08/2016", "05/08/2016", "05/08/2016", "05/08/2016"};
    int profilePic[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    String versionNames[];
    ListView lvVersionNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        versionNames = getResources().getStringArray(R.array.version_names);
        lvVersionNames = (ListView) findViewById(R.id.lvVersionNames);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListViewActivity.this,android.R.layout.simple_list_item_1,versionNames);
//        lvVersionNames.setAdapter(arrayAdapter);
        CustomAdapter adapter = new CustomAdapter();
        lvVersionNames.setAdapter(adapter);
        lvVersionNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "The position is" + versionNames[position], Toast.LENGTH_SHORT).show();

            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return names.length;
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
        public View getView(final int position, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = LayoutInflater.from(ListViewActivity.this);
            view = layoutInflater.inflate(R.layout.custom_layout, null);

            TextView tvName = (TextView) view.findViewById(R.id.tvName);
            TextView tvDate = (TextView) view.findViewById(R.id.tvDate);
            TextView tvStatus = (TextView) view.findViewById(R.id.tvStatus);
            ImageView ivProfilePic = (ImageView) view.findViewById(R.id.ivProfilePic);
            tvName.setText(names[position]);
            tvDate.setText(dates[position]);
            tvStatus.setText(status[position]);
            ivProfilePic.setImageResource(profilePic[position]);


            ivProfilePic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Dialog dialog = new Dialog(ListViewActivity.this);
                    dialog.setContentView(R.layout.custom_dialog);
                    ImageView ivProfilePic = (ImageView) dialog.findViewById(R.id.ivProfilePic);

                    ivProfilePic.setImageResource(profilePic[position]);
                    dialog.show();
                }
            });
            return view;
        }
    }
}