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


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    TextView status;
    /*
    Button button_1;
    Button button_2;
    Button button_3;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status=(TextView) findViewById(R.id.status);
        status.setText("Waiting...");

        final EditText mainEditText=(EditText) findViewById(R.id.mainEditText);

        Button button_add_item=(Button)findViewById(R.id.button_add_item);
        button_add_item.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText("Add item...");
            }
        });

        Button button_2=(Button)findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText("EditorActivity");
                //Intent i=new Intent("EditorActivity");
                Intent i = new Intent(MainActivity.this,EditActivity.class);
                startActivity(i);
            }
        });

        Button button_3=(Button)findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText("EditActivity");
                Intent i=new Intent("EditActivity");
                //Intent i;
                //i = new Intent(this,EditActivity.class);
                startActivity(i);
            }
        });

        Button button_4=(Button)findViewById(R.id.button_4);
        button_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                status.setText(mainEditText.getText().toString());
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
     public class MyActivity extends Activity {
     protected void onCreate(Bundle icicle) {
         super.onCreate(icicle);

         setContentView(R.layout.content_layout_id);

         final Button button = (Button) findViewById(R.id.button_id);
         button.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 // Perform action on click
             }
         });
     }
 }

    */


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

    @Override
    public void onClick(View v) {
        status.setText("Button 1 clicked");
    }

}
