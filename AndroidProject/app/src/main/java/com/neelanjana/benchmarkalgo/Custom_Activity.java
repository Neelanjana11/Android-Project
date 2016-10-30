package com.neelanjana.benchmarkalgo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Custom_Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout);

        Button btn = (Button) findViewById(R.id.btn);
        registerForContextMenu(btn);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose from the com.neelanjana.benchmarkalgo.VideoActivity.Menu");
        menu.add(0, v.getId(), 0, "Call");
        menu.add(0, v.getId(), 0, "SMS");
        menu.add(0, v.getId(), 0, "WhatsApp");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Call") {
            Toast.makeText(this, "Calling", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle() == "SMS") {
            Toast.makeText(this, "SMS Send", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle() == "WhatsApp") {
            Toast.makeText(this, "WhatsApp Now", Toast.LENGTH_SHORT).show();
        } else {
            return false;
        }
        return true;
    }
}
