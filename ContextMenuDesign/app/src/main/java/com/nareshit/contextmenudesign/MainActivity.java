package com.nareshit.contextmenudesign;


import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView tvName, tvName2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(R.id.tvName);
        registerForContextMenu(tvName);

        tvName2 = (TextView) findViewById(R.id.tvName2);
        registerForContextMenu(tvName2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()) {
            case R.id.tvName:
                menu.setHeaderTitle(tvName.getText().toString());
                menu.add(0, 0, 1, "Map");
                menu.add(0, 1, 2, "Contact US");
                menu.add(0, 2, 3, "Website");
                menu.add(0, 3, 4, "About US");
                break;
            case R.id.tvName2:
                menu.setHeaderTitle("this is made by me");
                menu.add(0, 4, 1, "hi");
                menu.add(0, 5, 2, "hello");
                menu.add(0, 6, 3, "how do u do");
                menu.add(0, 7, 4, "well bye");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                Toast.makeText(getApplicationContext(), "U selected Map", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "U selected ContactUS", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "U selected Wesite", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "U selected AboutUS", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(getApplicationContext(), "U selected me", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(getApplicationContext(), "U selected u", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(getApplicationContext(), "U selected i", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(getApplicationContext(), "U selected get on", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
