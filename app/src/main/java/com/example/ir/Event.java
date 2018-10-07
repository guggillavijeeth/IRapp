package com.example.ir;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Event extends Object {

    private String name;
    private String date;
    private String time;
    private int alarmDefault;
    private Calendar alarmTime;
    private static DateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mma");



    public Event(String nameInput, String dateInput, String timeInput){
        name = nameInput;
        date = dateInput;
        time = timeInput;
        alarmDefault = 30;

        alarmTime = Calendar.getInstance();
        try {
            String fullDate = date + " "+ time;
            Date eventDate = format.parse(fullDate);
            alarmTime.setTime(eventDate);
            alarmTime.add(Calendar.MINUTE, (0 - alarmDefault));

        }catch (ParseException dateException)
        {
            // If the date or time field has wrong format, the notification will be set to current time
            alarmTime.setTimeInMillis(System.currentTimeMillis());
        }
    }

    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public int getAlarmDefault() {return alarmDefault;}
    public Calendar getAlarmTime () {
        return alarmTime;}

    public void setName(String newName) {
        name = newName;
    }
    public void setDate(String newDate){
        date = newDate;
        setAlarmTime();
    }

    public void setTime(String newTime){
        time = newTime;
        setAlarmTime();
    }

    public void setAlarmDefault (int newAlarmDefault) {
        alarmDefault = newAlarmDefault;
        setAlarmTime();
    }

    private void setAlarmTime () {

        try {
            String fullDate = date + " "+ time;
            Date eventDate = format.parse(fullDate);
            alarmTime.setTime(eventDate);
            alarmTime.add(Calendar.MINUTE, (0 - alarmDefault));

        }catch (ParseException dateException)
        {
            // If the date or time field has wrong format, the notification will be set to current time
            alarmTime.setTimeInMillis(System.currentTimeMillis());
        }


    }

    public void setAlarm (Context context){
        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        alarm.set(alarm.RTC_WAKEUP, alarmTime.getTimeInMillis(), alarmIntent);

    }

}
