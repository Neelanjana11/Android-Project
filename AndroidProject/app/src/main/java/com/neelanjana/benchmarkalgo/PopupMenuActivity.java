package com.neelanjana.benchmarkalgo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PopupMenuActivity extends AppCompatActivity {

    private Button btnPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_layout);

        btnPopup = (Button) findViewById(R.id.btnPopup);
        btnPopup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(PopupMenuActivity.this, btnPopup);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
             /*   popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(PopupMenuActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });*/

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method
    }

    public void changeColor(MenuItem item){
        switch(item.getItemId()){

            case R.id.mnRed:
                btnPopup.setBackgroundColor(Color.RED);
                break;

            case R.id.mnBlue:
                btnPopup.setBackgroundColor(Color.BLUE);
                break;

            case R.id.mnYellow:
                btnPopup.setBackgroundColor(Color.YELLOW);
                break;
        }
    }
}
