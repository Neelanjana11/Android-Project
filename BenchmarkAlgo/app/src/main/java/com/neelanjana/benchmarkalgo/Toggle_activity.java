package com.neelanjana.benchmarkalgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Toggle_activity extends AppCompatActivity {

    private Button btnTL;
    private Button btnTC;
    private Button btnTR;
    private Button btnCL;
    private Button btnCC;
    private Button btnCR;
    private Button btnBL;
    private Button btnBC;
    private Button btnBR;
    Toast toast;

    public void toogleMsg(View view) {
        switch (view.getId()) {

            case R.id.btn_tl:
                toast = Toast.makeText(getApplicationContext(), "Top Left", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 40, 240);
                toast.show();
                break;

            case R.id.btn_tc:
                toast = Toast.makeText(getApplicationContext(), "Top Center", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.CENTER, 40, 240);
                toast.show();
                break;

            case R.id.btn_tr:
                toast = Toast.makeText(getApplicationContext(), "Top Right", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.RIGHT, 40, 240);
                toast.show();
                break;

            case R.id.btn_cl:
                toast = Toast.makeText(getApplicationContext(), "Center Left", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 40, 740);
                toast.show();
                break;

            case R.id.btn_cc:
                toast = Toast.makeText(getApplicationContext(), "Center Center", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.CENTER, 40, 740);
                toast.show();
                break;

            case R.id.btn_cr:
                toast = Toast.makeText(getApplicationContext(), "Center Right", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.RIGHT, 40, 740);
                toast.show();
                break;

            case R.id.btn_bl:
                toast = Toast.makeText(getApplicationContext(), "Bottom Left", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 40, 1240);
                toast.show();
                break;

            case R.id.btn_bc:
                toast = Toast.makeText(getApplicationContext(), "Bottom Center", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.CENTER, 40, 1240);
                toast.show();
                break;

            case R.id.btn_br:
                toast = Toast.makeText(getApplicationContext(), "Bottom Right", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.RIGHT, 40, 1240);
                toast.show();
                break;




        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggle_activity_layout);

        btnTL = (Button)findViewById(R.id.btn_tl);

    }
}
