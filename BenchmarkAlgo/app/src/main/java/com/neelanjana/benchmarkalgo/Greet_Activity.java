package com.neelanjana.benchmarkalgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Greet_Activity extends AppCompatActivity {
    private EditText etFirst;
    private EditText etLast;
    private TextView tvOutput;
    private Button btnGreet;
    private LinearLayout ll;
    private ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sv = new ScrollView(this);
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        etFirst = new EditText(this);
        etFirst.setHint("Enter first name");
        ll.addView(etFirst);
        etLast = new EditText(this);
        etLast.setHint("Enter last name");
        ll.addView(etLast);
        btnGreet = new Button(this);
        btnGreet.setText("Greetings");
        ll.addView(btnGreet);
        tvOutput = new TextView(this);
        tvOutput.setTextSize(30.00f);
        ll.addView(tvOutput);
        this.setContentView(sv);

        btnGreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = etFirst.getText().toString();
                String last = etLast.getText().toString();
                tvOutput.setText("Welcome " + first + " " + last);
            }
        });
    }


}
