package com.brobyn.androidgenericapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mark22 on 12/09/2015.
 */

public class edit extends AppCompatActivity {

    TextView jsonGot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        jsonGot=(TextView) findViewById(R.id.jsonGot);
        jsonGot.setText("Getting JSON...");

        JSON json=new JSON();

        //new json.ReadJSONFeedTask().execute("http://avail.mdx.ac.uk/items/items.html");


    }

}