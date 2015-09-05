package com.brobyn.androidgenericapp;

/**
 * Created by mark22 on 05/09/2015.
 */

//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

import android.database.Cursor;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String itemID = getIntent().getStringExtra("id");
        makeText(getApplicationContext(), "EditItem\nonCreate\nitemID=" +itemID, LENGTH_LONG).show();

        DataBaseHelper db=new DataBaseHelper(this);
        db.open();
        Cursor c=db.getItem(itemID);
        if (c.moveToFirst()) {
            String text = "\n"+c.getString(0)
            +"\n"+c.getString(1)
            +"\n"+c.getString(2)
            +"\n"+c.getString(3);
            makeText(getApplicationContext(),"EditItem\n_id="+itemID+" found:"+text, LENGTH_LONG).show();
            TextView edit_item_datetime = (TextView) findViewById (R.id.edit_item_datetime);
            TextView edit_item_title = (TextView) findViewById (R.id.edit_item_title);
            TextView edit_item_content = (TextView) findViewById (R.id.edit_item_content);
            edit_item_datetime.setText(c.getString(0));
            edit_item_title.setText(c.getString(1));
            edit_item_content.setText(c.getString(2));
        }
        else makeText(getApplicationContext(),"EditItem\n_id="+itemID+" not found", LENGTH_LONG).show();
        db.close();

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
