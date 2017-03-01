package edu.kiet.www.epoquejudge.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.kiet.www.epoquejudge.Adapter.EventsAdapter;
import edu.kiet.www.epoquejudge.Adapter.ParticipantsAdapter;
import edu.kiet.www.epoquejudge.R;

/**
 * Created by shrey on 28/2/17.
 */

public class ParticipantsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ParticipantsAdapter adapter;
    List<String> eventName,participants_group,participants_solo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);
        recyclerView=(RecyclerView)findViewById(R.id.event_details);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        eventName=new ArrayList<>();
        participants_group=new ArrayList<>();
        participants_solo=new ArrayList<>();
        for (int i=1;i<=10;i++)
        {
            eventName.add("Event Name:Event Name");
            participants_group.add("Participants Group:Participants Group");
            participants_solo.add("Participant Solo:Participant Solo");
        }
        adapter=new ParticipantsAdapter(this,eventName,participants_group,participants_solo);
        recyclerView.setAdapter(adapter);
    }
}