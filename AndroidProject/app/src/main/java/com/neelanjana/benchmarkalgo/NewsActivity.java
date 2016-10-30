package com.neelanjana.benchmarkalgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    Intent intent;

    public void launchNews(View view){
        switch (view.getId()) {

            case R.id.btnGoogle:
                intent=new Intent(getApplication(),News.class);
                intent.putExtra("News","Google News");
                startActivity(intent);
                break;

            case R.id.btnFelight:
                intent=new Intent(getApplication(),News.class);
                intent.putExtra("News","Felight News");
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_layout);

    }
}
