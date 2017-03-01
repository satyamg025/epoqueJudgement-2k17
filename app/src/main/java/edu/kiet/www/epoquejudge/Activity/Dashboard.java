package edu.kiet.www.epoquejudge.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import edu.kiet.www.epoquejudge.Adapter.EventsAdapter;
import edu.kiet.www.epoquejudge.R;

public class Dashboard extends AppCompatActivity {
RecyclerView recyclerView;
    EventsAdapter adapter;
    List<String> eventName,type,category,venue,schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Dashboard");
        setTitleColor(getResources().getColor(R.color.white));
        recyclerView=(RecyclerView)findViewById(R.id.event_details);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        eventName=new ArrayList<>();
        type=new ArrayList<>();
        category=new ArrayList<>();
        venue=new ArrayList<>();
        schedule=new ArrayList<>();
        for (int i=1;i<=10;i++)
        {
            eventName.add("Event Name:Event Name");
            type.add("Type:Institute");
            category.add("Category:Solo");
            venue.add("Venue:Ground Floor");
            schedule.add("Scheduled At:14:00:00");
        }
        adapter=new EventsAdapter(this,eventName,type,category,venue,schedule);
        recyclerView.setAdapter(adapter);
    }
}
