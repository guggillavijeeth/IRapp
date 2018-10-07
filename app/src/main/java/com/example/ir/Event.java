package com.example.ir;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.app.PendingIntent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.content.Context.ALARM_SERVICE;

public class Event extends Object {

    private String name;
    private String date;
    private String time;
    private int alarmDefault;

    public Event(String nameInput, String dateInput, String timeInput){
        name = nameInput;
        date = dateInput;
        time = timeInput;
        alarmDefault = 30;
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

    public void setName(String newName) {
        name = newName;
    }
    public void setDate(String newDate){
        date = newDate;
    }
    public void setTime(String newTime){
        time = newTime;
    }
    public void setAlarmDefault (int newAlarmDefault) {alarmDefault = newAlarmDefault;}





}
