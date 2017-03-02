package edu.kiet.www.epoquejudge.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.*;

import edu.kiet.www.epoquejudge.Models.EnterMarksPOJO;
import edu.kiet.www.epoquejudge.R;
import edu.kiet.www.epoquejudge.Requests.EnterGroupRequest;
import edu.kiet.www.epoquejudge.Requests.EnterSoloRequest;
import edu.kiet.www.epoquejudge.networking.ServiceGenerator;
import edu.kiet.www.epoquejudge.util.DbHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shrey on 27/2/17.
 */

public class EventJudgement extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String category;
    Spinner a1,a2,a3,a4;
    TextView attr1,attr2,attr3,attr4;
    String total="",attr_id="";
    Call<EnterMarksPOJO> call;
    String id,event_id;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_judgement);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Give your Judgement");
        category=getIntent().getExtras().getString("type");
        event_id=getIntent().getExtras().getString("event_id");
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Uploading marks...");
        progressDialog.setCancelable(false);
        setTitleColor(getResources().getColor(R.color.white));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AppCompatButton submit=(AppCompatButton)findViewById(R.id.submit);
        //final String[] marks={"0","1","2","3","4","5"};
        attr1=(TextView)findViewById(R.id.attr1);
        attr2=(TextView)findViewById(R.id.attr2);
        attr3=(TextView)findViewById(R.id.attr3);
        attr4=(TextView)findViewById(R.id.attr4);
        a1=(Spinner)findViewById(R.id.m1);
        a2=(Spinner)findViewById(R.id.m2);
        a3=(Spinner)findViewById(R.id.m3);
        a4=(Spinner)findViewById(R.id.m4);
        // Creating adapter for spinner
        String max[]=new String[4];
        String min[]=new String[4];
        String attr_id_array[]=new String[4];
        String attr_array[]=new String[4];
        max=getIntent().getExtras().getStringArray("max");
        min=getIntent().getExtras().getStringArray("min");
        int max1=Integer.parseInt(max[0]),min1=Integer.parseInt(min[0]),k1=min1;
        Log.e(max[0],min[0]);
        String marks1[]=new String[max1-min1+1];
        for(int i=0;i<=max1-min1;i++)
        {
            marks1[i]=Integer.toString(k1++);
        }
        int max2=Integer.parseInt(max[1]),min2=Integer.parseInt(min[1]),k2=min2;
        String marks2[]=new String[max2-min2+1];
        for(int i=0;i<=max2-min2;i++)
        {
            marks2[i]=Integer.toString(k2++);
        }
        int max3=Integer.parseInt(max[2]),min3=Integer.parseInt(min[2]),k3=min3;
        String marks3[]=new String[max3-min3+1];
        for(int i=0;i<=max3-min3;i++)
        {
            marks3[i]=Integer.toString(k3++);
        }
        int max4=Integer.parseInt(max[3]),min4=Integer.parseInt(min[3]),k4=min4;
        String marks4[]=new String[max4-min4+1];
        for(int i=0;i<=max4-min4;i++)
        {
            marks4[i]=Integer.toString(k4++);
        }
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, marks1);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, marks2);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, marks3);
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, marks4);

        a1.setAdapter(dataAdapter1);
        a2.setAdapter(dataAdapter2);
        a3.setAdapter(dataAdapter3);
        a4.setAdapter(dataAdapter4);
        id=getIntent().getExtras().getString("id");
        attr_id_array=getIntent().getExtras().getStringArray("attr_id");
        attr_id=attr_id_array[0]+","+attr_id_array[1]+","+attr_id_array[2]+","+attr_id_array[3];
        attr_array=getIntent().getExtras().getStringArray("attr");
        attr1.setText(attr_array[0]);
        attr2.setText(attr_array[1]);
        attr3.setText(attr_array[2]);
        attr4.setText(attr_array[3]);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total=a1.getSelectedItem().toString()+","+a2.getSelectedItem().toString()+","+a3.getSelectedItem().toString()+","+a4.getSelectedItem().toString();
                Log.e(attr_id,total);
                AlertDialog.Builder builder=new AlertDialog.Builder(EventJudgement.this);
                builder.setMessage("These marks cannot be changed")
                        .setTitle("Are you sure?")
                        .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                progressDialog.show();
                                if(category.equalsIgnoreCase("G"))
                                {
                                    String bearer= DbHandler.getString(EventJudgement.this, "bearer", "");
                                    EnterGroupRequest request= ServiceGenerator.createService(EnterGroupRequest.class,bearer);
                                    call=request.request(id,event_id,attr_id,total);

                                }
                                else{
                                    String bearer=DbHandler.getString(EventJudgement.this, "bearer", "");
                                    EnterSoloRequest request= ServiceGenerator.createService(EnterSoloRequest.class,bearer);
                                    call=request.request(id,event_id,attr_id,total);


                                }
                                call.enqueue(new Callback<EnterMarksPOJO>() {
                                    @Override
                                    public void onResponse(Call<EnterMarksPOJO> call, Response<EnterMarksPOJO> response) {
                                        progressDialog.dismiss();
                                        Toast.makeText(EventJudgement.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                                        if(response.body().getError())
                                        {
                                            startActivity(new Intent(EventJudgement.this,Login.class));
                                            finishAffinity();
                                        }
                                        else {
                                            if(response.body().getStatus().equalsIgnoreCase("success"))
                                            {
                                                Intent intent=new Intent(EventJudgement.this,ParticipantsActivity.class);
                                                intent.putExtra("event_id",getIntent().getExtras().getString("event_id"));
                                                intent.putExtra("category",category);
                                                startActivity(intent);
                                                finish();
                                            }


                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<EnterMarksPOJO> call, Throwable t) {
                                        Snackbar.make(findViewById(android.R.id.content),"Connection Error",Snackbar.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).show();


            }
        });


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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id==android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
