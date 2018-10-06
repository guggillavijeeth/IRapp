package com.example.ir;

import android.os.Environment;
import android.app.AlarmManager;
import android.widget.ArrayAdapter;
import java.io.File;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.ListView;
import java.util.Date;


public class MainPage extends AppCompatActivity {

    private ListView listView;
    private BetterArrayAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        listView = (ListView) findViewById(R.id.ListUpcoming);
        ArrayList<Event> displayedEvents = new ArrayList<Event>();

        displayedEvents.add(new Event("Harris", "10/6/2018", "10:00pm"));
        displayedEvents.add(new Event("Badminton", "10/13/2018", "7:00pm"));
        displayedEvents.add(new Event("Gardner", "11/2/2018", "11:00pm"));

        eAdapter = new BetterArrayAdapter(this, R.layout.event_text_format, displayedEvents);
        listView.setAdapter(eAdapter);
    }

}






