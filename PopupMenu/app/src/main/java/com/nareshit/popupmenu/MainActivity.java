package com.nareshit.popupmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    PopupMenu popupMenu;
    TextView tvPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPopup = (TextView) findViewById(R.id.tvPopup);
        tvPopup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        popupMenu = new PopupMenu(MainActivity.this, tvPopup);
        popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.One:
                        Toast.makeText(getApplicationContext(), "U selected One", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.Two:
                        Toast.makeText(getApplicationContext(), "U selected Two", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.Three:
                        Toast.makeText(getApplicationContext(), "U selected Three", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}