package com.brobyn.androidgenericapp;

import android.database.Cursor;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

/**
 * Created by mark22 on 31/08/2015.
 */
public class SQLiteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        Button button_sqlite_show_all=(Button)findViewById(R.id.button_sqlite_show_all);
        button_sqlite_show_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                makeText(getApplicationContext(),
                        "SQLite\nShow All", LENGTH_LONG).show();
            }
        });

        DataBaseHelper db=new DataBaseHelper(this); //

        db.open();
        Cursor c=db.showAll();
        if (c.moveToFirst()) makeText(getApplicationContext(),"SQLite\nshowAll()>0", LENGTH_LONG).show();
        else makeText(getApplicationContext(),"SQLite\nshowAll==0", LENGTH_LONG).show();
        db.close();
    }
}
