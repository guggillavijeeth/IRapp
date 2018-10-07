package com.example.ir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditPage extends AppCompatActivity {

    TextView name;
    TextView date;
    TextView time;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page);


        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBack(v);
            }
        });
        name = (EditText) findViewById(R.id.editText3);
        date = (EditText) findViewById(R.id.editText4);
        time = (EditText) findViewById(R.id.editText7);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        name.setText(bundle.getString("originalName"));
        date.setText(bundle.getString("originalDate"));
        time.setText(bundle.getString("originalTime"));



    }

    public void sendBack(View view){
        Intent intent = new Intent (EditPage.this, MainPage.class);

        EditText ed3 = findViewById(R.id.editText3);
        EditText ed4 = findViewById(R.id.editText4);
        EditText ed7 = findViewById(R.id.editText7);

        intent.putExtra("originalName",ed3.getText().toString());
        intent.putExtra("originalDate",ed4.getText().toString());
        intent.putExtra("originalTime",ed7.getText().toString());
        startActivity(intent);
    }
}
