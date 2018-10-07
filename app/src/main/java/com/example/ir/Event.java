package com.example.ir;

import android.widget.Button;

public class Event extends Object {

    private String name;
    private String date;
    private String time;

    public Event(String nameInput, String dateInput, String timeInput){
        name = nameInput;
        date = dateInput;
        time = timeInput;
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

    public void setName(String newName) {
        name = newName;
    }
    public void setDate(String newDate){
        date = newDate;
    }
    public void setTime(String newTime){
        time = newTime;
    }
}
