package com.example.ir;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BetterArrayAdapter extends ArrayAdapter<Event>{

    private static final String TAG = "BetterArrayAdapter";
    private Context myContext;
    private int resource;
    private List<Event> eventsList = new ArrayList<Event>();

    public BetterArrayAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<Event> eventsList) {
        super(context, resource, eventsList);
        this.myContext = context;
        this.resource = resource;
        this.eventsList = eventsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(myContext).inflate(R.layout.event_text_format, parent, false);

        final Event currentEvent = eventsList.get(position);

        TextView name = (TextView) listItem.findViewById(R.id.eventName);
        name.setText(currentEvent.getName());

        TextView date = (TextView) listItem.findViewById(R.id.eventDate);
        date.setText(currentEvent.getDate());

        TextView time = (TextView) listItem.findViewById(R.id.eventTime);
        time.setText(currentEvent.getTime());

        Button button = (Button) listItem.findViewById(R.id.editButton);
        //button.setFocusable(false);

        return listItem;
    }




}

