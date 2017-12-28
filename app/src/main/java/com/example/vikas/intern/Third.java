package com.example.vikas.intern;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by VIKAS on 12/21/2017.
 */

public class Third extends Activity {
    private static final String TAG = "ListDataActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;
    TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();

        try {
            Bundle intent = getIntent().getBundleExtra("add");

            String name = intent.getString("hai1");
            String email = intent.getString("hai2");
            String password = intent.getString("hai3");
            textView2 = (TextView) findViewById(R.id.textView2);
            textView2.setText("Name:" + name + "\nEmail:" + email + "\nPassword:" + password + "");
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return;
        }
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){

            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}

