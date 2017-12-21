package com.example.vikas.intern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by VIKAS on 12/21/2017.
 */

public class Second extends Activity{

    TextView name, email, pass;

    EditText name1, email1, pass1;

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        pass = (TextView) findViewById(R.id.pass);

        button = (Button) findViewById(R.id.button);

        name1 = (EditText) findViewById(R.id.name1);
        email1 = (EditText) findViewById(R.id.email1);
        pass1 = (EditText) findViewById(R.id.pass1);

        /*Intent activity = new Intent(ActivityB.this,ActivityC.class);
                Bundle bundle= new Bundle();
                bundle.putString("secret","VIKASH");
                bundle.putString("second_secret","VIKASH_NAME");
                activity.putExtra("add",bundle);
        startActivity(activity);*/


        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {

                                          String str1 = name1.getText().toString();
                                          String str2 = email1.getText().toString();
                                          String str3 = pass1.getText().toString();

                                          sendData(str1, str2, str3);
                                      }
                                  }
        );
    }

    private void sendData(String str1, String str2, String str3) {

        Intent activity = new Intent(Second.this, Third.class);
        Bundle bundle = new Bundle();
        bundle.putString("hai1", str1);
        bundle.putString("hai2", str2);
        bundle.putString("hai3", str3);
        activity.putExtra("add", bundle);
        startActivity(activity);

    }


}
