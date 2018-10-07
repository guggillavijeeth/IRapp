package com.example.ir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class EditPage extends AppCompatActivity {


    TextView name;
    TextView date;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page);


        name = (EditText) findViewById(R.id.editText3);
        date = (EditText) findViewById(R.id.editText4);
        time = (EditText) findViewById(R.id.editText7);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        name.setText(bundle.getString("originalName"));
        date.setText(bundle.getString("originalDate"));
        time.setText(bundle.getString("originalTime"));

    }
}
