package com.example.vikas.intern;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by VIKAS on 12/21/2017.
 */

public class Third extends Activity {

    TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);


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
}