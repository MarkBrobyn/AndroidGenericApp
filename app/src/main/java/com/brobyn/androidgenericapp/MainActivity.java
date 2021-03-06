// http://www.mysamplecode.com/2011/10/android-dynamic-layout-using-xml-add.html

package com.brobyn.androidgenericapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import android.database.SQLException;

import static android.widget.Toast.*;

// http://www.reigndesign.com/blog/using-your-own-sqlite-database-in-android-applications/


public class MainActivity extends ActionBarActivity {

    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("FIRSTRUN", false)) {
            makeText(getApplicationContext(),"FIRST RUN", LENGTH_SHORT).show();

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("FIRSTRUN", true);
            editor.commit();
        }
        else  makeText(getApplicationContext(), "NOT FIRST RUN", LENGTH_SHORT).show();

        status=(TextView) findViewById(R.id.status);
        status.setText("Waiting...");

        //final EditText mainEditText=(EditText) findViewById(R.id.mainEditText);

        Button button_add_item=(Button)findViewById(R.id.button_add_item);
        button_add_item.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText("button_add_item");
                //Intent i=new Intent("EditorActivity");
                Intent i = new Intent(MainActivity.this, addItemActivity.class);
                startActivity(i);
            }
        });

        Button button_list_items=(Button)findViewById(R.id.button_list_items);
        button_list_items.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText("button_list_items");
                Intent i = new Intent(MainActivity.this, listItemsActivity.class);
                startActivity(i);
            }
        });

        Button button_sqlite=(Button)findViewById(R.id.button_sqlite);
        button_sqlite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText("button_sqlite");
                Intent i = new Intent(MainActivity.this, SQLiteActivity.class);
                startActivity(i);
            }
        });

        Button button_prefs=(Button)findViewById(R.id.button_prefs);
        button_prefs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText("button_prefs");
                //Intent i = new Intent(MainActivity.this, listItemsActivity.class);
                //startActivity(i);
            }
        });







        //status.setText(mainEditText.getText().toString());


        Button button_camera=(Button)findViewById(R.id.button_camera);
        button_camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText("button_camera");


        Context context = getApplicationContext();
        CharSequence text = "Lights, Camera, Action!";
        int duration = LENGTH_SHORT;

        Toast toast = makeText(context, text, duration);
        toast.show();

        // Quick toast
        makeText(getApplicationContext(),
                "Button is clicked", LENGTH_LONG).show();
            }
        });

        DataBaseHelper myDbHelper = new DataBaseHelper(this);

        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        /*
        try {
            myDbHelper.openDataBase();
        }
        catch(SQLException sqle){
            throw sqle;
        }
        */


    }

    public void edit(View v) {
        Intent i = new Intent(MainActivity.this, edit.class);
        startActivity(i);
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
            startActivity(new Intent(this,AppPreferences.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
