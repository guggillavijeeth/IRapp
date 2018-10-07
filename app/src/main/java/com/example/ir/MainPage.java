package com.example.ir;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

public class MainPage extends AppCompatActivity {

    private static final String TAG = "MainPage";
    private ListView listView;
    private BetterArrayAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Log.d(TAG, "OnCreate");

        //listView header design
        TextView textHeader = new TextView(this);
        textHeader.setText(R.string.home_title);
        textHeader.setTextSize(24);
        textHeader.setTypeface(null, Typeface.BOLD);

        listView = (ListView) findViewById(R.id.ListUpcoming);
        listView.addHeaderView(textHeader);

        final ArrayList<Event> displayedEvents = new ArrayList<Event>();

        displayedEvents.add(new Event("Back to School Harris by SGA", "10/06/2018", "10:00PM"));
        displayedEvents.add(new Event("Badminton", "10/07/2018", "7:32AM"));
        displayedEvents.add(new Event("Gardner", "10/07/2018", "5:40AM"));

        // Set Alarm for event with private field Calender AlarmTime of event
        for (Event e: displayedEvents){
            e.setAlarm(this.getApplicationContext());
        }

        eAdapter = new BetterArrayAdapter(this, R.layout.event_text_format, displayedEvents);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Event currentEvent = displayedEvents.get(i);
                Intent intent = new Intent (view.getContext(), EditPage.class);
                intent.putExtra("originalName",currentEvent.getName());
                intent.putExtra("originalDate",currentEvent.getDate());
                intent.putExtra("originalTime",currentEvent.getTime());

                startActivity(intent);
            }
        });

        listView.setAdapter(eAdapter);



    }


}
