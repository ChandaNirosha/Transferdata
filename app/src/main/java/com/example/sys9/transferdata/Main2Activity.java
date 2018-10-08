package com.example.sys9.transferdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView text=findViewById(R.id.txt1);
        SharedPreferences preferences=getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String name=preferences.getString(MainActivity.NAME,"");
        String college=preferences.getString(MainActivity.COLLEGE,"");
        String branch=preferences.getString(MainActivity.BRANCH,"");
        text.setText(name+"\n+college+\n"+branch);

    }
}
