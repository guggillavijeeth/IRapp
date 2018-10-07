package com.example.ir;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    private ListView listView;
    private BetterArrayAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //listView header design
        TextView textHeader = new TextView(this);
        textHeader.setText(R.string.home_title);
        textHeader.setTextSize(24);
        textHeader.setTypeface(null, Typeface.BOLD);

        listView = (ListView) findViewById(R.id.ListUpcoming);
        listView.addHeaderView(textHeader);

        ArrayList<Event> displayedEvents = new ArrayList<Event>();

        displayedEvents.add(new Event("Back to School Harris by SGA", "10/06/2018", "10:00PM"));
        displayedEvents.add(new Event("Badminton", "10/13/2018", "7:00PM"));
        displayedEvents.add(new Event("Gardner", "11/02/2018", "11:00PM"));

        eAdapter = new BetterArrayAdapter(this, R.layout.event_text_format, displayedEvents);
        listView.setAdapter(eAdapter);
    }

    public void sendMessage(View view){
        
        //Intent intent = new Intent(this, EditPage.class);
        //TextView nameView = (TextView) findViewById(R.id.eventName)
    }

}
