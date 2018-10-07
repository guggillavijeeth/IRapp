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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    private ListView listView;
    private BetterArrayAdapter eAdapter;
    private ArrayList<Event> displayedEvents;

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

        displayedEvents = new ArrayList<Event>();

        displayedEvents.add(new Event("Back to School Harris by SGA", "10/06/2018", "10:00PM"));
        displayedEvents.add(new Event("Badminton", "10/13/2018", "7:00PM"));
        displayedEvents.add(new Event("Gardner", "11/02/2018", "11:00PM"));

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
                startActivityForResult(openCam, 1);
                return true;
            case R.id.action_add:
                //User chose to add manually, open event add
                Intent addEvent = new Intent(this, AddPage.class);
                startActivityForResult(addEvent, 2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

        if(requestCode == 2){

            Bundle b = intent.getExtras();

            displayedEvents.add(new Event(b.get(AddPage.NAME_KEY).toString(), b.get(AddPage.DATE_KEY).toString(), b.get(AddPage.TIME_KEY).toString()));
            eAdapter = new BetterArrayAdapter(this, R.layout.event_text_format, displayedEvents);
            listView.setAdapter(eAdapter);
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    public void onReceive(View view){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Event e = new Event((bundle.getString("originalName"))
                ,(bundle.getString("originalDate"))
                , (bundle.getString("originalTime")));

        e.setAlarm(this);
    }

}
