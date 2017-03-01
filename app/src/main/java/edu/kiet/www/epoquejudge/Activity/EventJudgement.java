package edu.kiet.www.epoquejudge.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.*;
import edu.kiet.www.epoquejudge.R;

/**
 * Created by shrey on 27/2/17.
 */

public class EventJudgement extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_judgement);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Judgement");
        setTitleColor(getResources().getColor(R.color.white));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] marks={"0","1","2","3","4","5"};
        Spinner a1,a2,a3,a4;
        a1=(Spinner)findViewById(R.id.m1);
        a2=(Spinner)findViewById(R.id.m2);
        a3=(Spinner)findViewById(R.id.m3);
        a4=(Spinner)findViewById(R.id.m4);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, marks);
        a1.setAdapter(dataAdapter);
        a2.setAdapter(dataAdapter);
        a3.setAdapter(dataAdapter);
        a4.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
