
package com.brobyn.androidgenericapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

// http://www.mysamplecode.com/2011/10/android-dynamic-layout-using-xml-add.html
// http://stackoverflow.com/questions/4878159/android-whats-the-best-way-to-share-data-between-activities

public class addItemActivity extends ActionBarActivity {

    ListView myListView;
    ArrayAdapter myArrayAdapter;
    ArrayList<String> myArrayList=new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_activity);

        myArrayList.add("Mark");
        myArrayList.add("Gaby");
        myArrayList.add("Izzy");
        myArrayList.add("Paul");
        myArrayList.add("Viki");

        myListView=(ListView) findViewById(R.id.additem_listview);
        myArrayAdapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                myArrayList);
        myListView.setAdapter(myArrayAdapter);
        myArrayAdapter.notifyDataSetChanged();
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
