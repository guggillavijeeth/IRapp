package com.example.ir;

import android.content.Context;
import android.os.Environment;
import android.app.AlarmManager;
import android.widget.ArrayAdapter;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.ListView;

import java.util.Calendar;
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

        displayedEvents.add(new Event("Harris", "10/6/2018", "10:00PM"));
        displayedEvents.add(new Event("Badminton", "10/13/2018", "7:00PM"));
        displayedEvents.add(new Event("Gardner", "11/2/2018", "11:00PM"));

        /*
        for (Event e : displayedEvents){
            setAlarm(e);
        }
*/
        eAdapter = new BetterArrayAdapter(this, R.layout.event_text_format, displayedEvents);
        listView.setAdapter(eAdapter);

        //Testing if alarm is working
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        Calendar ca = Calendar.getInstance();
        ca.setTimeInMillis(System.currentTimeMillis());

        alarm.set(alarm.RTC_WAKEUP, ca.getTimeInMillis(), alarmIntent);
//

    }

    public void setAlarm (Event e){
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        //set time for event
        Calendar calendar = Calendar.getInstance();
        try {
            DateFormat format = new SimpleDateFormat("MM/DD/YYYY hh:mma");
            String fullDate = e.getDate() + " "+ e.getTime();
            Date eventDate = format.parse(fullDate);
            calendar.setTime(eventDate);
            calendar.add(Calendar.MINUTE, (0 - e.getAlarmDefault()));
        }catch (ParseException dateException)
        {
            // If the date or time field has wrong format, the notification will be set to current time
            calendar.setTimeInMillis(System.currentTimeMillis());
        }

        // set alarm
        alarm.set(alarm.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);


    }

}






