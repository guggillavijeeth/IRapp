package com.example.ir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class AddPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);
    }

    public static final String NAME_KEY = "com.example.ir.NAME";
    public static final String DATE_KEY = "com.example.ir.DATE";
    public static final String TIME_KEY = "com.example.ir.TIME";

    /** Called when the user taps the DONE button */
    public void sendEntry(View view) {
        Intent intent = getIntent();

        EditText nameText = (EditText) findViewById(R.id.addText3);
        EditText dateText = (EditText) findViewById(R.id.addText4);
        EditText timeText = (EditText) findViewById(R.id.addText7);

        String newName = nameText.getText().toString();
        String newDate = dateText.getText().toString();
        String newTime = timeText.getText().toString();

        intent.putExtra(NAME_KEY, newName);
        intent.putExtra(DATE_KEY, newDate);
        intent.putExtra(TIME_KEY, newTime);

        setResult(RESULT_OK, intent);
        finish();
    }
}

