package com.example.ir;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.action_bar_buttons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_camera:
                //User chose camera option, open camera activity
                Intent openCam = new Intent(this, MainActivity.class);
                startActivity(openCam);
                return true;
            case R.id.action_add:
                //User chose to add manually, open event add
                Intent addEvent = new Intent(this, AddPage.class);
                startActivity(addEvent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void sendMessage(View view){
        
        //Intent intent = new Intent(this, EditPage.class);
        //TextView nameView = (TextView) findViewById(R.id.eventName)
    }

}
