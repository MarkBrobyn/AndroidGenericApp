package com.brobyn.androidgenericapp;

import android.database.Cursor;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

/**
 * Created by mark22 on 31/08/2015.
 */
public class SQLiteActivity extends AppCompatActivity {

    TextView status;


    DataBaseHelper db=new DataBaseHelper(this); //

    ListView myListView;
    ArrayAdapter myArrayAdapter;
    ArrayList<String> myArrayList=new ArrayList<String>();

    long addItemId;

    private void showAll(){
        int count = 0;
        makeText(getApplicationContext(), "SQLite\nShow All", LENGTH_LONG).show();

        db.open();
        Cursor cursor = db.showAll();
        myArrayList.clear();
        if (cursor.moveToFirst()) {
            do {
                myArrayList.add(0, cursor.getString(0) + " " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3)); // add to start of list
                //myArrayList.add(cursor.getString(1));
                count++;
            } while (cursor.moveToNext());
        }
        db.close();
        myArrayAdapter.notifyDataSetChanged();
        status = (TextView) findViewById(R.id.sqlite_status);
        status.setText("Items = "+String.valueOf(count));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

// list view stuff
        /*
        myArrayList.add("Mark");
        myArrayList.add("Gaby");
        myArrayList.add("Izzy");
        myArrayList.add("Paul");
        myArrayList.add("Viki");
        */

        myListView=(ListView) findViewById(R.id.sqlite_listview);
        myArrayAdapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                myArrayList);
        myListView.setAdapter(myArrayAdapter);
        myArrayAdapter.notifyDataSetChanged();
// end list view stuff

        showAll();

        Button button_sqlite_show_all=(Button)findViewById(R.id.button_sqlite_show_all);
        button_sqlite_show_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*
                int count = 0;

                makeText(getApplicationContext(), "SQLite\nShow All", LENGTH_LONG).show();

                db.open();
                Cursor cursor = db.showAll();
                myArrayList.clear();
                if (cursor.moveToFirst()) {
                    do {
                        myArrayList.add(0, cursor.getString(0) + " " + cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3)); // add to start of list
                        //myArrayList.add(cursor.getString(1));
                        count++;
                    } while (cursor.moveToNext());
                }
                db.close();
                myArrayAdapter.notifyDataSetChanged();
                status = (TextView) findViewById(R.id.sqlite_status);
                status.setText("Items = "+String.valueOf(count));
                */
                showAll();
            }
        });



        Button button_sqlite_add_item=(Button)findViewById(R.id.button_sqlite_add_item);
        button_sqlite_add_item.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText title_text= (EditText) findViewById(R.id.title_edittext);
                EditText content_text= (EditText) findViewById(R.id.content_edittext);
                makeText(getApplicationContext(), "SQLite\nAdd item", LENGTH_LONG).show();
                db.open();
                addItemId = db.addItem(title_text.getText().toString(),content_text.getText().toString());
                db.close();
                showAll();
            }
        });


        Button button_sqlite_delete_all=(Button)findViewById(R.id.button_sqlite_delete_all);
        button_sqlite_delete_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeText(getApplicationContext(), "SQLite\nDelete all", LENGTH_LONG).show();
                db.open();
                db.deleteAll();
                db.close();
            }
        });


        db.open();
        Cursor c=db.showAll();
        if (c.moveToFirst()) makeText(getApplicationContext(),"SQLite\nshowAll()>0", LENGTH_LONG).show();
        else makeText(getApplicationContext(),"SQLite\nshowAll==0", LENGTH_LONG).show();
        db.close();
    }
}
