package com.example.andst.space_invaders;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HighScore extends AppCompatActivity {

    ListView lv;
    private DBHandler db;
    ArrayList<String> listData;
    ArrayList<String> listDataToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        db = new DBHandler(this);

        lv = (ListView) findViewById(R.id.listviewHighScore);


        //get the data and append to a list
        Cursor data = db.getData();
        listData = new ArrayList<>();
        listDataToShow = new ArrayList<>();
        while (data.moveToNext()) {
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
            listData.add(data.getString(2));
        }

        for(int i =0; i<listData.size();i=i+2){
            listDataToShow.add(listData.get(i) + " - " + listData.get(i+1));
        }

        //create the list adapter and set the adapter
        final ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listDataToShow);
        lv.setAdapter(adapter);

    }
}
