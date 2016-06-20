package com.example.listview_tutorial;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     ListView listview;
     Button b;
     EditText t;
     ArrayAdapter<String> arrad;
    ArrayList<String> s;
    SharedPreferences sp;
    String key="Item";
    String pref="Preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       s=new ArrayList<String>();
        s.add("a1");
        s.add("a2");
        s.add("a3");


        b=(Button)findViewById(R.id.button);
        t=(EditText)findViewById(R.id.editText);
        listview=(ListView)findViewById(R.id.listview);
        arrad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s);
        Toast.makeText(this,"created",Toast.LENGTH_LONG).show();
        listview.setAdapter(arrad);
        sp=getSharedPreferences(pref, Context.MODE_PRIVATE);
        String returned=sp.getString(key,"Doesnotexist");
        s.add(returned);

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
    public void abc(View v){
        Toast.makeText(this, "clicked",Toast.LENGTH_LONG).show();
        s.add(t.getText().toString());
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(key, t.getText().toString());
        editor.commit();

    }
}
