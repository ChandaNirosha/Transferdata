package com.example.sys9.transferdata;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "NAME";
    public static final String COLLEGE = "COLLEGE";
    public static final String BRANCH = "BRANCH";
    EditText e1, e2, e3;
    Button b1;
    private String photo_path;
    private Uri mImageUri;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.NAME);
        e2 = findViewById(R.id.COLLEGE);
        e3 = findViewById(R.id.BRANCH);
        b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = true;
                String name = e1.getText().toString().trim();
                String college = e2.getText().toString().trim();
                String branch = e3.getText().toString().trim();

                if (name.isEmpty()) {
                    isValid = false;
                    e1.setError("name should not be empty");
                }
                if (college.isEmpty()) {
                    isValid = false;
                    e2.setError("college should not be empty");
                }
                if (branch.isEmpty()) {
                    isValid = false;
                    e3.setError("branch should not be empty");
                }
                if (isValid) {
                    SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(NAME, name);
                    editor.putString(COLLEGE, college);
                    editor.putString(BRANCH, branch);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
                     ExampleDb db=new ExampleDb(MainActivity.this);
                     db.insert(name,college,branch);



                }
            }
        });
    }

}




