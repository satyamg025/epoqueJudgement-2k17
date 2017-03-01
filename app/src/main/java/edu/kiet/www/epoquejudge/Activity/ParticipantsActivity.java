package edu.kiet.www.epoquejudge.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

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
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Participations");
        setTitleColor(getResources().getColor(R.color.white));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=(RecyclerView)findViewById(R.id.participants_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Toast.makeText(this,String.valueOf(getIntent().getExtras().getString("event_id","")),Toast.LENGTH_LONG).show();

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