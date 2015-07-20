// http://www.mysamplecode.com/2011/10/android-dynamic-layout-using-xml-add.html

package com.brobyn.androidgenericapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status=(TextView) findViewById(R.id.status);
        status.setText("Waiting...");

        //final EditText mainEditText=(EditText) findViewById(R.id.mainEditText);



        Button button_add_item=(Button)findViewById(R.id.button_add_item);
        button_add_item.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText("button_add_item");
                //Intent i=new Intent("EditorActivity");
                Intent i = new Intent(MainActivity.this,addItemActivity.class);
                startActivity(i);
            }
        });

        Button button_list_items=(Button)findViewById(R.id.button_list_items);
        button_list_items.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText("button_list_items");
            }
        });
        //status.setText(mainEditText.getText().toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
