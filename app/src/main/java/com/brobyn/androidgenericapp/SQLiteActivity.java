package com.brobyn.androidgenericapp;

import android.database.Cursor;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

// list view stuff
        myArrayList.add("Mark");
        myArrayList.add("Gaby");
        myArrayList.add("Izzy");
        myArrayList.add("Paul");
        myArrayList.add("Viki");

        myListView=(ListView) findViewById(R.id.sqlite_listview);
        myArrayAdapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                myArrayList);
        myListView.setAdapter(myArrayAdapter);
        myArrayAdapter.notifyDataSetChanged();
// end list view stuff


        Button button_sqlite_show_all=(Button)findViewById(R.id.button_sqlite_show_all);
        button_sqlite_show_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int count=0;
                makeText(getApplicationContext(),"SQLite\nShow All", LENGTH_LONG).show();

                db.open();
                Cursor cursor=db.showAll();
                if (cursor.moveToFirst()) {
                    do {
                        myArrayList.add(cursor.getString(1));
                        count++;
                    } while (cursor.moveToNext());
                }
                db.close();
                myArrayAdapter.notifyDataSetChanged();
                status=(TextView) findViewById(R.id.sqlite_status);
                status.setText(String.valueOf(count));
            }
        });



        Button button_sqlite_add_item=(Button)findViewById(R.id.button_sqlite_add_item);
        button_sqlite_add_item.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeText(getApplicationContext(), "SQLite\nAdd item", LENGTH_LONG).show();
                db.open();
                addItemId = db.addItem("Title test", "Content test");
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
