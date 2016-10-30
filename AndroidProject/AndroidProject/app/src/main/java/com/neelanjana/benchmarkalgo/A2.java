package com.neelanjana.benchmarkalgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class A2 extends AppCompatActivity {

    private Button btnClick;

    public void submit(){

        String name = ((EditText)findViewById(R.id.etName)).getText().toString();
        Intent intent = new Intent();
        intent.putExtra("username", name);
        //setIntent(intent);
        setResult(RESULT_OK, intent);

        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2_layout);

        btnClick = (Button) findViewById(R.id.btnClick);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }
}
