package com.ceibalabs.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.myListView);

        final ArrayList<String> family = new ArrayList<String>();
        family.add("Rick");
        family.add("Chandler");
        family.add("Ross");
        family.add("Joey");
        //ArrayList<String> family2 = new ArrayList<String>(asList("Jhon", "Paul", "Charlie")); //other way to add a list

        //simple_lis_item_1 es un solo formato de varios recomendado probar los existentes para ver las diferencias
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, family);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //AdapterView<?> is a generic because inside this code we dont know which view is going to be calling this method
                //of coursefor this demo we already know it is a listView

                //view represents the element being tapped in this case a row

                //position is the number of the row that has being tapped

                //id the same as position but on other cases could be different
                Log.i("Person tapped:", family.get(position));
                //parent.setVisibility(View.GONE); //to make invisible the element tapped
                Toast.makeText(getApplicationContext(), "Hello " + family.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
