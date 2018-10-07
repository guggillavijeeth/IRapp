package com.example.ir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class EditPage extends AppCompatActivity {

    private static final String TAG = "EditPage";

    TextView name;
    TextView date;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page);
        Log.d(TAG, "OnCreate: started");

        name = (EditText) findViewById(R.id.editText3);
        date = (EditText) findViewById(R.id.editText4);
        time = (EditText) findViewById(R.id.editText7);
/*
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            name.setText(bundle.getString("name"));
        }
        */
    }
}
