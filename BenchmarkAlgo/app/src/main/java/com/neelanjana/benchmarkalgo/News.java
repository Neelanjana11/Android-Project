package com.neelanjana.benchmarkalgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class News extends AppCompatActivity {

    private TextView tvNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);


        Bundle br = getIntent().getExtras();
        tvNews = (TextView) findViewById(R.id.tvNews);


        tvNews.setText(br.getCharSequence("News"));

    }
}
