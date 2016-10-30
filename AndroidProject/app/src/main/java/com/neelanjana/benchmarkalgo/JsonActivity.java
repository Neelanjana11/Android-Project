package com.neelanjana.benchmarkalgo;

import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class JsonActivity extends Activity {

    private TextView tvText;
    String strJson="{\"Movies\":[{\"name\":\"PINK\",\"actor\":\"PINK\" },{\"name\":\"KUCH KUCH HOTA HAIN\",\"actor\":\"Sharukh Khan\"},{\"name\":\"KABHI KHUSI KABHI GAM\",\"actor\":\"HRITHIK ROSHAN\"}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_layout);

        tvText = (TextView) findViewById(R.id.tvText);

        String data = "";
        try {
            JSONObject  jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("Movies");

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

            //    int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                String actor = jsonObject.optString("actor").toString();
             //   float salary = Float.parseFloat(jsonObject.optString("salary").toString());

                data += "\n Movie"+i+" : \n Name = "+ name +" \n Actor = "+ actor +" \n ";
            }
            tvText.setText(data);
        } catch (JSONException e) {e.printStackTrace();}
    }
}
